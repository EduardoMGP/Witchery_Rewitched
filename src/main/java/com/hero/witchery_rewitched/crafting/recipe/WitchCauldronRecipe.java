package com.hero.witchery_rewitched.crafting.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.hero.witchery_rewitched.block.witch_cauldron.WitchCauldronTileEntity;
import net.minecraft.item.ItemStack;
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
import java.util.ArrayList;
import java.util.List;

public class WitchCauldronRecipe implements IRecipe<WitchCauldronTileEntity> {
    private ResourceLocation id;
    private final List<Ingredient> ingredients = new ArrayList<>();
    private final  ItemStack result;
    private final int power;

    public WitchCauldronRecipe(ResourceLocation id, ItemStack result, int power){
        this.id = id;
        this.result = result;
        this.power = power;
    }

    @Override
    public boolean matches(WitchCauldronTileEntity inv, World worldIn) {
        int ings = 0;
        for(int i = 0; i < WitchCauldronTileEntity.INVENTORY_SIZE -1; i++)
        {
            if(inv.getItem(i)  == ItemStack.EMPTY) continue;
            boolean flag = false;
            for(Ingredient ingredient : ingredients){
                if(ingredient.test(inv.getItem(i))) {
                    flag = true;
                    ings++;
                    break;
                }
            }
            if(!flag)
                return false;
        }
        if(ings != ingredients.size())
            return false;

        return true;
    }

    public int getPower(){
        return power;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> ings =  NonNullList.withSize(ingredients.size(), Ingredient.EMPTY);
        for(int  i = 0; i < ingredients.size(); i++){
            ings.set(i, ingredients.get(i));
        }
        return ings;
    }

    @Override
    public ItemStack assemble(WitchCauldronTileEntity inv) {
        return result;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return false;
    }

    @Override
    public ItemStack getResultItem() {
        return result.copy();
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return ModRecipes.Serializers.WITCH_CAULDRON.get();
    }

    @Override
    public IRecipeType<?> getType() {
        return ModRecipes.Types.WITCH_CAULDRON;
    }

    public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<WitchCauldronRecipe>{

        @Override
        public WitchCauldronRecipe fromJson(ResourceLocation recipeId, JsonObject json) {

            ResourceLocation itemId = new ResourceLocation(JSONUtils.getAsString(json.getAsJsonObject("result"),"item"));
            int count = JSONUtils.getAsInt(json.getAsJsonObject("result"),"count");
            int power = JSONUtils.getAsInt(json, "power");
            ItemStack result = new ItemStack(ForgeRegistries.ITEMS.getValue(itemId), count);
            WitchCauldronRecipe recipe = new WitchCauldronRecipe(recipeId, result, power);
            JsonArray array = json.getAsJsonArray("ingredients");
            for(JsonElement je : array){
                recipe.ingredients.add(Ingredient.fromJson(je));
            }
            return recipe;
        }

        @Nullable
        @Override
        public WitchCauldronRecipe fromNetwork(ResourceLocation recipeId, PacketBuffer buffer) {
            ItemStack result = buffer.readItem();
            result.setCount(buffer.readByte());
            WitchCauldronRecipe recipe = new WitchCauldronRecipe(recipeId, result, buffer.readByte());
            int count = buffer.readByte();
            for(int i = 0; i < count; i++){
                recipe.ingredients.add(Ingredient.fromNetwork(buffer));
            }
            return recipe;
        }

        @Override
        public void toNetwork(PacketBuffer buffer, WitchCauldronRecipe recipe) {
            buffer.writeItem(recipe.result);
            buffer.writeByte(recipe.result.getCount());
            buffer.writeByte(recipe.power);
            buffer.writeByte(recipe.ingredients.size());
            for( Ingredient ingredient : recipe.ingredients){
                    ingredient.toNetwork(buffer);
            }
        }
    }

}
