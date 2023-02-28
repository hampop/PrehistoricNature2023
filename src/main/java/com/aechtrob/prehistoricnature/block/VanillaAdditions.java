package com.aechtrob.prehistoricnature.block;

import net.minecraft.tags.*;
import net.minecraft.world.level.block.*;
import net.minecraftforge.registries.*;

import java.util.*;

public class VanillaAdditions {
    public static void register(){

    }

    public static RegistryObject<Block> SPRUCE_LADDER = BlockRegistration.ladderBlock(
            Blocks.SPRUCE_PLANKS, List.of(BlockTags.MINEABLE_WITH_AXE, BlockTags.CLIMBABLE),List.of(),"spruce");
    public static RegistryObject<Block> BIRCH_LADDER = BlockRegistration.ladderBlock(
            Blocks.BIRCH_PLANKS, List.of(BlockTags.MINEABLE_WITH_AXE, BlockTags.CLIMBABLE),List.of(),"birch");
    public static RegistryObject<Block> JUNGLE_LADDER = BlockRegistration.ladderBlock(
            Blocks.JUNGLE_PLANKS, List.of(BlockTags.MINEABLE_WITH_AXE, BlockTags.CLIMBABLE),List.of(),"jungle");
    public static RegistryObject<Block> ACACIA_LADDER = BlockRegistration.ladderBlock(
            Blocks.ACACIA_PLANKS, List.of(BlockTags.MINEABLE_WITH_AXE, BlockTags.CLIMBABLE),List.of(),"acacia");
    public static RegistryObject<Block> DARK_OAK_LADDER = BlockRegistration.ladderBlock(
            Blocks.DARK_OAK_PLANKS, List.of(BlockTags.MINEABLE_WITH_AXE, BlockTags.CLIMBABLE),List.of(),"dark_oak");
    public static RegistryObject<Block> MANGROVE_LADDER = BlockRegistration.ladderBlock(
            Blocks.MANGROVE_PLANKS, List.of(BlockTags.MINEABLE_WITH_AXE, BlockTags.CLIMBABLE),List.of(),"mangrove");

    public static RegistryObject<Block> WARPED_LADDER = BlockRegistration.ladderBlock(
            Blocks.WARPED_PLANKS, List.of(BlockTags.MINEABLE_WITH_AXE, BlockTags.CLIMBABLE),List.of(),"warped");
    public static RegistryObject<Block> CRIMSON_LADDER = BlockRegistration.ladderBlock(
            Blocks.CRIMSON_PLANKS, List.of(BlockTags.MINEABLE_WITH_AXE, BlockTags.CLIMBABLE),List.of(),"crimson");
}
