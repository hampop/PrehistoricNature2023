package com.aechtrob.prehistoricnature.world.tree;

import com.aechtrob.prehistoricnature.PrehistoricNatureMod;
import com.aechtrob.prehistoricnature.world.tree.lepidodendron.LepidodendronFoliagePlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class PNFoliagePlacerType {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACER_TYPES = DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, PrehistoricNatureMod.MOD_ID);

    public static RegistryObject<FoliagePlacerType<LepidodendronFoliagePlacer>> LEPIDODENDRON_FOLIAGE_PLACER = FOLIAGE_PLACER_TYPES.register("lepidodendron_foliage_placer", () -> new FoliagePlacerType<>(LepidodendronFoliagePlacer.CODEC));
    //public static RegistryObject<FoliagePlacerType<FancyCherryBlossomFoliagePlacer>> FANCY_CHERRY_TREE_Foliage_PLACER = Foliage_PLACER_TYPES.register("fancy_cherry_blossom_tree_Foliage_placer", () -> new FoliagePlacerType<>(FancyCherryBlossomFoliagePlacer.CODEC));
    //public static RegistryObject<FoliagePlacerType<GrandCherryBlossomFoliagePlacer>> GRAND_CHERRY_TREE_Foliage_PLACER = Foliage_PLACER_TYPES.register("grand_cherry_blossom_tree_Foliage_placer", () -> new FoliagePlacerType<>(GrandCherryBlossomFoliagePlacer.CODEC));

}