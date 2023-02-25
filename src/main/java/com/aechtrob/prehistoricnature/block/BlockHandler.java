package com.aechtrob.prehistoricnature.block;

import com.aechtrob.prehistoricnature.*;
import com.aechtrob.prehistoricnature.block.trees.lepidodendron.*;
import com.aechtrob.prehistoricnature.creativetabs.*;
import com.aechtrob.prehistoricnature.datagen.*;
import com.aechtrob.prehistoricnature.datagen.helpers.*;
import com.aechtrob.prehistoricnature.datagen.loottable.*;
import com.aechtrob.prehistoricnature.item.*;
import com.ibm.icu.impl.*;
import net.minecraft.tags.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
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
    Consumer<RegistryObject<Block>> blockConsumer:
                        A consumer that passes the appropriate BlockStateProvider method in consumer form for the block that
                        is being generated.  **BE CAREFUL** The texture files should be placed in the correct folder with the correct names.
                        See the lepidodendron blocks for examples, or wait for the data gen to shout at you about the resource it can't find.
    Consumer<RegistryObject<Item>> itemConsumer:
                        A consumer that passes the appropriate ItemModelProvider method in consumer form for the blockitem that
                        is being generated.  **BE CAREFUL** The texture files should be placed in the correct folder with the correct names.
                        See the lepidodendron items for examples, or wait for the data gen to shout at you about the resource it can't find.
    String translation:
                        The translation that is passed to the LanguageHelper and added to the en_us.json.

     */
    public static <T extends Block> RegistryObject<Block> registerBlock(String name, Supplier<T> block, List<TagKey<Block>> blockTags,
                                                                        List<TagKey<Item>> itemTags, BiConsumer<PrehistoricNatureBlockStateProvider,RegistryObject<Block>> blockConsumer,
                                                                        BiConsumer<PrehistoricNatureItemModelProvider, RegistryObject<Item>> itemConsumer,
                                                                        BiConsumer<BlockLootSubProvider, RegistryObject<Block>> lootConsumer,
                                                                        List<Pair<String,Integer>> creativeModeTabs,
                                                                        String translation){
        RegistryObject<Block> returnBlock = BlockHandler.BLOCKS.register(name, block);
        blockTags.stream().forEach((tagKey) -> {TagHelper.addBlockTag(returnBlock,tagKey);});
        ModelHelper.addBlockModel(returnBlock, blockConsumer);
        LootTableHelper.addLootTable(returnBlock,lootConsumer);
        LanguageHelper.addBlockTranslation(returnBlock,translation);
        RegistryObject<Item> registerItem = registerBlockItem(name, returnBlock, itemTags);
        ModelHelper.addItemModel(registerItem,itemConsumer);
        return returnBlock;
    }

    public static <T extends Block> RegistryObject<Block> registerBlock(String name, Supplier<T> block, List<TagKey<Block>> blockTags,
                                                                        List<TagKey<Item>> itemTags,
                                                                        BiConsumer<PrehistoricNatureBlockStateProvider,RegistryObject<Block>> blockConsumer,
                                                                        BiConsumer<PrehistoricNatureItemModelProvider, RegistryObject<Item>> itemConsumer,
                                                                        BiConsumer<BlockLootSubProvider, RegistryObject<Block>> lootConsumer,
                                                                        BiConsumer<PrehistoricNatureRecipeProvider, RegistryObject<Block>> reciperConsumer,
                                                                        List<Pair<String,Integer>> creativeModeTabs,
                                                                        String translation){
        RegistryObject<Block> returnBlock = BlockHandler.BLOCKS.register(name, block);
        blockTags.stream().forEach((tagKey) -> {TagHelper.addBlockTag(returnBlock,tagKey);});
        ModelHelper.addBlockModel(returnBlock, blockConsumer);
        LootTableHelper.addLootTable(returnBlock,lootConsumer);
        LanguageHelper.addBlockTranslation(returnBlock,translation);
        RegistryObject<Item> registerItem = registerBlockItem(name, returnBlock, itemTags);
        ModelHelper.addItemModel(registerItem,itemConsumer);
        RecipeHelper.addBlockRecipe(returnBlock,reciperConsumer);
        return returnBlock;
    }

    public static <T extends Block> RegistryObject<Block> registerBlock(String name, Supplier<T> block, List<TagKey<Block>> blockTags,
                                                                        BiConsumer<PrehistoricNatureBlockStateProvider,RegistryObject<Block>> consumer,
                                                                        BiConsumer<PrehistoricNatureItemModelProvider, RegistryObject<Item>> itemConsumer,
                                                                        BiConsumer<BlockLootSubProvider, RegistryObject<Block>> lootConsumer,
                                                                        BiConsumer<PrehistoricNatureRecipeProvider, RegistryObject<Block>> reciperConsumer,
                                                                        List<Pair<String,Integer>> creativeModeTabs,
                                                                        String translation){
        RegistryObject<Block> returnBlock = BlockHandler.BLOCKS.register(name, block);
        blockTags.stream().forEach((tagKey) -> {TagHelper.addBlockTag(returnBlock,tagKey);});
        ModelHelper.addBlockModel(returnBlock, consumer);
        LootTableHelper.addLootTable(returnBlock,lootConsumer);
        LanguageHelper.addBlockTranslation(returnBlock,translation);
        RegistryObject<Item> registerItem = registerBlockItem(name, returnBlock);
        ModelHelper.addItemModel(registerItem,itemConsumer);
        RecipeHelper.addBlockRecipe(returnBlock,reciperConsumer);
        creativeModeTabs.forEach((pair)->{
            CreativeTabHelper.addCreativeItem(pair.first,returnBlock,pair.second);});
        return returnBlock;
    }

    public static <T extends Block> RegistryObject<Block> registerBlock(String name, Supplier<T> block, List<TagKey<Block>> blockTags,
                                                                        BiConsumer<PrehistoricNatureBlockStateProvider,RegistryObject<Block>> consumer,
                                                                        BiConsumer<PrehistoricNatureItemModelProvider, RegistryObject<Item>> itemConsumer,
                                                                        BiConsumer<BlockLootSubProvider, RegistryObject<Block>> lootConsumer,
                                                                        List<Pair<String,Integer>> creativeModeTabs,
                                                                        String translation){
        RegistryObject<Block> returnBlock = BlockHandler.BLOCKS.register(name, block);
        blockTags.stream().forEach((tagKey) -> {TagHelper.addBlockTag(returnBlock,tagKey);});
        ModelHelper.addBlockModel(returnBlock, consumer);
        LootTableHelper.addLootTable(returnBlock,lootConsumer);
        LanguageHelper.addBlockTranslation(returnBlock,translation);
        RegistryObject<Item> registerItem = registerBlockItem(name, returnBlock);
        ModelHelper.addItemModel(registerItem,itemConsumer);
        creativeModeTabs.forEach((pair)->{
            CreativeTabHelper.addCreativeItem(pair.first,returnBlock,pair.second);});
        return returnBlock;
    }

    public static <T extends Block> RegistryObject<Block> registerBlock(String name, Supplier<T> block,
                                                                        BiConsumer<PrehistoricNatureBlockStateProvider,RegistryObject<Block>> consumer,
                                                                        BiConsumer<PrehistoricNatureItemModelProvider, RegistryObject<Item>> itemConsumer,
                                                                        BiConsumer<BlockLootSubProvider, RegistryObject<Block>> lootConsumer,
                                                                        BiConsumer<PrehistoricNatureRecipeProvider, RegistryObject<Block>> reciperConsumer,
                                                                        List<Pair<String,Integer>> creativeModeTabs,
                                                                        String translation){
        RegistryObject<Block> returnBlock = BlockHandler.BLOCKS.register(name, block);
        ModelHelper.addBlockModel(returnBlock, consumer);
        LootTableHelper.addLootTable(returnBlock,lootConsumer);
        LanguageHelper.addBlockTranslation(returnBlock,translation);
        RegistryObject<Item> registerItem = registerBlockItem(name, returnBlock);
        ModelHelper.addItemModel(registerItem,itemConsumer);
        RecipeHelper.addBlockRecipe(returnBlock,reciperConsumer);
        creativeModeTabs.forEach((pair)->{
            CreativeTabHelper.addCreativeItem(pair.first,returnBlock,pair.second);});

        return returnBlock;
    }

    public static <T extends Block> RegistryObject<Block> registerBlock(String name, Supplier<T> block,
                                                                        List<TagKey<Block>> blockTags,
                                                                        List<TagKey<Item>> itemTags,
                                                                        BiConsumer<PrehistoricNatureItemModelProvider, RegistryObject<Item>> itemConsumer,
                                                                        BiConsumer<BlockLootSubProvider, RegistryObject<Block>> lootConsumer,
                                                                        List<Pair<String,Integer>> creativeModeTabs,
                                                                        String translation,int check){
        RegistryObject<Block> returnBlock = BlockHandler.BLOCKS.register(name, block);
        blockTags.stream().forEach((tagKey) -> {TagHelper.addBlockTag(returnBlock,tagKey);});
        LootTableHelper.addLootTable(returnBlock,lootConsumer);
        LanguageHelper.addBlockTranslation(returnBlock,translation);
        RegistryObject<Item> registerItem = registerBlockItem(name, returnBlock, itemTags);
        ModelHelper.addItemModel(registerItem,itemConsumer);
        creativeModeTabs.forEach((pair)->{
            CreativeTabHelper.addCreativeItem(pair.first,returnBlock,pair.second);});
        return returnBlock;
    }

    public static <T extends Block> RegistryObject<Block> registerBlock(String name, Supplier<T> block,
                                                                        BiConsumer<PrehistoricNatureBlockStateProvider,RegistryObject<Block>> consumer,
                                                                        BiConsumer<PrehistoricNatureItemModelProvider, RegistryObject<Item>> itemConsumer,
                                                                        BiConsumer<BlockLootSubProvider, RegistryObject<Block>> lootConsumer,
                                                                        List<Pair<String,Integer>> creativeModeTabs,
                                                                        String translation){
        RegistryObject<Block> returnBlock = BlockHandler.BLOCKS.register(name, block);
        ModelHelper.addBlockModel(returnBlock, consumer);
        LootTableHelper.addLootTable(returnBlock,lootConsumer);
        LanguageHelper.addBlockTranslation(returnBlock,translation);
        RegistryObject<Item> registerItem = registerBlockItem(name, returnBlock);
        ModelHelper.addItemModel(registerItem,itemConsumer);
        creativeModeTabs.forEach((pair)->{
            CreativeTabHelper.addCreativeItem(pair.first,returnBlock,pair.second);});
        return returnBlock;
    }

    public static <T extends Block> RegistryObject<Block> registerBlock(String name, Supplier<T> block,
                                                                        List<TagKey<Block>> blockTags,
                                                                        List<TagKey<Item>> itemTags,
                                                                        BiConsumer<BlockLootSubProvider, RegistryObject<Block>> lootConsumer,
                                                                        BiConsumer<PrehistoricNatureRecipeProvider, RegistryObject<Block>> reciperConsumer,
                                                                        List<Pair<String,Integer>> creativeModeTabs,
                                                                        String translation){
        RegistryObject<Block> returnBlock = BlockHandler.BLOCKS.register(name, block);
        blockTags.stream().forEach((tagKey) -> {TagHelper.addBlockTag(returnBlock,tagKey);});
        LootTableHelper.addLootTable(returnBlock,lootConsumer);
        LanguageHelper.addBlockTranslation(returnBlock,translation);
        registerBlockItem(name, returnBlock, itemTags);
        RecipeHelper.addBlockRecipe(returnBlock,reciperConsumer);
        creativeModeTabs.forEach((pair)->{
            CreativeTabHelper.addCreativeItem(pair.first,returnBlock,pair.second);});
        return returnBlock;
    }

    public static <T extends Block> RegistryObject<Block> registerBlock(String name, Supplier<T> block,List<TagKey<Item>> itemTags,
                                                                        BiConsumer<BlockLootSubProvider, RegistryObject<Block>> lootConsumer,
                                                                        List<Pair<String,Integer>> creativeModeTabs,
                                                                        String translation){
        RegistryObject<Block> returnBlock = BlockHandler.BLOCKS.register(name, block);
        LootTableHelper.addLootTable(returnBlock,lootConsumer);
        LanguageHelper.addBlockTranslation(returnBlock,translation);
        registerBlockItem(name, returnBlock, itemTags);
        creativeModeTabs.forEach((pair)->{
            CreativeTabHelper.addCreativeItem(pair.first,returnBlock,pair.second);});
        return returnBlock;
    }

    public static <T extends Block> RegistryObject<Block> registerBlock(String name,
                                                                        Supplier<T> block,
                                                                        BiConsumer<BlockLootSubProvider, RegistryObject<Block>> lootConsumer,
                                                                        List<Pair<String,Integer>> creativeModeTabs,
                                                                        String translation){
        RegistryObject<Block> returnBlock = BlockHandler.BLOCKS.register(name, block);
        LootTableHelper.addLootTable(returnBlock,lootConsumer);
        LanguageHelper.addBlockTranslation(returnBlock,translation);
        registerBlockItem(name, returnBlock);
        creativeModeTabs.forEach((pair)->{
            CreativeTabHelper.addCreativeItem(pair.first,returnBlock,pair.second);});
        return returnBlock;
    }

    public static <T extends Block> RegistryObject<Block> registerBlock(String name, Supplier<T> block){
        RegistryObject<Block> returnBlock = BlockHandler.BLOCKS.register(name, block);
        registerBlockItem(name, returnBlock);
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
