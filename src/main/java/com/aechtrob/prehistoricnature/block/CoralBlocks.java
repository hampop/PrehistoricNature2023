package com.aechtrob.prehistoricnature.block;

import com.aechtrob.prehistoricnature.PrehistoricNatureMod;
import com.aechtrob.prehistoricnature.block.blocks.PNCoralBlock;
import com.aechtrob.prehistoricnature.block.blocks.PNLeavesBlock;
import com.aechtrob.prehistoricnature.creativetabs.CreativeTabHelper;
import com.aechtrob.prehistoricnature.item.PrehistoricNatureItems;
import com.aechtrob.prehistoricnature.tag.PrehistoricNatureTags;
import com.ibm.icu.impl.Pair;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class CoralBlocks {

    public static void register(){

    }
    //public static final RegistryObject<Block> CARBONIFEROUS_FOSSIL = coralBlock("carboniferous_fossil", "Carboniferous Fossil", PrehistoricNatureItems.CARBONIFEROUS_RAW_FOSSIL);


    public static RegistryObject<Block> addCoralBlock(String name, String translation, RegistryObject<Block> coralItem, Block deadBlock){
        return BlockHandler.registerBlock(name,
                () -> {return new PNCoralBlock(deadBlock, BlockBehaviour.Properties.copy(Blocks.BRAIN_CORAL));},
                (provider, block) -> {provider.simpleBlock(block);},
                (provider, item) -> {provider.withExistingParent(name, new ResourceLocation(PrehistoricNatureMod.MOD_ID, "block/"+name));},
                (provider, block) -> {provider.createLeavesDrops(block,coralItem);},
                List.of(Pair.of("prehistoricnature_natural_tab",Pair.of(1,1))),
                translation);
    }


}
