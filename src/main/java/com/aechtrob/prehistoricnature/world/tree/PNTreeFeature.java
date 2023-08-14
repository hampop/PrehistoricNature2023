package com.aechtrob.prehistoricnature.world.tree;

import com.mojang.serialization.Codec;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

public class PNTreeFeature extends TreeFeature {
    public PNTreeFeature(Codec<TreeConfiguration> p_67201_) {
        super(p_67201_);
    }

    public static boolean canLogReplaceBlock(LevelSimulatedReader p_67289_, BlockPos p_67290_) {
        return p_67289_.isStateAtPosition(p_67290_, (p_160551_) -> {
            Material material = p_160551_.getMaterial ( );
            return (material.isReplaceable()
                || !material.isSolid()
                || (material == Material.WEB)
                || (material == Material.AIR)
                || (material == Material.STRUCTURAL_AIR)
                || (material == Material.LEAVES)
                || (material == Material.SNOW)
                || (material == Material.WATER)
                || (material == Material.BAMBOO)
                || (material == Material.BAMBOO_SAPLING)
                || (material == Material.BUBBLE_COLUMN)
                || (material == Material.CACTUS)
                || (material == Material.CAKE)
                || (material == Material.CLOTH_DECORATION)
                || (material == Material.DECORATION)
                || (material == Material.LAVA)
                || (material == Material.MOSS)
                || (material == Material.PLANT)
                || (material == Material.POWDER_SNOW)
                || (material == Material.VEGETABLE)
                || (material == Material.TOP_SNOW)
                || (material == Material.WATER_PLANT)
                || (material == Material.REPLACEABLE_FIREPROOF_PLANT)
                || (material == Material.REPLACEABLE_PLANT)
                || (material == Material.REPLACEABLE_WATER_PLANT)
                    || (material == Material.FROGSPAWN) //1.19!
                || (material == Material.WATER));
        });
    }

    public static boolean canLeavesReplaceBlock(LevelSimulatedReader p_67289_, BlockPos p_67290_) {
        return p_67289_.isStateAtPosition(p_67290_, (p_160551_) -> {
            Material material = p_160551_.getMaterial();
            return ((material == Material.AIR)
                || (material == Material.STRUCTURAL_AIR)
                || (material == Material.LEAVES));
        });
    }
}
