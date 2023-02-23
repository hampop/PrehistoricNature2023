package com.aechtrob.prehistoricnature.item;

import com.aechtrob.prehistoricnature.*;
import com.aechtrob.prehistoricnature.datagen.helpers.*;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.registries.*;

public class ItemHandler {

    public static final DeferredRegister<Item> ITEMS =
                DeferredRegister.create(ForgeRegistries.ITEMS, PrehistoricNatureMod.MOD_ID);

    public static void register(IEventBus eventBus){
        PrehistoricNatureItems.register();
        ITEMS.register(eventBus);
    }

    public static <T extends Item> RegistryObject<Item> addItem(String name, Item.Properties properties, String translation){
        RegistryObject<Item> returnItem = ITEMS.register(name, () -> {return new Item(properties);});
        LanguageHelper.addItemTranslation(returnItem, translation);
        return returnItem;
    }
}
