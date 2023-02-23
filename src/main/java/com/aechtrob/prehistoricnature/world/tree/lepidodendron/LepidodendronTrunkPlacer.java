package com.aechtrob.prehistoricnature.world.tree.lepidodendron;

import com.aechtrob.prehistoricnature.block.blocks.PNRotatedPillarFlammableBlock;
import com.aechtrob.prehistoricnature.block.trees.lepidodendron.ModBlocksTreeLepidodendron;
import com.aechtrob.prehistoricnature.world.tree.PNTreeFeature;
import com.aechtrob.prehistoricnature.world.tree.PNTrunkPlacerType;
import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;

public class LepidodendronTrunkPlacer extends TrunkPlacer {

    public LepidodendronTrunkPlacer(int p_70268_, int p_70269_, int p_70270_) {
        super(p_70268_, p_70269_, p_70270_);
    }
    public static final Codec<LepidodendronTrunkPlacer> CODEC = RecordCodecBuilder.create((instance) -> {
        return trunkPlacerParts(instance).apply(instance, LepidodendronTrunkPlacer::new);
    });

    protected void setFoliage(LevelSimulatedReader levelSimulatedReader, BiConsumer<BlockPos, BlockState> biConsumer, RandomSource random, TreeConfiguration treeConfiguration, int ii, FoliagePlacer.FoliageAttachment foliageAttachment, int p_161366_, int p_161367_, int p_161368_) {
        BlockPos pos = foliageAttachment.pos();
        if (PNTreeFeature.canLeavesReplaceBlock(levelSimulatedReader, pos)) {
            biConsumer.accept(pos, treeConfiguration.foliageProvider.getState(random, pos));
        }
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return PNTrunkPlacerType.LEPIDODENDRON_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader levelSimulatedReader, BiConsumer<BlockPos, BlockState> biConsumer, RandomSource random, int p_161871_, BlockPos pos, TreeConfiguration treeConfiguration) {

        List<FoliagePlacer.FoliageAttachment> list = Lists.newArrayList();
        int height = 0;
        int counter = 0;
        BlockState logState = ModBlocksTreeLepidodendron.LEPIDODENDRON_LOG.get().defaultBlockState();
        BlockState woodState = ModBlocksTreeLepidodendron.LEPIDODENDRON_WOOD.get().defaultBlockState();

        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos)) {
            biConsumer.accept(pos, logState);
            placeLog(levelSimulatedReader, biConsumer, random, pos, treeConfiguration);
        }
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.above())) {
            biConsumer.accept(pos.above(), logState);
            placeLog(levelSimulatedReader, biConsumer, random, pos.above(), treeConfiguration);
        }
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.south())) {
            biConsumer.accept(pos.south(), logState);
            placeLog(levelSimulatedReader, biConsumer, random, pos.south(), treeConfiguration);
        }
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.south(2))) {
            biConsumer.accept(pos.south(2), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.Z));
            placeLog(levelSimulatedReader, biConsumer, random, pos.south(2), treeConfiguration);
        }
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.north())) {
            biConsumer.accept(pos.north(), logState);
            placeLog(levelSimulatedReader, biConsumer, random, pos.north(), treeConfiguration);
        }
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.north(2))) {
            biConsumer.accept(pos.north(2), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.Z));
            placeLog(levelSimulatedReader, biConsumer, random, pos.north(2), treeConfiguration);
        }
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.east())) {
            biConsumer.accept(pos.east(), logState);
            placeLog(levelSimulatedReader, biConsumer, random, pos.east(), treeConfiguration);
        }
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.east(2))) {
            biConsumer.accept(pos.east(2), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.X));
            placeLog(levelSimulatedReader, biConsumer, random, pos.east(2), treeConfiguration);
        }
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.west())) {
            biConsumer.accept(pos.west(), logState);
            placeLog(levelSimulatedReader, biConsumer, random, pos.west(), treeConfiguration);
        }
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.west(2))) {
            biConsumer.accept(pos.west(2), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.X));
            placeLog(levelSimulatedReader, biConsumer, random, pos.west(2), treeConfiguration);
        }

        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.east().above())) {
            biConsumer.accept(pos.east().above(), woodState);
            placeLog(levelSimulatedReader, biConsumer, random, pos.east().above(), treeConfiguration);
        }
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.west().above())) {
            biConsumer.accept(pos.west().above(), woodState);
            placeLog(levelSimulatedReader, biConsumer, random, pos.west().above(), treeConfiguration);
        }
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.south().above())) {
            biConsumer.accept(pos.south().above(), woodState);
            placeLog(levelSimulatedReader, biConsumer, random, pos.south().above(), treeConfiguration);
        }
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.north().above())) {
            biConsumer.accept(pos.north().above(), woodState);
            placeLog(levelSimulatedReader, biConsumer, random, pos.north().above(), treeConfiguration);
        }

        height = (int) ((18D) + Math.round((Math.random() * 10D) / 2D) + Math.round((Math.random() * 10D) / 2D)
                + Math.round((Math.random() * 10D) / 2D));
        counter = 1;
        while (counter <= height) {
            if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.above(1 + counter))) {
                biConsumer.accept(pos.above(1 + counter), logState);
                placeLog(levelSimulatedReader, biConsumer, random, pos.above(1 + counter), treeConfiguration);
            }
            counter += 1;
        }

        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.offset(0, height + 1, 0))) {
            biConsumer.accept(pos.offset(0, height + 1, 0), logState);
            placeLog(levelSimulatedReader, biConsumer, random, pos.offset(0, height + 1, 0), treeConfiguration);
        }
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.offset(0, height + 2, 0))) {
            biConsumer.accept(pos.offset(0, height + 2, 0), logState);
            placeLog(levelSimulatedReader, biConsumer, random, pos.offset(0, height + 2, 0), treeConfiguration);
        }
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.offset(0, height + 3, 0))) {
            biConsumer.accept(pos.offset(0, height + 3, 0), logState);
            placeLog(levelSimulatedReader, biConsumer, random, pos.offset(0, height + 3, 0), treeConfiguration);
        }
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.offset(0, height + 4, 0))) {
            biConsumer.accept(pos.offset(0, height + 4, 0), logState);
            placeLog(levelSimulatedReader, biConsumer, random, pos.offset(0, height + 4, 0), treeConfiguration);
        }
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.offset(0, height + 5, 0))) {
            biConsumer.accept(pos.offset(0, height + 5, 0), logState);
            placeLog(levelSimulatedReader, biConsumer, random, pos.offset(0, height + 5, 0), treeConfiguration);
        }
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.offset(0, height + 6, 0))) {
            biConsumer.accept(pos.offset(0, height + 6, 0), woodState);
            placeLog(levelSimulatedReader, biConsumer, random, pos.offset(0, height + 6, 0), treeConfiguration);
        }
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.offset(0, height + 2, 1))) {
            biConsumer.accept(pos.offset(0, height + 2, 1), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.Z));
            placeLog(levelSimulatedReader, biConsumer, random, pos.offset(0, height + 2, 1), treeConfiguration);
        }
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.offset(0, height + 2, 2))) {
            biConsumer.accept(pos.offset(0, height + 2, 2), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.Z));
            placeLog(levelSimulatedReader, biConsumer, random, pos.offset(0, height + 2, 2), treeConfiguration);
        }
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.offset(0, height + 2, 3))) {
            biConsumer.accept(pos.offset(0, height + 2, 3), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.Z));
            placeLog(levelSimulatedReader, biConsumer, random, pos.offset(0, height + 2, 3), treeConfiguration);
        }
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.offset(0, height + 2, 4))) {
            biConsumer.accept(pos.offset(0, height + 2, 4), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.Z));
            placeLog(levelSimulatedReader, biConsumer, random, pos.offset(0, height + 2, 4), treeConfiguration);
        }
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.offset(0, height + 2, -1))) {
            biConsumer.accept(pos.offset(0, height + 2, -1), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.Z));
            placeLog(levelSimulatedReader, biConsumer, random, pos.offset(0, height + 2, -1), treeConfiguration);
        }
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.offset(0, height + 2, -2))) {
            biConsumer.accept(pos.offset(0, height + 2, -2), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.Z));
            placeLog(levelSimulatedReader, biConsumer, random, pos.offset(0, height + 2, -2), treeConfiguration);
        }
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.offset(0, height + 2, -3))) {
            biConsumer.accept(pos.offset(0, height + 2, -3), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.Z));
            placeLog(levelSimulatedReader, biConsumer, random, pos.offset(0, height + 2, -3), treeConfiguration);
        }
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.offset(0, height + 2, -4))) {
            biConsumer.accept(pos.offset(0, height + 2, -4), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.Z));
            placeLog(levelSimulatedReader, biConsumer, random, pos.offset(0, height + 2, -4), treeConfiguration);
        }
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.offset(1, height + 2, 0))) {
            biConsumer.accept(pos.offset(1, height + 2, 0), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.X));
            placeLog(levelSimulatedReader, biConsumer, random, pos.offset(1, height + 2, 0), treeConfiguration);
        }
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.offset(2, height + 2, 0))) {
            biConsumer.accept(pos.offset(2, height + 2, 0), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.X));
            placeLog(levelSimulatedReader, biConsumer, random, pos.offset(2, height + 2, 0), treeConfiguration);
        }
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.offset(3, height + 2, 0))) {
            biConsumer.accept(pos.offset(3, height + 2, 0), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.X));
            placeLog(levelSimulatedReader, biConsumer, random, pos.offset(3, height + 2, 0), treeConfiguration);
        }
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.offset(4, height + 2, 0))) {
            biConsumer.accept(pos.offset(4, height + 2, 0), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.X));
            placeLog(levelSimulatedReader, biConsumer, random, pos.offset(4, height + 2, 0), treeConfiguration);
        }
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.offset(-1, height + 2, 0))) {
            biConsumer.accept(pos.offset(-1, height + 2, 0), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.X));
            placeLog(levelSimulatedReader, biConsumer, random, pos.offset(-1, height + 2, 0), treeConfiguration);
        }
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.offset(-2, height + 2, 0))) {
            biConsumer.accept(pos.offset(-2, height + 2, 0), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.X));
            placeLog(levelSimulatedReader, biConsumer, random, pos.offset(-2, height + 2, 0), treeConfiguration);
        }
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.offset(-3, height + 2, 0))) {
            biConsumer.accept(pos.offset(-3, height + 2, 0), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.X));
            placeLog(levelSimulatedReader, biConsumer, random, pos.offset(-3, height + 2, 0), treeConfiguration);
        }
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.offset(-4, height + 2, 0))) {
            biConsumer.accept(pos.offset(-4, height + 2, 0), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.X));
            placeLog(levelSimulatedReader, biConsumer, random, pos.offset(-4, height + 2, 0), treeConfiguration);
        }

        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.offset(1, height + 3, 1))) {
            biConsumer.accept(pos.offset(1, height + 3, 1), woodState);
            placeLog(levelSimulatedReader, biConsumer, random, pos.offset(1, height + 3, 1), treeConfiguration);
        }
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.offset(-1, height + 3, 1))) {
            biConsumer.accept(pos.offset(-1, height + 3, 1), woodState);
            placeLog(levelSimulatedReader, biConsumer, random, pos.offset(-1, height + 3, 1), treeConfiguration);
        }
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.offset(-1, height + 3, -1))) {
            biConsumer.accept(pos.offset(-1, height + 3, -1), woodState);
            placeLog(levelSimulatedReader, biConsumer, random, pos.offset(-1, height + 3, -1), treeConfiguration);
        }
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.offset(1, height + 3, -1))) {
            biConsumer.accept(pos.offset(1, height + 3, -1), woodState);
            placeLog(levelSimulatedReader, biConsumer, random, pos.offset(1, height + 3, -1), treeConfiguration);
        }
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.offset(-2, height + 3, -2))) {
            biConsumer.accept(pos.offset(-2, height + 3, -2), woodState);
            placeLog(levelSimulatedReader, biConsumer, random, pos.offset(-2, height + 3, -2), treeConfiguration);
        }
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.offset(2, height + 3, -2))) {
            biConsumer.accept(pos.offset(2, height + 3, -2), woodState);
            placeLog(levelSimulatedReader, biConsumer, random, pos.offset(2, height + 3, -2), treeConfiguration);
        }
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.offset(2, height + 3, 2))) {
            biConsumer.accept(pos.offset(2, height + 3, 2), woodState);
            placeLog(levelSimulatedReader, biConsumer, random, pos.offset(2, height + 3, 2), treeConfiguration);
        }
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.offset(-2, height + 3, 2))) {
            biConsumer.accept(pos.offset(-2, height + 3, 2), woodState);
            placeLog(levelSimulatedReader, biConsumer, random, pos.offset(-2, height + 3, 2), treeConfiguration);
        }

        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.offset(1, height + 5, 0))) {
            biConsumer.accept(pos.offset(1, height + 5, 0), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.X));
            placeLog(levelSimulatedReader, biConsumer, random, pos.offset(1, height + 5, 0), treeConfiguration);
        }
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.offset(-1, height + 5, 0))) {
            biConsumer.accept(pos.offset(-1, height + 5, 0), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.X));
            placeLog(levelSimulatedReader, biConsumer, random, pos.offset(-1, height + 5, 0), treeConfiguration);
        }
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.offset(0, height + 5, 1))) {
            biConsumer.accept(pos.offset(0, height + 5, 1), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.Z));
            placeLog(levelSimulatedReader, biConsumer, random, pos.offset(0, height + 5, 1), treeConfiguration);
        }
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos.offset(0, height + 5, -1))) {
            biConsumer.accept(pos.offset(0, height + 5, -1), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.Z));
            placeLog(levelSimulatedReader, biConsumer, random, pos.offset(0, height + 5, -1), treeConfiguration);
        }

        //Leaves:
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + 1, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(6, height + 1, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + 1, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-6, height + 1, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 1, 3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 1, 6), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 1, -3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 1, -6), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + 1, 4), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + 1, -4), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + 1, 4), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + 1, -4), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(4, height + 1, 3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(4, height + 1, -3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-4, height + 1, 3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-4, height + 1, -3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 2, 5), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 2, 6), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 3, -2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 3, 2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + 3, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + 3, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 3, -3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 3, 3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 3, -3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 3, 3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + 3, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + 3, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + 3, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + 3, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 2, -5), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 2, -6), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(5, height + 2, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(6, height + 2, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-5, height + 2, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-6, height + 2, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 2, 3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 2, 4), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 2, 5), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 2, 3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 2, 4), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 2, 5), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 2, -3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 2, -4), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 2, -5), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 2, -3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 2, -4), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 2, -5), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + 2, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(4, height + 2, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(5, height + 2, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + 2, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(4, height + 2, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(5, height + 2, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + 2, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-4, height + 2, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-5, height + 2, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + 2, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-4, height + 2, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-5, height + 2, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 2, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 2, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 2, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 2, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + 2, 4), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + 2, 4), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + 2, 4), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + 2, 4), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + 2, -4), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + 2, -4), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + 2, -4), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + 2, -4), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(4, height + 2, 2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(4, height + 2, 3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(4, height + 2, -2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(4, height + 2, -3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-4, height + 2, 2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-4, height + 2, 3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-4, height + 2, -2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-4, height + 2, -3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + 3, 3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + 3, 3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + 3, 3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + 3, 3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + 3, 2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 3, 2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 3, 2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + 3, 2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + 3, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 3, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + 3, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 3, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 3, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + 3, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 3, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + 3, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + 3, -2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 3, -2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 3, -2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + 3, -2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + 3, -3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + 3, -3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + 3, -3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + 3, -3), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + 4, 2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + 4, 2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + 4, -2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + 4, -2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 4, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 4, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 4, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 4, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + 5, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 5, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 5, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 5, 2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 5, -2), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 5, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 5, -1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + 5, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 6, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 6, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 6, 0), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 6, 1), 0, true));
        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 6, -1), 0, true));

        //Strobili:
        if ((Math.random() > 0.4)) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(6, height, 0), 1, true));
        }
        if ((Math.random() > 0.4)) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-6, height, 0), 1, true));
        }
        if ((Math.random() > 0.4)) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height, 6), 1, true));
        }
        if ((Math.random() > 0.4)) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height, -6), 1, true));
        }
        if ((Math.random() > 0.4)) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height, 4), 1, true));
        }
        if ((Math.random() > 0.4)) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height, -4), 1, true));
        }
        if ((Math.random() > 0.4)) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height, 4), 1, true));
        }
        if ((Math.random() > 0.4)) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height, -4), 1, true));
        }
        if ((Math.random() > 0.4)) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(4, height, 3), 1, true));
        }
        if ((Math.random() > 0.4)) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(4, height, -3), 1, true));
        }
        if ((Math.random() > 0.4)) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-4, height, 3), 1, true));
        }
        if ((Math.random() > 0.4)) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-4, height, -3), 1, true));
        }
        if ((Math.random() > 0.4)) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 1, 5), 1, true));
        }
        if ((Math.random() > 0.4)) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 1, 5), 1, true));
        }
        if ((Math.random() > 0.4)) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 1, -5), 1, true));
        }
        if ((Math.random() > 0.4)) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 1, -5), 1, true));
        }
        if ((Math.random() > 0.4)) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(5, height + 1, 1), 1, true));
        }
        if ((Math.random() > 0.4)) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(5, height + 1, -1), 1, true));
        }
        if ((Math.random() > 0.4)) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-5, height + 1, 1), 1, true));
        }
        if ((Math.random() > 0.4)) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-5, height + 1, -1), 1, true));
        }

        return list;
    }

}
