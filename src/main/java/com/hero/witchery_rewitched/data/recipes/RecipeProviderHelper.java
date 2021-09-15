package com.hero.witchery_rewitched.data.recipes;

import com.google.common.collect.Sets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.criterion.ImpossibleTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IDataProvider;
import net.minecraft.data.RecipeProvider;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Set;

public class RecipeProviderHelper extends RecipeProvider {

    private static final Logger LOGGER = LogManager.getLogger();

    public RecipeProviderHelper(DataGenerator generatorIn) {
        super(generatorIn);
    }

    /**
     * Performs this provider's action.
     */
    public void run(DirectoryCache cache) throws IOException {
        Path path = this.generator.getOutputFolder();
        Set<ResourceLocation> set = Sets.newHashSet();
        buildShapelessRecipes((recipe) -> {
            if (!set.add(recipe.getId())) {
                throw new IllegalStateException("Duplicate recipe " + recipe.getId());
            } else {
                saveRecipe(cache, recipe.serializeRecipe(), path.resolve("data/" + recipe.getId().getNamespace() + "/recipes/" + recipe.getId().getPath() + ".json"));
                JsonObject jsonobject = recipe.serializeAdvancement();
                if (jsonobject != null) {
                    saveAdvancement(cache, jsonobject, path.resolve("data/" + recipe.getId().getNamespace() + "/advancements/" + recipe.getAdvancementId().getPath() + ".json"));
                }

            }
        });
    }

    /**
     * Saves a recipe to a file.
     */
    private static void saveRecipe(DirectoryCache cache, JsonObject recipeJson, Path path) {
        try {
            Gson gson = new GsonBuilder().disableHtmlEscaping().create();
            String s = gson.toJson((JsonElement)recipeJson);
            String s1 = SHA1.hashUnencodedChars(s).toString();
            if (!Objects.equals(cache.getHash(path), s1) || !Files.exists(path)) {
                Files.createDirectories(path.getParent());

                try (BufferedWriter bufferedwriter = Files.newBufferedWriter(path)) {
                    bufferedwriter.write(s);
                }
            }

            cache.putNew(path, s1);
        } catch (IOException ioexception) {
            LOGGER.error("Couldn't save recipe {}", path, ioexception);
        }

    }

    /**
     * Saves an advancement to a file.
     */
    protected void saveAdvancement(DirectoryCache cache, JsonObject advancementJson, Path path) {
        try {
            Gson gson = new GsonBuilder().create();
            String s = gson.toJson((JsonElement)advancementJson);
            String s1 = SHA1.hashUnencodedChars(s).toString();
            if (!Objects.equals(cache.getHash(path), s1) || !Files.exists(path)) {
                Files.createDirectories(path.getParent());

                try (BufferedWriter bufferedwriter = Files.newBufferedWriter(path)) {
                    bufferedwriter.write(s);
                }
            }

            cache.putNew(path, s1);
        } catch (IOException ioexception) {
            LOGGER.error("Couldn't save recipe advancement {}", path, ioexception);
        }

    }
}
