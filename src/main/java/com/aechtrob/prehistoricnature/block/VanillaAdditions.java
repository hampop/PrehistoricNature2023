package com.aechtrob.prehistoricnature.block;

import com.aechtrob.prehistoricnature.block.trees.*;
import net.minecraft.tags.*;
import net.minecraft.world.level.block.*;
import net.minecraftforge.registries.*;

import java.util.*;

public class VanillaAdditions {
    public static void register(){

    }

    public static RegistryObject<Block> SPRUCE_LADDER = TreeBlockRegistration.ladderBlock(
            Blocks.SPRUCE_PLANKS, List.of(BlockTags.MINEABLE_WITH_AXE, BlockTags.CLIMBABLE),List.of(),"spruce");
    public static RegistryObject<Block> BIRCH_LADDER = TreeBlockRegistration.ladderBlock(
            Blocks.BIRCH_PLANKS, List.of(BlockTags.MINEABLE_WITH_AXE, BlockTags.CLIMBABLE),List.of(),"birch");
    public static RegistryObject<Block> JUNGLE_LADDER = TreeBlockRegistration.ladderBlock(
            Blocks.JUNGLE_PLANKS, List.of(BlockTags.MINEABLE_WITH_AXE, BlockTags.CLIMBABLE),List.of(),"jungle");
    public static RegistryObject<Block> ACACIA_LADDER = TreeBlockRegistration.ladderBlock(
            Blocks.ACACIA_PLANKS, List.of(BlockTags.MINEABLE_WITH_AXE, BlockTags.CLIMBABLE),List.of(),"acacia");
    public static RegistryObject<Block> DARK_OAK_LADDER = TreeBlockRegistration.ladderBlock(
            Blocks.DARK_OAK_PLANKS, List.of(BlockTags.MINEABLE_WITH_AXE, BlockTags.CLIMBABLE),List.of(),"dark_oak");
    public static RegistryObject<Block> MANGROVE_LADDER = TreeBlockRegistration.ladderBlock(
            Blocks.MANGROVE_PLANKS, List.of(BlockTags.MINEABLE_WITH_AXE, BlockTags.CLIMBABLE),List.of(),"mangrove");

    public static RegistryObject<Block> WARPED_LADDER = TreeBlockRegistration.ladderBlock(
            Blocks.WARPED_PLANKS, List.of(BlockTags.MINEABLE_WITH_AXE, BlockTags.CLIMBABLE),List.of(),"warped");
    public static RegistryObject<Block> CRIMSON_LADDER = TreeBlockRegistration.ladderBlock(
            Blocks.CRIMSON_PLANKS, List.of(BlockTags.MINEABLE_WITH_AXE, BlockTags.CLIMBABLE),List.of(),"crimson");
}
