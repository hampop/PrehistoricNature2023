package com.aechtrob.prehistoricnature.blocks.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import org.jetbrains.annotations.Nullable;

public class PNRotatedPillarFlammableBlock extends RotatedPillarBlock {

    public PNRotatedPillarFlammableBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if (getStrippedBlock() == null) {
            return state;
        }
        if (context.getItemInHand().getItem() instanceof AxeItem && state.getBlock() != getStrippedBlock()) {
            return getStrippedBlock().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
        }
        return state;
    }

    @javax.annotation.Nullable
    public Block getStrippedBlock() {
        return null;
    }

}
