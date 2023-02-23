package com.aechtrob.prehistoricnature.block.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

import javax.annotation.Nullable;

public class PNDecayableDirectional extends Block {
    public static final BooleanProperty PERSISTENT = BlockStateProperties.PERSISTENT;
    public static final DirectionProperty FACING = DirectionalBlock.FACING;

    public PNDecayableDirectional(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return !state.getValue(PERSISTENT);
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        BlockState blockstate = this.defaultBlockState();
        LevelReader levelreader = blockPlaceContext.getLevel();
        BlockPos blockpos = blockPlaceContext.getClickedPos();
        Direction[] adirection = blockPlaceContext.getNearestLookingDirections();

        for(Direction direction : adirection) {
            Direction direction1 = direction.getOpposite();
            blockstate = blockstate.setValue(FACING, direction1).setValue(PERSISTENT, Boolean.valueOf(true));
            if (blockstate.canSurvive(levelreader, blockpos)) {
                return blockstate;
            }
        }

        return null;
    }

    @Override
    public void neighborChanged(BlockState state, Level world, BlockPos pos1, Block block, BlockPos pos2, boolean bool) {
        if (world instanceof ServerLevel) {
            this.randomTick(state, (ServerLevel) world, pos1, world.getRandom());
        }
        super.neighborChanged(state, world, pos1, block, pos2, bool);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        Direction direction = state.getValue(FACING);
        BlockPos blockpos = pos.relative(direction.getOpposite());
        BlockState blockstate = world.getBlockState(blockpos);
        return blockstate.isFaceSturdy(world, blockpos, direction) || blockstate.getBlock() instanceof LeavesBlock;
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockBlockStateBuilder) {
        blockBlockStateBuilder.add(FACING, PERSISTENT);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState state2, LevelAccessor world, BlockPos pos, BlockPos pos2) {
        return direction.getOpposite() == state.getValue(FACING) && !state.canSurvive(world, pos) ? Blocks.AIR.defaultBlockState() : state;
    }

}
