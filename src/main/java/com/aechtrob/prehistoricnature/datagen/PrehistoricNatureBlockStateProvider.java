package com.aechtrob.prehistoricnature.datagen;

import com.aechtrob.prehistoricnature.*;
import com.aechtrob.prehistoricnature.datagen.helpers.*;
import net.minecraft.core.*;
import net.minecraft.data.*;
import net.minecraft.resources.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.*;
import net.minecraftforge.event.level.*;
import net.minecraftforge.registries.*;

public class PrehistoricNatureBlockStateProvider extends BlockStateProvider {

    public PrehistoricNatureBlockStateProvider(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
        super(packOutput, PrehistoricNatureMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        ModelHelper.getBlockModels().forEach((block, consumer)->{consumer.accept(this,block);});
    }

    public void ladderBlock(RegistryObject<Block> ladder){
        horizontalBlock(ladder.get(),models().getBuilder(name(ladder.get()))
                .parent(new ModelFile.UncheckedModelFile("block/ladder")).texture("texture","block/"+ForgeRegistries.BLOCKS.getKey(ladder.get()).getPath()).renderType("cutout"));
    }

    public void pnTrapdoorBlock(RegistryObject<Block> block, String treeName) {
        ModelFile open = models().getBuilder(name(block.get())+"_open").parent(new ModelFile.UncheckedModelFile(new ResourceLocation(PrehistoricNatureMod.MOD_ID, "block/trapdoor_open")))
                .texture("texture","block/"+treeName+"_trapdoor").texture("planktexture","block/"+treeName+"_planks").texture("particle", "block/"+treeName+"_trapdoor");
        ModelFile top = models().getBuilder(name(block.get())+"_top").parent(new ModelFile.UncheckedModelFile(new ResourceLocation(PrehistoricNatureMod.MOD_ID, "block/trapdoor_top")))
                .texture("texture","block/"+treeName+"_trapdoor").texture("planktexture","block/"+treeName+"_planks").texture("particle", "block/"+treeName+"_trapdoor");
        ModelFile bottom = models().getBuilder(name(block.get())+"_bottom").parent(new ModelFile.UncheckedModelFile(new ResourceLocation(PrehistoricNatureMod.MOD_ID, "block/trapdoor_bottom")))
                .texture("texture","block/"+treeName+"_trapdoor").texture("planktexture","block/"+treeName+"_planks").texture("particle", "block/"+treeName+"_trapdoor");

        MultiPartBlockStateBuilder trapdoor = getMultipartBuilder(block.get());
        for (Direction d : Direction.Plane.HORIZONTAL) {
            int rotY = switch (d) {
                default -> 0;
                case EAST -> 90;
                case SOUTH -> 180;
                case WEST -> 270;
            };

            trapdoor.part().modelFile(bottom).rotationY(rotY).addModel()
                    .condition(TrapDoorBlock.FACING, d).condition(TrapDoorBlock.OPEN, false)
                    .condition(TrapDoorBlock.HALF, Half.BOTTOM);
            trapdoor.part().modelFile(top).rotationY(rotY).addModel()
                    .condition(TrapDoorBlock.FACING, d).condition(TrapDoorBlock.OPEN, false)
                    .condition(TrapDoorBlock.HALF, Half.TOP);
            trapdoor.part().modelFile(open).rotationY(rotY).addModel()
                    .condition(TrapDoorBlock.FACING, d).condition(TrapDoorBlock.OPEN, true)
                    .condition(TrapDoorBlock.HALF, Half.BOTTOM);
            trapdoor.part().modelFile(open).rotationY(rotY).addModel()
                    .condition(TrapDoorBlock.FACING, d).condition(TrapDoorBlock.OPEN, true)
                    .condition(TrapDoorBlock.HALF, Half.TOP).end();
        }
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

    public void fenceGateBlock(RegistryObject<Block> fenceGate, RegistryObject<Block> block) {
        super.fenceGateBlock((FenceGateBlock) fenceGate.get(), blockTexture(block.get()));
    }

    public void doorBlock(RegistryObject<Block> door) {
        super.doorBlock((DoorBlock) door.get(),
                new ResourceLocation(PrehistoricNatureMod.MOD_ID,"block/"+ForgeRegistries.BLOCKS.getKey(door.get()).getPath()+"_bottom"),
                new ResourceLocation(PrehistoricNatureMod.MOD_ID,"block/"+ForgeRegistries.BLOCKS.getKey(door.get()).getPath()+"_top"));
    }

    public void buttonBlock(RegistryObject<Block> button, RegistryObject<Block> block) {
        super.buttonBlock((ButtonBlock) button.get(), blockTexture(block.get()));
    }

    public void pressurePlateBlock(RegistryObject<Block> plate,RegistryObject<Block> block){
        super.pressurePlateBlock((PressurePlateBlock) plate.get(),blockTexture(block.get()));
    }

    public void signBlock(RegistryObject<Block> signBlock, RegistryObject<Block> wallSignBlock, ResourceLocation texture) {
        ModelFile sign = models().sign(ForgeRegistries.BLOCKS.getKey(signBlock.get()).getPath(),texture);
        signBlock((StandingSignBlock) signBlock.get(), (WallSignBlock) wallSignBlock.get(), sign);
    }

    public void builtinEntity(RegistryObject<Block> b, String particle) {
        super.simpleBlock(b.get(), models().getBuilder(name(b.get())).parent(new ModelFile.UncheckedModelFile("builtin/entity")).texture("particle",particle));
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
    protected ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }
    protected String name(Block block) {
        return key(block).getPath();
    }
}
