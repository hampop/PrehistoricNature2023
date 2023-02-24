package com.aechtrob.prehistoricnature.datagen;

import com.aechtrob.prehistoricnature.*;
import com.aechtrob.prehistoricnature.block.*;
import com.aechtrob.prehistoricnature.block.trees.lepidodendron.*;
import com.aechtrob.prehistoricnature.datagen.helpers.*;
import com.ibm.icu.impl.*;
import net.minecraft.core.*;
import net.minecraft.data.*;
import net.minecraft.resources.*;
import net.minecraft.server.packs.repository.*;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.*;
import net.minecraftforge.registries.*;

public class PrehistoricNatureBlockStateProvider extends BlockStateProvider {

    public PrehistoricNatureBlockStateProvider(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
        super(packOutput, PrehistoricNatureMod.MOD_ID, existingFileHelper);
    }
    @Override
    protected void registerStatesAndModels() {
        ModelHelper.getBlockModels().forEach((block, consumer)->{consumer.accept(this,block);});
        //simpleBlock(FossilBlocks.CARBONIFEROUS_FOSSIL.get());
    }

    public void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    public void stairsBlock(RegistryObject<Block> stairs, RegistryObject<Block> block){
        super.stairsBlock((StairBlock) stairs.get(), blockTexture(block.get()));
    }
    public void simpleBlock(RegistryObject<Block> block) {
        super.simpleBlock(block.get());
    }

    public void axisBlock(RegistryObject<Block> block) {
        super.axisBlock((RotatedPillarBlock) block.get());
    }

    public void logBlock(RegistryObject<Block> block) {
        super.logBlock((RotatedPillarBlock) block.get());
    }

    public void slabBlock(RegistryObject<Block> slab, RegistryObject<Block> block) {
        super.slabBlock((SlabBlock) slab.get(),
                models().slab(ForgeRegistries.BLOCKS.getKey(slab.get()).getPath(),
                        blockTexture(block.get()),blockTexture(block.get()),blockTexture(block.get())),
                models().slabTop(ForgeRegistries.BLOCKS.getKey(slab.get()).getPath(),
                        blockTexture(block.get()),blockTexture(block.get()),blockTexture(block.get())),
                models().cube(ForgeRegistries.BLOCKS.getKey(slab.get()).getPath(),
                        blockTexture(block.get()),blockTexture(block.get()),blockTexture(block.get()),blockTexture(block.get()),blockTexture(block.get()),blockTexture(block.get())));
    }

    public void fenceBlock(RegistryObject<Block> fence, RegistryObject<Block> block) {
        super.fenceBlock((FenceBlock) fence.get(), blockTexture(block.get()));
    }

//    public void strobilusBlock(RegistryObject<Block> strobilus){
//        getVariantBuilder((LepidodendronStrobilus)strobilus.get()).forAllStatesExcept(state -> {
//            Direction facing = state.getValue(LepidodendronStrobilus.FACING);
//            int yRot =0;
//            int xRot =0;
//            if(facing == Direction.NORTH){
//                xRot = 90;
//            } else if(facing == Direction.EAST){
//                xRot = yRot = 90;
//            } else if(facing == Direction.SOUTH){
//                xRot = 90;
//                yRot = 180;
//            } else if(facing == Direction.WEST){
//                xRot = 90;
//                yRot = 270;
//            } else if(facing == Direction.DOWN){
//                xRot = 180;
//            }
//            return ConfiguredModel
//                    .builder()
//                    .rotationX(xRot)
//                    .rotationY(yRot)
//                    .build();
//        }).partialState().setModels( new ConfiguredModel(models().cross(ForgeRegistries.BLOCKS.getKey(strobilus.get()).getPath(), blockTexture(strobilus.get())).renderType("cutout")));
//    }
}
