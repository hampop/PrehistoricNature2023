package com.aechtrob.prehistoricnature.block.trees.lepidodendron;

import com.aechtrob.prehistoricnature.block.*;
import com.aechtrob.prehistoricnature.block.blocks.*;
import com.aechtrob.prehistoricnature.world.tree.lepidodendron.LepidodendronTreeGrower;
import com.machinezoo.noexception.throwing.*;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
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
            List.of(ItemTags.LOGS,ItemTags.LOGS_THAT_BURN), block ->{
                ThrowingBiConsumer<BlockStateProvider, RotatedPillarBlock> blockStateProviderBlockThrowingBiConsumer = BlockStateProvider::logBlock;}
            ,"Lepidodendron Log");
    public static final RegistryObject<Block> LEPIDODENDRON_LOG_STRIPPED = BlockHandler.registerBlock("lepidodendron_log_stripped",
            () -> new PNRotatedPillarFlammableBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)
                .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> LEPIDODENDRON_WOOD = BlockHandler.registerBlock("lepidodendron_wood",
            () -> new PNRotatedPillarFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)
                .requiresCorrectToolForDrops()){
                @Override
                public Block getStrippedBlock() {
                    return ModBlocksTreeLepidodendron.LEPIDODENDRON_WOOD_STRIPPED.get().defaultBlockState().getBlock();
                }
            });
    public static final RegistryObject<Block> LEPIDODENDRON_WOOD_STRIPPED = BlockHandler.registerBlock("lepidodendron_wood_stripped",
            () -> new PNRotatedPillarFlammableBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> LEPIDODENDRON_LEAVES = BlockHandler.registerBlock("lepidodendron_leaves",
            () -> new PNLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> LEPIDODENDRON_SAPLING = BlockHandler.registerBlock("lepidodendron_sapling",
            () -> new SaplingBlock(new LepidodendronTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> LEPIDODENDRON_PLANKS = BlockHandler.registerBlock("lepidodendron_planks",
            () -> new PNPlanksFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> LEPIDODENDRON_SLAB = BlockHandler.registerBlock("lepidodendron_slab",
            () -> new PNSlabFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> LEPIDODENDRON_STAIRS = BlockHandler.registerBlock("lepidodendron_stairs",
            () -> new PNStairFlammableBlock(() -> ModBlocksTreeLepidodendron.LEPIDODENDRON_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> LEPIDODENDRON_FENCE = BlockHandler.registerBlock("lepidodendron_fence",
            () -> new PNFenceFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> LEPIDODENDRON_FENCE_GATE = BlockHandler.registerBlock("lepidodendron_fence_gate",
            () -> new PNFenceGateFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)
                    .requiresCorrectToolForDrops(), SoundEvents.FENCE_GATE_CLOSE, SoundEvents.FENCE_GATE_OPEN));
    public static final RegistryObject<Block> LEPIDODENDRON_DOOR = BlockHandler.registerBlock("lepidodendron_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR)
                    .requiresCorrectToolForDrops(), SoundEvents.WOODEN_DOOR_OPEN, SoundEvents.WOODEN_DOOR_OPEN));
    public static final RegistryObject<Block> LEPIDODENDRON_TRAPDOOR = BlockHandler.registerBlock("lepidodendron_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR)
                    .requiresCorrectToolForDrops(), SoundEvents.WOODEN_TRAPDOOR_OPEN, SoundEvents.WOODEN_TRAPDOOR_OPEN));
    public static final RegistryObject<Block> LEPIDODENDRON_BUTTON = BlockHandler.registerBlock("lepidodendron_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON)
                    .requiresCorrectToolForDrops(), 30, true, SoundEvents.WOODEN_BUTTON_CLICK_OFF, SoundEvents.WOODEN_BUTTON_CLICK_ON));
//    public static final RegistryObject<Block> LEPIDODENDRON_BENCH = BlockHandler.registerBlock("lepidodendron_bench",
//            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON)
//                    .requiresCorrectToolForDrops(), 30, true, SoundEvents.WOODEN_BUTTON_CLICK_OFF, SoundEvents.WOODEN_BUTTON_CLICK_ON));

    //How do signs work? There are a few different blocks for each one!


    //Other tree-specific stuff:
    public static final RegistryObject<Block> LEPIDODENDRON_STROBILUS = BlockHandler.registerBlock("lepidodendron_strobilus",
            () -> new LepidodendronStrobilus(BlockBehaviour.Properties.copy(Blocks.GRASS)));



}
