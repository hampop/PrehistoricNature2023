package com.aechtrob.prehistoricnature.world.tree.lepidodendron;

import com.aechtrob.prehistoricnature.block.blocks.PNRotatedPillarFlammableBlock;
import com.aechtrob.prehistoricnature.block.trees.lepidodendron.BlocksTreeLepidodendron;
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

import java.util.*;
import java.util.function.*;

public class LepidodendronTrunkPlacer extends TrunkPlacer {

    private LevelSimulatedReader levelSimulatedReader;
    private BiConsumer<BlockPos, BlockState> biConsumer;
    private RandomSource randomSource;
    private BlockPos pos;
    private TreeConfiguration treeConfiguration;
    
    
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
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader levelSimulatedReader, BiConsumer<BlockPos, BlockState> biConsumer, 
                                                            RandomSource random, int p_161871_, BlockPos pos, TreeConfiguration treeConfiguration) {
        this.levelSimulatedReader = levelSimulatedReader;
        this.biConsumer = biConsumer;
        this.randomSource = random;
        this.pos = pos;
        this.treeConfiguration = treeConfiguration;
        List<FoliagePlacer.FoliageAttachment> list = Lists.newArrayList();

        int height = 0;
        BlockState logState = BlocksTreeLepidodendron.LEPIDODENDRON_LOG.get().defaultBlockState().setValue(PNRotatedPillarFlammableBlock.AXIS,Direction.Axis.Y);
        BlockState woodState = BlocksTreeLepidodendron.LEPIDODENDRON_WOOD.get().defaultBlockState().setValue(PNRotatedPillarFlammableBlock.AXIS,Direction.Axis.Y);

        List<Consumer<BlockPos>> placableBlocks = List.of(
                (blockPos) -> {}, //0 or x = Air
                (blockPos) -> {placeLog(blockPos, logState.setValue(PNRotatedPillarFlammableBlock.AXIS,Direction.Axis.X));}, //1
                (blockPos) -> {placeLog(blockPos, logState.setValue(PNRotatedPillarFlammableBlock.AXIS,Direction.Axis.Y));}, //2
                (blockPos) -> {placeLog(blockPos, logState.setValue(PNRotatedPillarFlammableBlock.AXIS,Direction.Axis.Z));}, //3
                (blockPos) -> {placeLog(blockPos, woodState.setValue(PNRotatedPillarFlammableBlock.AXIS,Direction.Axis.X));}, //4
                (blockPos) -> {placeLog(blockPos, woodState.setValue(PNRotatedPillarFlammableBlock.AXIS,Direction.Axis.Y));}, //5
                (blockPos) -> {placeLog(blockPos, woodState.setValue(PNRotatedPillarFlammableBlock.AXIS,Direction.Axis.Z));}, //6
                (blockPos) -> {placeFoliage(blockPos, 0, list);}, //7 = Leaves
                (blockPos) -> {placeRandomFoliage(blockPos, 0.4, 1, list);} //8 = Strobilus
        );
        int x = 0;

        //Wood:
        //stump

        int[][][] trunk ={
            {
                {x,x,2,x,x},
                {x,2,1,1,x},
                {2,1,1,1,2},
                {x,2,1,2,x},
                {x,x,2,x,x}
            }, {
                {x,x,x,x,x},
                {x,x,1,x,x},
                {x,1,1,1,x},
                {x,x,1,x,x},
                {x,x,x,x,x}
            }
        };

        int[][][] crown = {
                {
                        {x,x,x,x,x,x,4,x,x,x,x,x,x},
                        {x,x,x,x,x,x,x,x,x,x,x,x,x},
                        {x,x,x,4,x,x,x,x,x,4,x,x,x},
                        {x,x,4,x,x,x,x,x,x,x,4,x,x},
                        {x,x,x,x,x,x,x,x,x,x,x,x,x},
                        {x,x,x,x,x,x,x,x,x,x,x,x,x},
                        {4,x,x,x,x,x,1,x,x,x,x,x,4},
                        {x,x,x,x,x,x,x,x,x,x,x,x,x},
                        {x,x,x,x,x,x,x,x,x,x,x,x,x},
                        {x,x,4,x,x,x,x,x,x,x,4,x,x},
                        {x,x,x,4,x,x,x,x,x,4,x,x,x},
                        {x,x,x,x,x,x,x,x,x,x,x,x,x},
                        {x,x,x,x,x,x,4,x,x,x,x,x,x}
                },
                {
                        {x,x,x,x,x,x,3,x,x,x,x,x,x},
                        {x,x,x,x,x,x,x,x,x,x,x,x,x},
                        {x,x,x,3,x,x,x,x,x,3,x,x,x},
                        {x,x,3,x,x,x,3,x,x,x,3,x,x},
                        {x,x,x,x,x,x,x,x,x,x,x,x,x},
                        {x,x,x,x,x,x,x,x,x,x,x,x,x},
                        {3,x,x,3,x,x,1,x,x,3,x,x,3},
                        {x,x,x,x,x,x,x,x,x,x,x,x,x},
                        {x,x,x,x,x,x,x,x,x,x,x,x,x},
                        {x,x,3,x,x,x,3,x,x,x,3,x,x},
                        {x,x,x,3,x,x,x,x,x,3,x,x,x},
                        {x,x,x,x,x,x,x,x,x,x,x,x,x},
                        {x,x,x,x,x,x,3,x,x,x,x,x,x}
                },
                {
                        {x,x,x,x,x,x,3,x,x,x,x,x,x},
                        {x,x,x,x,x,3,3,3,x,x,x,x,x},
                        {x,x,x,3,3,3,2,3,3,3,x,x,x},
                        {x,x,3,x,x,3,6,3,x,x,3,x,x},
                        {x,x,3,x,x,x,6,x,x,x,3,x,x},
                        {x,3,3,3,x,3,6,3,x,3,3,3,x},
                        {3,3,2,5,5,5,1,5,5,5,2,3,3},
                        {x,3,3,3,x,3,6,3,x,3,3,3,x},
                        {x,x,3,x,x,x,6,x,x,x,3,x,x},
                        {x,x,3,x,x,3,6,3,x,x,3,x,x},
                        {x,x,x,3,3,3,2,3,3,3,x,x,x},
                        {x,x,x,x,x,3,3,3,x,x,x,x,x},
                        {x,x,x,x,x,x,3,x,x,x,x,x,x}
                },
                {
                        {x,x,x,x,x,x,x,x,x,x,x,x,x},
                        {x,x,x,x,x,x,x,x,x,x,x,x,x},
                        {x,x,x,x,x,x,x,x,x,x,x,x,x},
                        {x,x,x,3,3,3,x,3,3,3,x,x,x},
                        {x,x,x,3,1,3,3,3,1,3,x,x,x},
                        {x,x,x,3,3,1,3,1,3,3,x,x,x},
                        {x,x,x,x,3,3,1,3,3,x,x,x,x},
                        {x,x,x,3,3,1,3,1,3,3,x,x,x},
                        {x,x,x,3,1,3,3,3,1,3,x,x,x},
                        {x,x,x,3,3,3,x,3,3,3,x,x,x},
                        {x,x,x,x,x,x,x,x,x,x,x,x,x},
                        {x,x,x,x,x,x,x,x,x,x,x,x,x},
                        {x,x,x,x,x,x,x,x,x,x,x,x,x}
                },
                {
                        {x,x,x,x,x,x,x,x,x,x,x,x,x},
                        {x,x,x,x,x,x,x,x,x,x,x,x,x},
                        {x,x,x,x,x,x,x,x,x,x,x,x,x},
                        {x,x,x,x,x,x,x,x,x,x,x,x,x},
                        {x,x,x,x,3,x,x,x,3,x,x,x,x},
                        {x,x,x,x,x,x,3,x,x,x,x,x,x},
                        {x,x,x,x,x,3,1,3,x,x,x,x,x},
                        {x,x,x,x,x,x,3,x,x,x,x,x,x},
                        {x,x,x,x,3,x,x,x,3,x,x,x,x},
                        {x,x,x,x,x,x,x,x,x,x,x,x,x},
                        {x,x,x,x,x,x,x,x,x,x,x,x,x},
                        {x,x,x,x,x,x,x,x,x,x,x,x,x},
                        {x,x,x,x,x,x,x,x,x,x,x,x,x}
                },
                {
                        {x,x,x,x,x,x,x,x,x,x,x,x,x},
                        {x,x,x,x,x,x,x,x,x,x,x,x,x},
                        {x,x,x,x,x,x,x,x,x,x,x,x,x},
                        {x,x,x,x,x,x,x,x,x,x,x,x,x},
                        {x,x,x,x,x,x,3,x,x,x,x,x,x},
                        {x,x,x,x,x,3,6,3,x,x,x,x,x},
                        {x,x,x,x,3,5,1,5,3,x,x,x,x},
                        {x,x,x,x,x,3,6,3,x,x,x,x,x},
                        {x,x,x,x,x,x,3,x,x,x,x,x,x},
                        {x,x,x,x,x,x,x,x,x,x,x,x,x},
                        {x,x,x,x,x,x,x,x,x,x,x,x,x},
                        {x,x,x,x,x,x,x,x,x,x,x,x,x},
                        {x,x,x,x,x,x,x,x,x,x,x,x,x}
                },
                {
                        {x,x,x,x,x,x,x,x,x,x,x,x,x},
                        {x,x,x,x,x,x,x,x,x,x,x,x,x},
                        {x,x,x,x,x,x,x,x,x,x,x,x,x},
                        {x,x,x,x,x,x,x,x,x,x,x,x,x},
                        {x,x,x,x,x,x,x,x,x,x,x,x,x},
                        {x,x,x,x,x,x,3,x,x,x,x,x,x},
                        {x,x,x,x,x,3,2,3,x,x,x,x,x},
                        {x,x,x,x,x,x,3,x,x,x,x,x,x},
                        {x,x,x,x,x,x,x,x,x,x,x,x,x},
                        {x,x,x,x,x,x,x,x,x,x,x,x,x},
                        {x,x,x,x,x,x,x,x,x,x,x,x,x},
                        {x,x,x,x,x,x,x,x,x,x,x,x,x},
                        {x,x,x,x,x,x,x,x,x,x,x,x,x}
                }
        };

        int finalHeight = height;
        height = placeTreeSegment(trunk, height, placableBlocks);
        //trunk
        height = placeTrunk(pos, logState, height);
        //crown
        placeTreeSegment(crown, height, placableBlocks);
        //trunk
        height = placeTrunk(pos, logState, height);
        //crown
        placeTreeSegment(crown, height, placableBlocks);
        return list;
    }

    private void placeLog(BlockPos pos, BlockState logState) {
        if (PNTreeFeature.canLogReplaceBlock(levelSimulatedReader, pos)) {
            biConsumer.accept(pos, logState);
            placeLog(levelSimulatedReader, biConsumer, randomSource, pos, treeConfiguration);
        }
    }

    public int placeTrunk(BlockPos pos, BlockState logState, int height){
        height += (int) ((18D) + Math.round((Math.random() * 10D) / 2D) + Math.round((Math.random() * 10D) / 2D)
                + Math.round((Math.random() * 10D) / 2D));
        int counter = 1;
        while (counter <= height) {
            placeLog(pos.above(1 + counter), logState);
            counter += 1;
        }
        return height;
    }

    public void placeRandomFoliage(BlockPos pos, double odds, int foliageId, List<FoliagePlacer.FoliageAttachment> list){
        if ((Math.random() > odds)) {
            list.add(new FoliagePlacer.FoliageAttachment(pos, foliageId, true));
        }
    }

    public void placeFoliage(BlockPos pos, int foliageId, List<FoliagePlacer.FoliageAttachment> list){
        list.add(new FoliagePlacer.FoliageAttachment(pos, foliageId, true));
    }

    public int placeTreeSegment(int[][][] segment, int height, List<Consumer<BlockPos>> blockPlacingConsumer){
        for (int layer = 0; layer < segment.length; layer++) {
            for (int row = 0; row < segment[layer].length; row++) {
                for (int block = 0; block < segment[layer][row].length; block++) {
                    int middleV = Math.round(segment[layer].length / 2);
                    int middleH = Math.round(segment[layer][row].length / 2);
                    int distanceV = block - middleV;
                    int distanceH = row - middleH;
                    blockPlacingConsumer.get(segment[layer][row][block]).accept(pos.offset(distanceH, height, distanceV));
                }
            }
            height++;
        }
        return height;
    }
}



//        placeLog(pos, logState);
//        placeLog(pos.above(), logState);
//        placeLog(pos.south(), logState);
//        placeLog(pos.south(2), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.Z));
//        placeLog(pos.north(), logState);
//        placeLog(pos.north(2), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.Z));
//        placeLog(pos.east(), logState);
//        placeLog(pos.east(2), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.X));
//        placeLog(pos.west(), logState);
//        placeLog(pos.west(2), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.X));
//        placeLog(pos.east().above(), woodState);
//        placeLog(pos.west().above(), woodState);
//        placeLog(pos.south().above(), woodState);
//        placeLog(pos.north().above(), woodState);
//
//        height = placeTrunk(pos, logState, height);
//
//        //crown
//        placeLog(pos.offset(0, height + 1, 0), logState);
//        placeLog(pos.offset(0, height + 2, 0), logState);
//        placeLog(pos.offset(0, height + 3, 0), logState);
//        placeLog(pos.offset(0, height + 4, 0), logState);
//        placeLog(pos.offset(0, height + 5, 0), logState);
//        placeLog(pos.offset(0, height + 6, 0), woodState);
//        placeLog(pos.offset(0, height + 2, 1), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.Z));
//        placeLog(pos.offset(0, height + 2, 2), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.Z));
//        placeLog(pos.offset(0, height + 2, 3), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.Z));
//        placeLog(pos.offset(0, height + 2, 4), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.Z));
//        placeLog(pos.offset(0, height + 2, -1), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.Z));
//        placeLog(pos.offset(0, height + 2, -2), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.Z));
//        placeLog(pos.offset(0, height + 2, -3), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.Z));
//        placeLog(pos.offset(0, height + 2, -4), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.Z));
//        placeLog(pos.offset(1, height + 2, 0), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.X));
//        placeLog(pos.offset(2, height + 2, 0), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.X));
//        placeLog(pos.offset(3, height + 2, 0), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.X));
//        placeLog(pos.offset(4, height + 2, 0), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.X));
//        placeLog(pos.offset(-1, height + 2, 0), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.X));
//        placeLog(pos.offset(-2, height + 2, 0), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.X));
//        placeLog(pos.offset(-3, height + 2, 0), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.X));
//        placeLog(pos.offset(-4, height + 2, 0), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.X));
//        placeLog(pos.offset(1, height + 3, 1), woodState);
//        placeLog(pos.offset(-1, height + 3, 1), woodState);
//        placeLog(pos.offset(-1, height + 3, -1), woodState);
//        placeLog(pos.offset(1, height + 3, -1), woodState);
//        placeLog(pos.offset(-2, height + 3, -2), woodState);
//        placeLog(pos.offset(2, height + 3, -2), woodState);
//        placeLog(pos.offset(2, height + 3, 2), woodState);
//        placeLog(pos.offset(-2, height + 3, 2), woodState);
//        placeLog(pos.offset(1, height + 5, 0), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.X));
//        placeLog(pos.offset(-1, height + 5, 0), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.X));
//        placeLog(pos.offset(0, height + 5, 1), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.Z));
//        placeLog(pos.offset(0, height + 5, -1), logState.setValue(PNRotatedPillarFlammableBlock.AXIS, Direction.Axis.Z));
//
//        //Leaves:
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + 1, 0), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(6, height + 1, 0), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + 1, 0), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-6, height + 1, 0), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 1, 3), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 1, 6), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 1, -3), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 1, -6), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + 1, 4), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + 1, -4), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + 1, 4), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + 1, -4), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(4, height + 1, 3), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(4, height + 1, -3), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-4, height + 1, 3), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-4, height + 1, -3), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 2, 5), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 2, 6), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 3, -2), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 3, 2), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + 3, 0), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + 3, 0), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 3, -3), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 3, 3), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 3, -3), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 3, 3), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + 3, 1), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + 3, -1), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + 3, 1), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + 3, -1), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 2, -5), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 2, -6), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(5, height + 2, 0), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(6, height + 2, 0), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-5, height + 2, 0), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-6, height + 2, 0), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 2, 3), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 2, 4), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 2, 5), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 2, 3), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 2, 4), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 2, 5), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 2, -3), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 2, -4), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 2, -5), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 2, -3), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 2, -4), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 2, -5), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + 2, 1), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(4, height + 2, 1), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(5, height + 2, 1), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + 2, -1), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(4, height + 2, -1), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(5, height + 2, -1), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + 2, 1), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-4, height + 2, 1), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-5, height + 2, 1), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + 2, -1), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-4, height + 2, -1), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-5, height + 2, -1), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 2, 1), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 2, -1), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 2, 1), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 2, -1), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + 2, 4), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + 2, 4), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + 2, 4), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + 2, 4), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + 2, -4), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + 2, -4), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + 2, -4), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + 2, -4), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(4, height + 2, 2), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(4, height + 2, 3), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(4, height + 2, -2), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(4, height + 2, -3), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-4, height + 2, 2), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-4, height + 2, 3), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-4, height + 2, -2), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-4, height + 2, -3), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + 3, 3), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + 3, 3), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + 3, 3), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + 3, 3), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + 3, 2), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 3, 2), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 3, 2), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + 3, 2), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + 3, 1), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 3, 1), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + 3, 1), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 3, 0), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 3, 0), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + 3, -1), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 3, -1), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + 3, -1), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + 3, -2), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 3, -2), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 3, -2), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + 3, -2), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(3, height + 3, -3), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + 3, -3), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-3, height + 3, -3), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + 3, -3), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + 4, 2), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + 4, 2), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + 4, -2), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + 4, -2), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 4, 0), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 4, 0), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 4, 1), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 4, -1), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(2, height + 5, 0), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 5, 1), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 5, -1), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 5, 2), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 5, -2), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 5, 1), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 5, -1), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-2, height + 5, 0), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 6, 0), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(1, height + 6, 0), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(-1, height + 6, 0), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 6, 1), 0, true));
//        list.add(new FoliagePlacer.FoliageAttachment(pos.offset(0, height + 6, -1), 0, true));
//
//        //Strobili:
//        placeRandomFoliage(pos.offset(6, height, 0),0.4, 1, list);
//        placeRandomFoliage(pos.offset(-6, height, 0),0.4, 1, list);
//        placeRandomFoliage(pos.offset(0, height, 6),0.4, 1, list);
//        placeRandomFoliage(pos.offset(0, height, -6),0.4,1, list);
//        placeRandomFoliage(pos.offset(3, height, 4),0.4, 1, list);
//        placeRandomFoliage(pos.offset(3, height, -4),0.4, 1, list);
//        placeRandomFoliage(pos.offset(-3, height, 4),0.4, 1, list);
//        placeRandomFoliage(pos.offset(-3, height, -4),0.4, 1, list);
//        placeRandomFoliage(pos.offset(4, height, 3),0.4, 1, list);
//        placeRandomFoliage(pos.offset(4, height, -3),0.4, 1, list);
//        placeRandomFoliage(pos.offset(-4, height, 3),0.4, 1, list);
//        placeRandomFoliage(pos.offset(-4, height, -3),0.4, 1, list);
//        placeRandomFoliage(pos.offset(1, height + 1, 5),0.4, 1, list);
//        placeRandomFoliage(pos.offset(-1, height + 1, 5),0.4, 1, list);
//        placeRandomFoliage(pos.offset(1, height + 1, -5),0.4, 1, list);
//        placeRandomFoliage(pos.offset(-1, height + 1, -5),0.4, 1, list);
//        placeRandomFoliage(pos.offset(5, height + 1, 1),0.4, 1, list);
//        placeRandomFoliage(pos.offset(5, height + 1, -1),0.4, 1, list);
//        placeRandomFoliage(pos.offset(-5, height + 1, 1),0.4, 1, list);
//        placeRandomFoliage(pos.offset(-5, height + 1, -1),0.4, 1, list);

