package com.aechtrob.prehistoricnature;

import com.aechtrob.prehistoricnature.blocks.ModBlocks;
import com.aechtrob.prehistoricnature.blocks.trees.lepidodendron.ModBlocksTreeLepidodendron;
import com.aechtrob.prehistoricnature.items.ModItems;
import com.aechtrob.prehistoricnature.world.ModConfiguredFeatures;
import com.aechtrob.prehistoricnature.world.tree.PNFoliagePlacerType;
import com.aechtrob.prehistoricnature.world.tree.PNTrunkPlacerType;
import com.mojang.logging.LogUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(PrehistoricNatureMod.MOD_ID)
public class PrehistoricNatureMod
{
    public static final String MOD_ID = "prehistoricnature";
    private static final Logger LOGGER = LogUtils.getLogger();

    public PrehistoricNatureMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.ITEMS.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlocksTreeLepidodendron.register(modEventBus);

        PNTrunkPlacerType.TRUNK_PLACER_TYPES.register(modEventBus);
        PNFoliagePlacerType.FOLIAGE_PLACER_TYPES.register(modEventBus);
        ModConfiguredFeatures.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

   @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }

}
