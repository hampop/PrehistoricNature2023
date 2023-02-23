package com.aechtrob.prehistoricnature.block;

import com.aechtrob.prehistoricnature.*;
import com.aechtrob.prehistoricnature.block.trees.lepidodendron.*;
import com.aechtrob.prehistoricnature.datagen.helpers.*;
import com.aechtrob.prehistoricnature.item.*;
import net.minecraft.tags.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.registries.*;

import java.util.*;
import java.util.function.*;

public class BlockHandler {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, PrehistoricNatureMod.MOD_ID);

    public static void register(IEventBus eventBus){
        FossilBlocks.register();
        ModBlocksTreeLepidodendron.register();
        BLOCKS.register(eventBus);
    }

    public static <T extends Block> RegistryObject<Block> registerBlock(String name, Supplier<T> block, List<TagKey<Block>> blockTags, List<TagKey<Item>> itemTags, String translation){
        RegistryObject<Block> returnBlock = BlockHandler.BLOCKS.register(name, block);
        blockTags.stream().forEach((tagKey) -> {TagHelper.addBlockTag(returnBlock,tagKey);});
        LanguageHelper.addBlockTranslation(returnBlock,translation);
        registerBlockItem(name, returnBlock, itemTags);
        return returnBlock;
    }

    public static <T extends Block> RegistryObject<Block> registerBlock(String name, Supplier<T> block, List<TagKey<Block>> blockTags,
                                                                        List<TagKey<Item>> itemTags, Consumer<RegistryObject<Block>> consumer,
                                                                        String translation){
        RegistryObject<Block> returnBlock = BlockHandler.BLOCKS.register(name, block);
        blockTags.stream().forEach((tagKey) -> {TagHelper.addBlockTag(returnBlock,tagKey);});
        ModelHelper.addBlockModel(returnBlock, consumer);
        LanguageHelper.addBlockTranslation(returnBlock,translation);
        registerBlockItem(name, returnBlock, itemTags);
        return returnBlock;
    }

    public static <T extends Block> RegistryObject<Block> registerBlock(String name, Supplier<T> block, List<TagKey<Block>> blockTags, Consumer<RegistryObject<Block>> consumer,
                                                                        String translation){
        RegistryObject<Block> returnBlock = BlockHandler.BLOCKS.register(name, block);
        blockTags.stream().forEach((tagKey) -> {TagHelper.addBlockTag(returnBlock,tagKey);});
        ModelHelper.addBlockModel(returnBlock, consumer);
        LanguageHelper.addBlockTranslation(returnBlock,translation);
        registerBlockItem(name, returnBlock);
        return returnBlock;
    }

    public static <T extends Block> RegistryObject<Block> registerBlock(String name, Supplier<T> block){
        RegistryObject<Block> returnBlock = BlockHandler.BLOCKS.register(name, block);
        registerBlockItem(name, returnBlock);
        return returnBlock;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, List<TagKey<Item>> itemTags) {
        RegistryObject<Item> returnItem = ItemHandler.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
        itemTags.stream().forEach((tagKey)-> {TagHelper.addItemTag(returnItem, tagKey);});
        return returnItem;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ItemHandler.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }
}
