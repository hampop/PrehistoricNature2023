package com.aechtrob.prehistoricnature.world;

import com.aechtrob.prehistoricnature.PrehistoricNatureMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

public class ModConfiguredFeatures {

    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registries.CONFIGURED_FEATURE, PrehistoricNatureMod.MOD_ID);

    public static final ResourceKey<ConfiguredFeature<?, ?>> LEPIDODENDRON_TREE = createKey("lepidodendron_tree");

    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
        return ResourceKey.create(CONFIGURED_FEATURES.getRegistryKey(), new ResourceLocation(PrehistoricNatureMod.MOD_ID, name));
    }

    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }

}
