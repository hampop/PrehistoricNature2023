package com.aechtrob.prehistoricnature.datagen.helpers;

import com.aechtrob.prehistoricnature.datagen.*;
import com.aechtrob.prehistoricnature.datagen.loottable.*;
import com.google.common.collect.*;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraftforge.registries.*;

import java.util.function.*;

public class RecipeHelper {

    private static LinkedHashMultimap<RegistryObject<Block>, BiConsumer> blockRecipes = LinkedHashMultimap.create();

    private static LinkedHashMultimap<RegistryObject<Item>, BiConsumer> itemRecipes = LinkedHashMultimap.create();

    public static void addBlockRecipe(RegistryObject<Block> block, BiConsumer<PrehistoricNatureRecipeProvider, RegistryObject<Block>> consumer){
        blockRecipes.put(block, consumer);
    }

    public static LinkedHashMultimap<RegistryObject<Block>, BiConsumer> getBlockRecipes(){
        return blockRecipes;
    }


    public static void addItemRecipe(RegistryObject<Item> item, BiConsumer<PrehistoricNatureRecipeProvider, RegistryObject<Item>> consumer){
        itemRecipes.put(item, consumer);
    }

    public static LinkedHashMultimap<RegistryObject<Item>, BiConsumer> getItemRecipes(){
        return itemRecipes;
    }

}
