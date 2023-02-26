package com.aechtrob.prehistoricnature.entity.block;

import com.aechtrob.prehistoricnature.block.trees.lepidodendron.*;
import net.minecraft.core.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;

public class PNSignBlockEntity extends SignBlockEntity {
    public PNSignBlockEntity(BlockPos pos, BlockState state){
        super(pos, state);
    }

    @Override
    public BlockEntityType<?> getType(){
        return PNBlockEntities.PN_SIGN.get();
    }
}
