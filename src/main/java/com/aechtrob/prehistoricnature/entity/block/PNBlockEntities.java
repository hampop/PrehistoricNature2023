package com.aechtrob.prehistoricnature.entity.block;

import com.aechtrob.prehistoricnature.*;
import com.aechtrob.prehistoricnature.block.trees.lepidodendron.*;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.core.registries.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.registries.*;

import java.util.*;

public class PNBlockEntities {
    public static void register(IEventBus eventBus){
        EntitiesTreeLepidodendron.register();
        BLOCK_ENTITY_REGISTER.register(eventBus);
        ENTITY_TYPE_REGISTER.register(eventBus);
    }

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_REGISTER =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, PrehistoricNatureMod.MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> ENTITY_TYPE_REGISTER =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, PrehistoricNatureMod.MOD_ID);

    private static Block[] signs;
    public static final RegistryObject<BlockEntityType<PNSignBlockEntity>> PN_SIGN = ENTITY_TYPE_REGISTER.register("pn_sign",
            () -> BlockEntityType.Builder.of(PNSignBlockEntity::new,
           BlocksTreeLepidodendron.LEPIDODENDRON_SIGN.get()).build(null));

    // () -> BlockEntityType.Builder.of(PNSignBlockEntity::new, signs = registryToArray(TreeBlockRegistration.prehistoricNatureSigns))
    //                    .build(null)
    @OnlyIn(Dist.CLIENT)
    public static void registerTileEntityRenders(){
        BlockEntityRenderers.register(PN_SIGN.get(),SignRenderer::new);
    }

    private static Block[] registryToArray(ArrayList<RegistryObject<Block>> registryObjects){
        ArrayList<Block> array = new ArrayList<>();
        registryObjects.stream().forEach(reg->array.add(reg.get()));
        return array.toArray(Block[]::new);
    }
}
