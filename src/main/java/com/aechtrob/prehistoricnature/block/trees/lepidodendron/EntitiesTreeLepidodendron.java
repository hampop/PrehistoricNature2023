package com.aechtrob.prehistoricnature.block.trees.lepidodendron;

import com.aechtrob.prehistoricnature.entity.block.*;
import com.aechtrob.prehistoricnature.entity.entities.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraftforge.registries.*;

import static com.aechtrob.prehistoricnature.entity.block.PNBlockEntities.BLOCK_ENTITY_REGISTER;

public class EntitiesTreeLepidodendron {

    public static void register(){

    }
    public static final RegistryObject<BlockEntityType<PNSignBlockEntity>> LEPIDODENDRON_SIGN_BLOCK_ENTITIES =
            BLOCK_ENTITY_REGISTER.register("lepidodendron_sign_block_entity", ()->
                    BlockEntityType.Builder.of(PNSignBlockEntity::new,BlocksTreeLepidodendron.LEPIDODENDRON_WALL_SIGN.get(),
                            BlocksTreeLepidodendron.LEPIDODENDRON_SIGN.get()).build(null));

}
