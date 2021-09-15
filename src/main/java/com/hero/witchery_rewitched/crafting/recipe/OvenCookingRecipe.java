package com.hero.witchery_rewitched.crafting.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.hero.witchery_rewitched.block.witch_oven.WitchOvenTileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
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

public class OvenCookingRecipe implements IRecipe<WitchOvenTileEntity> {
    private ResourceLocation id;
    private final List<Ingredient> ingredients = new ArrayList<>();
    private final ItemStack possibleResult;
    private final ItemStack result;

    public OvenCookingRecipe(ResourceLocation id, ItemStack possibleResult, ItemStack result) {
        this.id = id;
        this.possibleResult = possibleResult;
        this.result = result;
    }

    @SuppressWarnings("SuspiciousMethodCalls")
    @Override
    public boolean matches(WitchOvenTileEntity inv, World worldIn) {
        ItemStack tester = inv.getItem(0).copy();
        tester.setCount(1);
        for(Ingredient ingredient : ingredients)
        {
            if(ingredient.test(tester))
                return true;
        }
        return false;
    }

    @Override
    public ItemStack assemble(WitchOvenTileEntity inv) {
        return result;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return false;
    }

    @Override
    public ItemStack getResultItem() {
        return result;
    }

    public ItemStack getPossibleResult(){
        return possibleResult;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> returnList  = NonNullList.create();
        returnList.addAll(ingredients);
        return returnList;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return ModRecipes.Serializers.WITCH_OVEN.get();
    }

    @Override
    public IRecipeType<?> getType() {
        return ModRecipes.Types.WITCH_OVEN;
    }

    public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<OvenCookingRecipe>{

        @Override
        public OvenCookingRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
            JsonArray array = json.getAsJsonArray("ingredients");
            ResourceLocation itemId = new ResourceLocation(JSONUtils.getAsString(json.getAsJsonObject("result"), "item"));
            ResourceLocation itemId2 = new ResourceLocation(JSONUtils.getAsString(json.getAsJsonObject("possibleResult"), "item"));

            ItemStack result = new ItemStack(ForgeRegistries.ITEMS.getValue(itemId), 1);
            ItemStack possibleResult= null;
            if(!itemId2.toString().isEmpty())
                possibleResult =  new ItemStack(ForgeRegistries.ITEMS.getValue(itemId2), 1);

            OvenCookingRecipe rec = new OvenCookingRecipe(recipeId, possibleResult, result);
            for (JsonElement je : array) {
                rec.ingredients.add(Ingredient.fromJson(je));
            }
            return rec;
        }

        @Nullable
        @Override
        public OvenCookingRecipe fromNetwork(ResourceLocation recipeId, PacketBuffer buffer) {
            List<Ingredient> ingredients = new ArrayList<>();
            int count = buffer.readByte();
            for (int i = 0; i < count; ++i) {
                ingredients.add(Ingredient.fromNetwork(buffer));
            }
            ItemStack possibleResult = buffer.readItem();
            ItemStack result = buffer.readItem();
            OvenCookingRecipe rec = new OvenCookingRecipe(recipeId, possibleResult, result);
            rec.ingredients.addAll(ingredients);
            return rec;
        }

        @Override
        public void toNetwork(PacketBuffer buffer, OvenCookingRecipe recipe) {
            buffer.writeByte(recipe.ingredients.size());
            recipe.ingredients.forEach(ingredient -> ingredient.toNetwork(buffer));
            buffer.writeItem(recipe.possibleResult);
            buffer.writeItem(recipe.result);
        }
    }
}
