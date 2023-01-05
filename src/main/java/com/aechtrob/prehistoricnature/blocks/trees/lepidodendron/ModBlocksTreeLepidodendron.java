package com.aechtrob.prehistoricnature.blocks.trees.lepidodendron;

import com.aechtrob.prehistoricnature.PrehistoricNatureMod;
import com.aechtrob.prehistoricnature.blocks.blocks.PNRotatedPillarFlammableBlock;
import com.aechtrob.prehistoricnature.world.tree.lepidodendron.LepidodendronTreeGrower;
import com.aechtrob.prehistoricnature.items.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
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
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)
                    .requiresCorrectToolForDrops()){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }
            });
    public static final RegistryObject<Block> LEPIDODENDRON_STROBILUS = registerBlock("lepidodendron_strobilus",
            () -> new LepidodendronStrobilus(BlockBehaviour.Properties.copy(Blocks.GRASS)));
    public static final RegistryObject<Block> LEPIDODENDRON_SAPLING = registerBlock("lepidodendron_sapling",
            () -> new SaplingBlock(new LepidodendronTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> LEPIDODENDRON_PLANKS = registerBlock("lepidodendron_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
                    .requiresCorrectToolForDrops()){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
            });

}
