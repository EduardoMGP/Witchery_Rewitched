package com.hero.witchery_rewitched.data;

import com.hero.witchery_rewitched.WitcheryRewitched;
import com.hero.witchery_rewitched.init.ModBlocks;
import com.hero.witchery_rewitched.init.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ObjectHolder;

public class ModBlockTagsProvider extends BlockTagsProvider {
    @ObjectHolder("witchery_rewitched:rowan_sapling")
    public static final Block ROWAN_SAPLING = null;
    @ObjectHolder("witchery_rewitched:alder_sapling")
    public static final Block ALDER_SAPLING = null;
    @ObjectHolder("witchery_rewitched:hawthorn_sapling")
    public static final Block HAWTHORN_SAPLING = null;


    public ModBlockTagsProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, WitcheryRewitched.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(BlockTags.LOGS)
                .add(ModBlocks.ROWAN_LOG.get())
                .add(ModBlocks.ALDER_LOG.get())
                .add(ModBlocks.HAWTHORN_LOG.get())
                .add(ModBlocks.STRIPPED_ALDER_LOG.get())
                .add(ModBlocks.STRIPPED_ROWAN_LOG.get())
                .add(ModBlocks.STRIPPED_HAWTHORN_LOG.get());
        tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.ROWAN_LOG.get())
                .add(ModBlocks.ALDER_LOG.get())
                .add(ModBlocks.HAWTHORN_LOG.get())
                .add(ModBlocks.STRIPPED_ALDER_LOG.get())
                .add(ModBlocks.STRIPPED_ROWAN_LOG.get())
                .add(ModBlocks.STRIPPED_HAWTHORN_LOG.get());
        tag(BlockTags.PLANKS)
                .add(ModBlocks.ROWAN_PLANKS.get())
                .add(ModBlocks.ALDER_LOG.get())
                .add(ModBlocks.HAWTHORN_LOG.get());

        tag((BlockTags.LEAVES))
                .add(ModBlocks.ROWAN_LEAVES.get())
                .add(ModBlocks.ALDER_LEAVES.get())
                .add(ModBlocks.HAWTHORN_LEAVES.get());

        tag(BlockTags.SAPLINGS)
                .add(ModBlocks.ROWAN_SAPLING.get())
                .add(ModBlocks.ALDER_SAPLING.get())
                .add(ModBlocks.HAWTHORN_SAPLING.get());

        tag(ModTags.Blocks.MUTANDIS_PLANTS)
                .addTag(BlockTags.SMALL_FLOWERS)
                .addTag(BlockTags.SAPLINGS)
                .add(Blocks.GRASS)
                .add(ROWAN_SAPLING)
                .add(Blocks.TALL_GRASS)
                .add(ALDER_SAPLING)
                .add(HAWTHORN_SAPLING)
                .add(ModBlocks.SPANISH_MOSS.get())
                .add(ModBlocks.EMBER_MOSS.get())
                .add(ModBlocks.GLINTWEED.get());

        tag(ModTags.Blocks.WITCH_LEAVES)
                .add(ModBlocks.ROWAN_LEAVES.get())
                .add(ModBlocks.ALDER_LEAVES.get())
                .add(ModBlocks.HAWTHORN_LEAVES.get());

        tag(ModTags.Blocks.WITCH_LOG)
                .add(ModBlocks.ROWAN_LOG.get())
                .add(ModBlocks.ALDER_LOG.get())
                .add(ModBlocks.HAWTHORN_LOG.get());

        tag(BlockTags.CROPS)
                .add(ModBlocks.BELLADONNA.get())
                .add(ModBlocks.GARLIC.get())
                .add(ModBlocks.SNOWBELL.get())
                .add(ModBlocks.WOLFSBANE.get())
                .add(ModBlocks.WATER_ARTICHOKE.get());

        tag(ModTags.Blocks.MUTANDIS_EXTREMIS_PLANTS)
                .addTag(BlockTags.CROPS)
                .add(Blocks.SUGAR_CANE)
                .add(Blocks.CACTUS);
    }
}
