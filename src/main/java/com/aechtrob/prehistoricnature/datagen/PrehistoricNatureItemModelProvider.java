package com.aechtrob.prehistoricnature.datagen;

import com.aechtrob.prehistoricnature.*;
import com.aechtrob.prehistoricnature.item.*;
import net.minecraft.data.*;
import net.minecraft.resources.*;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.*;

public class PrehistoricNatureItemModelProvider extends ItemModelProvider {


    public PrehistoricNatureItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, PrehistoricNatureMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));
        withExistingParent("carboniferous_fossil", new ResourceLocation(PrehistoricNatureMod.MOD_ID, "block/carboniferous_fossil"));

        this.basicItem(PrehistoricNatureItems.GEOLOGIC_PICK.get());
        this.basicItem(PrehistoricNatureItems.CARBONIFEROUS_RAW_FOSSIL.get());
    }
}
