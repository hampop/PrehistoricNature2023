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



    //Register Living Wall corals here:
    //test brain coral registry
    public static final RegistryObject<Block> BRAIN_CORAL_WALL = wallCoralBlock(List.of(BlockTags.WALL_CORALS),"brain_coral", Blocks.DEAD_BRAIN_CORAL);
    //test brain coral standing registry
    public static final RegistryObject<Block> BRAIN_CORAL_STANDING = standingCoralBlock(List.of(BlockTags.CORAL_PLANTS),"brain_coral", Blocks.DEAD_BRAIN_CORAL);

    //Register living standing corals here:
    public static final RegistryObject<Item> BRAIN_CORAL_ITEM = coralItem(BRAIN_CORAL_WALL, BRAIN_CORAL_STANDING, "brain_coral", "Brain Coral");



    //Register Living Corals here:



    /*
    The next three methods are Registration methods for Corals that go both on the ground and on walls.
    Here is what each of the parameters for each method does:

     */

    //TODO particle needs changing when the new respective method is made
    public static RegistryObject<Block> wallCoralBlock(List<TagKey<Block>> blockTags, String name, Block deadBlock){
        RegistryObject<Block> sign = BlockHandler.registerBlockWithoutItem(name,
                () -> new CoralWallFanBlock(deadBlock, BlockBehaviour.Properties.copy(Blocks.BRAIN_CORAL_FAN)),
                List.of(BlockTags.CORALS, BlockTags.WALL_CORALS));
        return sign;
    }

    public static RegistryObject<Block> standingCoralBlock( List<TagKey<Block>> blockTags, String name, Block deadBlock){
        RegistryObject<Block> sign = BlockHandler.registerBlockWithoutItem(name,
                () -> new CoralPlantBlock(deadBlock, BlockBehaviour.Properties.copy(Blocks.BRAIN_CORAL_FAN)),
                List.of(BlockTags.CORALS, BlockTags.UNDERWATER_BONEMEALS, BlockTags.CORAL_PLANTS));
        return sign;
    }

    //End TODO

    public static RegistryObject<Item> coralItem(//RegistryObject<Block> coral, Not sure what this does of if its needed
                                                 RegistryObject<Block> wallCoral,
                                                 RegistryObject<Block> standingCoral,
                                                 String name,
                                                 String translation){
        return ItemHandler.addItem(
                name,
                () -> new StandingAndWallBlockItem(standingCoral.get(), wallCoral.get(), new Item.Properties(), Direction.DOWN),
                (provider, item) -> {provider.basicItem(item);},
                (provider,item) ->{
                    provider.createSingleItemTableWithSilkTouch(wallCoral, item);
                    provider.createSingleItemTableWithSilkTouch(standingCoral, item);
                    },
                List.of(Pair.of("prehistoricnature_natural_tab",Pair.of(1,1))),
                translation);
    }

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
