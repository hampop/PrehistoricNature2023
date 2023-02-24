package com.aechtrob.prehistoricnature.block.trees.lepidodendron;

import com.aechtrob.prehistoricnature.*;
import com.aechtrob.prehistoricnature.block.*;
import com.aechtrob.prehistoricnature.block.blocks.*;
import com.aechtrob.prehistoricnature.datagen.*;
import com.aechtrob.prehistoricnature.world.tree.lepidodendron.LepidodendronTreeGrower;
import com.ibm.icu.impl.*;
import com.machinezoo.noexception.throwing.*;
import net.minecraft.resources.*;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.storage.loot.*;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.registries.RegistryObject;

import java.util.*;

public class ModBlocksTreeLepidodendron {

    public static final RegistryObject<Block> LEPIDODENDRON_LOG = BlockHandler.registerBlock("lepidodendron_log",
            () -> new PNRotatedPillarFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)){
                @Override
                public Block getStrippedBlock() {
                    return ModBlocksTreeLepidodendron.LEPIDODENDRON_LOG_STRIPPED.get().defaultBlockState().getBlock();
                }
            }, List.of(BlockTags.MINEABLE_WITH_AXE,BlockTags.LOGS,BlockTags.LOGS_THAT_BURN,BlockTags.OVERWORLD_NATURAL_LOGS),
            List.of(ItemTags.LOGS,ItemTags.LOGS_THAT_BURN), (provider, block) -> {provider.logBlock(block);},
            (provider, item) -> {provider.withExistingParent("lepidodendron_log", new ResourceLocation(PrehistoricNatureMod.MOD_ID, "block/lepidodendron_log"));}
            ,(provider,block) -> {provider.dropSelf(block);},"Lepidodendron Log");

    public static final RegistryObject<Block> LEPIDODENDRON_LOG_STRIPPED = BlockHandler.registerBlock("lepidodendron_log_stripped",
            () -> new PNRotatedPillarFlammableBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)
                ),
            List.of(BlockTags.MINEABLE_WITH_AXE,BlockTags.LOGS,BlockTags.LOGS_THAT_BURN,BlockTags.OVERWORLD_NATURAL_LOGS),
            List.of(ItemTags.LOGS,ItemTags.LOGS_THAT_BURN), (provider, block) -> {provider.axisBlock(block);},
            (provider, item) -> {provider.withExistingParent("lepidodendron_log_stripped", new ResourceLocation(PrehistoricNatureMod.MOD_ID, "block/lepidodendron_log_stripped"));},
            (provider,block) -> {provider.dropSelf(block);},
            "Lepidodendron Stripped Log");

    public static final RegistryObject<Block> LEPIDODENDRON_WOOD = BlockHandler.registerBlock("lepidodendron_wood",
            () -> new PNRotatedPillarFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)
                ){
                @Override
                public Block getStrippedBlock() {
                    return ModBlocksTreeLepidodendron.LEPIDODENDRON_WOOD_STRIPPED.get().defaultBlockState().getBlock();
                }
            }, List.of(BlockTags.MINEABLE_WITH_AXE,BlockTags.LOGS,BlockTags.LOGS_THAT_BURN,BlockTags.OVERWORLD_NATURAL_LOGS),
            List.of(ItemTags.LOGS,ItemTags.LOGS_THAT_BURN), (provider, block) -> {provider.axisBlock(block);},
            (provider, item) -> {provider.withExistingParent("lepidodendron_wood", new ResourceLocation(PrehistoricNatureMod.MOD_ID, "block/lepidodendron_wood"));}
            ,(provider,block) -> {provider.dropSelf(block);},"Lepidodendron Wood");

    public static final RegistryObject<Block> LEPIDODENDRON_WOOD_STRIPPED = BlockHandler.registerBlock("lepidodendron_wood_stripped",
            () -> new PNRotatedPillarFlammableBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)
                    ), List.of(BlockTags.MINEABLE_WITH_AXE,BlockTags.LOGS,BlockTags.LOGS_THAT_BURN,BlockTags.OVERWORLD_NATURAL_LOGS),
            List.of(ItemTags.LOGS,ItemTags.LOGS_THAT_BURN), (provider, block) -> {provider.axisBlock(block);},
            (provider, item) -> {provider.withExistingParent("lepidodendron_wood_stripped", new ResourceLocation(PrehistoricNatureMod.MOD_ID, "block/lepidodendron_wood_stripped"));}
            ,(provider,block) -> {provider.dropSelf(block);},"Lepidodendron Stripped Wood");

    public static final RegistryObject<Block> LEPIDODENDRON_LEAVES = BlockHandler.registerBlock("lepidodendron_leaves",
            () -> new PNLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)
                    ),
            List.of(BlockTags.MINEABLE_WITH_HOE, BlockTags.LEAVES),List.of(ItemTags.LEAVES),
            (provider, block) -> {provider.simpleBlock(block);},
            (provider, item) -> {provider.withExistingParent("lepidodendron_leaves", new ResourceLocation(PrehistoricNatureMod.MOD_ID, "block/lepidodendron_leaves"));}
            ,(provider,block) -> {provider.createLeavesDrops(block,block);},"Lepidodendron Leaves");

    public static final RegistryObject<Block> LEPIDODENDRON_SAPLING = BlockHandler.registerBlock("lepidodendron_sapling",
            () -> new SaplingBlock(new LepidodendronTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)
                    ),List.of(BlockTags.SAPLINGS),
            List.of(ItemTags.SAPLINGS),(provider, block) -> {provider.saplingBlock(block);},
            (provider, item) -> {provider.withExistingParent("lepidodendron_sapling",new ResourceLocation(PrehistoricNatureMod.MOD_ID,"block/lepidodendron_sapling"));}, (provider,block) -> {provider.dropSelf(block);},"Lepidodendron Sapling");

    public static final RegistryObject<Block> LEPIDODENDRON_PLANKS = BlockHandler.registerBlock("lepidodendron_planks",
            () -> new PNPlanksFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
                    ), List.of(BlockTags.MINEABLE_WITH_AXE,BlockTags.PLANKS),List.of(ItemTags.PLANKS),
            (provider, block) -> {provider.simpleBlock(block);},
            (provider, item) -> {provider.withExistingParent("lepidodendron_planks", new ResourceLocation(PrehistoricNatureMod.MOD_ID, "block/lepidodendron_planks"));},
            (provider,block) -> {provider.dropSelf(block);},"Lepidodendron Planks");
    public static final RegistryObject<Block> LEPIDODENDRON_SLAB = BlockHandler.registerBlock("lepidodendron_slab",
            () -> new PNSlabFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)
                    ), List.of(BlockTags.MINEABLE_WITH_AXE,BlockTags.WOODEN_SLABS), List.of(ItemTags.WOODEN_SLABS),
            (provider, block) -> {provider.slabBlock(block, LEPIDODENDRON_PLANKS);},
            (provider, item) -> {provider.withExistingParent("lepidodendron_slab", new ResourceLocation(PrehistoricNatureMod.MOD_ID, "block/lepidodendron_planks"));},
            (provider,block) -> {provider.dropSelf(block);},"Lepidodendron Slab");
    public static final RegistryObject<Block> LEPIDODENDRON_STAIRS = BlockHandler.registerBlock("lepidodendron_stairs",
            () -> new PNStairFlammableBlock(() -> ModBlocksTreeLepidodendron.LEPIDODENDRON_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)
                    ), List.of(BlockTags.MINEABLE_WITH_AXE,BlockTags.WOODEN_STAIRS), List.of(ItemTags.WOODEN_STAIRS),
            (provider, block) -> {provider.stairsBlock(block, LEPIDODENDRON_PLANKS);},
            (provider, item) -> {provider.withExistingParent("lepidodendron_stairs", new ResourceLocation(PrehistoricNatureMod.MOD_ID, "block/lepidodendron_planks"));},
            (provider,block) -> {provider.dropSelf(block);},"Lepidodendron Stairs");
    public static final RegistryObject<Block> LEPIDODENDRON_FENCE = BlockHandler.registerBlock("lepidodendron_fence",
            () -> new PNFenceFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)),
                    List.of(BlockTags.MINEABLE_WITH_AXE,BlockTags.WOODEN_FENCES, BlockTags.FENCES), List.of(ItemTags.WOODEN_FENCES, ItemTags.FENCES),
            (provider, block) -> {provider.fenceBlock(block, LEPIDODENDRON_PLANKS);},
            (provider, item) -> {provider.fencePost("lepidodendron_fence", new ResourceLocation(PrehistoricNatureMod.MOD_ID, "block/lepidodendron_planks"));},
            (provider,block) -> {provider.dropSelf(block);},"Lepidodendron Stairs");
    /*
    public static final RegistryObject<Block> LEPIDODENDRON_FENCE_GATE = BlockHandler.registerBlock("lepidodendron_fence_gate",
            () -> new PNFenceGateFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)
                    , SoundEvents.FENCE_GATE_CLOSE, SoundEvents.FENCE_GATE_OPEN));
    public static final RegistryObject<Block> LEPIDODENDRON_DOOR = BlockHandler.registerBlock("lepidodendron_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR)
                    , SoundEvents.WOODEN_DOOR_OPEN, SoundEvents.WOODEN_DOOR_OPEN));

    //Needs manual json file.
    public static final RegistryObject<Block> LEPIDODENDRON_TRAPDOOR = BlockHandler.registerBlock("lepidodendron_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR)
                    , SoundEvents.WOODEN_TRAPDOOR_OPEN, SoundEvents.WOODEN_TRAPDOOR_OPEN));
    public static final RegistryObject<Block> LEPIDODENDRON_BUTTON = BlockHandler.registerBlock("lepidodendron_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON)
                    , 30, true, SoundEvents.WOODEN_BUTTON_CLICK_OFF, SoundEvents.WOODEN_BUTTON_CLICK_ON));
*/
//    public static final RegistryObject<Block> LEPIDODENDRON_BENCH = BlockHandler.registerBlock("lepidodendron_bench",
//            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON)
//                    , 30, true, SoundEvents.WOODEN_BUTTON_CLICK_OFF, SoundEvents.WOODEN_BUTTON_CLICK_ON));

    //How do signs work? There are a few different blocks for each one!

    //Other tree-specific stuff:
    public static final RegistryObject<Block> LEPIDODENDRON_STROBILUS = BlockHandler.registerBlock("lepidodendron_strobilus",
            () -> new LepidodendronStrobilus(BlockBehaviour.Properties.copy(Blocks.GRASS)), List.of(BlockTags.FLOWERS),
            List.of(ItemTags.FLOWERS),(provider, block) -> {provider.saplingBlock(block);},(provider, item) -> {provider.withExistingParent("lepidodendron_strobilus",new ResourceLocation(PrehistoricNatureMod.MOD_ID,"block/lepidodendron_strobilus"));},
            (provider,block) -> {provider.dropSelf(block);}
            ,"Lepidodendron Strobilus");

    public static void register() {
    }
}
