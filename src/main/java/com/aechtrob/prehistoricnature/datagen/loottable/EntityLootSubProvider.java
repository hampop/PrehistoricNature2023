package com.aechtrob.prehistoricnature.datagen.loottable;

import net.minecraft.world.flag.*;

public class EntityLootSubProvider extends net.minecraft.data.loot.EntityLootSubProvider {
    protected EntityLootSubProvider() {
        super(FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    public void generate() {

    }
}
