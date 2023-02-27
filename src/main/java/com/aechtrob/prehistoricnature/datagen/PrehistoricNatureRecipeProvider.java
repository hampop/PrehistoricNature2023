package com.aechtrob.prehistoricnature.datagen;

import com.aechtrob.prehistoricnature.datagen.helpers.*;
import net.minecraft.advancements.critereon.*;
import net.minecraft.data.*;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.crafting.conditions.*;
import net.minecraftforge.registries.*;
import org.openjdk.nashorn.internal.ir.*;

import java.util.function.*;

public class PrehistoricNatureRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public PrehistoricNatureRecipeProvider(PackOutput packout) {
        super(packout);
    }

    Consumer<FinishedRecipe> consumer;
    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        this.consumer = consumer;
        RecipeHelper.getBlockRecipes().forEach((itemlike,biConsumer)->{biConsumer.accept(this,itemlike);});
        RecipeHelper.getItemRecipes().forEach((itemlike,biConsumer)->{biConsumer.accept(this,itemlike);});
    }

    public void twoByTwoRecipeBlocktoBlock(RecipeCategory recipeCategory, RegistryObject<Block> in, RegistryObject<Block> out, int amountOut){
        ShapedRecipeBuilder.shaped(recipeCategory, out.get(), amountOut).define('I',in.get())
                .pattern("II")
                .pattern("II")
                .unlockedBy("has_"+in.getId().getPath(),inventoryTrigger(ItemPredicate.Builder.item().of(in.get()).build()))
                .save(consumer);
    }
    public void twoByTwoRecipeItemToBlock(RecipeCategory recipeCategory, RegistryObject<Item> in, RegistryObject<Block> out, int amountOut){
        ShapedRecipeBuilder.shaped(recipeCategory, out.get(), amountOut).define('I',in.get())
                .pattern("II")
                .pattern("II")
                .unlockedBy("has_"+in.getId().getPath(),inventoryTrigger(ItemPredicate.Builder.item().of(in.get()).build()))
                .save(consumer);
    }
    public void twoByTwoRecipeBlockToItem(RecipeCategory recipeCategory, RegistryObject<Block> in, RegistryObject<Item> out, int amountOut){
        ShapedRecipeBuilder.shaped(recipeCategory, out.get(), amountOut).define('I',in.get())
                .pattern("II")
                .pattern("II")
                .unlockedBy("has_"+in.getId().getPath(),inventoryTrigger(ItemPredicate.Builder.item().of(in.get()).build()))
                .save(consumer);
    }
    public void twoByTwoRecipeItemToItem(RecipeCategory recipeCategory, RegistryObject<Item> in, RegistryObject<Item> out, int amountOut){
        ShapedRecipeBuilder.shaped(recipeCategory, out.get(), amountOut).define('I',in.get())
                .pattern("II")
                .pattern("II")
                .unlockedBy("has_"+in.getId().getPath(),inventoryTrigger(ItemPredicate.Builder.item().of(in.get()).build()))
                .save(consumer);
    }

    public void twoByTwoRecipeTagToBlock(RecipeCategory recipeCategory, TagKey<Item> in, RegistryObject<Block> out, int amountOut){
        ShapedRecipeBuilder.shaped(recipeCategory, out.get(), amountOut).define('I',in)
                .pattern("II")
                .pattern("II")
                .unlockedBy("has_"+in.location(),inventoryTrigger(ItemPredicate.Builder.item().of(in).build()))
                .save(consumer);
    }

    public void twoByTwoRecipeTagToItem(RecipeCategory recipeCategory, TagKey<Item> in, RegistryObject<Item> out, int amountOut){
        ShapedRecipeBuilder.shaped(recipeCategory, out.get(), amountOut).define('I',in)
                .pattern("II")
                .pattern("II")
                .unlockedBy("has_"+in.location(),inventoryTrigger(ItemPredicate.Builder.item().of(in).build()))
                .save(consumer);
    }


    public void shapelessConversionRecipe(RecipeCategory recipeCategory, RegistryObject<Block> in, RegistryObject<Block> out, int amountOut){
        ShapelessRecipeBuilder.shapeless(recipeCategory,out.get(), amountOut).requires(in.get())
                .unlockedBy("has_"+in.getId().getPath(),inventoryTrigger(ItemPredicate.Builder.item().of(in.get()).build()))
                .save(consumer);
    }

    public void shapelessConversionRecipe(RecipeCategory recipeCategory, TagKey<Item> in, RegistryObject<Block> out, int amountOut){
        ShapelessRecipeBuilder.shapeless(recipeCategory,out.get(), amountOut).requires(in)
                .unlockedBy("has_"+in.location().getPath(),inventoryTrigger(ItemPredicate.Builder.item().of(in).build()))
                .save(consumer);
    }

    public void slabRecipe(RecipeCategory recipeCategory, RegistryObject<Block> in, RegistryObject<Block> out){
        ShapedRecipeBuilder.shaped(recipeCategory, out.get(), 6).define('I',in.get())
                .pattern("III")
                .unlockedBy("has_"+in.getId().getPath(),inventoryTrigger(ItemPredicate.Builder.item().of(in.get()).build()))
                .save(consumer);
    }

    public void stairRecipe(RecipeCategory recipeCategory, RegistryObject<Block> in, RegistryObject<Block> out){
        ShapedRecipeBuilder.shaped(recipeCategory, out.get(), 4).define('I',in.get())
                .pattern("I  ")
                .pattern("II ")
                .pattern("III")
                .unlockedBy("has_"+in.getId().getPath(),inventoryTrigger(ItemPredicate.Builder.item().of(in.get()).build()))
                .save(consumer);
    }

    public void fenceRecipe(RecipeCategory recipeCategory, RegistryObject<Block> in, RegistryObject<Block> out){
        ShapedRecipeBuilder.shaped(recipeCategory, out.get(), 3).define('I',in.get()).define('S',Items.STICK)
                .pattern("ISI")
                .pattern("ISI")
                .unlockedBy("has_"+in.getId().getPath(),inventoryTrigger(ItemPredicate.Builder.item().of(in.get()).build()))
                .save(consumer);
    }

    public void fenceGateRecipe(RecipeCategory recipeCategory, RegistryObject<Block> in, RegistryObject<Block> out){
        ShapedRecipeBuilder.shaped(recipeCategory, out.get()).define('I',in.get()).define('S',Items.STICK)
                .pattern("SIS")
                .pattern("SIS")
                .unlockedBy("has_"+in.getId().getPath(),inventoryTrigger(ItemPredicate.Builder.item().of(in.get()).build()))
                .save(consumer);
    }

    public void boatRecipe(RecipeCategory recipeCategory, RegistryObject<Block> in, RegistryObject<Block> out){
        ShapedRecipeBuilder.shaped(recipeCategory, out.get()).define('I',in.get())
                .pattern("I I")
                .pattern("III")
                .unlockedBy("has_"+in.getId().getPath(),inventoryTrigger(ItemPredicate.Builder.item().of(in.get()).build()))
                .save(consumer);
    }

    public void combinationRecipe(RecipeCategory recipeCategory, RegistryObject<ItemLike> itemOne, RegistryObject<ItemLike> itemTwo, RegistryObject<ItemLike> out, int amountOut){
        ShapelessRecipeBuilder.shapeless(recipeCategory,out.get(), amountOut).requires(itemOne.get()).requires(itemTwo.get())
                .unlockedBy("has_"+itemOne.getId().getPath(),inventoryTrigger(ItemPredicate.Builder.item().of(itemOne.get()).build()))
                .unlockedBy("has_"+itemTwo.getId().getPath(),inventoryTrigger(ItemPredicate.Builder.item().of(itemTwo.get()).build()))
                .save(consumer);
    }

    public void doorRecipe(RecipeCategory recipeCategory, RegistryObject<Block> in, RegistryObject<Block> out){
        ShapedRecipeBuilder.shaped(recipeCategory, out.get(), 3).define('I',in.get())
                .pattern("II")
                .pattern("II")
                .pattern("II")
                .unlockedBy("has_"+in.getId().getPath(),inventoryTrigger(ItemPredicate.Builder.item().of(in.get()).build()))
                .save(consumer);
    }

    public void pnLadderRecipe(RecipeCategory recipeCategory, RegistryObject<Block> in, RegistryObject<Block> out){
        ShapedRecipeBuilder.shaped(recipeCategory, out.get()).define('I',in.get()).define('S',Items.STICK)
                .pattern("S S")
                .pattern("SIS")
                .pattern("S S")
                .unlockedBy("has_"+in.getId().getPath(),inventoryTrigger(ItemPredicate.Builder.item().of(in.get()).build()))
                .save(consumer);
    }

    public void pnLadderRecipe(RecipeCategory recipeCategory, Block in, RegistryObject<Block> out){
        ShapedRecipeBuilder.shaped(recipeCategory, out.get()).define('I',in).define('S',Items.STICK)
                .pattern("S S")
                .pattern("SIS")
                .pattern("S S")
                .unlockedBy("has_"+in.getDescriptionId(),inventoryTrigger(ItemPredicate.Builder.item().of(in).build()))
                .save(consumer);
    }

    public void pressurePlateRecipe(RecipeCategory recipeCategory, RegistryObject<Block> in, RegistryObject<Block> out){
        ShapedRecipeBuilder.shaped(recipeCategory, out.get()).define('I',in.get())
                .pattern("II")
                .unlockedBy("has_"+in.getId().getPath(),inventoryTrigger(ItemPredicate.Builder.item().of(in.get()).build()))
                .save(consumer);
    }

    public void signRecipe(RecipeCategory recipeCategory, RegistryObject<Block> in, RegistryObject<Item> out){
        ShapedRecipeBuilder.shaped(recipeCategory, out.get(),3).define('I',in.get()).define('S',Items.STICK)
                .pattern("III")
                .pattern("III")
                .pattern(" S ")
                .unlockedBy("has_"+in.getId().getPath(),inventoryTrigger(ItemPredicate.Builder.item().of(in.get()).build()))
                .save(consumer);
    }

    public void trapdoorRecipe(RecipeCategory recipeCategory, RegistryObject<Block> in, RegistryObject<Block> out){
        ShapedRecipeBuilder.shaped(recipeCategory, out.get(), 3).define('I',in.get())
                .pattern("III")
                .pattern("III")
                .unlockedBy("has_"+in.getId().getPath(),inventoryTrigger(ItemPredicate.Builder.item().of(in.get()).build()))
                .save(consumer);
    }
}
