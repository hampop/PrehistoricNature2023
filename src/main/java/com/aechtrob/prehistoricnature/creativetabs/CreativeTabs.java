package com.aechtrob.prehistoricnature.creativetabs;

import com.aechtrob.prehistoricnature.*;
import com.aechtrob.prehistoricnature.block.trees.lepidodendron.*;
import com.aechtrob.prehistoricnature.item.*;
import com.aechtrob.prehistoricnature.datagen.helpers.*;
import com.ibm.icu.impl.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.*;
import net.minecraft.resources.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.registries.*;

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


    public static DeferredRegister < CreativeModeTab > REGISTRY = DeferredRegister.create ( Registries.CREATIVE_MODE_TAB , PrehistoricNatureMod.MOD_ID );

    {

        PREHISTORIC_NATURE_FOSSILS = addTab ( "prehistoricnature_fossils_tab" , PrehistoricNatureItems.GEOLOGIC_PICK ,
                "Prehistoric Nature Fossils"
                                            );

        PREHISTORIC_NATURE_BUILDING = addTab ( "prehistoricnature_building_tab" , BlocksTreeLepidodendron.LEPIDODENDRON_PLANKS ,
                "Prehistoric Nature Building Blocks"
                                             );

        PREHISTORIC_NATURE_NATURAL = addTab ( "prehistoricnature_natural_tab" , BlocksTreeLepidodendron.LEPIDODENDRON_SAPLING ,
                "Prehistoric Nature Natural Blocks"
                                            );

        PREHISTORIC_NATURE_FUNCTIONAL = addTab ( "prehistoricnature_functional_tab" , ItemsTreeLepidodendron.LEPIDODENDRON_SIGN_ITEM ,
                "Prehistoric Nature Functional Blocks"
                                               );

        PREHISTORIC_NATURE_TRANSPORT = addTab ( "prehistoricnature_transport_tab" , ItemsTreeLepidodendron.LEPIDODENDRON_BOAT_ITEM ,
                "Prehistoric Nature Transportation"
                                              );
    }

    private static
    < T extends ItemLike > CreativeModeTab addTab ( String name , RegistryObject < T > icon , String translation ) {

        CreativeModeTab tab = CreativeModeTab.builder ( )
                .icon ( ( ) -> new ItemStack ( icon.get ( ) ) )
                .displayItems((enabledFlags, populator) -> {
                    CreativeTabHelper.getCreativeItems().get(name).stream()
                            .sorted(Comparator.comparingInt((Pair<RegistryObject<ItemLike>, Pair<Integer, Integer>> pair) -> pair.second.first)
                                    .thenComparingInt(pair -> pair.second.second)
                                    .thenComparing(pair -> pair.first.getId()))
                            .forEach(pair -> populator.accept(pair.first.get()));
                })
                .title ( Component.translatable ( "prehistoricnature." + name ) )
                .build ( );

        LanguageHelper.addTranslatableTranslation ( "prehistoricnature." + name , translation );

        return tab;
    }
}