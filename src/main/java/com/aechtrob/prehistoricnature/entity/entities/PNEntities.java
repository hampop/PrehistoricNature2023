package com.aechtrob.prehistoricnature.entity.entities;

import com.aechtrob.prehistoricnature.PrehistoricNatureMod;
import com.aechtrob.prehistoricnature.entity.renderers.PNBoatRenderer;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.aechtrob.prehistoricnature.PrehistoricNatureMod.MOD_ID;

@Mod.EventBusSubscriber(modid = PrehistoricNatureMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PNEntities {

    public static void register(IEventBus eventBus){
        ENTITIES.register(eventBus);
    }

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MOD_ID);

    public static final RegistryObject<EntityType<PNBoat>> BOAT = buildNoEgg(new ResourceLocation(MOD_ID,"boat"), makeCastedBuilder(PNBoat.class, PNBoat::new, 1.375F, 0.5625F, 10, 3), false);

    public static final RegistryObject<EntityType<PNChestBoat>> CHEST_BOAT = buildNoEgg(new ResourceLocation(MOD_ID,"chest_boat"), makeCastedBuilder(PNChestBoat.class, PNChestBoat::new, 1.375F, 0.5625F, 10, 3), false);


//    @SubscribeEvent
//    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event){
//        event.registerBlockEntityRenderer(PNEntities.BOAT.get(), m -> new PNBoat());
//    }

    @OnlyIn(Dist.CLIENT)
    public static void registerEntityRenders(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(PNEntities.BOAT.get(), m -> new PNBoatRenderer(m, false));
        event.registerEntityRenderer(PNEntities.CHEST_BOAT.get(), m -> new PNBoatRenderer(m, true));
    }

    @OnlyIn(Dist.CLIENT)
    public static void registerEntityLayers(final EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(PNBoatRenderer.BOAT_LOCATION, () -> BoatModel.createBodyModel());
        event.registerLayerDefinition(PNBoatRenderer.CHEST_BOAT_LOCATION, () -> ChestBoatModel.createBodyModel());
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
