package com.aechtrob.prehistoricnature.item;

import com.aechtrob.prehistoricnature.item.items.*;
import com.ibm.icu.impl.*;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.*;

import java.util.*;

public class PrehistoricNatureItems {
    public static final RegistryObject<Item> GEOLOGIC_PICK = ItemHandler.addItem(
            "geologic_pick", () -> new GeologicPickItem(Tiers.IRON, new Item.Properties()),
            (provider, item) -> {provider.basicItem(item);}, List.of(Pair.of("prehistoricnature_fossils_tab",Pair.of(10,0))),"Geologic Pick");
    public static final RegistryObject<Item> CARBONIFEROUS_RAW_FOSSIL = ItemHandler.addItem("carboniferous_raw_fossil", new Item.Properties(),
            (provider, item) -> {provider.basicItem(item);}, List.of(Pair.of("prehistoricnature_fossils_tab",Pair.of(10,0))),
            "Carboniferous Raw Fossil");
    public static void register(){}
}
