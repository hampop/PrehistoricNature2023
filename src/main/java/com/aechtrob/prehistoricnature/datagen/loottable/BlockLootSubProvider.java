package com.aechtrob.prehistoricnature.datagen.loottable;

import com.aechtrob.prehistoricnature.block.*;
import com.aechtrob.prehistoricnature.datagen.helpers.*;
import com.aechtrob.prehistoricnature.item.*;
import net.minecraft.advancements.critereon.*;
import net.minecraft.tags.*;
import net.minecraft.world.flag.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.storage.loot.*;
import net.minecraft.world.level.storage.loot.entries.*;
import net.minecraft.world.level.storage.loot.functions.*;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.minecraft.world.level.storage.loot.providers.number.*;
import net.minecraftforge.registries.*;

import java.util.*;
import java.util.stream.*;

public class BlockLootSubProvider extends net.minecraft.data.loot.BlockLootSubProvider {
    private static float MAX_FOSSILS = 3F;
    private static final float[] NORMAL_LEAVES_SAPLING_CHANCES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};
    private static final LootItemCondition.Builder HAS_GEOLOGIC_PICK = MatchTool.toolMatches(ItemPredicate.Builder.item().of(PrehistoricNatureItems.GEOLOGIC_PICK.get()));
    //private static final LootItemCondition.Builder HAS_PICKAXE = MatchTool.toolMatches(ItemPredicate.Builder.item().of(ItemTags.CLUSTER_MAX_HARVESTABLES));
    public BlockLootSubProvider(){
        super(Collections.emptySet(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        LootTableHelper.getLootTables().forEach((block,consumer)->{consumer.accept(this,block);});
    }

    public void add(RegistryObject<Block> block, LootTable.Builder p_249817_) {
        super.add(block.get(), p_249817_);
    }

    public void createShearsOnlyDrop(RegistryObject<Block> block){
        super.add(block.get(),(shearableBlock)->createShearsOnlyDrop(shearableBlock));
    }
    public void dropSelf(RegistryObject<Block> block) {
        super.dropSelf(block.get());
    }

    public void createFossilTable(RegistryObject<Block> fossil, RegistryObject<Item> coveredFossil){
        this.add(fossil.get(),LootTable.lootTable().withPool(LootPool.lootPool()
                .add(LootItem.lootTableItem(coveredFossil.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1,MAX_FOSSILS)))
                        .when(HAS_GEOLOGIC_PICK).otherwise(LootItem.lootTableItem(fossil.get())))));
    }

    /*
    creates a loot table that drops the block when a silk touch tool is used to mine the block
     */
    public <T extends ItemLike> LootTable.Builder createSingleItemTableWithSilkTouch(RegistryObject<Block> pBlock, RegistryObject<T> item) {
        return super.createSingleItemTableWithSilkTouch(pBlock.get(), item.get());
    }

    public void createLeavesDrops(RegistryObject<Block> block, RegistryObject<Block> sapling) {
        this.add(block.get(),(lambdaBlock) -> createLeavesDrops(lambdaBlock, sapling.get(), NORMAL_LEAVES_SAPLING_CHANCES));
    }

    @Override
    protected Iterable<Block> getKnownBlocks(){
        return BlockHandler.BLOCKS.getEntries().stream()
                .map(RegistryObject::get)
                .collect(Collectors.toList());
    }

    public <T extends ItemLike> void dropOther(RegistryObject<Block> block,RegistryObject<T> item) {
        super.dropOther(block.get(), item.get());
    }

    public void createDoorDrops(RegistryObject<Block> door) {
        this.add(door.get(),(lambdaBlock)->createDoorTable(lambdaBlock));
    }
}
