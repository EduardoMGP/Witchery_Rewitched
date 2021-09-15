package com.hero.witchery_rewitched.block.witch_cauldron;

import com.hero.witchery_rewitched.block.INamedContainerExtraData;
import com.hero.witchery_rewitched.crafting.recipe.WitchCauldronRecipe;
import com.hero.witchery_rewitched.crafting.recipe.ModRecipes;
import com.hero.witchery_rewitched.init.ModTileEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CampfireBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.RecipeManager;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.IIntArray;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.stream.Collectors;

public class WitchCauldronTileEntity extends TileEntity implements ITickableTileEntity, INamedContainerExtraData, ISidedInventory {
    public static int MAX_WATER = 3000;
    public static int POTION_TAKE_AMOUNT = 1000;
    private static int warmUpTime = 2*20;
    private static int CRAFTING_TIME = 2*20;

    private int progress = 0;
    private int warmUpProgress = 0;
    private int waterLevel = 0;
    private int pullTimer = 0;
    private int potionIn = 0;


    private static final int[] INPUT_SLOTS = {0, 1, 2, 3, 4, 5};
    public static final int INVENTORY_SIZE = INPUT_SLOTS.length + 1;

    protected final NonNullList<ItemStack> items;
    static VoxelShape BLOCK_ABOVE_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 32.0D, 16.0D);

    private final IIntArray fields = new IIntArray() {
        @Override
        public int get(int index) {
            switch(index){
                case 0:
                    return warmUpProgress;
                case 1:
                    return warmUpTime;
                case 2:
                    return potionIn;
                case 3:
                    return waterLevel;
                default:
                    return 0;
            }
        }
        @Override
        public void set(int index, int value) {
            switch(index){
                case 0:
                    warmUpProgress = value;
                    break;
                case 1:
                    warmUpTime = value;
                    break;
                case 2:
                    potionIn = value;
                    break;
                case 3:
                    waterLevel = value;
                    break;
            }
        }

        @Override
        public int getCount() {
            return 4;
        }
    };


    public WitchCauldronTileEntity() {
        super(ModTileEntities.WITCH_CAULDRON.get());
        items = NonNullList.withSize(INVENTORY_SIZE, ItemStack.EMPTY);
    }

    @Nonnull
    @Override
    public int[] getSlotsForFace(Direction side) {
        return INPUT_SLOTS;
    }



    @Override
    public void tick() {
        //TODO: Do some stuff pertaining to power
        if(this.level == null || this.level.isClientSide)
            return;

        BlockState below = level.getBlockState(getBlockPos().offset(0,-1,0));
        if(waterLevel > 0 && isHeatSource(below) && warmUpProgress < warmUpTime) {
            warmUpProgress++;
            if(warmUpProgress == warmUpTime) WitchCauldronBlock.setLit(level, true, worldPosition, getBlockState());
        }
         else if((!(isHeatSource(below)) || waterLevel == 0) && warmUpProgress > 0 )
            stopWork();

        if(warmUpProgress < warmUpTime)
            return;

        if(progress > 1) {
            progress--;
            return;
        }
        else if(progress == 1)
        {
            progress--;
            pullTimer = 100;
            InventoryHelper.dropItemStack(level, worldPosition.getX(), worldPosition.getY() + 1.5, worldPosition.getZ(), items.get(INVENTORY_SIZE -1));
            takeWater(MAX_WATER, false);
            items.set(INVENTORY_SIZE -1, ItemStack.EMPTY);
            stopWork();
        }

        if(pullTimer != 0)
            pullTimer--;
        else if(potionIn == 0){
            if(pullItems()){
                boolean potion = hasValidPotionRecipe();
                WitchCauldronRecipe recipe = getCauldronRecipe();
                if(potion) {
                    WitchCauldronBlock.setHasPotionRecipe(level, true, worldPosition, getBlockState());
                    WitchCauldronBlock.setHasCauldronRecipe(level, false, worldPosition, getBlockState());
                }
                else if(recipe != null) {
                    WitchCauldronBlock.setHasPotionRecipe(level, false, worldPosition, getBlockState());
                    WitchCauldronBlock.setHasCauldronRecipe(level, true, worldPosition, getBlockState());
                    clearContent();
                    items.set(INVENTORY_SIZE -1, recipe.getResultItem());
                    progress = CRAFTING_TIME;
                }
                else {
                    WitchCauldronBlock.setHasPotionRecipe(level, false, worldPosition, getBlockState());
                    WitchCauldronBlock.setHasCauldronRecipe(level, false, worldPosition, getBlockState());
                }
            }
        }
    }

    private boolean isHeatSource(BlockState block){
        return  block.getBlock() == Blocks.FIRE ||
                block.getBlock() == Blocks.MAGMA_BLOCK ||
                block.getBlock() == Blocks.CAMPFIRE && block.getValue(CampfireBlock.LIT) ||
                block.getBlock() == Blocks.SOUL_FIRE ||
                block.getBlock() == Blocks.SOUL_CAMPFIRE && block.getValue(CampfireBlock.LIT);
    }

    private WitchCauldronRecipe getCauldronRecipe(){
        RecipeManager manager = level.getRecipeManager();
        WitchCauldronRecipe recipe = manager.getRecipeFor(ModRecipes.Types.WITCH_CAULDRON, this, level).orElse(null);
        return recipe;
    }

    private boolean hasValidPotionRecipe(){
        if(items.get(0) == ItemStack.EMPTY) return false;

        ItemStack potion = PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER);
        for(int i = 0; i < INVENTORY_SIZE -1; i++) {
            if(items.get(i) == ItemStack.EMPTY) continue;
            NonNullList<ItemStack> itemList = NonNullList.withSize(1, potion);
            if(!BrewingRecipeRegistry.canBrew(itemList, items.get(i),  new int[]{0})) {
                return false;
            }
            else {
                potion = BrewingRecipeRegistry.getOutput(potion, items.get(i));
            }
        }
        return true;
    }

    public void empty(){
        stopWork();
        takeWater(waterLevel, false);
        clearContent();
        potionIn = 0;
    }
    private boolean pullItems(){
        for(ItemEntity itemEntity: WitchCauldronTileEntity.getCaptureItems(this)){
            boolean isPotion = itemEntity.getItem().getItem() == Items.POTION;
            if(!isPotion && pullTimer == 0 && captureItem(itemEntity))
                pullTimer = 5;
                return true;
        }
        return false;
    }
    public void onEntityCollision(Entity itemEntity) {
        if (itemEntity instanceof ItemEntity) {
            BlockPos blockpos = this.getBlockPos();
            if (VoxelShapes.joinIsNotEmpty(VoxelShapes.create(itemEntity.getBoundingBox().move((-blockpos.getX()), (-blockpos.getY()), (-blockpos.getZ()))), BLOCK_ABOVE_SHAPE, IBooleanFunction.AND)) {
                    captureItem((ItemEntity)itemEntity);
            }
        }
    }
    public boolean captureItem(ItemEntity itemEntity) {
        boolean flag = false;
        if(waterLevel != MAX_WATER)
            return false;
        ItemStack itemstack = itemEntity.getItem().copy();
        ItemStack itemstack1 = tryInsertAllSlots(itemstack);
        if (itemstack1.isEmpty()) {
            flag = true;
            itemEntity.remove();
        } else {
            itemEntity.setItem(itemstack1);
        }

        return flag;
    }

    private ItemStack tryInsertAllSlots(ItemStack itemStack){
        for(int i = 0; i < items.size() - 1; i++){
            if(items.get(i).getItem() == itemStack.getItem())
                return itemStack;

            if(items.get(i) == ItemStack.EMPTY){
                items.set(i, new ItemStack(itemStack.getItem()));
                if(itemStack.getCount() - 1 == 0) {
                    return ItemStack.EMPTY;
                }
                else {
                    return new ItemStack(itemStack.getItem(), itemStack.getCount() - 1);
                }
            }
        }
        return ItemStack.EMPTY;
    }

    public static List<ItemEntity> getCaptureItems(WitchCauldronTileEntity p_200115_0_) {
        return BLOCK_ABOVE_SHAPE.toAabbs().stream().flatMap((p_200110_1_) -> {
            return p_200115_0_.getLevel().getEntitiesOfClass(ItemEntity.class, p_200110_1_.move(p_200115_0_.worldPosition.getX() - 0.5D, p_200115_0_.worldPosition.getY() - 0.5D, p_200115_0_.worldPosition.getZ() - 0.5D), EntityPredicates.ENTITY_STILL_ALIVE).stream();
        }).collect(Collectors.toList());
    }


    public ItemStack getPotionRecipe(){
        if(waterLevel == 0)
            return ItemStack.EMPTY;

        if(items.get(INVENTORY_SIZE -1) != ItemStack.EMPTY)
            return items.get(INVENTORY_SIZE -1);

        ItemStack potion = PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER);
        items.set(INVENTORY_SIZE -1, potion);
        for(int i = 0; i < INVENTORY_SIZE -1; i++) {
            if(items.get(i) == ItemStack.EMPTY) continue;
            NonNullList<ItemStack> itemList = NonNullList.withSize(1, potion);
            if(!BrewingRecipeRegistry.canBrew(itemList, items.get(i),  new int[]{0})) {
                items.set(INVENTORY_SIZE -1, ItemStack.EMPTY);
                potionIn = 0;
                return null;
            }
            else {
                potionIn = 1;
                potion = BrewingRecipeRegistry.getOutput(potion, items.get(i));
                items.set(INVENTORY_SIZE -1, potion);
            }
        }
        return potion;
    }

    private void stopWork(){
        WitchCauldronBlock.setLit(level, false, worldPosition, getBlockState());
        WitchCauldronBlock.setHasPotionRecipe(level, false, worldPosition, getBlockState());
        WitchCauldronBlock.setHasCauldronRecipe(level, false, worldPosition, getBlockState());
        warmUpProgress = 0;
        progress = 0;
    }

    public boolean takeWater(int amount, boolean potion){
        if(waterLevel - amount  >= 0) {
            waterLevel -= amount;
            if(potion) {
                ItemStack stack = items.get(INVENTORY_SIZE -1).copy();
                this.clearContent();

                if (waterLevel != 0) items.set(INVENTORY_SIZE -1, stack);
                else potionIn = 0;
            }

            updateLevel();
            return true;
        }
        return false;
    }

    private void updateLevel(){
        if(level != null)
            WitchCauldronBlock.setLevel(level, ((float)waterLevel) / MAX_WATER, worldPosition, this.getBlockState());
    }

    public void fill(){
        waterLevel = MAX_WATER;
        updateLevel();
    }

    public boolean isFullLiquid(){
        return waterLevel == MAX_WATER;
    }


    // Basic Tile Entity Shit but specific to this one after here


    @Override
    public void encodeExtraData(PacketBuffer buffer) {
        buffer.writeItem(items.get(INVENTORY_SIZE -1));
    }

    @Override
    public boolean canPlaceItemThroughFace(int index, @Nonnull ItemStack itemStackIn, @Nullable Direction direction) {
        return items.get(index).isEmpty() || items.get(index).getItem() == itemStackIn.getItem();
    }

    @Override
    public boolean canTakeItemThroughFace(int index, @Nonnull ItemStack stack, @Nonnull Direction direction) {
        return true;
    }

    @Nonnull
    @Override
    public ITextComponent getDisplayName() {
        return new TranslationTextComponent("container.witchery_rewitched.witch_cauldron");
    }



    // Honestly Pretty Generic Tile Entity Shit Past This Point

    @Override
    public void load(@Nonnull BlockState state, @Nonnull CompoundNBT nbt) {
        super.load(state, nbt);
        ItemStackHelper.loadAllItems(nbt, this.items);

        progress = nbt.getInt("progress");
        warmUpProgress = nbt.getInt("warmup");
        waterLevel = nbt.getInt("waterlevel");
        pullTimer = nbt.getInt("pulltimer");
        potionIn = nbt.getInt("potion");

    }

    @Nonnull
    @Override
    public CompoundNBT save(@Nonnull CompoundNBT compound) {
        super.save(compound);
        ItemStackHelper.saveAllItems(compound, this.items);
        compound.putInt("progress", progress);
        compound.putInt("warmup", warmUpProgress);
        compound.putInt("waterlevel", waterLevel);
        compound.putInt("pulltimer", pullTimer);
        compound.putInt("potion", potionIn);
        return compound;
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket packet) {
        super.onDataPacket(net, packet);
        ItemStackHelper.loadAllItems(packet.getTag(), this.items);
        CompoundNBT tags = packet.getTag();
        progress = tags.getInt("progress");
        warmUpProgress = tags.getInt("warmup");
        waterLevel = tags.getInt("waterlevel");
        pullTimer = tags.getInt("pulltimer");
        potionIn = tags.getInt("potion");

    }

    @Nonnull
    @Override
    public CompoundNBT getUpdateTag() {
        CompoundNBT tags= super.getUpdateTag();
        tags.putInt("progress", progress);
        tags.putInt("warmup", warmUpProgress);
        tags.putInt("waterlevel", waterLevel);
        tags.putInt("pulltimer", pullTimer);
        tags.putInt("potion", potionIn);
        return tags;
    }

    @Override
    public int getContainerSize() {
        return INVENTORY_SIZE;
    }

    @Override
    public boolean isEmpty() {
        return getItem(0).isEmpty() && getItem(1).isEmpty() && getItem(2).isEmpty() && getItem(3).isEmpty() && getItem(4).isEmpty();
    }

    @Nonnull
    @Override
    public ItemStack getItem(int index) {
        return index >= 0 && index < this.items.size() ? this.items.get(index) : ItemStack.EMPTY;
    }

    @Nonnull
    @Override
    public ItemStack removeItem(int index, int count) {
        return ItemStackHelper.removeItem(this.items, index, count);
    }

    @Nonnull
    @Override
    public ItemStack removeItemNoUpdate(int index) {
        return ItemStackHelper.takeItem(items, index);
    }

    @Override
    public void setItem(int index, @Nonnull ItemStack stack) {
        items.set(index, stack);
    }

    @Override
    public boolean stillValid(@Nonnull PlayerEntity player) {

        return this.level != null &&
                this.level.getBlockEntity(this.worldPosition) == this &&
                player.distanceToSqr(this.worldPosition.getX() + .5, this.worldPosition.getY()+.5, this.worldPosition.getZ()) <= 64 ;
    }

    @Override
    public void clearContent() {
        items.clear();
    }


    @Nullable
    @Override
    public Container createMenu(int p_createMenu_1_, @Nonnull PlayerInventory p_createMenu_2_, @Nonnull PlayerEntity p_createMenu_3_) {
        return null;
    }
}
