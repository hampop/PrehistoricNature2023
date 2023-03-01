package com.aechtrob.prehistoricnature.block.trees.lepidodendron;

import com.aechtrob.prehistoricnature.PrehistoricNatureMod;
import com.aechtrob.prehistoricnature.block.BlockHandler;
import com.aechtrob.prehistoricnature.block.blocks.*;
import com.aechtrob.prehistoricnature.block.trees.*;
import com.aechtrob.prehistoricnature.block.BlockRegistration;
import com.aechtrob.prehistoricnature.creativetabs.CreativeTabHelper;
import com.aechtrob.prehistoricnature.datagen.loottable.BlockLootSubProvider;
import com.aechtrob.prehistoricnature.world.tree.lepidodendron.LepidodendronTreeGrower;
import com.ibm.icu.impl.Pair;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class BlocksTreeLepidodendron {
    public static class LepidodendronBlockTags {
        public static TagKey<Block> LEPIDODENDRON_LOGS = BlockTags.create(new ResourceLocation(PrehistoricNatureMod.MOD_ID, "lepidodendron_logs"));
    }
    public static class LepidodendronItemTags {
        public static TagKey<Item> LEPIDODENDRON_LOGS = ItemTags.create(new ResourceLocation(PrehistoricNatureMod.MOD_ID, "lepidodendron_logs"));
    }
    public static String treeName = "lepidodendron";
    public static int treeId = 1;
    public static final WoodType LEPIDODENDRON = WoodTypeHelper.putWoodType(WoodType.create(treeName));

    public static final RegistryObject<Block> LEPIDODENDRON_STRIPPED_LOG = BlockRegistration.strippedLogBlock(
                                                                            List.of(LepidodendronBlockTags.LEPIDODENDRON_LOGS,BlockTags.MINEABLE_WITH_AXE,BlockTags.LOGS,BlockTags.LOGS_THAT_BURN,BlockTags.OVERWORLD_NATURAL_LOGS),
                                                                            List.of(LepidodendronItemTags.LEPIDODENDRON_LOGS, ItemTags.LOGS,ItemTags.LOGS_THAT_BURN),treeName,treeId);
    public static final RegistryObject<Block> LEPIDODENDRON_LOG = BlockRegistration.logBlock(LEPIDODENDRON_STRIPPED_LOG,
                                                                            List.of(LepidodendronBlockTags.LEPIDODENDRON_LOGS,BlockTags.MINEABLE_WITH_AXE,BlockTags.LOGS,BlockTags.LOGS_THAT_BURN,BlockTags.OVERWORLD_NATURAL_LOGS),
                                                                            List.of(LepidodendronItemTags.LEPIDODENDRON_LOGS, ItemTags.LOGS,ItemTags.LOGS_THAT_BURN),treeName,treeId);
    public static final RegistryObject<Block> LEPIDODENDRON_STRIPPED_WOOD = BlockRegistration.strippedWoodBlock(LEPIDODENDRON_STRIPPED_LOG,
                                                                            List.of(LepidodendronBlockTags.LEPIDODENDRON_LOGS, BlockTags.MINEABLE_WITH_AXE,BlockTags.LOGS,BlockTags.LOGS_THAT_BURN,BlockTags.OVERWORLD_NATURAL_LOGS),
                                                                            List.of(LepidodendronItemTags.LEPIDODENDRON_LOGS, ItemTags.LOGS,ItemTags.LOGS_THAT_BURN), treeName, treeId);
    public static final RegistryObject<Block> LEPIDODENDRON_WOOD = BlockRegistration.woodBlock(LEPIDODENDRON_LOG,LEPIDODENDRON_STRIPPED_WOOD, List.of(LepidodendronBlockTags.LEPIDODENDRON_LOGS, BlockTags.MINEABLE_WITH_AXE,BlockTags.LOGS,BlockTags.LOGS_THAT_BURN,BlockTags.OVERWORLD_NATURAL_LOGS),
                                                                            List.of(LepidodendronItemTags.LEPIDODENDRON_LOGS, ItemTags.LOGS,ItemTags.LOGS_THAT_BURN), treeName, treeId);
    public static final RegistryObject<Block> LEPIDODENDRON_SAPLING = BlockRegistration.saplingBlock(new LepidodendronTreeGrower(),List.of(BlockTags.SAPLINGS),
                                                                            List.of(ItemTags.SAPLINGS), treeName, treeId);
    public static final RegistryObject<Block> LEPIDODENDRON_LEAVES = BlockRegistration.leafBlock(LEPIDODENDRON_SAPLING,
                                                                            List.of(BlockTags.MINEABLE_WITH_HOE, BlockTags.LEAVES),List.of(ItemTags.LEAVES), treeName, treeId);
    public static final RegistryObject<Block> LEPIDODENDRON_PLANKS = BlockRegistration.plankBlock(LepidodendronItemTags.LEPIDODENDRON_LOGS,List.of(BlockTags.MINEABLE_WITH_AXE,BlockTags.PLANKS),
                                                                            List.of(ItemTags.PLANKS),treeName,treeId);
    public static final RegistryObject<Block> LEPIDODENDRON_SLAB = BlockRegistration.slabBlock(LEPIDODENDRON_PLANKS,List.of(BlockTags.MINEABLE_WITH_AXE,BlockTags.WOODEN_SLABS),
                                                                            List.of(ItemTags.WOODEN_SLABS),treeName,treeId);
    public static final RegistryObject<Block> LEPIDODENDRON_STAIRS = BlockRegistration.stairsBlock(LEPIDODENDRON_PLANKS,List.of(BlockTags.MINEABLE_WITH_AXE,BlockTags.WOODEN_STAIRS),
                                                                            List.of(ItemTags.WOODEN_STAIRS),treeName,treeId);
    public static final RegistryObject<Block> LEPIDODENDRON_FENCE = BlockRegistration.fenceBlock(LEPIDODENDRON_PLANKS,List.of(BlockTags.MINEABLE_WITH_AXE,BlockTags.WOODEN_FENCES),
                                                                            List.of(ItemTags.WOODEN_FENCES),treeName,treeId);
    public static final RegistryObject<Block> LEPIDODENDRON_FENCE_GATE = BlockRegistration.fenceGateBlock(LEPIDODENDRON_PLANKS,List.of(BlockTags.MINEABLE_WITH_AXE,BlockTags.FENCE_GATES),
                                                                            List.of(ItemTags.FENCE_GATES), treeName, treeId);
    public static final RegistryObject<Block> LEPIDODENDRON_DOOR = BlockRegistration.doorBlock(LEPIDODENDRON_PLANKS,List.of(BlockTags.MINEABLE_WITH_AXE,BlockTags.WOODEN_DOORS),
                                                                            List.of(ItemTags.WOODEN_DOORS), treeName, treeId);
    //Needs manual json file.
    public static final RegistryObject<Block> LEPIDODENDRON_TRAPDOOR = BlockRegistration.trapdoorBlock(LEPIDODENDRON_PLANKS,List.of(BlockTags.MINEABLE_WITH_AXE,BlockTags.WOODEN_TRAPDOORS),
                                                                            List.of(ItemTags.WOODEN_TRAPDOORS), treeName, treeId);
    public static final RegistryObject<Block> LEPIDODENDRON_PRESSURE_PLATE = BlockRegistration.pressurePlateBlock(LEPIDODENDRON_PLANKS,List.of(BlockTags.MINEABLE_WITH_AXE,BlockTags.WOODEN_PRESSURE_PLATES),
                                                                            List.of(ItemTags.WOODEN_PRESSURE_PLATES), treeName, treeId);
    public static final RegistryObject<Block> LEPIDODENDRON_BUTTON = BlockRegistration.buttonBlock(LEPIDODENDRON_PLANKS ,List.of(BlockTags.MINEABLE_WITH_AXE,BlockTags.WOODEN_BUTTONS),
                                                                            List.of(ItemTags.WOODEN_BUTTONS), treeName, treeId);
    public static final RegistryObject<Block> LEPIDODENDRON_WALL_SIGN = BlockRegistration.wallSignBlock(LEPIDODENDRON,List.of(BlockTags.WALL_SIGNS),treeName);
    public static final RegistryObject<Block> LEPIDODENDRON_SIGN = BlockRegistration.standingSignBlock(LEPIDODENDRON_WALL_SIGN,LEPIDODENDRON,List.of(BlockTags.STANDING_SIGNS),treeName);

    public static final RegistryObject<Block> LEPIDODENDRON_LADDER = BlockRegistration.ladderBlock(
            LEPIDODENDRON_PLANKS, List.of(BlockTags.MINEABLE_WITH_AXE, BlockTags.CLIMBABLE),List.of(),treeName,treeId);


//    public static final RegistryObject<Block> LEPIDODENDRON_BENCH = BlockHandler.registerBlock("lepidodendron_bench",
//            () -> new PNBenchBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON)
//                    , 30, true, SoundEvents.WOODEN_BUTTON_CLICK_OFF, SoundEvents.WOODEN_BUTTON_CLICK_ON));

    //Other tree-specific stuff:
    public static final RegistryObject<Block> LEPIDODENDRON_STROBILUS = BlockHandler.registerBlock("lepidodendron_strobilus",
            () -> new LepidodendronStrobilus(BlockBehaviour.Properties.copy(Blocks.GRASS)),
            List.of(BlockTags.FLOWERS),
            List.of(ItemTags.FLOWERS),
            (provider, item) -> {provider.generated("lepidodendron_strobilus",new ResourceLocation(PrehistoricNatureMod.MOD_ID,"block/lepidodendron_strobilus"));},
            BlockLootSubProvider::dropSelf,
            List.of(Pair.of("prehistoricnature_natural_tab",Pair.of(CreativeTabHelper.naturalTabSaplingTier,treeId))),
            "Lepidodendron Strobilus", 0);

    public static void register() {
    }
}
