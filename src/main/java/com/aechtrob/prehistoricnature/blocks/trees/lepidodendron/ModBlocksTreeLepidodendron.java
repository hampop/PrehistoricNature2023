package com.aechtrob.prehistoricnature.blocks.trees.lepidodendron;

import com.aechtrob.prehistoricnature.PrehistoricNatureMod;
import com.aechtrob.prehistoricnature.blocks.blocks.*;
import com.aechtrob.prehistoricnature.items.ModItems;
import com.aechtrob.prehistoricnature.world.tree.lepidodendron.LepidodendronTreeGrower;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocksTreeLepidodendron {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, PrehistoricNatureMod.MOD_ID);

    public static RegistryObject<Block> registerBlock(String name, Supplier<Block> block){
        return registerBlockWithItem(name, block, new Item.Properties());
    }

    public static RegistryObject<Block> registerBlockWithItem(String name, Supplier<Block> block, Item.Properties blockItemProps){
        RegistryObject<Block> blockObj = BLOCKS.register(name, block);
        ModItems.ITEMS.register(name, () -> new BlockItem(blockObj.get(), blockItemProps));
        return blockObj;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    public static final RegistryObject<Block> LEPIDODENDRON_LOG = registerBlock("lepidodendron_log",
            () -> new PNRotatedPillarFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)){
                @Override
                public Block getStrippedBlock() {
                    return ModBlocksTreeLepidodendron.LEPIDODENDRON_LOG_STRIPPED.get().defaultBlockState().getBlock();
                }
            });
    public static final RegistryObject<Block> LEPIDODENDRON_LOG_STRIPPED = registerBlock("lepidodendron_log_stripped",
            () -> new PNRotatedPillarFlammableBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)
                .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> LEPIDODENDRON_WOOD = registerBlock("lepidodendron_wood",
            () -> new PNRotatedPillarFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)
                .requiresCorrectToolForDrops()){
                @Override
                public Block getStrippedBlock() {
                    return ModBlocksTreeLepidodendron.LEPIDODENDRON_WOOD_STRIPPED.get().defaultBlockState().getBlock();
                }
            });
    public static final RegistryObject<Block> LEPIDODENDRON_WOOD_STRIPPED = registerBlock("lepidodendron_wood_stripped",
            () -> new PNRotatedPillarFlammableBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> LEPIDODENDRON_LEAVES = registerBlock("lepidodendron_leaves",
            () -> new PNLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> LEPIDODENDRON_SAPLING = registerBlock("lepidodendron_sapling",
            () -> new SaplingBlock(new LepidodendronTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> LEPIDODENDRON_PLANKS = registerBlock("lepidodendron_planks",
            () -> new PNPlanksFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> LEPIDODENDRON_SLAB = registerBlock("lepidodendron_slab",
            () -> new PNSlabFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> LEPIDODENDRON_STAIRS = registerBlock("lepidodendron_stairs",
            () -> new PNStairFlammableBlock(() -> ModBlocksTreeLepidodendron.LEPIDODENDRON_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> LEPIDODENDRON_FENCE = registerBlock("lepidodendron_fence",
            () -> new PNFenceFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> LEPIDODENDRON_FENCE_GATE = registerBlock("lepidodendron_fence_gate",
            () -> new PNFenceGateFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)
                    .requiresCorrectToolForDrops(), SoundEvents.FENCE_GATE_CLOSE, SoundEvents.FENCE_GATE_OPEN));
    public static final RegistryObject<Block> LEPIDODENDRON_DOOR = registerBlock("lepidodendron_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR)
                    .requiresCorrectToolForDrops(), SoundEvents.WOODEN_DOOR_OPEN, SoundEvents.WOODEN_DOOR_OPEN));
    public static final RegistryObject<Block> LEPIDODENDRON_TRAPDOOR = registerBlock("lepidodendron_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR)
                    .requiresCorrectToolForDrops(), SoundEvents.WOODEN_TRAPDOOR_OPEN, SoundEvents.WOODEN_TRAPDOOR_OPEN));
    public static final RegistryObject<Block> LEPIDODENDRON_BUTTON = registerBlock("lepidodendron_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON)
                    .requiresCorrectToolForDrops(), 30, true, SoundEvents.WOODEN_BUTTON_CLICK_OFF, SoundEvents.WOODEN_BUTTON_CLICK_ON));
    public static final RegistryObject<Block> LEPIDODENDRON_BENCH = registerBlock("lepidodendron_bench",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON)
                    .requiresCorrectToolForDrops(), 30, true, SoundEvents.WOODEN_BUTTON_CLICK_OFF, SoundEvents.WOODEN_BUTTON_CLICK_ON));

    //How do signs work? There are a few different blocks for each one!


    //Other tree-specific stuff:
    public static final RegistryObject<Block> LEPIDODENDRON_STROBILUS = registerBlock("lepidodendron_strobilus",
            () -> new LepidodendronStrobilus(BlockBehaviour.Properties.copy(Blocks.GRASS)));



}
