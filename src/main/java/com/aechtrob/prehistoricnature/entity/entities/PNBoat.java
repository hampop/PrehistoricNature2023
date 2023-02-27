//package com.aechtrob.prehistoricnature.entity.entities;
//
//import com.aechtrob.prehistoricnature.block.trees.lepidodendron.*;
//import net.minecraft.nbt.*;
//import net.minecraft.network.protocol.*;
//import net.minecraft.network.protocol.game.*;
//import net.minecraft.network.syncher.*;
//import net.minecraft.world.entity.*;
//import net.minecraft.world.entity.vehicle.*;
//import net.minecraft.world.item.*;
//import net.minecraft.world.level.*;
//import net.minecraft.world.level.block.*;
//import net.minecraftforge.network.*;
//
//public class PNBoat extends Boat {
//    private static final EntityDataAccessor<Integer> BOAT_TYPE = SynchedEntityData.defineId(PNBoat.class, EntityDataSerializers.INT);
//
//    public PNBoat(EntityType<? extends Boat> p_38290_, Level p_38291_) {
//        super(p_38290_, p_38291_);
//    }
//
//    public PNBoat(Level level, double x, double y, double z) {
//        this(PNEntities.BOAT.get(), level);
//        this.setPos(x, y, z);
//        this.xo = x;
//        this.yo = y;
//        this.zo = z;
//    }
//
//    public PNBoat.Type getTwilightBoatType() {
//        return PNBoat.Type.byId(this.getEntityData().get(BOAT_TYPE));
//    }
//
//    @Override
//    public Item getDropItem() {
//        return switch (this.getTwilightBoatType()) {
//            case LEPIDODENDRON -> ItemsTreeLepidodendron.LEPIDODENDRON_BOAT_ITEM.get();
//        };
//    }
//
//    public void setPNBoatType(PNBoat.Type boatType) {
//        this.getEntityData().set(BOAT_TYPE, boatType.ordinal());
//    }
//
//    @Override
//    protected void defineSynchedData() {
//        super.defineSynchedData();
//        this.getEntityData().define(BOAT_TYPE, Type.LEPIDODENDRON.ordinal());
//    }
//
//    @Override
//    protected void addAdditionalSaveData(CompoundTag tag) {
//        tag.putString("Type", this.getTwilightBoatType().getName());
//    }
//
//    @Override
//    protected void readAdditionalSaveData(CompoundTag tag) {
//        if (tag.contains("Type", 8)) {
//            this.setPNBoatType(PNBoat.Type.getTypeFromString(tag.getString("Type")));
//        }
//    }
//
//    @Override
//    public Packet<ClientGamePacketListener> getAddEntityPacket() {
//        return NetworkHooks.getEntitySpawningPacket(this);
//    }
////TODO add every woodtype thats added to the mod here
//    public enum Type {
//
//        LEPIDODENDRON(BlocksTreeLepidodendron.LEPIDODENDRON_PLANKS.get(),BlocksTreeLepidodendron.treeName);
//
//        private final String name;
//        private final Block block;
//
//        Type(Block block, String name) {
//            this.name = name;
//            this.block = block;
//        }
//
//        public String getName() {
//            return this.name;
//        }
//
//        public Block asPlank() {
//            return this.block;
//        }
//
//        public String toString() {
//            return this.name;
//        }
//
//        public static PNBoat.Type byId(int id) {
//            PNBoat.Type[] types = values();
//            if (id < 0 || id >= types.length) {
//                id = 0;
//            }
//
//            return types[id];
//        }
//
//        public static PNBoat.Type getTypeFromString(String nameIn) {
//            PNBoat.Type[] types = values();
//
//            for (Type type : types) {
//                if (type.getName().equals(nameIn)) {
//                    return type;
//                }
//            }
//
//            return types[0];
//        }
//    }
//}
