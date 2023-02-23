package com.aechtrob.prehistoricnature.datagen.helpers;

import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.minecraftforge.registries.*;
import oshi.util.tuples.*;

import java.util.*;

public class LanguageHelper {
    private static HashMap<RegistryObject<Block>, String> blockLanguage = new HashMap<>();
    private static HashMap<RegistryObject<Item>, String> itemLanguage = new HashMap<>();
    private static HashMap<String, String> translatableLanguage = new HashMap<>();

    public static void addBlockTranslation(RegistryObject<Block> block, String translation){
        blockLanguage.put(block,translation);
    }

    public static void addItemTranslation(RegistryObject<Item> item, String translation){
        itemLanguage.put(item,translation);
    }

    public static void addTranslatableTranslation(String translatableid, String translation){
        translatableLanguage.put(translatableid,translation);
    }

    public static HashMap<RegistryObject<Block>,String>getBlockLanguage(){
        return blockLanguage;
    }

    public static HashMap<RegistryObject<Item>, String>getItemLanguage(){
        return itemLanguage;
    }

    public static HashMap<String, String>getTranslatableLanguage(){
        return translatableLanguage;
    }
}
