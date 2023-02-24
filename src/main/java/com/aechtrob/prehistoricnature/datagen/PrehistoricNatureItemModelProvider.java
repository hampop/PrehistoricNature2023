package com.aechtrob.prehistoricnature.datagen;

import com.aechtrob.prehistoricnature.*;
import com.aechtrob.prehistoricnature.datagen.helpers.*;
import com.aechtrob.prehistoricnature.item.*;
import net.minecraft.data.*;
import net.minecraft.resources.*;
import net.minecraft.world.item.*;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.*;
import net.minecraftforge.registries.*;

public class PrehistoricNatureItemModelProvider extends ItemModelProvider {


    public PrehistoricNatureItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, PrehistoricNatureMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        ModelHelper.getItemModels().forEach((item,consumer)->{consumer.accept(this,item);});
        this.basicItem(PrehistoricNatureItems.GEOLOGIC_PICK.get());
    }

    public ItemModelBuilder basicItem(RegistryObject<Item> item) {
        return super.basicItem(item.get());
    }
}
