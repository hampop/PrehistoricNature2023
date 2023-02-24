package com.aechtrob.prehistoricnature.item;

import com.aechtrob.prehistoricnature.*;
import com.aechtrob.prehistoricnature.datagen.*;
import com.aechtrob.prehistoricnature.datagen.helpers.*;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.registries.*;

import java.util.function.*;

//This handler class handles everything to do with adding items to the mod. See comments on registerBlock for details
//on how to use it.
public class ItemHandler {

    public static final DeferredRegister<Item> ITEMS =
                DeferredRegister.create(ForgeRegistries.ITEMS, PrehistoricNatureMod.MOD_ID);

    public static void register(IEventBus eventBus){
        PrehistoricNatureItems.register();
        ITEMS.register(eventBus);
    }

   //The  main method that you should be using to add items. Takes care of the lang file as well, but is incomplete for now.
    //TODO add item model generation, add tag generation
    public static <T extends Item> RegistryObject<Item> addItem(String name, Item.Properties properties, String translation,
                                                                BiConsumer<PrehistoricNatureItemModelProvider, RegistryObject<Item>> itemConsumer){
        RegistryObject<Item> returnItem = ITEMS.register(name, () -> {return new Item(properties);});
        ModelHelper.addItemModel(returnItem,itemConsumer);
        LanguageHelper.addItemTranslation(returnItem, translation);
        return returnItem;
    }
}
