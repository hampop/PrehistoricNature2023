package com.aechtrob.prehistoricnature.world.tree;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

public class PNTreeFeature extends TreeFeature {
    public PNTreeFeature(Codec<TreeConfiguration> p_67201_) {
        super(p_67201_);
    }

    public static boolean canLogReplaceBlock(LevelSimulatedReader p_67289_, BlockPos p_67290_) {
        return p_67289_.isStateAtPosition(p_67290_, (state) -> {
            Block block = state.getBlock();
            return block == net.minecraft.world.level.block.Blocks.AIR
                    || block == net.minecraft.world.level.block.Blocks.SNOW
                    || block == net.minecraft.world.level.block.Blocks.WATER
                    || block == net.minecraft.world.level.block.Blocks.BAMBOO
                    || block == net.minecraft.world.level.block.Blocks.BAMBOO_SAPLING
                    || block == net.minecraft.world.level.block.Blocks.BUBBLE_COLUMN
                    || block == net.minecraft.world.level.block.Blocks.CACTUS
                    || block == net.minecraft.world.level.block.Blocks.CAKE
                    || block == net.minecraft.world.level.block.Blocks.LAVA
                    || block == net.minecraft.world.level.block.Blocks.POWDER_SNOW
                    || block == Blocks.PETRIFIED_OAK_SLAB
                    || block == Blocks.OAK_WOOD
                    || block == net.minecraft.world.level.block.Blocks.FROGSPAWN
                    || block == net.minecraft.world.level.block.Blocks.WATER;
        });
    }

    public static boolean canLeavesReplaceBlock(LevelSimulatedReader p_67289_, BlockPos p_67290_) {
        return p_67289_.isStateAtPosition(p_67290_, (state) -> {
            Block block = state.getBlock();
            return block == net.minecraft.world.level.block.Blocks.AIR
                    || block == Blocks.STRUCTURE_VOID
                    || block == Blocks.OAK_LEAVES;
        });
    }
}
