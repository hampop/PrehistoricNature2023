package com.aechtrob.prehistoricnature.block.trees.lepidodendron;

import com.aechtrob.prehistoricnature.*;
import com.aechtrob.prehistoricnature.block.*;
import com.aechtrob.prehistoricnature.block.blocks.*;
import com.aechtrob.prehistoricnature.creativetabs.*;
import com.aechtrob.prehistoricnature.datagen.*;
import com.aechtrob.prehistoricnature.datagen.loottable.*;
import com.aechtrob.prehistoricnature.world.tree.lepidodendron.LepidodendronTreeGrower;
import com.ibm.icu.impl.*;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.*;
import net.minecraft.sounds.*;
import net.minecraft.tags.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;

import java.util.*;

public class ModBlocksTreeLepidodendron {
    public static class LepidodendronBlockTags {
        public static TagKey<Block> LEPIDODENDRON_LOGS = BlockTags.create(new ResourceLocation(PrehistoricNatureMod.MOD_ID, "lepidodendron_logs"));
    }
    public static class LepidodendronItemTags {
        public static TagKey<Item> LEPIDODENDRON_LOGS = ItemTags.create(new ResourceLocation(PrehistoricNatureMod.MOD_ID, "lepidodendron_logs"));
    }

    public static final RegistryObject<Block> LEPIDODENDRON_LOG = BlockHandler.registerBlock("lepidodendron_log",
            () -> new PNRotatedPillarFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)){
                @Override
                public Block getStrippedBlock() {
                    return ModBlocksTreeLepidodendron.LEPIDODENDRON_STRIPPED_LOG.get().defaultBlockState().getBlock();
                }
            }, List.of(LepidodendronBlockTags.LEPIDODENDRON_LOGS,BlockTags.MINEABLE_WITH_AXE,BlockTags.LOGS,BlockTags.LOGS_THAT_BURN,BlockTags.OVERWORLD_NATURAL_LOGS),
            List.of(LepidodendronItemTags.LEPIDODENDRON_LOGS, ItemTags.LOGS,ItemTags.LOGS_THAT_BURN),
            PrehistoricNatureBlockStateProvider::logBlock,
            (provider, item) -> {provider.withExistingParent("lepidodendron_log", new ResourceLocation(PrehistoricNatureMod.MOD_ID, "block/lepidodendron_log"));},
            BlockLootSubProvider::dropSelf,
            List.of(Pair.of("prehistoricnature_natural_tab",10),Pair.of("prehistoricnature_building_tab",10)),
            "Lepidodendron Log");

    public static final RegistryObject<Block> LEPIDODENDRON_STRIPPED_LOG = BlockHandler.registerBlock("lepidodendron_log_stripped",
            () -> new PNRotatedPillarFlammableBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)),
            List.of(LepidodendronBlockTags.LEPIDODENDRON_LOGS,BlockTags.MINEABLE_WITH_AXE,BlockTags.LOGS,BlockTags.LOGS_THAT_BURN,BlockTags.OVERWORLD_NATURAL_LOGS),
            List.of(LepidodendronItemTags.LEPIDODENDRON_LOGS, ItemTags.LOGS,ItemTags.LOGS_THAT_BURN),
            PrehistoricNatureBlockStateProvider::axisBlock,
            (provider, item) -> {provider.withExistingParent("lepidodendron_log_stripped", new ResourceLocation(PrehistoricNatureMod.MOD_ID, "block/lepidodendron_log_stripped"));},
            BlockLootSubProvider::dropSelf,
            List.of(Pair.of("prehistoricnature_building_tab",10)),
            "Lepidodendron Stripped Log");

    public static final RegistryObject<Block> LEPIDODENDRON_WOOD = BlockHandler.registerBlock("lepidodendron_wood",
            () -> new PNRotatedPillarFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)
                ){
                @Override
                public Block getStrippedBlock() {
                    return ModBlocksTreeLepidodendron.LEPIDODENDRON_STRIPPED_WOOD.get().defaultBlockState().getBlock();
                }
            }, List.of(LepidodendronBlockTags.LEPIDODENDRON_LOGS, BlockTags.MINEABLE_WITH_AXE,BlockTags.LOGS,BlockTags.LOGS_THAT_BURN,BlockTags.OVERWORLD_NATURAL_LOGS),
            List.of(LepidodendronItemTags.LEPIDODENDRON_LOGS, ItemTags.LOGS,ItemTags.LOGS_THAT_BURN),
            PrehistoricNatureBlockStateProvider::axisBlock,
            (provider, item) -> {provider.withExistingParent("lepidodendron_wood", new ResourceLocation(PrehistoricNatureMod.MOD_ID, "block/lepidodendron_wood"));},
            BlockLootSubProvider::dropSelf,
            (provider,block) -> {provider.twoByTwoRecipeBlocktoBlock(RecipeCategory.BUILDING_BLOCKS,LEPIDODENDRON_LOG,block,3);},
            List.of(Pair.of("prehistoricnature_building_tab",10),Pair.of("prehistoricnature_natural_tab",10)),
            "Lepidodendron Wood");

    public static final RegistryObject<Block> LEPIDODENDRON_STRIPPED_WOOD = BlockHandler.registerBlock(
            "lepidodendron_wood_stripped",
            () -> new PNRotatedPillarFlammableBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)
                    ), List.of(LepidodendronBlockTags.LEPIDODENDRON_LOGS, BlockTags.MINEABLE_WITH_AXE,BlockTags.LOGS,BlockTags.LOGS_THAT_BURN,BlockTags.OVERWORLD_NATURAL_LOGS),
            List.of(LepidodendronItemTags.LEPIDODENDRON_LOGS, ItemTags.LOGS,ItemTags.LOGS_THAT_BURN),
            PrehistoricNatureBlockStateProvider::axisBlock,
            (provider, item) -> {provider.withExistingParent("lepidodendron_wood_stripped", new ResourceLocation(PrehistoricNatureMod.MOD_ID, "block/lepidodendron_wood_stripped"));},
            BlockLootSubProvider::dropSelf,
            (provider,block) -> {provider.twoByTwoRecipeBlocktoBlock(RecipeCategory.BUILDING_BLOCKS, LEPIDODENDRON_STRIPPED_LOG,block,3);},
            List.of(Pair.of("prehistoricnature_building_tab",10)),
            "Lepidodendron Stripped Wood");

    public static final RegistryObject<Block> LEPIDODENDRON_SAPLING = BlockHandler.registerBlock("lepidodendron_sapling",
            () -> new SaplingBlock(new LepidodendronTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)
            ),List.of(BlockTags.SAPLINGS),
            List.of(ItemTags.SAPLINGS),
            PrehistoricNatureBlockStateProvider::saplingBlock,
            (provider, item) -> {provider.paneNoSide("lepidodendron_sapling",new ResourceLocation(PrehistoricNatureMod.MOD_ID,"block/lepidodendron_sapling"));},
            BlockLootSubProvider::dropSelf,
            List.of(Pair.of("prehistoricnature_natural_tab",10)),
            "Lepidodendron Sapling");

    public static final RegistryObject<Block> LEPIDODENDRON_LEAVES = BlockHandler.registerBlock("lepidodendron_leaves",
            () -> new PNLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)
                    ),
            List.of(BlockTags.MINEABLE_WITH_HOE, BlockTags.LEAVES),List.of(ItemTags.LEAVES),
            PrehistoricNatureBlockStateProvider::simpleBlock,
            (provider, item) -> {provider.withExistingParent("lepidodendron_leaves", new ResourceLocation(PrehistoricNatureMod.MOD_ID, "block/lepidodendron_leaves"));}
            ,(provider,block) -> {provider.createLeavesDrops(block,LEPIDODENDRON_SAPLING);},
            List.of(Pair.of("prehistoricnature_natural_tab",10)),
            "Lepidodendron Leaves");
    //TODO make 2d item model instead of 3d

    public static final RegistryObject<Block> LEPIDODENDRON_PLANKS = BlockHandler.registerBlock("lepidodendron_planks",
            () -> new PNPlanksFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
                    ), List.of(BlockTags.MINEABLE_WITH_AXE,BlockTags.PLANKS),List.of(ItemTags.PLANKS),
            PrehistoricNatureBlockStateProvider::simpleBlock,
            (provider, item) -> {provider.withExistingParent("lepidodendron_planks", new ResourceLocation(PrehistoricNatureMod.MOD_ID, "block/lepidodendron_planks"));},
            BlockLootSubProvider::dropSelf,
            (provider,block) -> {provider.shapelessConversionRecipe(RecipeCategory.BUILDING_BLOCKS, LepidodendronItemTags.LEPIDODENDRON_LOGS,block,4);},
            List.of(Pair.of("prehistoricnature_building_tab",10)),
            "Lepidodendron Planks");
    public static final RegistryObject<Block> LEPIDODENDRON_SLAB = BlockHandler.registerBlock("lepidodendron_slab",
            () -> new PNSlabFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)
                    ), List.of(BlockTags.MINEABLE_WITH_AXE,BlockTags.WOODEN_SLABS), List.of(ItemTags.WOODEN_SLABS),
            (provider, block) -> {provider.slabBlock(block, LEPIDODENDRON_PLANKS);},
            (provider, item) -> {provider.slab("lepidodendron_slab", new ResourceLocation(PrehistoricNatureMod.MOD_ID, "block/lepidodendron_planks"));},
            BlockLootSubProvider::dropSelf,
            (provider,block) -> {provider.slabRecipe(RecipeCategory.BUILDING_BLOCKS, LEPIDODENDRON_PLANKS,block);},
            List.of(Pair.of("prehistoricnature_building_tab",10)),
            "Lepidodendron Slab");
    public static final RegistryObject<Block> LEPIDODENDRON_STAIRS = BlockHandler.registerBlock("lepidodendron_stairs",
            () -> new PNStairFlammableBlock(() -> ModBlocksTreeLepidodendron.LEPIDODENDRON_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)
                    ), List.of(BlockTags.MINEABLE_WITH_AXE,BlockTags.WOODEN_STAIRS), List.of(ItemTags.WOODEN_STAIRS),
            (provider, block) -> {provider.stairsBlock(block, LEPIDODENDRON_PLANKS);},
            (provider, item) -> {provider.withExistingParent("lepidodendron_stairs", new ResourceLocation(PrehistoricNatureMod.MOD_ID, "block/lepidodendron_stairs"));},
            BlockLootSubProvider::dropSelf,
            (provider,block) -> {provider.stairRecipe(RecipeCategory.BUILDING_BLOCKS, LEPIDODENDRON_PLANKS,block);},
            List.of(Pair.of("prehistoricnature_building_tab",10)),
            "Lepidodendron Stairs");
    public static final RegistryObject<Block> LEPIDODENDRON_FENCE = BlockHandler.registerBlock("lepidodendron_fence",
            () -> new PNFenceFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)),
                    List.of(BlockTags.MINEABLE_WITH_AXE,BlockTags.WOODEN_FENCES), List.of(ItemTags.WOODEN_FENCES),
            (provider, block) -> {provider.fenceBlock(block, LEPIDODENDRON_PLANKS);},
            (provider, item) -> {provider.fenceInventory("lepidodendron_fence", new ResourceLocation(PrehistoricNatureMod.MOD_ID, "block/lepidodendron_planks"));},
            BlockLootSubProvider::dropSelf,
            (provider,block) -> {provider.fenceRecipe(RecipeCategory.BUILDING_BLOCKS, LEPIDODENDRON_PLANKS,block);},
            List.of(Pair.of("prehistoricnature_building_tab",10)),
            "Lepidodendron Fence");

    public static final RegistryObject<Block> LEPIDODENDRON_FENCE_GATE = BlockHandler.registerBlock("lepidodendron_fence_gate",
            () -> new PNFenceGateFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)
                    , SoundEvents.FENCE_GATE_CLOSE, SoundEvents.FENCE_GATE_OPEN),
            List.of(BlockTags.MINEABLE_WITH_AXE,BlockTags.FENCE_GATES),List.of(ItemTags.FENCE_GATES),
            (provider, block) -> {provider.fenceGateBlock(block, LEPIDODENDRON_PLANKS);},
            (provider, item) -> {provider.fenceGate("lepidodendron_fence_gate", new ResourceLocation(PrehistoricNatureMod.MOD_ID, "block/lepidodendron_planks"));},
            BlockLootSubProvider::dropSelf,
            (provider,block) -> {provider.fenceGateRecipe(RecipeCategory.BUILDING_BLOCKS, LEPIDODENDRON_PLANKS,block);},
            List.of(Pair.of("prehistoricnature_building_tab",10)),
            "Lepidodendron Fence Gate");

    public static final RegistryObject<Block> LEPIDODENDRON_DOOR = BlockHandler.registerBlock("lepidodendron_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR)
                    , SoundEvents.WOODEN_DOOR_OPEN, SoundEvents.WOODEN_DOOR_OPEN),
            List.of(BlockTags.MINEABLE_WITH_AXE,BlockTags.WOODEN_DOORS),List.of(ItemTags.WOODEN_DOORS),
            PrehistoricNatureBlockStateProvider::doorBlock,
            PrehistoricNatureItemModelProvider::basicItem,
            BlockLootSubProvider::createDoorTable,
            (provider,block) -> {provider.doorRecipe(RecipeCategory.BUILDING_BLOCKS, LEPIDODENDRON_PLANKS,block);},
            List.of(Pair.of("prehistoricnature_building_tab",10)),
            "Lepidodendron Door");

    //Needs manual json file.
    public static final RegistryObject<Block> LEPIDODENDRON_TRAPDOOR = BlockHandler.registerBlock("lepidodendron_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR)
                    , SoundEvents.WOODEN_TRAPDOOR_OPEN, SoundEvents.WOODEN_TRAPDOOR_OPEN),
            List.of(BlockTags.MINEABLE_WITH_AXE,BlockTags.WOODEN_TRAPDOORS),List.of(ItemTags.WOODEN_TRAPDOORS),
            BlockLootSubProvider::dropSelf,
            (provider,block) -> {provider.trapdoorRecipe(RecipeCategory.BUILDING_BLOCKS, LEPIDODENDRON_PLANKS,block);},
            List.of(Pair.of("prehistoricnature_building_tab",10)),
            "Lepidodendron Trapdoor");
    public static final RegistryObject<Block> LEPIDODENDRON_BUTTON = BlockHandler.registerBlock("lepidodendron_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON)
                    , 30, true, SoundEvents.WOODEN_BUTTON_CLICK_OFF, SoundEvents.WOODEN_BUTTON_CLICK_ON),
            List.of(BlockTags.MINEABLE_WITH_AXE,BlockTags.WOODEN_BUTTONS),List.of(ItemTags.WOODEN_BUTTONS),
            (provider, block) -> {provider.buttonBlock(block, LEPIDODENDRON_PLANKS);},
            (provider, item) -> {provider.buttonInventory("lepidodendron_button", new ResourceLocation(PrehistoricNatureMod.MOD_ID, "block/lepidodendron_planks"));},
            BlockLootSubProvider::dropSelf,
            (provider,block) -> {provider.shapelessConversionRecipe(RecipeCategory.BUILDING_BLOCKS, LEPIDODENDRON_PLANKS,block,1);},
            List.of(Pair.of("prehistoricnature_building_tab",10)),
            "Lepidodendron Button");

//    public static final RegistryObject<Block> LEPIDODENDRON_BENCH = BlockHandler.registerBlock("lepidodendron_bench",
//            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON)
//                    , 30, true, SoundEvents.WOODEN_BUTTON_CLICK_OFF, SoundEvents.WOODEN_BUTTON_CLICK_ON));

    //How do signs work? There are a few different blocks for each one!

    //Other tree-specific stuff:
    //
    //TODO make 2d item model instead of 3d
    public static final RegistryObject<Block> LEPIDODENDRON_STROBILUS = BlockHandler.registerBlock("lepidodendron_strobilus",
            () -> new LepidodendronStrobilus(BlockBehaviour.Properties.copy(Blocks.GRASS)),
            List.of(BlockTags.FLOWERS),
            List.of(ItemTags.FLOWERS),
            (provider, item) -> {provider.paneNoSide("lepidodendron_strobilus",new ResourceLocation(PrehistoricNatureMod.MOD_ID,"block/lepidodendron_strobilus"));},
            BlockLootSubProvider::dropSelf,
            List.of(Pair.of("prehistoricnature_natural_tab",10)),
            "Lepidodendron Strobilus", 0);

    public static void register() {
    }
}
