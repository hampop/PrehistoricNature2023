package com.aechtrob.prehistoricnature.block.trees.lepidodendron;

import com.aechtrob.prehistoricnature.block.BlockRegistration;
import com.aechtrob.prehistoricnature.entity.entities.PNBoat;
import com.aechtrob.prehistoricnature.item.ItemHandler;
import com.aechtrob.prehistoricnature.item.items.PNBoatItem;
import com.ibm.icu.impl.Pair;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

import static com.aechtrob.prehistoricnature.creativetabs.CreativeTabHelper.transportTabBoatTier;

public class ItemsTreeLepidodendron {
    public static void register(){}
    public static final RegistryObject<Item> LEPIDODENDRON_SIGN_ITEM = BlockRegistration.signItem(BlocksTreeLepidodendron.LEPIDODENDRON_PLANKS,BlocksTreeLepidodendron.LEPIDODENDRON_WALL_SIGN,BlocksTreeLepidodendron.LEPIDODENDRON_SIGN,
            List.of(ItemTags.SIGNS),BlocksTreeLepidodendron.treeName,BlocksTreeLepidodendron.treeId);


    public static final RegistryObject<Item> LEPIDODENDRON_BOAT_ITEM = ItemHandler.addItem("lepidodendron_boat",
            () -> new PNBoatItem(false, PNBoat.Type.LEPIDODENDRON, new Item.Properties().stacksTo(1)),
            (provider, item) -> {provider.basicItem(item);},
            java.util.List.of(Pair.of("prehistoricnature_transport_tab",Pair.of(transportTabBoatTier,BlocksTreeLepidodendron.treeId))),
            "Lepidodendron Boat");

    public static final RegistryObject<Item> LEPIDODENDRON_CHEST_BOAT_ITEM = ItemHandler.addItem("lepidodendron_chest_boat",
            () -> new PNBoatItem(true, PNBoat.Type.LEPIDODENDRON, new Item.Properties().stacksTo(1)),
            (provider, item) -> {provider.basicItem(item);},
            java.util.List.of(Pair.of("prehistoricnature_transport_tab",Pair.of(transportTabBoatTier,BlocksTreeLepidodendron.treeId))),
            "Lepidodendron Chest Boat");


            //regular item creation applies



}
