package com.aechtrob.prehistoricnature.block.blocks;

import com.aechtrob.prehistoricnature.entity.block.blocks.*;
import net.minecraft.core.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.*;

import javax.annotation.*;

public class PNWallSignBlock extends WallSignBlock {
    public PNWallSignBlock(Properties properties, WoodType woodType) {
        super(properties, woodType);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new PNSignBlockEntity(pos, state);
    }

    @Override
    public RenderShape getRenderShape(BlockState p_49232_) {
        return super.getRenderShape(p_49232_);
    }
}
