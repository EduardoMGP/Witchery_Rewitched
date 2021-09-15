package com.hero.witchery_rewitched.item;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

import net.minecraft.item.Item.Properties;

public class BoundWaystone extends Item {
    public BoundWaystone(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        BlockPos pos = getPos(stack);
        String text = "How did you get this?";
        String dim = getDimension(stack) != null ? format(getDimension(stack)): "huh?";
        if(pos != null)
        {
            if(getDimension(stack) != null)
                text = "Bound to: " + dim + ", ";
            text += pos.toShortString();
        }
        tooltip.add(new StringTextComponent(text));
    }

    @Override
    public boolean verifyTagAfterLoad(CompoundNBT nbt) {
        super.verifyTagAfterLoad(nbt);
        boolean flag = false;
        if(nbt.contains("pos")){
            BlockPos pos = NBTUtil.readBlockPos((CompoundNBT)nbt.get("pos"));
            nbt.put("pos", NBTUtil.writeBlockPos(pos));
            flag = true;
        }
        else if(nbt.contains("dimension"))
        {
            nbt.putString("dimension", nbt.getString("dimension"));
            flag = true;
        }
        return flag;
    }

    private String format(String string){
        string = string.substring(string.indexOf(':')+1);
        string = string.replace('_', ' ');
        char[] strings = string.toCharArray();
        for(int i = 0; i <  string.length(); i++){
            if(i == 0 || strings[i-1] == ' ')
                strings[i] = Character.toUpperCase(strings[i]);
        }
        return new String(strings);
    }

    public static BlockPos getPos(ItemStack stack){
        if(stack.hasTag()){
            CompoundNBT nbt = stack.getTag();
            if(nbt.contains("pos")){
                return NBTUtil.readBlockPos((CompoundNBT) nbt.get("pos"));
            }
        }
        return null;
    }

    public static String getDimension(ItemStack stack){
        if(stack.hasTag()){
            CompoundNBT nbt = stack.getTag();
            if(nbt.contains("dimension")){
                return nbt.getString("dimension");
            }
        }
        return null;
    }

    public static ItemStack updateStackWithPos(ItemStack stack, BlockPos pos, String dim){
        CompoundNBT nbt = stack.getOrCreateTag();
        nbt.put("pos", NBTUtil.writeBlockPos(pos));
        nbt.putString("dimension", dim);
        return stack;
    }
}
