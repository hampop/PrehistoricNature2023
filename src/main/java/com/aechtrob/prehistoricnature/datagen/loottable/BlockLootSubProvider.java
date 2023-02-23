package com.aechtrob.prehistoricnature.datagen.loottable;

import com.aechtrob.prehistoricnature.block.*;
import com.aechtrob.prehistoricnature.item.*;
import net.minecraft.advancements.critereon.*;
import net.minecraft.data.loot.*;
import net.minecraft.resources.*;
import net.minecraft.tags.*;
import net.minecraft.world.flag.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.storage.loot.*;
import net.minecraft.world.level.storage.loot.entries.*;
import net.minecraft.world.level.storage.loot.functions.*;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.minecraft.world.level.storage.loot.providers.number.*;
import net.minecraftforge.registries.*;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class BlockLootSubProvider extends net.minecraft.data.loot.BlockLootSubProvider {
    private static float MAX_FOSSILS = 3F;
    private static final LootItemCondition.Builder HAS_GEOLOGIC_PICK = MatchTool.toolMatches(ItemPredicate.Builder.item().of(PrehistoricNatureItems.GEOLOGIC_PICK.get()));
    //private static final LootItemCondition.Builder HAS_PICKAXE = MatchTool.toolMatches(ItemPredicate.Builder.item().of(ItemTags.CLUSTER_MAX_HARVESTABLES));
    public BlockLootSubProvider(){
        super(Collections.emptySet(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.add(FossilBlocks.CARBONIFEROUS_FOSSIL.get(), (block) -> createFossilTable(block, PrehistoricNatureItems.CARBONIFEROUS_RAW_FOSSIL.get()));
    }

    private LootTable.Builder createFossilTable(Block fossil, Item coveredFossil){
        return LootTable.lootTable().withPool(LootPool.lootPool()
                .add(LootItem.lootTableItem(coveredFossil).apply(SetItemCountFunction.setCount(UniformGenerator.between(1,MAX_FOSSILS)))
                        .when(HAS_GEOLOGIC_PICK).otherwise(LootItem.lootTableItem(fossil))));
//         LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(2.0F))
//                .add(LootItem.lootTableItem(coveredFossil).apply(SetItemCountFunction.setCount(UniformGenerator.between(1,MAX_FOSSILS)))
//                .when(HAS_GEOLOGIC_PICK).otherwise(LootItem.lootTableItem(fossil))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks(){
        return BlockHandler.BLOCKS.getEntries().stream()
                .map(RegistryObject::get)
                .collect(Collectors.toList());
    }
}
