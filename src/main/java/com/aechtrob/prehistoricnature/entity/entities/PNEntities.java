package com.aechtrob.prehistoricnature.entity.entities;

import com.aechtrob.prehistoricnature.*;
import net.minecraft.resources.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.*;
import net.minecraftforge.client.event.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.registries.*;

import static com.aechtrob.prehistoricnature.PrehistoricNatureMod.MOD_ID;

public class PNEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MOD_ID);

    public static final RegistryObject<EntityType<PNBoat>> BOAT = buildNoEgg(new ResourceLocation(MOD_ID,"boat"), makeCastedBuilder(PNBoat.class, PNBoat::new, 1.375F, 0.5625F, 10, 3), false);

    public static final RegistryObject<EntityType<PNChestBoat>> CHEST_BOAT = buildNoEgg(new ResourceLocation(MOD_ID,"boat"), makeCastedBuilder(PNChestBoat.class, PNChestBoat::new, 1.375F, 0.5625F, 10, 3), false);





    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event){
        event.registerBlockEntityRenderer(PNEntities.BOAT.get(), m -> new Pn);
    }





    private static <E extends Entity> RegistryObject<EntityType<E>> buildNoEgg(ResourceLocation id, EntityType.Builder<E> builder, boolean fireproof) {
        if (fireproof) builder.fireImmune();
        return ENTITIES.register(id.getPath(), () -> builder.build(id.toString()));
    }

    private static <E extends Entity> EntityType.Builder<E> makeCastedBuilder(@SuppressWarnings("unused") Class<E> cast, EntityType.EntityFactory<E> factory, float width, float height, int range, int interval) {
        return makeBuilder(factory, MobCategory.MISC, width, height, range, interval);
    }

    private static <E extends Entity> EntityType.Builder<E> makeBuilder(EntityType.EntityFactory<E> factory, MobCategory classification, float width, float height, int range, int interval) {
        return EntityType.Builder.of(factory, classification).
                sized(width, height).
                setTrackingRange(range).
                setUpdateInterval(interval).
                setShouldReceiveVelocityUpdates(true);
    }
}
