package com.aechtrob.prehistoricnature.datagen;

import com.aechtrob.prehistoricnature.*;
import com.aechtrob.prehistoricnature.datagen.loottable.BlockLootSubProvider;
import net.minecraft.core.*;
import net.minecraft.data.*;
import net.minecraft.data.loot.*;
import net.minecraft.tags.*;
import net.minecraft.world.level.storage.loot.parameters.*;
import net.minecraftforge.common.data.*;
import net.minecraftforge.data.event.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.common.*;

import java.util.*;
import java.util.concurrent.*;

@Mod.EventBusSubscriber(modid = PrehistoricNatureMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        generator.addProvider(
                event.includeClient(),
                new PrehistoricNatureBlockStateProvider(output,existingFileHelper));
        generator.addProvider(
                event.includeClient(),
                new PrehistoricNatureItemModelProvider(output, existingFileHelper));
        generator.addProvider(
                event.includeClient(),
                new PrehistoricNatureLanguageProvider(output, "en_us"));
        generator.addProvider(
                event.includeServer(),
                new PrehistoricNatureLootTableProvider(output,
                        Collections.emptySet(),
                        List.of(
                                new LootTableProvider.SubProviderEntry(
                                        BlockLootSubProvider::new,
                                        LootContextParamSets.BLOCK
                                )
                        )));
        generator.addProvider(
                event.includeServer(),
                new PrehistoricNatureRecipeProvider(output));
        final BlockTagsProvider blockTags;
        generator.addProvider(
                event.includeServer(),blockTags =
                new PrehistoricNatureBlockTagProvider(
                        output,
                        event.getLookupProvider(),
                        event.getExistingFileHelper()
                )
        );
        generator.addProvider(
                event.includeServer(),
                new PrehistoricNatureItemTagProvider(
                        output,
                        event.getLookupProvider(),
                        blockTags,
                        existingFileHelper
                )
        );
    }
}
