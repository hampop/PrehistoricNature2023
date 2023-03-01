package com.aechtrob.prehistoricnature.block;

import com.aechtrob.prehistoricnature.PrehistoricNatureMod;
import com.aechtrob.prehistoricnature.block.blocks.*;
import com.aechtrob.prehistoricnature.creativetabs.CreativeTabHelper;
import com.aechtrob.prehistoricnature.item.ItemHandler;
import com.aechtrob.prehistoricnature.item.PrehistoricNatureItems;
import com.aechtrob.prehistoricnature.tag.PrehistoricNatureTags;
import com.ibm.icu.impl.Pair;
import net.minecraft.core.Direction;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class CoralBlocks {

    public static void register(){

    }
    //Register Dead Bleached blocks here:



    //Register Living corals here:
    //public static final RegistryObject<Block> CARBONIFEROUS_FOSSIL = coralBlock("carboniferous_fossil", "Carboniferous Fossil", PrehistoricNatureItems.CARBONIFEROUS_RAW_FOSSIL);


    /*
    This is the registration method for Coral Plants, it takes in a name,
     */

    //TODO particle needs changing when the new respective method is made
    public static RegistryObject<Block> wallCoralBlock(WoodType woodType, List<TagKey<Block>> blockTags, String name, Block deadBlock){
        RegistryObject<Block> sign = BlockHandler.registerBlockWithoutItem(name,
                () -> new CoralWallFanBlock(deadBlock, BlockBehaviour.Properties.copy(Blocks.BRAIN_CORAL_FAN)),
                List.of(BlockTags.CORALS, BlockTags.WALL_CORALS));
        return sign;
    }

    public static RegistryObject<Block> standingCoralBlock(RegistryObject<Block> wallSign, WoodType woodType,  List<TagKey<Block>> blockTags, String name, Block deadBlock){
        RegistryObject<Block> sign = BlockHandler.registerBlockWithoutItem(name,
                () -> new CoralPlantBlock(deadBlock, BlockBehaviour.Properties.copy(Blocks.BRAIN_CORAL_FAN)),
                List.of(BlockTags.CORALS, BlockTags.UNDERWATER_BONEMEALS, BlockTags.CORAL_PLANTS));
        return sign;
    }
/*
    public static RegistryObject<Item> coralItem(RegistryObject<Block> plank, RegistryObject<Block> wallCoral, RegistryObject<Block> standingCoral,
                                                List<TagKey<Item>> itemTags, String name,String translation){
        return ItemHandler.addItem(name,
                () -> new StandingAndWallBlockItem(standingCoral.get(), wallCoral.get(), new Item.Properties(), Direction.DOWN),
                (provider, item) -> {provider.basicItem(item);},
                (provider,item) ->{
                    provider.createSingleItemTableWithSilkTouch(wallCoral, item);
                    provider.createSingleItemTableWithSilkTouch(standingCoral, item);
                    },
                List.of(Pair.of("prehistoricnature_natural_tab",Pair.of(1,1))),
                translation);
    }

 */

    public static RegistryObject<Block> addCoralPlantDead(String name, String translation, RegistryObject<Block> coralItem){
        return BlockHandler.registerBlock(name,
                () -> {return new BaseCoralWallFanBlock(BlockBehaviour.Properties.copy(Blocks.DEAD_BRAIN_CORAL_FAN));},
                List.of(BlockTags.CORALS, BlockTags.CORAL_PLANTS, BlockTags.UNDERWATER_BONEMEALS),
                (provider, block) -> {provider.simpleBlock(block);},
                (provider, item) -> {provider.withExistingParent(name, new ResourceLocation(PrehistoricNatureMod.MOD_ID, "block/"+name));},
                (provider, block) -> {provider.createSingleItemTableWithSilkTouch(block, coralItem);},
                List.of(Pair.of("prehistoricnature_natural_tab",Pair.of(1,1))),
                translation);
    }

    public static RegistryObject<Block> addCoralTabulate(String name, String translation, RegistryObject<Block> coralItem, Block deadBlock){
        return BlockHandler.registerBlock(name,
                () -> {return new CoralPlantBlock(deadBlock, BlockBehaviour.Properties.copy(Blocks.BRAIN_CORAL));},
                List.of(BlockTags.CORALS, BlockTags.CORAL_PLANTS, BlockTags.UNDERWATER_BONEMEALS),
                (provider, block) -> {provider.simpleBlock(block);},
                (provider, item) -> {provider.withExistingParent(name, new ResourceLocation(PrehistoricNatureMod.MOD_ID, "block/"+name));},
                (provider, block) -> {provider.createSingleItemTableWithSilkTouch(block, coralItem);},
                List.of(Pair.of("prehistoricnature_natural_tab",Pair.of(1,1))),
                translation);
    }

    public static RegistryObject<Block> addCoralBlock(String name, String translation, RegistryObject<Block> coralItem, Block deadBlock){
        return BlockHandler.registerBlock(name,
                () -> {return new CoralBlock(deadBlock, BlockBehaviour.Properties.copy(Blocks.BRAIN_CORAL));},
                List.of(BlockTags.CORAL_BLOCKS),
                (provider, block) -> {provider.simpleBlock(block);},
                (provider, item) -> {provider.withExistingParent(name, new ResourceLocation(PrehistoricNatureMod.MOD_ID, "block/"+name));},
                (provider, block) -> {provider.createSingleItemTableWithSilkTouch(block, coralItem);},
                List.of(Pair.of("prehistoricnature_natural_tab",Pair.of(1,1))),
                translation);
    }


}
