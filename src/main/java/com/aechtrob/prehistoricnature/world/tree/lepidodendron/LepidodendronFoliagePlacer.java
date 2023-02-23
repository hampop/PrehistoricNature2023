package com.aechtrob.prehistoricnature.world.tree.lepidodendron;

import com.aechtrob.prehistoricnature.block.blocks.PNDecayableDirectional;
import com.aechtrob.prehistoricnature.block.trees.lepidodendron.ModBlocksTreeLepidodendron;
import com.aechtrob.prehistoricnature.world.tree.PNFoliagePlacerType;
import com.aechtrob.prehistoricnature.world.tree.PNTreeFeature;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

import java.util.function.BiConsumer;

public class LepidodendronFoliagePlacer extends BlobFoliagePlacer {
    public LepidodendronFoliagePlacer(IntProvider p_161356_, IntProvider p_161357_, int p_161358_) {
        super(p_161356_, p_161357_, p_161358_);
    }
    public static final Codec<LepidodendronFoliagePlacer> CODEC = RecordCodecBuilder.create((instance) -> {
        return blobParts(instance).apply(instance, LepidodendronFoliagePlacer::new);
    });

    @Override
    protected FoliagePlacerType<?> type() {
        return PNFoliagePlacerType.LEPIDODENDRON_FOLIAGE_PLACER.get();
    }

    BlockState leafState = ModBlocksTreeLepidodendron.LEPIDODENDRON_LEAVES.get().defaultBlockState();
    BlockState strobilusState = ModBlocksTreeLepidodendron.LEPIDODENDRON_STROBILUS.get().defaultBlockState().setValue(PNDecayableDirectional.PERSISTENT, false);

    @Override
    protected void createFoliage(LevelSimulatedReader levelSimulatedReader, BiConsumer<BlockPos, BlockState> biConsumer, RandomSource random, TreeConfiguration treeConfiguration, int ii, FoliageAttachment foliageAttachment, int p_161366_, int p_161367_, int p_161368_) {
        //This sets a single block of foliage only, and is detailed in the Trunk generator for where exactly it all has to go.
        //For trees with no flowers, strobili or variant leaf blocks, do not use this, use PNFoliagePlacer instead.
        BlockPos pos = foliageAttachment.pos();
        BlockState state = treeConfiguration.foliageProvider.getState(random, pos);
        switch (foliageAttachment.radiusOffset()) { //Co-opting the radius field as a block enumerator for varied blocks
            case 0:
                state = leafState;
                break;
            case 1:
                state = strobilusState;
                break;
            default:
                state = leafState;
                break;
        }

        if (PNTreeFeature.canLeavesReplaceBlock(levelSimulatedReader, pos)) {
            biConsumer.accept(pos, state);
        }
    }
}
