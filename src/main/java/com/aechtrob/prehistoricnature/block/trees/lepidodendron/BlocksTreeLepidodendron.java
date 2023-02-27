package com.aechtrob.prehistoricnature.block.trees.lepidodendron;

import com.aechtrob.prehistoricnature.PrehistoricNatureMod;
import com.aechtrob.prehistoricnature.block.BlockHandler;
import com.aechtrob.prehistoricnature.block.trees.TreeBlockRegistration;
import com.aechtrob.prehistoricnature.block.trees.WoodTypeHelper;
import com.aechtrob.prehistoricnature.creativetabs.CreativeTabHelper;
import com.aechtrob.prehistoricnature.datagen.loottable.BlockLootSubProvider;
import com.aechtrob.prehistoricnature.world.tree.lepidodendron.LepidodendronTreeGrower;
import com.ibm.icu.impl.Pair;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
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

    public static final RegistryObject<Block> LEPIDODENDRON_STRIPPED_LOG = TreeBlockRegistration.strippedLogBlock(
                                                                            List.of(LepidodendronBlockTags.LEPIDODENDRON_LOGS,BlockTags.MINEABLE_WITH_AXE,BlockTags.LOGS,BlockTags.LOGS_THAT_BURN,BlockTags.OVERWORLD_NATURAL_LOGS),
                                                                            List.of(LepidodendronItemTags.LEPIDODENDRON_LOGS, ItemTags.LOGS,ItemTags.LOGS_THAT_BURN),treeName,treeId);
    public static final RegistryObject<Block> LEPIDODENDRON_LOG = TreeBlockRegistration.logBlock(LEPIDODENDRON_STRIPPED_LOG,
                                                                            List.of(LepidodendronBlockTags.LEPIDODENDRON_LOGS,BlockTags.MINEABLE_WITH_AXE,BlockTags.LOGS,BlockTags.LOGS_THAT_BURN,BlockTags.OVERWORLD_NATURAL_LOGS),
                                                                            List.of(LepidodendronItemTags.LEPIDODENDRON_LOGS, ItemTags.LOGS,ItemTags.LOGS_THAT_BURN),treeName,treeId);
    public static final RegistryObject<Block> LEPIDODENDRON_STRIPPED_WOOD = TreeBlockRegistration.strippedWoodBlock(LEPIDODENDRON_STRIPPED_LOG,
                                                                            List.of(LepidodendronBlockTags.LEPIDODENDRON_LOGS, BlockTags.MINEABLE_WITH_AXE,BlockTags.LOGS,BlockTags.LOGS_THAT_BURN,BlockTags.OVERWORLD_NATURAL_LOGS),
                                                                            List.of(LepidodendronItemTags.LEPIDODENDRON_LOGS, ItemTags.LOGS,ItemTags.LOGS_THAT_BURN), treeName, treeId);
    public static final RegistryObject<Block> LEPIDODENDRON_WOOD = TreeBlockRegistration.woodBlock(LEPIDODENDRON_LOG,LEPIDODENDRON_STRIPPED_WOOD, List.of(LepidodendronBlockTags.LEPIDODENDRON_LOGS, BlockTags.MINEABLE_WITH_AXE,BlockTags.LOGS,BlockTags.LOGS_THAT_BURN,BlockTags.OVERWORLD_NATURAL_LOGS),
                                                                            List.of(LepidodendronItemTags.LEPIDODENDRON_LOGS, ItemTags.LOGS,ItemTags.LOGS_THAT_BURN), treeName, treeId);
    public static final RegistryObject<Block> LEPIDODENDRON_SAPLING = TreeBlockRegistration.saplingBlock(new LepidodendronTreeGrower(),List.of(BlockTags.SAPLINGS),
                                                                            List.of(ItemTags.SAPLINGS), treeName, treeId);
    public static final RegistryObject<Block> LEPIDODENDRON_LEAVES = TreeBlockRegistration.leafBlock(LEPIDODENDRON_SAPLING,
                                                                            List.of(BlockTags.MINEABLE_WITH_HOE, BlockTags.LEAVES),List.of(ItemTags.LEAVES), treeName, treeId);
    public static final RegistryObject<Block> LEPIDODENDRON_PLANKS = TreeBlockRegistration.plankBlock(LepidodendronItemTags.LEPIDODENDRON_LOGS,List.of(BlockTags.MINEABLE_WITH_AXE,BlockTags.PLANKS),
                                                                            List.of(ItemTags.PLANKS),treeName,treeId);
    public static final RegistryObject<Block> LEPIDODENDRON_SLAB = TreeBlockRegistration.slabBlock(LEPIDODENDRON_PLANKS,List.of(BlockTags.MINEABLE_WITH_AXE,BlockTags.WOODEN_SLABS),
                                                                            List.of(ItemTags.WOODEN_SLABS),treeName,treeId);
    public static final RegistryObject<Block> LEPIDODENDRON_STAIRS = TreeBlockRegistration.stairsBlock(LEPIDODENDRON_PLANKS,List.of(BlockTags.MINEABLE_WITH_AXE,BlockTags.WOODEN_STAIRS),
                                                                            List.of(ItemTags.WOODEN_STAIRS),treeName,treeId);
    public static final RegistryObject<Block> LEPIDODENDRON_FENCE = TreeBlockRegistration.fenceBlock(LEPIDODENDRON_PLANKS,List.of(BlockTags.MINEABLE_WITH_AXE,BlockTags.WOODEN_FENCES),
                                                                            List.of(ItemTags.WOODEN_FENCES),treeName,treeId);
    public static final RegistryObject<Block> LEPIDODENDRON_FENCE_GATE = TreeBlockRegistration.fenceGateBlock(LEPIDODENDRON_PLANKS,List.of(BlockTags.MINEABLE_WITH_AXE,BlockTags.FENCE_GATES),
                                                                            List.of(ItemTags.FENCE_GATES), treeName, treeId);
    public static final RegistryObject<Block> LEPIDODENDRON_DOOR = TreeBlockRegistration.doorBlock(LEPIDODENDRON_PLANKS,List.of(BlockTags.MINEABLE_WITH_AXE,BlockTags.WOODEN_DOORS),
                                                                            List.of(ItemTags.WOODEN_DOORS), treeName, treeId);
    //Needs manual json file.
    public static final RegistryObject<Block> LEPIDODENDRON_TRAPDOOR = TreeBlockRegistration.trapdoorBlock(LEPIDODENDRON_PLANKS,List.of(BlockTags.MINEABLE_WITH_AXE,BlockTags.WOODEN_TRAPDOORS),
                                                                            List.of(ItemTags.WOODEN_TRAPDOORS), treeName, treeId);
    public static final RegistryObject<Block> LEPIDODENDRON_PRESSURE_PLATE = TreeBlockRegistration.pressurePlateBlock(LEPIDODENDRON_PLANKS,List.of(BlockTags.MINEABLE_WITH_AXE,BlockTags.WOODEN_PRESSURE_PLATES),
                                                                            List.of(ItemTags.WOODEN_PRESSURE_PLATES), treeName, treeId);
    public static final RegistryObject<Block> LEPIDODENDRON_BUTTON = TreeBlockRegistration.buttonBlock(LEPIDODENDRON_PLANKS ,List.of(BlockTags.MINEABLE_WITH_AXE,BlockTags.WOODEN_BUTTONS),
                                                                            List.of(ItemTags.WOODEN_BUTTONS), treeName, treeId);
    public static final RegistryObject<Block> LEPIDODENDRON_WALL_SIGN = TreeBlockRegistration.wallSignBlock(LEPIDODENDRON,List.of(BlockTags.WALL_SIGNS),treeName);
    public static final RegistryObject<Block> LEPIDODENDRON_SIGN =TreeBlockRegistration.standingSignBlock(LEPIDODENDRON_WALL_SIGN,LEPIDODENDRON,List.of(BlockTags.STANDING_SIGNS),treeName);


//    public static final RegistryObject<Block> LEPIDODENDRON_BENCH = BlockHandler.registerBlock("lepidodendron_bench",
//            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON)
//                    , 30, true, SoundEvents.WOODEN_BUTTON_CLICK_OFF, SoundEvents.WOODEN_BUTTON_CLICK_ON));

    //How do signs work? There are a few different blocks for each one!

    //Other tree-specific stuff:
    //
    //TODO make 2d item model instead of 3d
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
