package com.aechtrob.prehistoricnature.datagen;

import com.aechtrob.prehistoricnature.*;
import com.aechtrob.prehistoricnature.block.*;
import com.aechtrob.prehistoricnature.datagen.helpers.*;
import net.minecraft.data.*;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.*;

public class PrehistoricNatureBlockStateProvider extends BlockStateProvider {
    public PrehistoricNatureBlockStateProvider(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
        super(packOutput, PrehistoricNatureMod.MOD_ID, existingFileHelper);
    }
    @Override
    protected void registerStatesAndModels() {
        ModelHelper.getBlockModels().forEach((block, consumer)->{consumer.accept(block);});
        //simpleBlock(FossilBlocks.CARBONIFEROUS_FOSSIL.get());
    }
}
