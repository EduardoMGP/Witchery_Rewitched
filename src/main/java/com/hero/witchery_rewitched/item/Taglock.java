package com.hero.witchery_rewitched.item;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

import net.minecraft.item.Item.Properties;

public class Taglock extends Item {
    public Taglock(Properties properties) {
        super(properties.stacksTo(1));
    }

    @Override
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if(worldIn.isClientSide)
            return super.use(worldIn, playerIn, handIn);
        Hand otherHand;
        if(handIn == Hand.MAIN_HAND)
            otherHand = Hand.OFF_HAND;
        else
            otherHand = Hand.MAIN_HAND;

        if (!(playerIn.getItemInHand(otherHand).getItem() instanceof PoppetBase)) {
            return super.use(worldIn, playerIn, handIn);
        }
        PoppetBase item = ((PoppetBase)playerIn.getItemInHand(otherHand).getItem());
        if(playerIn.getItemInHand(otherHand).getItem() instanceof PoppetBase){
            playerIn.setItemInHand(handIn, TaglockKit.giveStackWithPlayerInfo(new ItemStack(item), playerIn.getUUID(), playerIn.getName().getString()));
            playerIn.setItemInHand(otherHand, ItemStack.EMPTY);
        }
        return super.use(worldIn, playerIn, handIn);
    }

    @Override
    public boolean verifyTagAfterLoad(CompoundNBT nbt) {
        super.verifyTagAfterLoad(nbt);
        boolean flag = false;
        if (nbt.contains("PlayerID")) {
            UUID id = NBTUtil.loadUUID(nbt.get("PlayerID"));
            nbt.putUUID("PlayerID", id);
            flag = true;
        }
        else if(nbt.contains("PlayerName")){
            String playerName = nbt.getString("PlayerName");
            nbt.putString("PlayerName", playerName);
            flag = true;
        }
        else{
            flag = false;
        }
        return flag;
    }

    public static String getPlayerName(ItemStack stack){
        String name = "How did you get this?";
        if (stack.hasTag()) {
            CompoundNBT compoundnbt = stack.getTag();
            if (compoundnbt.contains("PlayerName")) {
                name = compoundnbt.getString("PlayerName");
            }
        }
        return name;
    }

    public static UUID getPlayerID(ItemStack stack){
        UUID id = null;
        if (stack.hasTag()) {
            CompoundNBT compoundnbt = stack.getTag();
            if (compoundnbt.contains("PlayerName")) {
                id = NBTUtil.loadUUID(compoundnbt.get("PlayerID"));
            }
        }
        return id;
    }

    @Override
    public void appendHoverText(@Nonnull ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, @Nonnull ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent(getPlayerName(stack)));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }


}
