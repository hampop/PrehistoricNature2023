package com.aechtrob.prehistoricnature.creativetabs;

import com.aechtrob.prehistoricnature.*;
import com.aechtrob.prehistoricnature.item.*;
import com.aechtrob.prehistoricnature.*;
import com.aechtrob.prehistoricnature.block.*;
import com.aechtrob.prehistoricnature.datagen.helpers.*;
import net.minecraft.network.chat.*;
import net.minecraft.resources.*;
import net.minecraft.world.item.*;
import net.minecraftforge.event.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.common.*;

@Mod.EventBusSubscriber(modid = PrehistoricNatureMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreativeTabs {
    public static CreativeModeTab LEPIDODENDRON_BUILDING;
    public static CreativeModeTab LEPIDODENDRON_MISC;
    public static CreativeModeTab LEPIDODENDRON_MOBILE;
    public static CreativeModeTab LEPIDODENDRON_PLANTS;
    public static CreativeModeTab LEPIDODENDRON_STATIC;



//    @SubscribeEvent
//    public void registerTabs(CreativeModeTabEvent.Register event){
//        LEPIDODENDRON_BUILDING = addTab("lepidodendron_building_tab",ItemHandler.TEST.get(),"lepidodendron.building_tab", event);
//    }

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        LEPIDODENDRON_BUILDING = event.registerCreativeModeTab(new ResourceLocation(PrehistoricNatureMod.MOD_ID, "lepidodendron_building_tab"),
                builder -> builder.icon(() -> new ItemStack(PrehistoricNatureItems.GEOLOGIC_PICK.get()))
                        .title(Component.translatable("lepidodendron.building_tab")));
        LanguageHelper.addTranslatableTranslation("object.lepidodendron.building_tab", "Prehistoric Nature Building Blocks");
    }

    private CreativeModeTab addTab(String name, Item icon, String translationId, CreativeModeTabEvent.Register event){
        CreativeModeTab tab = event.registerCreativeModeTab(
                new ResourceLocation(PrehistoricNatureMod.MOD_ID, name),
                builder -> builder.icon(()-> new ItemStack(icon))
                        .title(Component.translatable(translationId))
        );
        return tab;
    }


}
