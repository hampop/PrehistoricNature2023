package com.aechtrob.prehistoricnature.datagen;

import com.aechtrob.prehistoricnature.*;
import com.aechtrob.prehistoricnature.datagen.helpers.*;
import net.minecraft.core.*;
import net.minecraft.data.*;
import net.minecraftforge.common.data.*;
import org.jetbrains.annotations.*;

import java.util.concurrent.*;

public class LepidodendronBlockTagProvider extends BlockTagsProvider {

    public LepidodendronBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, PrehistoricNatureMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        TagHelper.getBlockTags().forEach(((block, tagKey) -> {tag(tagKey).add(block.get());}));
    }
}
