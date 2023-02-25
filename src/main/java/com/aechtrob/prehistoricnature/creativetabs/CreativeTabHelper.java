package com.aechtrob.prehistoricnature.creativetabs;

import com.google.common.collect.*;
import com.ibm.icu.impl.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraftforge.registries.*;

public class CreativeTabHelper {
    private static LinkedHashMultimap<String, Pair<RegistryObject<ItemLike>, Integer>> creativeTempTabs = LinkedHashMultimap.create();

    private static LinkedHashMultimap<CreativeModeTab, Pair<RegistryObject<ItemLike>, Integer>> creativeItems = LinkedHashMultimap.create();

    public static <T extends ItemLike> void addCreativeItem(String creativeModeTab, RegistryObject<T> block){
        creativeTempTabs.put(creativeModeTab, Pair.of((RegistryObject<ItemLike>) block, 0));
    }

    public static <T extends ItemLike> void addCreativeItem(String creativeModeTab, RegistryObject<T> creativeItem, int tier){
        creativeTempTabs.put(creativeModeTab, Pair.of((RegistryObject<ItemLike>) creativeItem, tier));
    }

    public static LinkedHashMultimap<CreativeModeTab, Pair<RegistryObject<ItemLike>, Integer>> getCreativeItems(){
        return creativeItems;
    }

    public static void substituteTabs() {
        creativeTempTabs.forEach((id, pair)->{creativeItems.put(CreativeTabs.getTab(id),pair);});
    }
}
