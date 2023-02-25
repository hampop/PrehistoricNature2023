package com.aechtrob.prehistoricnature;

import com.aechtrob.prehistoricnature.block.*;
import com.aechtrob.prehistoricnature.creativetabs.*;
import com.aechtrob.prehistoricnature.item.*;
import com.aechtrob.prehistoricnature.world.ModConfiguredFeatures;
import com.aechtrob.prehistoricnature.world.tree.PNFoliagePlacerType;
import com.aechtrob.prehistoricnature.world.tree.PNTrunkPlacerType;
import com.ibm.icu.impl.*;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.*;
import org.slf4j.Logger;

import java.util.*;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(PrehistoricNatureMod.MOD_ID)
public class PrehistoricNatureMod
{
    public static final String MOD_ID = "prehistoricnature";
    public static final Logger LOGGER = LogUtils.getLogger();

    public PrehistoricNatureMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);
        ItemHandler.register(modEventBus);
        BlockHandler.register(modEventBus);

        PNTrunkPlacerType.TRUNK_PLACER_TYPES.register(modEventBus);
        PNFoliagePlacerType.FOLIAGE_PLACER_TYPES.register(modEventBus);
        ModConfiguredFeatures.register(modEventBus);


        MinecraftForge.EVENT_BUS.register(this);
    }

    public void addCreative(CreativeModeTabEvent.BuildContents event){
        CreativeTabHelper.getCreativeItems().get(event.getTab())
                .stream()
                .sorted(Comparator.comparingInt((Pair<RegistryObject<ItemLike>, Integer> pair) -> pair.second).thenComparing(pair -> pair.first.getId()))
                .forEach((pair) -> {
                    event.accept(pair.first);
                });
        CreativeTabs.register();
        CreativeTabHelper.substituteTabs();
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

   @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }

}
