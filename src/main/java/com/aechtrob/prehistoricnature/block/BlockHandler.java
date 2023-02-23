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

//This handler class handles everything to do with adding blocks to the mod. See comments on registerBlock for details
//on how to use it
public class BlockHandler {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, PrehistoricNatureMod.MOD_ID);

    public static void register(IEventBus eventBus){
        FossilBlocks.register();
        ModBlocksTreeLepidodendron.register();
        BLOCKS.register(eventBus);
    }
/*
    The registerBlock method should be used when you register a block. It has several different implementations, depending on
    the parameters of the block. The most complicated implementation is at the top, descending in complexity.
 */

    /*
    This is the standard implementation. For most blocks, this one should be used.
    See the trees/lepidodendron/ModBlocksTreeLepidodendron class for examples of different types of the method calls
    String name:
                        The block's id, for example "example_block"
    Supplier<T> block:
                        Lambda supplier of the block type.
    List<TagKey<Block>> blockTags:
                        A list of BlockTags that should be applied to this block. It passes it to the TagHelper
                        class, which generates the json files for the tags when the runData task is executed. This means you
                        do not need to add the tags to the datagenerator manually when using this method.
    List<TagKey<Item>> item:
                        A list of ItemTags that should be applied to the generated block item. It passes it to the TagHelper
                        class, which generates the json files for the tags when the runData task is executed. This means you
                        do not need to add the tags to the datagenerator manually when using this method.
    Consumer<RegistryObject<Block>> consumer:
                        A consumer that passes the appropriate BlockStateProvider method in consumer form for the block that
                        is being generated.
    String translation:
                        The translation thats passed to the LanguageHelper and added to the en_us.json.

     */
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

    public static <T extends Block> RegistryObject<Block> registerBlock(String name, Supplier<T> block, List<TagKey<Block>> blockTags,
                                                                        Consumer<RegistryObject<Block>> consumer,
                                                                        String translation){
        RegistryObject<Block> returnBlock = BlockHandler.BLOCKS.register(name, block);
        blockTags.stream().forEach((tagKey) -> {TagHelper.addBlockTag(returnBlock,tagKey);});
        ModelHelper.addBlockModel(returnBlock, consumer);
        LanguageHelper.addBlockTranslation(returnBlock,translation);
        registerBlockItem(name, returnBlock);
        return returnBlock;
    }

    public static <T extends Block> RegistryObject<Block> registerBlock(String name, Supplier<T> block, List<TagKey<Block>> blockTags,
                                                                        List<TagKey<Item>> itemTags, String translation){
        RegistryObject<Block> returnBlock = BlockHandler.BLOCKS.register(name, block);
        blockTags.stream().forEach((tagKey) -> {TagHelper.addBlockTag(returnBlock,tagKey);});
        LanguageHelper.addBlockTranslation(returnBlock,translation);
        registerBlockItem(name, returnBlock, itemTags);
        return returnBlock;
    }

    public static <T extends Block> RegistryObject<Block> registerBlock(String name, Supplier<T> block,List<TagKey<Item>> itemTags,
                                                                        String translation){
        RegistryObject<Block> returnBlock = BlockHandler.BLOCKS.register(name, block);
        LanguageHelper.addBlockTranslation(returnBlock,translation);
        registerBlockItem(name, returnBlock, itemTags);
        return returnBlock;
    }

    //These methods should not be called on their own. They are used to register the Block items for the blocks that are
    //Being registered using the above registration methods.
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
