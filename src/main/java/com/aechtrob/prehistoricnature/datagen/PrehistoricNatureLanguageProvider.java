package com.aechtrob.prehistoricnature.datagen;

import com.aechtrob.prehistoricnature.*;
import com.aechtrob.prehistoricnature.datagen.helpers.*;
import com.aechtrob.prehistoricnature.item.*;
import net.minecraft.data.*;
import net.minecraftforge.common.data.*;

public class PrehistoricNatureLanguageProvider extends LanguageProvider {


    public PrehistoricNatureLanguageProvider(PackOutput output, String locale) {
        super(output, PrehistoricNatureMod.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        LanguageHelper.getBlockLanguage().forEach((block,translation)->{this.addBlock(block,translation);});
        LanguageHelper.getItemLanguage().forEach((item,translation)->{this.addItem(item, translation);});
        LanguageHelper.getTranslatableLanguage().forEach((object,translation)->{this.add(object,translation);});
        this.addItem(PrehistoricNatureItems.GEOLOGIC_PICK, "Geologic Pick");
    }
}
