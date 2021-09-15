package com.hero.witchery_rewitched.crafting.recipe;

import com.hero.witchery_rewitched.init.RegistryHandler;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModRecipes {
    public static class Types{
        public static final IRecipeType<OvenCookingRecipe> WITCH_OVEN = IRecipeType.register("witch_oven");
        public static final IRecipeType<WitchCauldronRecipe> WITCH_CAULDRON = IRecipeType.register("witch_cauldron");
        public static final IRecipeType<DistilleryRecipe> DISTILLERY = IRecipeType.register("distillery");
        public static final IRecipeType<RitualRecipe> RITUAL = IRecipeType.register("ritual");
    }

    public static class Serializers {
        public static final RegistryObject<IRecipeSerializer<OvenCookingRecipe>> WITCH_OVEN = register("witch_oven", OvenCookingRecipe.Serializer::new);
        public static final RegistryObject<IRecipeSerializer<WitchCauldronRecipe>> WITCH_CAULDRON = register("witch_cauldron", WitchCauldronRecipe.Serializer::new);
        public static final RegistryObject<IRecipeSerializer<DistilleryRecipe>> DISTILLERY = register("distillery", DistilleryRecipe.Serializer::new);
        public static final RegistryObject<IRecipeSerializer<RitualRecipe>> RITUAL = register("ritual", RitualRecipe.Serializer::new);

        public static void register(){}
        private static <T extends IRecipe<?>> RegistryObject<IRecipeSerializer<T>> register(String name, Supplier<IRecipeSerializer<T>> serializer){
            return RegistryHandler.RECIPE_SERIALIZERS.register(name, serializer);
        }
    }

    public static void register(){ Serializers.register();}
}
