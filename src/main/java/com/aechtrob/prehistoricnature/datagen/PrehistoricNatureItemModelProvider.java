package com.aechtrob.prehistoricnature.datagen;

import com.aechtrob.prehistoricnature.PrehistoricNatureMod;
import com.aechtrob.prehistoricnature.datagen.helpers.ModelHelper;
import com.aechtrob.prehistoricnature.item.PrehistoricNatureItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.loaders.ItemLayersModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

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

    public ItemModelBuilder slab(String name, ResourceLocation material) {
        return super.slab(name, material, material, material);
    }

    private ItemModelBuilder generated(String name, ResourceLocation... layers) {
        return buildItem(name, "item/generated", 0, layers);
    }

    private ItemModelBuilder buildItem(String name, String parent, int emissivity, ResourceLocation... layers) {
        ItemModelBuilder builder = withExistingParent(name, parent);
        for (int i = 0; i < layers.length; i++) {
            builder = builder.texture("layer" + i, layers[i]);
        }
        if (emissivity > 0) builder = builder.customLoader(ItemLayersModelBuilder::begin).emissive(emissivity, emissivity, 0).renderType("forge_entity_unsorted_translucent", 0).end();
        return builder;
    }
}
