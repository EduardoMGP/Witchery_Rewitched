package com.hero.witchery_rewitched.init;

import com.hero.witchery_rewitched.WitcheryRewitched;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

public class ModTags {

    public static final class Items {
        public static final ITag.INamedTag<Item> ROWAN_LOG = mod("logs/rowan");
        public static final ITag.INamedTag<Item> ALDER_LOG = mod("logs/alder");
        public static final ITag.INamedTag<Item> HAWTHORN_LOG = mod("logs/hawthorn");

        private static ITag.INamedTag<Item> mod(String path){
            return ItemTags.bind(new ResourceLocation(WitcheryRewitched.MODID, path).toString());
        }
    }

    public static final class Blocks{
        public static final ITag.INamedTag<Block> MUTANDIS_EXTREMIS_PLANTS = mod("mutandis_extremis_plants");
        public static final ITag.INamedTag<Block> MUTANDIS_PLANTS = mod("mutandis_plants");
        public static final ITag.INamedTag<Block> WITCH_LOG = mod("witch_log");
        public static final ITag.INamedTag<Block> WITCH_LEAVES = mod("witch_leaves");
        private static ITag.INamedTag<Block> mod(String path){
            return BlockTags.bind(new ResourceLocation(WitcheryRewitched.MODID, path).toString());
        }
    }
}
