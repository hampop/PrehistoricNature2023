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
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.*;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import java.util.*;

@Mod.EventBusSubscriber(modid = PrehistoricNatureMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreativeTabs {
    public static CreativeModeTab PREHISTORIC_NATURE_BUILDING;
    public static CreativeModeTab PREHISTORIC_NATURE_NATURAL;
    public static CreativeModeTab PREHISTORIC_NATURE_FOSSILS;
    public static CreativeModeTab PREHISTORIC_NATURE_FUNCTIONAL;
    public static CreativeModeTab PREHISTORIC_NATURE_TRANSPORT;
    public static CreativeModeTab PREHISTORIC_NATURE_MOBILE;
    public static CreativeModeTab PREHISTORIC_NATURE_PLANTS;
    public static CreativeModeTab PREHISTORIC_NATURE_STATIC;
    private static BuildCreativeModeTabContentsEvent.Register Event;

    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {

        PREHISTORIC_NATURE_FOSSILS = addTab("prehistoricnature_fossils_tab",PrehistoricNatureItems.GEOLOGIC_PICK,
                "Prehistoric Nature Fossils",Event);

        PREHISTORIC_NATURE_BUILDING = addTab("prehistoricnature_building_tab", BlocksTreeLepidodendron.LEPIDODENDRON_PLANKS,
                "Prehistoric Nature Building Blocks", Event);

        PREHISTORIC_NATURE_NATURAL = addTab("prehistoricnature_natural_tab", BlocksTreeLepidodendron.LEPIDODENDRON_SAPLING,
                "Prehistoric Nature Natural Blocks", Event);

        PREHISTORIC_NATURE_FUNCTIONAL = addTab("prehistoricnature_functional_tab", ItemsTreeLepidodendron.LEPIDODENDRON_SIGN_ITEM,
                "Prehistoric Nature Functional Blocks", Event);

        PREHISTORIC_NATURE_TRANSPORT = addTab("prehistoricnature_transport_tab", ItemsTreeLepidodendron.LEPIDODENDRON_BOAT_ITEM,
                "Prehistoric Nature Transportation", Event);
    }

    private static <T extends ItemLike> CreativeModeTab addTab(String name, RegistryObject<T> icon, String translation, CreativeModeTabEvent.Register event){

        CreativeModeTab tab = event.registerCreativeModeTab(
                new ResourceLocation(PrehistoricNatureMod.MOD_ID, name),
                builder -> builder.icon(()-> new ItemStack(icon.get()))
                        .displayItems((enabledFlags, populator, hasPermissions)->{
                            CreativeTabHelper.getCreativeItems().get(name).stream()
                                    .sorted(Comparator.comparingInt((Pair<RegistryObject<ItemLike>, Pair<Integer, Integer>> pair) -> pair.second.first)
                                            .thenComparingInt(pair -> pair.second.second)
                                            .thenComparing(pair -> pair.first.getId()))
                                    .forEach((pair->populator.accept(pair.first.get())));
                        })
                        .title(Component.translatable("prehistoricnature."+name))
        );
        LanguageHelper.addTranslatableTranslation("prehistoricnature."+name, translation);
        return tab;
    }


}
