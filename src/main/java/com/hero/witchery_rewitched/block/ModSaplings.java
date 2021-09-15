package com.hero.witchery_rewitched.block;

import com.hero.witchery_rewitched.data.ModFeatures;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import javax.annotation.Nullable;
import java.util.Random;


public class ModSaplings {

    public static class RowanTree extends Tree{

        @Nullable
        @Override
        protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getConfiguredFeature(Random randomIn, boolean largeHive) {
            return ModFeatures.ROWAN;
        }
    }

    public static class AlderTree extends Tree{

        @Nullable
        @Override
        protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getConfiguredFeature(Random randomIn, boolean largeHive) {
            return ModFeatures.ALDER;
        }
    }

    public static class HawthornTree extends Tree{

        @Nullable
        @Override
        protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getConfiguredFeature(Random randomIn, boolean largeHive) {
            return ModFeatures.HAWTHORN;
        }
    }

    public static AbstractBlock.Properties getTreeProps(){
        return AbstractBlock.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS);
    }
}
