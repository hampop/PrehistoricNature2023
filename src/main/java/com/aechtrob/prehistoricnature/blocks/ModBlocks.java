package com.aechtrob.prehistoricnature.blocks;

import com.aechtrob.prehistoricnature.PrehistoricNatureMod;
import com.aechtrob.prehistoricnature.items.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

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


}
