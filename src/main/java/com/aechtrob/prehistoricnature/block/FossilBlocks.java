package com.aechtrob.prehistoricnature.block;

import com.aechtrob.prehistoricnature.tag.*;
import com.ibm.icu.impl.*;
import com.aechtrob.prehistoricnature.*;
import com.aechtrob.prehistoricnature.item.*;
import net.minecraft.resources.*;
import net.minecraft.tags.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.*;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.registries.*;

import java.util.*;

public class FossilBlocks {

    public static void register(){

    }
    public static final RegistryObject<Block> CARBONIFEROUS_FOSSIL = addFossilBlock("carboniferous_fossil", "Carboniferous Fossil", PrehistoricNatureItems.CARBONIFEROUS_RAW_FOSSIL);

    public static RegistryObject<Block> addFossilBlock(String name, String translation, RegistryObject<Item> fossilItem){
        return BlockHandler.registerBlock(name,
                () -> {return new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(1.5F).requiresCorrectToolForDrops());},
                List.of(BlockTags.MINEABLE_WITH_PICKAXE, PrehistoricNatureTags.MINALBE_WITH_GEOLOGICAL_PICK),
                (provider, block) -> {provider.simpleBlock(block);},
                (provider, item) -> {provider.withExistingParent(name, new ResourceLocation(PrehistoricNatureMod.MOD_ID, "block/"+name));},
                (provider, block) -> {provider.createFossilTable(block,fossilItem);},
                List.of(Pair.of("prehistoricnature_fossils_tab",Pair.of(1,1))),
                translation);
    }


}
