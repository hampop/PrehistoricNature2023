package com.aechtrob.prehistoricnature.entity.block;

import com.aechtrob.prehistoricnature.entity.block.blocks.*;

import com.aechtrob.prehistoricnature.PrehistoricNatureMod;
import com.aechtrob.prehistoricnature.block.trees.TreeBlockRegistration;
import com.aechtrob.prehistoricnature.block.trees.lepidodendron.EntitiesTreeLepidodendron;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;

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

    public static final RegistryObject<BlockEntityType<PNSignBlockEntity>> PN_SIGN = ENTITY_TYPE_REGISTER.register("pn_sign",
            () -> BlockEntityType.Builder.of(PNSignBlockEntity::new, registryToArray(TreeBlockRegistration.prehistoricNatureSigns))
                    .build(null));

    @OnlyIn(Dist.CLIENT)
    public static void registerTileEntityRenders(EntityRenderersEvent.RegisterRenderers event){
        event.registerBlockEntityRenderer(PN_SIGN.get(),SignRenderer::new);
    }

    private static Block[] registryToArray(ArrayList<RegistryObject<Block>> registryObjects){
        ArrayList<Block> array = new ArrayList<>();
        registryObjects.stream().forEach(reg->array.add(reg.get()));
        return array.toArray(Block[]::new);
    }
}
