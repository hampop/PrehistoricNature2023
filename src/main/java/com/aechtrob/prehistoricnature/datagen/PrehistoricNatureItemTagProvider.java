package com.aechtrob.prehistoricnature.datagen;

import com.aechtrob.prehistoricnature.*;
import com.aechtrob.prehistoricnature.datagen.helpers.*;
import net.minecraft.core.*;
import net.minecraft.data.*;
import net.minecraft.data.tags.*;
import net.minecraft.world.level.block.*;
import net.minecraftforge.common.data.*;

import java.util.concurrent.*;

public class PrehistoricNatureItemTagProvider extends ItemTagsProvider {
    public PrehistoricNatureItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookUp, TagsProvider<Block> blockTagsProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookUp, blockTagsProvider, PrehistoricNatureMod.MOD_ID,existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider p_256380_) {
        TagHelper.getItemTags().forEach((item, tagkey) -> tag(tagkey).add(item.get()));
    }
}
