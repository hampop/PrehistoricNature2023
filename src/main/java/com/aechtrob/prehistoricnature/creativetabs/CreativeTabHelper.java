package com.aechtrob.prehistoricnature.creativetabs;

import com.google.common.collect.*;
import com.ibm.icu.impl.*;
import net.minecraft.world.level.*;
import net.minecraftforge.registries.*;

public class CreativeTabHelper {

    public static int functionalTabSignTier = 10;
    public static int naturalTabLogTier = 8;
    public static int transportTabBoatTier = 2;
    public static int naturalTabLeafTier = 9;
    public static int naturalTabSaplingTier = 10;
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
