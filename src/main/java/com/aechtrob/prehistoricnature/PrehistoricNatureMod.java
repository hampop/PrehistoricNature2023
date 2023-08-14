package com.aechtrob.prehistoricnature;

import com.aechtrob.prehistoricnature.block.BlockHandler;
import com.aechtrob.prehistoricnature.block.VanillaAdditions;
import com.aechtrob.prehistoricnature.block.trees.WoodTypeHelper;
import com.aechtrob.prehistoricnature.entity.block.PNBlockEntities;
import com.aechtrob.prehistoricnature.entity.entities.PNEntities;
import com.aechtrob.prehistoricnature.item.ItemHandler;
import com.aechtrob.prehistoricnature.world.ModConfiguredFeatures;
import com.aechtrob.prehistoricnature.world.tree.PNFoliagePlacerType;
import com.aechtrob.prehistoricnature.world.tree.PNTrunkPlacerType;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import static net.minecraft.world.item.CreativeModeTabs.*;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(PrehistoricNatureMod.MOD_ID)
public class PrehistoricNatureMod
{
    public static final String MOD_ID = "prehistoricnature";
    public static final Logger LOGGER = LogUtils.getLogger();

    public PrehistoricNatureMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        PNBlockEntities.register(modEventBus);
        BlockHandler.register(modEventBus);
        PNEntities.register(modEventBus);
        ItemHandler.register(modEventBus);

        PNTrunkPlacerType.TRUNK_PLACER_TYPES.register(modEventBus);
        PNFoliagePlacerType.FOLIAGE_PLACER_TYPES.register(modEventBus);
        ModConfiguredFeatures.register(modEventBus);
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);
        MinecraftForge.EVENT_BUS.register(this);
    }

    public void addCreative(BuildCreativeModeTabContentsEvent event){
        if(event.getResult() == CreativeModeTabs.FUNCTIONAL_BLOCKS()){
            event.getEntries().putAfter(new ItemStack(Blocks.LADDER),new ItemStack(VanillaAdditions.SPRUCE_LADDER.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(VanillaAdditions.SPRUCE_LADDER.get()),new ItemStack(VanillaAdditions.BIRCH_LADDER.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(VanillaAdditions.BIRCH_LADDER.get()),new ItemStack(VanillaAdditions.JUNGLE_LADDER.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(VanillaAdditions.JUNGLE_LADDER.get()),new ItemStack(VanillaAdditions.ACACIA_LADDER.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(VanillaAdditions.ACACIA_LADDER.get()),new ItemStack(VanillaAdditions.DARK_OAK_LADDER.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(VanillaAdditions.DARK_OAK_LADDER.get()),new ItemStack(VanillaAdditions.MANGROVE_LADDER.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(VanillaAdditions.MANGROVE_LADDER.get()),new ItemStack(VanillaAdditions.CRIMSON_LADDER.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(VanillaAdditions.CRIMSON_LADDER.get()),new ItemStack(VanillaAdditions.WARPED_LADDER.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

   @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            WoodTypeHelper.getWoodTypes().stream().forEach((woodType -> Sheets.addWoodType(woodType)));
            WoodTypeHelper.getWoodTypes().stream().forEach((woodType -> WoodType.register(woodType)));
        }

       @SubscribeEvent
       public static void onClientSetup(EntityRenderersEvent.RegisterRenderers event)
       {
           PNBlockEntities.registerTileEntityRenders(event);
           PNEntities.registerEntityRenders(event);
       }

       @SubscribeEvent
       public static void onClientSetup(EntityRenderersEvent.RegisterLayerDefinitions event)
       {
           PNEntities.registerEntityLayers(event);
       }

    }

}
