package com.aechtrob.prehistoricnature.item;

import net.minecraft.world.item.*;
import net.minecraftforge.registries.*;

public class PrehistoricNatureItems {
    public static final RegistryObject<GeologicPickItem> GEOLOGIC_PICK = ItemHandler.ITEMS.register(
            "geologic_pick", () -> {return new GeologicPickItem(Tiers.IRON, new Item.Properties());});
    public static final RegistryObject<Item> CARBONIFEROUS_RAW_FOSSIL = ItemHandler.addItem("carboniferous_raw_fossil", new Item.Properties(), "Carboniferous Raw Fossil");
    public static void register(){}
}
