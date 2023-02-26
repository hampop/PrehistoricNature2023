package com.aechtrob.prehistoricnature.datagen.helpers;

import com.aechtrob.prehistoricnature.datagen.*;
import com.aechtrob.prehistoricnature.datagen.loottable.*;
import com.google.common.collect.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraftforge.registries.*;

import java.util.function.*;

public class LootTableHelper {
    private static LinkedHashMultimap<RegistryObject<ItemLike>, BiConsumer> blockLoottables = LinkedHashMultimap.create();

    public static <T extends ItemLike> void addLootTable(RegistryObject<T> block, BiConsumer<BlockLootSubProvider, RegistryObject<Block>> consumer){
        blockLoottables.put((RegistryObject<ItemLike>) block, consumer);
    }

    public static LinkedHashMultimap<RegistryObject<ItemLike>, BiConsumer> getLootTables(){
        return blockLoottables;
    }


}
