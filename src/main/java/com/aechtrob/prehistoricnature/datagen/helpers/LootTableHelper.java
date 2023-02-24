package com.aechtrob.prehistoricnature.datagen.helpers;

import com.aechtrob.prehistoricnature.datagen.*;
import com.aechtrob.prehistoricnature.datagen.loottable.*;
import com.google.common.collect.*;
import net.minecraft.world.level.block.*;
import net.minecraftforge.registries.*;

import java.util.function.*;

public class LootTableHelper {
    private static LinkedHashMultimap<RegistryObject<Block>, BiConsumer> blockLoottables = LinkedHashMultimap.create();

    public static void addLootTable(RegistryObject<Block> block, BiConsumer<BlockLootSubProvider, RegistryObject<Block>> consumer){
        blockLoottables.put(block, consumer);
    }

    public static LinkedHashMultimap<RegistryObject<Block>, BiConsumer> getLootTables(){
        return blockLoottables;
    }


}
