package com.hero.witchery_rewitched.crafting.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.hero.witchery_rewitched.block.distillery.DistilleryTileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nullable;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DistilleryRecipe implements IRecipe<DistilleryTileEntity> {

    private ResourceLocation id;
    private final List<Ingredient> ingredients = new ArrayList<>();
    private final List<Ingredient> ingredients2 = new ArrayList<>();
    private final List<ItemStack> result;
    private final List<Item> resultItems;
    public final int fumeAmount;

    public DistilleryRecipe(ResourceLocation id, List<ItemStack> result, int fumeAmount) {
        this.id = id;
        this.result = result;
        this.resultItems = result.stream().map(ItemStack::getItem).collect(Collectors.toList());
        this.fumeAmount = fumeAmount;
    }

    @Override
    public boolean matches(DistilleryTileEntity inv, World worldIn) {
        if( inv.getItem(2).getCount() < fumeAmount)
            return false;
        for(int i = 0; i < 7; i++){
            if(i > 2  && !(inv.getItem(i).getItem() == Items.AIR)  &&(!resultItems.contains(inv.getItem(i).getItem()) || inv.getItem(i).getCount() == inv.getItem(i).getMaxStackSize()))
                return false;
            else if(i == 0){
                boolean flag = false;
                for(Ingredient ingredient : ingredients){
                    if(ingredient.test(inv.getItem(i)))
                        flag = true;
                }
                if(!flag)
                    return false;
            }
            else if(i == 1){
                boolean flag = false;
                for(Ingredient ingredient : ingredients2){
                    if(ingredient.test(inv.getItem(i)))
                        flag = true;
                }
                if(ingredients2.size() == 0)
                    flag = true;
                if(!flag)
                    return false;
            }
        }
        return true;
    }
    public int getFumeAmount(){return fumeAmount;}

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> lst = NonNullList.withSize(ingredients.size(), Ingredient.EMPTY);
        for(int i = 0; i < ingredients.size(); i++)
            lst.set(i, ingredients.get(i));
        return lst;
    }

    public NonNullList<Ingredient> getIngredients2(){
        NonNullList<Ingredient> lst = NonNullList.withSize(ingredients2.size(), Ingredient.EMPTY);
        for(int i = 0; i < ingredients2.size(); i++)
            lst.set(i, ingredients2.get(i));
        return lst;
    }

    // DON'T USE THIS PLEASE
    @Override
    public ItemStack assemble(DistilleryTileEntity inv) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
        return result != null ? result.get(0) : ItemStack.EMPTY;
    }

    public List<ItemStack> getResults(){
        return result;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return ModRecipes.Serializers.DISTILLERY.get();
    }

    @Override
    public IRecipeType<?> getType() {
        return ModRecipes.Types.DISTILLERY;
    }

    public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<DistilleryRecipe>{

        @Override
        public DistilleryRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
            JsonArray array = json.getAsJsonArray("ingredients");
            JsonArray arr2 = json.getAsJsonArray("ingredients2");
            JsonArray results = json.getAsJsonArray("result");
            int fumeAmount = json.get("fumeAmount").getAsInt();

            List<ItemStack> result = new ArrayList<>();
            for(JsonElement je : results) {
                String item = JSONUtils.getAsString(je.getAsJsonObject(), "item");
                int count = JSONUtils.getAsInt(je.getAsJsonObject(), "count");
                result.add(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(item)), count));
            }
            DistilleryRecipe rec = new DistilleryRecipe(recipeId, result, fumeAmount);
            for (JsonElement je : array) {
                rec.ingredients.add(Ingredient.fromJson(je));
            }
            for (JsonElement je : arr2) {
                rec.ingredients2.add(Ingredient.fromJson(je));
            }
            return rec;
        }

        @Nullable
        @Override
        public DistilleryRecipe fromNetwork(ResourceLocation recipeId, PacketBuffer buffer) {
            int fumeAmount = buffer.readByte();
            List<Ingredient> ingredients = new ArrayList<>();
            int count = buffer.readByte();
            for (int i = 0; i < count; ++i) {
                ingredients.add(Ingredient.fromNetwork(buffer));
            }

            List<Ingredient> ingredients2 = new ArrayList<>();
            count = buffer.readByte();
            for (int i = 0; i < count; ++i) {
                ingredients2.add(Ingredient.fromNetwork(buffer));
            }

            List<ItemStack> result = new ArrayList<>();
            count = buffer.readByte();
            for (int i = 0; i < count; ++i) {
                result.add(buffer.readItem());
            }
            DistilleryRecipe rec = new DistilleryRecipe(recipeId, result, fumeAmount);
            rec.ingredients.addAll(ingredients);

            return rec;
        }

        @Override
        public void toNetwork(PacketBuffer buffer, DistilleryRecipe recipe) {
            buffer.writeByte(recipe.fumeAmount);
            buffer.writeByte(recipe.ingredients.size());
            recipe.ingredients.forEach(ingredient -> ingredient.toNetwork(buffer));
            buffer.writeByte(recipe.ingredients2.size());
            recipe.ingredients2.forEach(ingredient -> ingredient.toNetwork(buffer));
            buffer.writeByte(recipe.result.size());
            recipe.result.forEach(buffer::writeItem);
        }
    }
}
