package com.aechtrob.prehistoricnature.datagen;

import com.aechtrob.prehistoricnature.*;
import com.aechtrob.prehistoricnature.datagen.loottable.BlockLootSubProvider;
import net.minecraft.data.*;
import net.minecraft.data.loot.*;
import net.minecraft.world.level.storage.loot.parameters.*;
import net.minecraftforge.common.data.*;
import net.minecraftforge.data.event.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.common.*;

import java.util.*;

@Mod.EventBusSubscriber(modid = PrehistoricNatureMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(
                event.includeClient(),
                (DataProvider.Factory<LepidodendronBlockStateProvider>) output-> new LepidodendronBlockStateProvider(output, existingFileHelper));
        generator.addProvider(
                event.includeClient(),
                (DataProvider.Factory<LepidodendronItemModelProvider>) output -> new LepidodendronItemModelProvider(output, existingFileHelper));
        generator.addProvider(
                event.includeClient(),
                (DataProvider.Factory<LepidodendronLanguageProvider>) output -> new LepidodendronLanguageProvider(output, "en_us"));
        generator.addProvider(
                event.includeServer(),
                (DataProvider.Factory<LepidodendronLootTableProvider>) output -> new LepidodendronLootTableProvider(output,
                        Collections.emptySet(),
                        List.of(
                                new LootTableProvider.SubProviderEntry(
                                        BlockLootSubProvider::new,
                                        LootContextParamSets.BLOCK
                                )
                        )));
//        generator.addProvider(
//                event.includeServer(),
//                LepidodendronRecipeProvider::new);
        generator.addProvider(
                // Tell generator to run only when server data are generating
                event.includeServer(),
                // Extends net.minecraftforge.common.data.BlockTagsProvider
                (DataProvider.Factory<LepidodendronBlockTagProvider>) output -> new LepidodendronBlockTagProvider(
                        output,
                        event.getLookupProvider(),
                        event.getExistingFileHelper()
                )
        );
    }
}
