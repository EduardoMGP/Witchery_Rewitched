package com.hero.witchery_rewitched.data;

import com.hero.witchery_rewitched.WitcheryRewitched;
import com.hero.witchery_rewitched.init.ModTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.Item;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ObjectHolder;

public class ModItemTagsProvider extends ItemTagsProvider {
    @ObjectHolder("witchery_rewitched:rowan_planks")
    public static final Item ROWAN_PLANKS = null;
    @ObjectHolder("witchery_rewitched:rowan_log")
    public static final Item ROWAN_LOG = null;
    @ObjectHolder("witchery_rewitched:stripped_rowan_log")
    public static final Item STRIPPED_ROWAN_LOG = null;

    @ObjectHolder("witchery_rewitched:alder_planks")
    public static final Item ALDER_PLANKS = null;
    @ObjectHolder("witchery_rewitched:alder_log")
    public static final Item ALDER_LOG = null;
    @ObjectHolder("witchery_rewitched:stripped_alder_log")
    public static final Item STRIPPED_ALDER_LOG = null;

    @ObjectHolder("witchery_rewitched:hawthorn_planks")
    public static final Item HAWTHORN_PLANKS = null;
    @ObjectHolder("witchery_rewitched:hawthorn_log")
    public static final Item HAWTHORN_LOG = null;
    @ObjectHolder("witchery_rewitched:stripped_hawthorn_log")
    public static final Item STRIPPED_HAWTHORN_LOG = null;

    @ObjectHolder("witchery_rewitched:rowan_leaves")
    public static final Item ROWAN_LEAVES = null;
    @ObjectHolder("witchery_rewitched:alder_leaves")
    public static final Item ALDER_LEAVES = null;
    @ObjectHolder("witchery_rewitched:hawthorn_leaves")
    public static final Item HAWTHORN_LEAVES = null;


    public ModItemTagsProvider(DataGenerator generator, BlockTagsProvider blockTags, ExistingFileHelper existingFileHelper) {
        super(generator, blockTags, WitcheryRewitched.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(ItemTags.PLANKS)
                .add(ROWAN_PLANKS)
                .add(ALDER_PLANKS)
                .add(HAWTHORN_PLANKS);

        tag(ItemTags.LOGS)
                .add(ROWAN_LOG)
                .add(ALDER_LOG)
                .add(HAWTHORN_LOG)
                .add(STRIPPED_ALDER_LOG)
                .add(STRIPPED_HAWTHORN_LOG)
                .add(STRIPPED_ROWAN_LOG);

        tag(ItemTags.LOGS_THAT_BURN)
                .add(ROWAN_LOG)
                .add(ALDER_LOG)
                .add(HAWTHORN_LOG)
                .add(STRIPPED_ALDER_LOG)
                .add(STRIPPED_HAWTHORN_LOG)
                .add(STRIPPED_ROWAN_LOG);

        tag(ItemTags.LEAVES)
                .add(ROWAN_LEAVES)
                .add(ALDER_LEAVES)
                .add(HAWTHORN_LEAVES);

        tag(ModTags.Items.ROWAN_LOG)
                .add(ROWAN_LOG)
                .add(STRIPPED_ROWAN_LOG);
        tag(ModTags.Items.HAWTHORN_LOG)
                .add(HAWTHORN_LOG)
                .add(STRIPPED_HAWTHORN_LOG);
        tag(ModTags.Items.ALDER_LOG)
                .add(ALDER_LOG)
                .add(STRIPPED_ALDER_LOG);
    }
}
