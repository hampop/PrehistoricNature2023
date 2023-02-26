package com.aechtrob.prehistoricnature.datagen.helpers;

import com.aechtrob.prehistoricnature.datagen.*;
import com.google.common.collect.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.registries.*;

import java.util.*;
import java.util.function.*;

public class ModelHelper {

    private static LinkedHashMultimap<RegistryObject<ItemLike>, BiConsumer> blockModels = LinkedHashMultimap.create();
    private static LinkedHashMultimap<RegistryObject<Item>, BiConsumer> itemModels = LinkedHashMultimap.create();

    public static <T extends ItemLike> void addBlockModel(RegistryObject<T> block, BiConsumer<PrehistoricNatureBlockStateProvider, RegistryObject<Block>> consumer){
        blockModels.put((RegistryObject<ItemLike>) block, consumer);
    }

    public static void addItemModel(RegistryObject<Item> item, BiConsumer<PrehistoricNatureItemModelProvider, RegistryObject<Item>> consumer){
        itemModels.put(item, consumer);
    }

    public static LinkedHashMultimap<RegistryObject<ItemLike>, BiConsumer>getBlockModels(){
        return  blockModels;
    }

    public static LinkedHashMultimap<RegistryObject<Item>, BiConsumer>getItemModels(){
        return itemModels;
    }
}

