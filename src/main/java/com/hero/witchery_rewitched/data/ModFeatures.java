package com.hero.witchery_rewitched.data;

import com.hero.witchery_rewitched.init.ModBlocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.*;
import net.minecraft.world.gen.trunkplacer.FancyTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.ForkyTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

import java.util.OptionalInt;

public class ModFeatures {
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> ROWAN = register("rowan",
            Feature.TREE.configured(
                    (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.ROWAN_LOG.get().defaultBlockState()),
                            new SimpleBlockStateProvider(ModBlocks.ROWAN_LEAVES.get().defaultBlockState()),
                            new BlobFoliagePlacer(FeatureSpread.fixed(3), FeatureSpread.fixed(1), 4),
                            new StraightTrunkPlacer(5, 0, 0),
                            new TwoLayerFeature(2, 0, 2))).ignoreVines().build()
            )
    );
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> ALDER = register("alder",
            Feature.TREE.configured(
                    (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.ALDER_LOG.get().defaultBlockState()),
                            new SimpleBlockStateProvider(ModBlocks.ALDER_LEAVES.get().defaultBlockState()),
                            new FancyFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(2), 4),
                            new FancyTrunkPlacer(8, 2, 0),
                            new TwoLayerFeature(1, 0, 2, OptionalInt.of(4)))
                    ).ignoreVines().heightmap(Heightmap.Type.MOTION_BLOCKING).build()
            )
    );
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> HAWTHORN = register("hawthorn",
            Feature.TREE.configured(
                    (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.HAWTHORN_LOG.get().defaultBlockState()),
                            new SimpleBlockStateProvider(ModBlocks.HAWTHORN_LEAVES.get().defaultBlockState()),
                            new JungleFoliagePlacer(FeatureSpread.of(0, 2), FeatureSpread.of(0, 1), 3),
                            // Height,
                            new ForkyTrunkPlacer(5, 2, 0),
                            new TwoLayerFeature(1, 0, 2))).ignoreVines().build()
            )
    );
    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key, configuredFeature);
    }


}
