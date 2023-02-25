package com.aechtrob.prehistoricnature.creativetabs;

import com.google.common.collect.*;
import com.ibm.icu.impl.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraftforge.registries.*;

public class CreativeTabHelper {

    public static int logTier = 8;
    public static int leafTier = 9;
    public static int saplingTier = 10;
    private static LinkedHashMultimap<String, Pair<RegistryObject<ItemLike>, Pair<Integer,Integer>>> creativeItems = LinkedHashMultimap.create();

    public static <T extends ItemLike> void addCreativeItem(String creativeModeTab, RegistryObject<T> block){
        creativeItems.put(creativeModeTab, Pair.of((RegistryObject<ItemLike>) block ,Pair.of(0,0)));
    }

    public static <T extends ItemLike> void addCreativeItem(String creativeModeTab, RegistryObject<T> creativeItem, int tier){
        creativeItems.put(creativeModeTab, Pair.of((RegistryObject<ItemLike>) creativeItem, Pair.of(tier,0)));
    }

    public static <T extends ItemLike> void addCreativeItem(String creativeModeTab, RegistryObject<T> creativeItem, int tier, int priority){
        creativeItems.put(creativeModeTab, Pair.of((RegistryObject<ItemLike>) creativeItem, Pair.of(tier,priority)));
    }

    public static LinkedHashMultimap<String, Pair<RegistryObject<ItemLike>, Pair<Integer, Integer>>> getCreativeItems(){
        return creativeItems;
    }
}
