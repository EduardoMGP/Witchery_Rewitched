package com.hero.witchery_rewitched.block.poppet_shelf;

import com.hero.witchery_rewitched.block.INamedContainerExtraData;
import com.hero.witchery_rewitched.init.ModTileEntities;
import com.hero.witchery_rewitched.item.PoppetBase;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.stream.Collectors;

public class PoppetShelfTileEntity extends TileEntity implements INamedContainerExtraData, ISidedInventory {

    protected final NonNullList<ItemStack> items;
    public static final int INVENTORY_SIZE = 4;
    public PoppetShelfTileEntity() {
        super(ModTileEntities.POPPET_SHELF.get());
        items = NonNullList.withSize(INVENTORY_SIZE, ItemStack.EMPTY);
    }

    public void insert(ItemStack stack){
        for(int i =  0; i < INVENTORY_SIZE; i++){
            if(items.get(i) == ItemStack.EMPTY) {
                setItem(i, stack);
                break;
            }
        }
    }

    public ItemStack extract(){
        for(int i = INVENTORY_SIZE-1; i >= 0; i--){
            if(items.get(i) != ItemStack.EMPTY) {
                return removeItemNoUpdate(i);
            }
        }
        return ItemStack.EMPTY;
    }

    public boolean destroyPoppet(ItemStack poppet){
        boolean flag = false;
        for(int i = 0; i < INVENTORY_SIZE-1; i++){
            if(items.get(i).getItem() == poppet.getItem()  && PoppetBase.getPlayerID(poppet).equals(PoppetBase.getPlayerID(items.get(i)))) {
                removeItemNoUpdate(i);
                flag = true;
            }
            if(flag){
                items.set(i, items.get(i + 1));
            }
        }
        if(flag) {
            items.set(INVENTORY_SIZE - 1, ItemStack.EMPTY);
            this.setChanged();
        }
        return flag;
    }

    public boolean contains(PlayerEntity player){
        for(ItemStack stack: items){
            if((stack.getItem() instanceof PoppetBase) && (PoppetBase.getPlayerID(stack).equals(player.getUUID())))
                return true;
        }
        return false;
    }

    public NonNullList<ItemStack> getInventory() {
        return this.items;
    }

    @Override
    public void encodeExtraData(PacketBuffer buffer) {

    }

    @Override
    public ITextComponent getDisplayName() {
        return new TranslationTextComponent("container.witchery_rewitched.poppet_shelf");
    }

    @Nullable
    @Override
    public Container createMenu(int p_createMenu_1_, PlayerInventory p_createMenu_2_, PlayerEntity p_createMenu_3_) {
        return null;
    }

    @Override
    public int[] getSlotsForFace(Direction side) {
        int[] arr = new int[INVENTORY_SIZE];
        for(int i = 0; i < INVENTORY_SIZE; i++){arr[i] = i;}
        return arr;
    }

    @Override
    public boolean canPlaceItemThroughFace(int index, ItemStack itemStackIn, @Nullable Direction direction) {
        if(!(itemStackIn.getItem() instanceof PoppetBase))
            return false;

        for(ItemStack stack : items){
            if(stack == ItemStack.EMPTY)
                return true;
        }
        return false;
    }

    @Override
    public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction) {
        return stack.getItem() instanceof PoppetBase;
    }

    @Override
    public int getContainerSize() {
        return INVENTORY_SIZE;
    }

    @Override
    public boolean isEmpty() {
        return !items.contains(ItemStack.EMPTY);
    }

    @Override
    public ItemStack getItem(int index) {
        return items.get(index);
    }

    @Override
    public ItemStack removeItem(int index, int count) {
        this.setChanged();
        return items.set(index, new ItemStack(items.get(index).getItem(),items.get(index).getCount() - count));
    }

    @Override
    public void setChanged() {
        super.setChanged();
        sendUpdate();
    }

    private void sendUpdate() {
        if (this.level != null) {
            BlockState state = this.level.getBlockState(this.worldPosition);
            this.level.sendBlockUpdated(this.worldPosition, state, state, 3);
        }
    }

    @Override
    public ItemStack removeItemNoUpdate(int index) {
        ItemStack stack = items.get(index);
        items.set(index, ItemStack.EMPTY);
        this.setChanged();
        return stack;
    }

    @Override
    public void setItem(int index, ItemStack stack) {
        this.setChanged();
        items.set(index, stack);
    }

    @Override
    public boolean stillValid(PlayerEntity player) {
        return this.level != null &&
                this.level.getBlockEntity(this.worldPosition) == this &&
                player.distanceToSqr(this.worldPosition.getX() + .5, this.worldPosition.getY()+.5, this.worldPosition.getZ()) <= 64 ;
    }

    @Override
    public void clearContent() {
        this.setChanged();
        items.clear();
    }

    @Override
    public void load(@Nonnull BlockState state, @Nonnull CompoundNBT nbt) {
        super.load(state, nbt);
        ItemStackHelper.loadAllItems(nbt, this.items);
    }

    @Nonnull
    @Override
    public CompoundNBT save(@Nonnull CompoundNBT compound) {
        super.save(compound);
        ItemStackHelper.saveAllItems(compound, this.items);
        return compound;
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket packet) {
        super.onDataPacket(net, packet);
        for(int i = 0; i < INVENTORY_SIZE; i++)
            this.items.set(i, ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(packet.getTag(), this.items);
        CompoundNBT tags = packet.getTag();
    }

    @Nullable
    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        return new SUpdateTileEntityPacket(this.worldPosition, 0, getUpdateTag());
    }

    @Nonnull
    @Override
    public CompoundNBT getUpdateTag() {
        CompoundNBT tags = super.getUpdateTag();
        ItemStackHelper.saveAllItems(tags, this.items);
        return tags;
    }

}
