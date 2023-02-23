package com.aechtrob.prehistoricnature.item;

import com.aechtrob.prehistoricnature.tag.*;
import net.minecraft.world.item.*;

public class GeologicPickItem extends DiggerItem {
    public GeologicPickItem(Tier tier, Properties properties) {
        super(1, 4, tier, PrehistoricNatureTags.MINALBE_WITH_GEOLOGICAL_PICK, properties);
    }
}
