package com.hero.witchery_rewitched.api.processors;

import com.hero.witchery_rewitched.crafting.recipe.RitualRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.RecipeManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.registries.ForgeRegistries;
import vazkii.patchouli.api.IComponentProcessor;
import vazkii.patchouli.api.IVariable;
import vazkii.patchouli.api.IVariableProvider;

import java.util.Locale;

public class PlantProcessor implements IComponentProcessor {
    Item plant;
    Item seed;
    String name;
    String text;

    @Override
    public void setup(IVariableProvider variables) {
        this.plant = ForgeRegistries.ITEMS.getValue(new ResourceLocation(variables.get("plant").asString()));
        if(variables.has("seed"))
            this.seed = ForgeRegistries.ITEMS.getValue(new ResourceLocation(variables.get("seed").asString()));
        this.name = variables.get("name").asString();
        this.text = variables.get("text").asString();
    }

    @Override
    public IVariable process(String key) {
        if(key.equals("name")){
            return IVariable.wrap(name);
        }
        else if(key.startsWith("plant")){
            if(seed == null)
                return IVariable.from(ItemStack.EMPTY);
            return IVariable.from(new ItemStack(plant));
        }
        else if(key.startsWith("seed")){
            if(seed == null)
                return IVariable.from(ItemStack.EMPTY);
            return IVariable.from(new ItemStack(seed));
        }
        else if(key.equals("image")){
            String text = name.toLowerCase();
            text = text.replace(' ', '_');
            if(seed != null)
                return IVariable.wrap("witchery_rewitched:textures/block/"+text+"/age2.png");
            else
                return IVariable.wrap("witchery_rewitched:textures/block/"+text+".png");
        }
        else if(key.equals("text")){
            return IVariable.wrap(text);
        }
        return null;
    }
}
