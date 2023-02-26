package com.aechtrob.prehistoricnature.block.trees;

import com.aechtrob.prehistoricnature.*;
import com.aechtrob.prehistoricnature.block.*;
import com.aechtrob.prehistoricnature.block.blocks.*;
import com.aechtrob.prehistoricnature.block.trees.lepidodendron.*;
import com.aechtrob.prehistoricnature.creativetabs.*;
import com.aechtrob.prehistoricnature.datagen.*;
import com.aechtrob.prehistoricnature.datagen.loottable.*;
import com.aechtrob.prehistoricnature.item.*;
import com.ibm.icu.impl.*;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.*;
import net.minecraft.sounds.*;
import net.minecraft.tags.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.registries.*;

import java.util.*;

import static com.aechtrob.prehistoricnature.creativetabs.CreativeTabHelper.naturalTabLogTier;

public class TreeBlockRegistration {

    public static ArrayList<RegistryObject<Block>> prehistoricNatureSigns =new ArrayList<>();

    public static RegistryObject<Block> logBlock(RegistryObject<Block> strippedLog, List<TagKey<Block>> blockTags,
                                                 List<TagKey<Item>> itemTags, String treeName,int treeId){
        return BlockHandler.registerBlock(treeName + "_log",
                () -> new PNRotatedPillarFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)){
                    @Override
                    public Block getStrippedBlock() {
                        return strippedLog.get().defaultBlockState().getBlock();
                    }
                }, blockTags,itemTags,
                PrehistoricNatureBlockStateProvider::logBlock,
                (provider, item) -> {provider.withExistingParent(treeName+"_log", new ResourceLocation(PrehistoricNatureMod.MOD_ID, "block/"+treeName+"_log"));},
                BlockLootSubProvider::dropSelf,
                java.util.List.of(Pair.of("prehistoricnature_natural_tab",Pair.of(treeId,1)),Pair.of("prehistoricnature_building_tab",Pair.of(naturalTabLogTier,treeId))),
                capitalizeWord(treeName)+" Log");
    }

    public static RegistryObject<Block> strippedLogBlock(List<TagKey<Block>> blockTags,
                                                         List<TagKey<Item>> itemTags, String treeName,int treeId){
        return BlockHandler.registerBlock(treeName+"_log_stripped",
                () -> new PNRotatedPillarFlammableBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)),
                blockTags,
                itemTags,
                PrehistoricNatureBlockStateProvider::axisBlock,
                (provider, item) -> {provider.withExistingParent(treeName+"_log_stripped", new ResourceLocation(PrehistoricNatureMod.MOD_ID, "block/"+treeName+"_log_stripped"));},
                BlockLootSubProvider::dropSelf,
                List.of(Pair.of("prehistoricnature_building_tab",Pair.of(treeId,3))),
                capitalizeWord(treeName)+" Stripped Log");
    }

    public static RegistryObject<Block> woodBlock(RegistryObject<Block> log,RegistryObject<Block> strippedLog, List<TagKey<Block>> blockTags,
                                                  List<TagKey<Item>> itemTags, String treeName,int treeId){
        return BlockHandler.registerBlock(treeName+"_wood",
                () -> new PNRotatedPillarFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)
                ){
                    @Override
                    public Block getStrippedBlock() {
                        return strippedLog.get().defaultBlockState().getBlock();
                    }
                }, blockTags, itemTags,
                PrehistoricNatureBlockStateProvider::axisBlock,
                (provider, item) -> {provider.withExistingParent(treeName+"_wood", new ResourceLocation(PrehistoricNatureMod.MOD_ID, "block/"+treeName+"_wood"));},
                BlockLootSubProvider::dropSelf,
                (provider,block) -> {provider.twoByTwoRecipeBlocktoBlock(RecipeCategory.BUILDING_BLOCKS,log,block,3);},
                List.of(Pair.of("prehistoricnature_building_tab",Pair.of(treeId,1)),Pair.of("prehistoricnature_natural_tab",Pair.of(naturalTabLogTier,treeId))),
                capitalizeWord(treeName)+" Wood");
    }

    public static RegistryObject<Block> strippedWoodBlock(RegistryObject<Block> strippedLog, List<TagKey<Block>> blockTags,
                                                         List<TagKey<Item>> itemTags, String treeName,int treeId){
        return BlockHandler.registerBlock(treeName+"_wood_stripped",
                () -> new PNRotatedPillarFlammableBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)
                ), blockTags, itemTags,
                PrehistoricNatureBlockStateProvider::axisBlock,
                (provider, item) -> {provider.withExistingParent(treeName+"_wood_stripped", new ResourceLocation(PrehistoricNatureMod.MOD_ID, "block/"+treeName+"_wood_stripped"));},
                BlockLootSubProvider::dropSelf,
                (provider,block) -> {provider.twoByTwoRecipeBlocktoBlock(RecipeCategory.BUILDING_BLOCKS, strippedLog,block,3);},
                List.of(Pair.of("prehistoricnature_building_tab",Pair.of(treeId,4))),
                capitalizeWord(treeName)+" Stripped Wood");
    }

    public static RegistryObject<Block> saplingBlock(AbstractTreeGrower treeGrower, List<TagKey<Block>> blockTags,
                                                     List<TagKey<Item>> itemTags, String treeName, int treeId){
        return BlockHandler.registerBlock(treeName+"_sapling",
                () -> new SaplingBlock(treeGrower, BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)
                ),blockTags,
                itemTags,
                PrehistoricNatureBlockStateProvider::saplingBlock,
                (provider, item) -> {provider.paneNoSide(treeName+"_sapling",new ResourceLocation(PrehistoricNatureMod.MOD_ID,"block/"+treeName+"_sapling"));},
                BlockLootSubProvider::dropSelf,
                List.of(Pair.of("prehistoricnature_natural_tab",Pair.of(CreativeTabHelper.naturalTabSaplingTier,treeId))),
                capitalizeWord(treeName)+" Sapling");
    }
    //TODO make 2d item model instead of 3d
    public static RegistryObject<Block> leafBlock(RegistryObject<Block> sapling, List<TagKey<Block>> blockTags,
                                                  List<TagKey<Item>> itemTags, String treeName,int treeId){
        return BlockHandler.registerBlock(treeName+"_leaves",
                () -> new PNLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)
                ),
                blockTags, itemTags,
                (prehistoricNatureBlockStateProvider, block) -> prehistoricNatureBlockStateProvider.simpleBlock(block),
                (provider, item) -> {provider.withExistingParent(treeName+"_leaves", new ResourceLocation(PrehistoricNatureMod.MOD_ID, "block/"+treeName+"_leaves"));}
                ,(provider,block) -> {provider.createLeavesDrops(block,sapling);},
                List.of(Pair.of("prehistoricnature_natural_tab",Pair.of(CreativeTabHelper.naturalTabLeafTier,treeId))),
                capitalizeWord(treeName)+" Leaves");
    }

    public static RegistryObject<Block> plankBlock(TagKey<Item> logs, List<TagKey<Block>> blockTags,
                                                   List<TagKey<Item>> itemTags, String treeName,int treeId){
        return BlockHandler.registerBlock(treeName+"_planks",
                () -> new PNPlanksFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
                ), blockTags,itemTags,
                (prehistoricNatureBlockStateProvider, block) -> prehistoricNatureBlockStateProvider.simpleBlock(block),
                (provider, item) -> {provider.withExistingParent(treeName+"_planks", new ResourceLocation(PrehistoricNatureMod.MOD_ID, "block/"+treeName+"_planks"));},
                BlockLootSubProvider::dropSelf,
                (provider,block) -> {provider.shapelessConversionRecipe(RecipeCategory.BUILDING_BLOCKS, logs,block,4);},
                List.of(Pair.of("prehistoricnature_building_tab",Pair.of(treeId,5))),
                capitalizeWord(treeName)+" Planks");
    }

    public static RegistryObject<Block> slabBlock(RegistryObject<Block> plank, List<TagKey<Block>> blockTags,
                                                  List<TagKey<Item>> itemTags, String treeName,int treeId){
        return BlockHandler.registerBlock(treeName+"_slab",
                () -> new PNSlabFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)
                ), blockTags, itemTags,
                (provider, block) -> {provider.slabBlock(block, plank);},
                (provider, item) -> {provider.slab(treeName+"_slab", new ResourceLocation(PrehistoricNatureMod.MOD_ID, "block/"+treeName+"_planks"));},
                BlockLootSubProvider::dropSelf,
                (provider,block) -> {provider.slabRecipe(RecipeCategory.BUILDING_BLOCKS, plank,block);},
                List.of(Pair.of("prehistoricnature_building_tab",Pair.of(treeId,7))),
                capitalizeWord(treeName)+" Slab");
    }

    public static RegistryObject<Block> stairsBlock(RegistryObject<Block> plank, List<TagKey<Block>> blockTags,
                                                    List<TagKey<Item>> itemTags, String treeName,int treeId){
        return BlockHandler.registerBlock(treeName+"_stairs",
                () -> new PNStairFlammableBlock(() -> BlocksTreeLepidodendron.LEPIDODENDRON_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)
                ), blockTags, itemTags,
                (provider, block) -> {provider.stairsBlock(block, plank);},
                (provider, item) -> {provider.withExistingParent(treeName+"_stairs", new ResourceLocation(PrehistoricNatureMod.MOD_ID, "block/"+treeName+"_stairs"));},
                BlockLootSubProvider::dropSelf,
                (provider,block) -> {provider.stairRecipe(RecipeCategory.BUILDING_BLOCKS, plank,block);},
                List.of(Pair.of("prehistoricnature_building_tab",Pair.of(treeId,6))),
                capitalizeWord(treeName)+" Stairs");
    }

    public static RegistryObject<Block> fenceBlock(RegistryObject<Block> plank, List<TagKey<Block>> blockTags,
                                                   List<TagKey<Item>> itemTags, String treeName,int treeId){
        return BlockHandler.registerBlock(treeName+"_fence",
                () -> new PNFenceFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)),
                blockTags, itemTags,
                (provider, block) -> {provider.fenceBlock(block, plank);},
                (provider, item) -> {provider.fenceInventory(treeName+"_fence", new ResourceLocation(PrehistoricNatureMod.MOD_ID, "block/"+treeName+"_planks"));},
                BlockLootSubProvider::dropSelf,
                (provider,block) -> {provider.fenceRecipe(RecipeCategory.BUILDING_BLOCKS, plank,block);},
                List.of(Pair.of("prehistoricnature_building_tab",Pair.of(treeId,8))),
                capitalizeWord(treeName)+" Fence");
    }

    public static RegistryObject<Block> fenceGateBlock(RegistryObject<Block> plank, List<TagKey<Block>> blockTags,
                                                       List<TagKey<Item>> itemTags, String treeName,int treeId){
        return BlockHandler.registerBlock(treeName+"_fence_gate",
                () -> new PNFenceGateFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)
                        , SoundEvents.FENCE_GATE_CLOSE, SoundEvents.FENCE_GATE_OPEN),
                blockTags,itemTags,
                (provider, block) -> {provider.fenceGateBlock(block, plank);},
                (provider, item) -> {provider.fenceGate(treeName+"_fence_gate", new ResourceLocation(PrehistoricNatureMod.MOD_ID, "block/"+treeName+"_planks"));},
                BlockLootSubProvider::dropSelf,
                (provider,block) -> {provider.fenceGateRecipe(RecipeCategory.BUILDING_BLOCKS, plank,block);},
                List.of(Pair.of("prehistoricnature_building_tab",Pair.of(treeId,9))),
                capitalizeWord(treeName)+" Fence Gate");
    }

    public static RegistryObject<Block> doorBlock(RegistryObject<Block> plank, List<TagKey<Block>> blockTags,
                                                  List<TagKey<Item>> itemTags, String treeName,int treeId){
        return BlockHandler.registerBlock(treeName+"_door",
                () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR)
                        , SoundEvents.WOODEN_DOOR_OPEN, SoundEvents.WOODEN_DOOR_OPEN),
                blockTags,itemTags,
                PrehistoricNatureBlockStateProvider::doorBlock,
                PrehistoricNatureItemModelProvider::basicItem,
                BlockLootSubProvider::createDoorDrops,
                (provider,block) -> {provider.doorRecipe(RecipeCategory.BUILDING_BLOCKS, plank,block);},
                List.of(Pair.of("prehistoricnature_building_tab",Pair.of(treeId,10))),
                capitalizeWord(treeName)+" Door");
    }

    public static RegistryObject<Block> trapdoorBlock(RegistryObject<Block> plank, List<TagKey<Block>> blockTags,
                                                      List<TagKey<Item>> itemTags, String treeName,int treeId){
        return BlockHandler.registerBlock(treeName+"_trapdoor",
                () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR)
                        , SoundEvents.WOODEN_TRAPDOOR_OPEN, SoundEvents.WOODEN_TRAPDOOR_OPEN),
                blockTags,itemTags,
                BlockLootSubProvider::dropSelf,
                (provider,block) -> {provider.trapdoorRecipe(RecipeCategory.BUILDING_BLOCKS, plank,block);},
                List.of(Pair.of("prehistoricnature_building_tab",Pair.of(treeId,11))),
                capitalizeWord(treeName)+" Trapdoor");
    }

    public static RegistryObject<Block> pressurePlateBlock(RegistryObject<Block> plank, List<TagKey<Block>> blockTags,
                                                           List<TagKey<Item>> itemTags, String treeName,int treeId){
        return BlockHandler.registerBlock(treeName+"_pressure_plate",
                () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON),SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON,SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF),
                blockTags, itemTags,
                (provider, block) -> {provider.pressurePlateBlock(block, plank);},
                (provider, item) -> {provider.pressurePlate(treeName+"_pressure_plate", new ResourceLocation(PrehistoricNatureMod.MOD_ID, "block/"+treeName+"_planks"));},
                BlockLootSubProvider::dropSelf,
                (provider,block) -> {provider.pressurePlateRecipe(RecipeCategory.BUILDING_BLOCKS, plank,block);},
                List.of(Pair.of("prehistoricnature_building_tab",Pair.of(treeId,12))),
                capitalizeWord(treeName)+" Pressure Plate");
    }

    public static RegistryObject<Block> buttonBlock(RegistryObject<Block> plank, List<TagKey<Block>> blockTags,
                                                      List<TagKey<Item>> itemTags, String treeName,int treeId){
        return BlockHandler.registerBlock(treeName+"_button",
                () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON)
                        , 30, true, SoundEvents.WOODEN_BUTTON_CLICK_OFF, SoundEvents.WOODEN_BUTTON_CLICK_ON),
                blockTags,itemTags,
                (provider, block) -> {provider.buttonBlock(block, plank);},
                (provider, item) -> {provider.buttonInventory(treeName+"_button", new ResourceLocation(PrehistoricNatureMod.MOD_ID, "block/"+treeName+"_planks"));},
                BlockLootSubProvider::dropSelf,
                (provider,block) -> {provider.shapelessConversionRecipe(RecipeCategory.BUILDING_BLOCKS, plank,block,1);},
                List.of(Pair.of("prehistoricnature_building_tab",Pair.of(treeId,13))),
                capitalizeWord(treeName)+" Button");
    }

    public static RegistryObject<Block> wallSignBlock(WoodType woodType,  List<TagKey<Block>> blockTags, String treeName){
        return BlockHandler.registerBlockWithoutItem(treeName+"_wall_sign",
                () -> new PNWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN),woodType),
                (provider, block) -> {provider.builtinEntity(block, PrehistoricNatureMod.MOD_ID+":block/"+treeName+"_planks");},
                blockTags);
    }

    public static RegistryObject<Block> standingSignBlock(RegistryObject<Block> wallSign, WoodType woodType,  List<TagKey<Block>> blockTags, String treeName){
        RegistryObject<Block> sign = BlockHandler.registerBlockWithoutItem(treeName+"_sign",
                () -> new PNStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN),woodType),
                (provider, block) -> {//provider.signBlock(block,wallSign,new ResourceLocation(PrehistoricNatureMod.MOD_ID, "block/"+treeName+"_planks"));
                                        provider.builtinEntity(block, PrehistoricNatureMod.MOD_ID+":block/"+treeName+"_planks");},
                blockTags);
        prehistoricNatureSigns.add(sign);
        return sign;
    }

    public static RegistryObject<Item> signItem(RegistryObject<Block> plank, RegistryObject<Block> wallSign, RegistryObject<Block> standingSign,
                                                List<TagKey<Item>> itemTags, String treeName,int treeId){
        return ItemHandler.addSignItem(treeName+"_sign",
                () -> new SignItem(new Item.Properties().stacksTo(16),standingSign.get(),wallSign.get()),
                (provider, item) -> {provider.basicItem(item);},
                    (provider,item) ->{
            provider.dropOther(wallSign,item);
            provider.dropOther(standingSign, item);},
                (provider,item) -> {provider.signRecipe(RecipeCategory.BUILDING_BLOCKS, plank,item);},
                List.of(Pair.of("prehistoricnature_functional_tab",Pair.of(treeId,CreativeTabHelper.functionalTabSignTier))),
                capitalizeWord(treeName)+" Sign");
    }


    public static String capitalizeWord(String str){
        String words[]=str.split("\\s");
        String capitalizeWord="";
        for(String w:words){
            String first=w.substring(0,1);
            String afterfirst=w.substring(1);
            capitalizeWord+=first.toUpperCase()+afterfirst+" ";
        }
        return capitalizeWord.trim();
    }
}
