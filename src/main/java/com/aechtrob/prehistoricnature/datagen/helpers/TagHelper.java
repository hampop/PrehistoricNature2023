package com.aechtrob.prehistoricnature.datagen.helpers;

import com.google.common.collect.*;
import net.minecraft.tags.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.*;
import net.minecraftforge.registries.*;
import org.antlr.v4.runtime.misc.*;

import java.util.*;

public class TagHelper {

    private static LinkedHashMultimap<RegistryObject<Block>, TagKey> blockTags = LinkedHashMultimap.create();
    private static LinkedHashMultimap<RegistryObject<Item>, TagKey> itemTags = LinkedHashMultimap.create();
    private static LinkedHashMultimap<RegistryObject<Entity>, TagKey> entityTags = LinkedHashMultimap.create();
    private static LinkedHashMultimap<RegistryObject<Fluid>, TagKey> fluidTags = LinkedHashMultimap.create();
    private static LinkedHashMultimap<RegistryObject<Biome>, TagKey> biomeTags = LinkedHashMultimap.create();

    public static void addBlockTag(RegistryObject<Block> block, TagKey tagKey){
        blockTags.put(block, tagKey);
    }

    public static void addItemTag(RegistryObject<Item> item, TagKey tagKey){
        itemTags.put(item, tagKey);
    }
    public static void addEntityTag(RegistryObject<Entity> entity, TagKey tagKey){
        entityTags.put(entity, tagKey);
    }
    public static void addFluidTag(RegistryObject<Fluid> fluid, TagKey tagKey){
        fluidTags.put(fluid, tagKey);
    }
    public static void addBiomeTag(RegistryObject<Biome> biome, TagKey tagKey){
        biomeTags.put(biome, tagKey);
    }

    public static LinkedHashMultimap<RegistryObject<Block>, TagKey> getBlockTags () {
        return blockTags;
    }

    public static LinkedHashMultimap<RegistryObject<Item>, TagKey> getItemTags () {
        return itemTags;
    }

    public static LinkedHashMultimap<RegistryObject<Entity>, TagKey> getEntityTags () {
        return entityTags;
    }

    public static LinkedHashMultimap<RegistryObject<Fluid>, TagKey> getFluidTags() {
        return fluidTags;
    }

    public static LinkedHashMultimap<RegistryObject<Biome>, TagKey> getBiomeTags() {
        return biomeTags;
    }
}
