package com.aechtrob.prehistoricnature.blocks.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;

public class PNWoodenBenchBlock extends Block implements SimpleWaterloggedBlock, ITileEntityProvider {

    public static final DirectionProperty FACING = DirectionalBlock.FACING;
    public static final BooleanProperty LEFT = BooleanProperty.create("left");
    public static final BooleanProperty RIGHT = BooleanProperty.create("right");
    public static final IntegerProperty VARIANT = IntegerProperty.create("variant", 0, 15);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	public PNWoodenBenchBlock() {
        super(Material.WOOD, MapColor.WOOD);
        setHarvestLevel("axe", 1);
        setSoundType(SoundType.WOOD);
        setHardness(2F);
        setResistance(3F);
        setLightOpacity(0);
        setCreativeTab(null);
        setCreativeTab(TabLepidodendronBuilding.tab);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }
    
    @Override
    public void addCollisionBoxToList(BlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean isActualState) {

        if (!isActualState)
        {
            state = state.updateShape(worldIn, pos);
        }

        if (state.getValue(FACING) == Direction.WEST) {
            //Seat:
            //From 5-6 px tall
            addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0.4, 0.3125,  0 , 0.875, 0.375, 1));
            //Back-rest:
            addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0.875, 0.375, 0, 0.9375, 1, 1));
        }
        if (state.getValue(FACING) == Direction.EAST) {
            //Seat:
            //From 5-6 px tall
            addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0.0625, 0.3125, 0, 0.625, 0.375, 1));
            //Back-rest:
            addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0.0625, 0.375, 0, 0.125, 1, 1));
        }

        if (state.getValue(FACING) == Direction.NORTH) {
            //Seat:
            //From 5-6 px tall
            addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0.0, 0.3125, 0.4, 1, 0.375, 0.875));
            //Back-rest:
            addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0, 0.375, 0.875, 1, 1, 0.9375));

        }
        if (state.getValue(FACING) == Direction.SOUTH) {
            //Seat:
            //From 5-6 px tall
            addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0.0, 0.3125, 0.0625, 1, 0.375, 0.625));
            //Back-rest:
            addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0, 0.375, 0.0625, 1, 1, 0.125));

        }
    }

    @Override
    public AxisAlignedBB getBoundingBox(BlockState state, IBlockAccess source, BlockPos pos) {
        return new AxisAlignedBB(0, 0.0, 0, 1, 1, 1);
    }


    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 20;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult blockHitResult) {
    if (!playerIn.capabilities.allowEdit)
        {
            return super.use(state, worldIn, pos, playerIn, hand, blockHitResult);
        }
        else if (hand == InteractionHand.MAIN_HAND) {
            int enumUsed = 0;
            if (playerIn.getItemInHand(hand).getItem() == Items.IRON_NUGGET) {
                enumUsed = 1;
            }
            else if (playerIn.getItemInHand(hand).getItem() == Items.GOLD_NUGGET) {
                enumUsed = 2;
            }
            else if (playerIn.getItemInHand(hand).getItem() == new ItemStack(ZirconItem.block, 1).getItem()) {
                enumUsed = 3;
            }
            else if (playerIn.getItemInHand(hand).getItem() == Items.EMERALD) {
                enumUsed = 4;
            }
            else if (playerIn.getItemInHand(hand).getItem() == Items.DIAMOND) {
                enumUsed = 5;
            }
            else if (playerIn.getItemInHand(hand).getItem() == new ItemStack(BalticAmberChunkItem.block, 1).getItem()) {
                enumUsed = 6;
            }
            else if (playerIn.getItemInHand(hand).getItem() == new ItemStack(DominicanAmberChunkItem.block, 1).getItem()) {
                enumUsed = 7;
            }
            else if (playerIn.getItemInHand(hand).getItem() == Items.QUARTZ) {
                enumUsed = 8;
            }
            else if (playerIn.getItemInHand(hand).getItem() == Items.LAPIS_LAZULI) {
                enumUsed = 9;
            }
            else if (playerIn.getItemInHand(hand).getItem() == Items.COAL) {
                enumUsed = 10;
            }
            else if (playerIn.getItemInHand(hand).getItem() == new ItemStack(AraucarioxylonLogPetrifiedItem.block, 1).getItem()){
                enumUsed = 11;
            }
            else if (playerIn.getItemInHand(hand).getItem() == new ItemStack(Blocks.REDSTONE_TORCH, 1).getItem()){
                enumUsed = 12;
            }
            else if (playerIn.getItemInHand(hand).getItem() == new ItemStack(AnthraciteItem.block, 1).getItem()) {
                enumUsed = 13;
            }
            else if (playerIn.getItemInHand(hand).getItem() == new ItemStack(SaltItem.block, 1).getItem()) {
                enumUsed = 14;
            }
            else if (playerIn.getItemInHand(hand).getItem() == new ItemStack(SulphurItem.block, 1).getItem()) {
                enumUsed = 15;
            }

            if (enumUsed > 0) {
                ItemStack itemstack = playerIn.getItemInHand(hand);
                if (!playerIn.isCreative()) {
                    itemstack.shrink(1);
                }
                Direction bsFacing = this.updateShape(state, worldIn, pos).getValue(FACING);
                boolean left = this.updateShape(state, worldIn, pos).getValue(LEFT);
                boolean right = this.updateShape(state, worldIn, pos).getValue(RIGHT);

                worldIn.setBlockState(pos, this.defaultBlockState().withProperty(FACING, bsFacing).withProperty(LEFT, left).withProperty(RIGHT, right).withProperty(VARIANT, enumUsed));
                TileEntity te = worldIn.getTileEntity(pos);
                if (te !=  null) {
                    if (te instanceof PNWoodenBenchBlock.TileEntityBench) {
                        te.getTileData().setInteger("variant", enumUsed);
                        worldIn.notifyBlockUpdate(pos, state, this.getActualState(state, worldIn, pos), 3);
                    }
                }
                return InteractionResult.SUCCESS;
            }
        }
        return super.use(state, worldIn, pos, playerIn, hand, blockHitResult);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction p_53383_, BlockState p_53384_, LevelAccessor worldIn, BlockPos p_53386_, BlockPos p_53387_) {
        Direction facing = state.getValue(FACING);
        if (facing == Direction.UP || facing == Direction.DOWN) {
            facing = Direction.NORTH;
        }

        //0. Wood base
        //1. Iron
        //2. Gold
        //3. Zircon
        //4. Emerald
        //5. Diamond
        //6. Baltic Amber
        //7. Dominican Amber
        //8. Quartz
        //9. Lapis
        //10. Coal
        //11. Petrified Wood
        //12. Redstone
        //13. Anthracite
        //14. Salt
        //15. Sulphur
        int variant = new Object() {
            public int getValue(BlockPos pos1, String tag) {
                TileEntity tileEntity = worldIn.getTileEntity(pos1);
                if (tileEntity != null)
                    return tileEntity.getTileData().getInteger(tag);
                return 0;
            }
        }.getValue(pos, "variant");

        boolean left = false;
        boolean right = false;
        if (state.getValue(FACING) == Direction.NORTH) {
            if (worldIn.getBlockState(pos.east()).getBlock() instanceof PNWoodenBenchBlock) {
                right = worldIn.getBlockState(pos.east()).getValue(FACING) == Direction.NORTH;
            }
            if (worldIn.getBlockState(pos.west()).getBlock() instanceof PNWoodenBenchBlock) {
                left = worldIn.getBlockState(pos.west()).getValue(FACING) == Direction.NORTH;
            }
        } else if (state.getValue(FACING) == Direction.SOUTH) {
            if (worldIn.getBlockState(pos.east()).getBlock() instanceof PNWoodenBenchBlock) {
                left = worldIn.getBlockState(pos.east()).getValue(FACING) == Direction.SOUTH;
            }
            if (worldIn.getBlockState(pos.west()).getBlock() instanceof PNWoodenBenchBlock) {
                right = worldIn.getBlockState(pos.west()).getValue(FACING) == Direction.SOUTH;
            }
        } else if (state.getValue(FACING) == Direction.WEST) {
            if (worldIn.getBlockState(pos.north()).getBlock() instanceof PNWoodenBenchBlock) {
                right = worldIn.getBlockState(pos.north()).getValue(FACING) == Direction.WEST;
            }
            if (worldIn.getBlockState(pos.south()).getBlock() instanceof PNWoodenBenchBlock) {
                left = worldIn.getBlockState(pos.south()).getValue(FACING) == Direction.WEST;
            }
        } else if (state.getValue(FACING) == Direction.EAST) {
            if (worldIn.getBlockState(pos.north()).getBlock() instanceof PNWoodenBenchBlock) {
                left = worldIn.getBlockState(pos.north()).getValue(FACING) == Direction.EAST;
            }
            if (worldIn.getBlockState(pos.south()).getBlock() instanceof PNWoodenBenchBlock) {
                right = worldIn.getBlockState(pos.south()).getValue(FACING) == Direction.EAST;
            }
        }
        return state.withProperty(VARIANT, variant).withProperty(FACING, facing).withProperty(LEFT, !left).withProperty(RIGHT, !right);
    }

    @Override
    public BlockState getStateForPlacement(World worldIn, BlockPos pos, Direction facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        //System.err.println("Placed by: " + placer);
        return this.defaultBlockState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    @Override
    public BlockState getStateFromMeta(int meta) {
        Direction enumfacing = Direction.byIndex(meta);

        if (enumfacing.getAxis() == Direction.Axis.Y) {
            enumfacing = Direction.NORTH;
        }

        return this.defaultBlockState().withProperty(FACING, enumfacing);
    }

    @Override
    public int getMetaFromState(BlockState state) {
        return ((Direction) state.getValue(FACING)).getIndex();
    }

    @Override
    public BlockState withRotation(BlockState state, Rotation rot) {
        return state.withProperty(FACING, rot.rotate(state.getValue(FACING)));
    }

    @SuppressWarnings("deprecation")
    @Override
    public BlockState withMirror(BlockState state, Mirror mirrorIn) {
        return state.withRotation(mirrorIn.toRotation(state.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateDef) {
        stateDef.add(FACING, LEFT, RIGHT, VARIANT, WATERLOGGED);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public boolean canRenderInLayer(BlockState state, BlockRenderLayer layer) {
        return layer == BlockRenderLayer.CUTOUT_MIPPED;
    }

    @Override
    public boolean doesSideBlockRendering(BlockState state, IBlockAccess world, BlockPos pos, Direction face) {
        return false;
    }

    @Override
    public boolean isFullBlock(BlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(BlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(BlockState state)
    {
        return false;
    }

    @Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, BlockState state, BlockPos pos, Direction face) {
        return BlockFaceShape.UNDEFINED;
    }

    @Override
    public void breakBlock(World world, BlockPos pos, BlockState state) {
        TileEntity tileentity = world.getTileEntity(pos);
        world.removeTileEntity(pos);
        super.breakBlock(world, pos, state);
    }

    @Override
    protected boolean canSilkHarvest() {
        return false;
    }

    @Override
    public boolean removedByPlayer(BlockState state, World world, BlockPos pos, Player player, boolean willHarvest) {
        if (!world.isRemote && !player.isCreative()) {
            int variant = this.getActualState(state, world, pos).getValue(VARIANT);
            if (variant > 0) {
                EntityItem entityToSpawn = null;
                if (variant == 1) {
                    entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.IRON_NUGGET, (int) (1)));
                }
                else if (variant == 2) {
                    entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.GOLD_NUGGET, (int) (1)));
                }
                else if (variant == 3) {
                    entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemZircon.block, (int) (1)));
                }
                else if (variant == 4) {
                    entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.EMERALD, (int) (1)));
                }
                else if (variant == 5) {
                    entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.DIAMOND, (int) (1)));
                }
                else if (variant == 6) {
                    entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemBalticAmberChunk.block, (int) (1)));
                }
                else if (variant == 7) {
                    entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemDominicanAmberChunk.block, (int) (1)));
                }
                else if (variant == 8) {
                    entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.QUARTZ, (int) (1)));
                }
                else if (variant == 9) {
                    entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.DYE, 1, 4));
                }
                else if (variant == 10) {
                    entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.COAL, (int) (1)));
                }
                else if (variant == 11) {
                    entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockAraucarioxylonLogPetrified.block, (int) (1)));
                }
                else if (variant == 12) {
                    entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Blocks.REDSTONE_TORCH, (int) (1)));
                }
                else if (variant == 13) {
                    entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemAnthracite.block, (int) (1)));
                }
                else if (variant == 14) {
                    entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemSalt.block, (int) (1)));
                }
                else if (variant == 15) {
                    entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemSulphur.block, (int) (1)));
                }
                if (entityToSpawn != null) {
                    entityToSpawn.setPickupDelay(10);
                    world.spawnEntity(entityToSpawn);
                }
            }
        }
        return super.removedByPlayer(state, world, pos, player, willHarvest);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new PNWoodenBenchBlock.TileEntityBench();
    }

    @Override
    public boolean eventReceived(BlockState state, World worldIn, BlockPos pos, int eventID, int eventParam) {
        super.eventReceived(state, worldIn, pos, eventID, eventParam);
        TileEntity tileentity = worldIn.getTileEntity(pos);
        return tileentity == null ? false : tileentity.receiveClientEvent(eventID, eventParam);
    }


    public static class TileEntityBench extends TileEntity {

        @Override
        public boolean shouldRefresh(World world, BlockPos pos, BlockState oldState, BlockState newSate) {
            return (oldState.getBlock() != newSate.getBlock());
        }

        @Override
        public SPacketUpdateTileEntity getUpdatePacket() {
            return new SPacketUpdateTileEntity(this.pos, 0, this.getUpdateTag());
        }

        @Override
        public NBTTagCompound getUpdateTag() {
            return this.writeToNBT(new NBTTagCompound());
        }


        @Override
        public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
            this.readFromNBT(pkt.getNbtCompound());
        }

        @Override
        public void handleUpdateTag(NBTTagCompound tag) {
            this.readFromNBT(tag);
        }

    }
}
