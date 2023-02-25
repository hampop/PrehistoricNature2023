package com.aechtrob.prehistoricnature.creativetabs;

import com.aechtrob.prehistoricnature.*;
import com.aechtrob.prehistoricnature.block.trees.lepidodendron.*;
import com.aechtrob.prehistoricnature.item.*;
import com.aechtrob.prehistoricnature.datagen.helpers.*;
import com.ibm.icu.impl.*;
import net.minecraft.network.chat.*;
import net.minecraft.resources.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraftforge.event.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.registries.*;

import java.util.*;

@Mod.EventBusSubscriber(modid = PrehistoricNatureMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreativeTabs {

    public static void register(){
        tabs.put("minecraft_ingredients_tab",CreativeModeTabs.INGREDIENTS);
        tabs.put("minecraft_building_blocks_tab",CreativeModeTabs.BUILDING_BLOCKS);
        tabs.put("minecraft_combat_tab",CreativeModeTabs.COMBAT);
        tabs.put("minecraft_colored_blocks_tab",CreativeModeTabs.COLORED_BLOCKS);
        tabs.put("minecraft_food_drinks_tab",CreativeModeTabs.FOOD_AND_DRINKS);
        tabs.put("minecraft_functional_blocks_tab",CreativeModeTabs.FUNCTIONAL_BLOCKS);
        tabs.put("minecraft_natural_blocks_tab",CreativeModeTabs.NATURAL_BLOCKS);
        tabs.put("minecraft_op_blocks_tab",CreativeModeTabs.OP_BLOCKS);
        tabs.put("minecraft_redstone_blocks_tab",CreativeModeTabs.REDSTONE_BLOCKS);
        tabs.put("minecraft_tools_and_utilities_tab",CreativeModeTabs.TOOLS_AND_UTILITIES);
        tabs.put("minecraft_swawn_eggs_tab",CreativeModeTabs.SPAWN_EGGS);
        tabs.put("prehistoricnature_fossils_tab", PREHISTORIC_NATURE_FOSSILS);
        tabs.put("prehistoricnature_building_tab", PREHISTORIC_NATURE_BUILDING);
        tabs.put("prehistoricnature_natural_tab", PREHISTORIC_NATURE_NATURAL);
    }
    public static CreativeModeTab PREHISTORIC_NATURE_BUILDING;

    public static CreativeModeTab PREHISTORIC_NATURE_NATURAL;

    public static CreativeModeTab PREHISTORIC_NATURE_FOSSILS;
    public static CreativeModeTab PREHISTORIC_NATURE_MISC;
    public static CreativeModeTab PREHISTORIC_NATURE_MOBILE;
    public static CreativeModeTab PREHISTORIC_NATURE_PLANTS;
    public static CreativeModeTab PREHISTORIC_NATURE_STATIC;

    public static HashMap<String, CreativeModeTab> tabs;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {

        PREHISTORIC_NATURE_FOSSILS = addTab("prehistoricnature_fossils_tab",PrehistoricNatureItems.GEOLOGIC_PICK,
                "Prehistoric Nature Fossils",event);

        PREHISTORIC_NATURE_BUILDING = addTab("prehistoricnature_building_tab", ModBlocksTreeLepidodendron.LEPIDODENDRON_PLANKS,
                "Prehistoric Nature Building Blocks", event);

        PREHISTORIC_NATURE_NATURAL = addTab("prehistoricnature_natural_tab", ModBlocksTreeLepidodendron.LEPIDODENDRON_SAPLING,
                "Prehistoric Nature Natural Blocks", event);
    }

    private static <T extends ItemLike> CreativeModeTab addTab(String name, RegistryObject<T> icon, String translation, CreativeModeTabEvent.Register event){
        CreativeModeTab tab = event.registerCreativeModeTab(
                new ResourceLocation(PrehistoricNatureMod.MOD_ID, name),
                builder -> builder.icon(()-> new ItemStack(icon.get()))
                        .title(Component.translatable("prehistoricnature."+name))
        );
        LanguageHelper.addTranslatableTranslation("prehistoricnature."+name, translation);
        return tab;
    }

    public static CreativeModeTab getTab(String id){
        return tabs.get(id);
    }


}
