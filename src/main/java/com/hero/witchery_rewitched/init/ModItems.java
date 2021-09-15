package com.hero.witchery_rewitched.init;

import com.hero.witchery_rewitched.WitcheryRewitched;
import com.hero.witchery_rewitched.item.*;
import com.hero.witchery_rewitched.item.ChalkBase;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.fml.RegistryObject;

import java.rmi.registry.Registry;
import java.util.function.Supplier;

public class ModItems {

    public static final RegistryObject<Item> UNCOOKED_CLAY_POT =                createItem("uncooked_clay_pot");
    public static final RegistryObject<Item> COOKED_CLAY_POT =                  createItem("cooked_clay_pot");
    public static final RegistryObject<Item> ROWAN_BERRY =                      createItem("rowan_berries", () -> new Item(getBaseProps().food(createFood(1,4))));

    public static final RegistryObject<Item> BREATH_OF_THE_GODDESS =            createItem("breath_of_the_goddess");
    public static final RegistryObject<Item> EXHALE_OF_THE_HORNED_ONE =         createItem("exhale_of_the_horned_one");
    public static final RegistryObject<Item> FOUL_FUME =                        createItem("foul_fume");
    public static final RegistryObject<Item> HINT_OF_REBIRTH =                  createItem("hint_of_rebirth");
    public static final RegistryObject<Item> ODOR_OF_PURITY =                   createItem("odor_of_purity");
    public static final RegistryObject<Item> REEK_OF_MISFORTUNE =               createItem("reek_of_misfortune");
    public static final RegistryObject<Item> WHIFF_OF_MAGIC =                   createItem("whiff_of_magic");
    public static final RegistryObject<Item> WOOD_ASH =                         createItem("wood_ash");

    public static final RegistryObject<Item> BELLADONNA =                       createItem("belladonna");
    public static final RegistryObject<Item> BELLADONNA_SEEDS =                 createItem("belladonna_seeds", () -> new SeedItem(ModBlocks.BELLADONNA.get(), getBaseProps()));
    public static final RegistryObject<Item> GARLIC =                           createItem("garlic", () -> new SeedItem(ModBlocks.GARLIC.get(), getBaseProps().food(createFood(1,1))));
    public static final RegistryObject<Item> SNOWBELL_SEEDS =                   createItem("snowbell_seeds", () -> new SeedItem(ModBlocks.SNOWBELL.get(), getBaseProps()));
    public static final RegistryObject<Item> ICY_NEEDLE =                       createItem("icy_needle");
    public static final RegistryObject<Item> WATER_ARTICHOKE_BULB =             createItem("water_artichoke_bulb");
    public static final RegistryObject<Item> WATER_ARTICHOKE_SEEDS =            createItem("water_artichoke_seeds", ()-> new WaterArtichokeSeed(ModBlocks.WATER_ARTICHOKE.get(), getBaseProps()));
    public static final RegistryObject<Item> WOLFSBANE =                        createItem("wolfsbane");
    public static final RegistryObject<Item> WOLFSBANE_SEEDS =                  createItem("wolfsbane_seeds", () -> new SeedItem(ModBlocks.WOLFSBANE.get(), getBaseProps()));
    public static final RegistryObject<Item> MANDRAKE_ROOT =                    createItem("mandrake_root");
    public static final RegistryObject<Item> MANDRAKE_SEEDS =                   createItem("mandrake_seeds", () -> new SeedItem(ModBlocks.MANDRAKE.get(), getBaseProps()));
    public static final RegistryObject<Item> ANOINTING_PASTE =                  createItem("anointing_paste", () -> new AnointingPaste(getBaseProps()));
    public static final RegistryObject<Item> MUTANDIS =                         createItem("mutandis", () -> new Mutandis(getBaseProps(), false));
    public static final RegistryObject<Item> MUTANDIS_EXTREMIS =                createItem("mutandis_extremis", () -> new Mutandis(getBaseProps(), true));
    public static final RegistryObject<Item> ATTUNED_STONE =                    createItem("attuned_stone");
    public static final RegistryObject<Item> CHARGED_ATTUNED_STONE =            createItem("charged_attuned_stone");
    public static final RegistryObject<Item> FUME_FILTER =                      createItem("fume_filter");
    public static final RegistryObject<Item> TAGLOCK_KIT =                      createItem("taglock_kit", () -> new TaglockKit(getBaseProps()));
    public static final RegistryObject<Item> FILLED_TAGLOCK =                   createItem("filled_taglock", () -> new Taglock(new Item.Properties()));
    public static final RegistryObject<Item> BONE_NEEDLE =                      createItem("bone_needle");
    public static final RegistryObject<Item> GOLD_CHALK =                       createItem("gold_chalk", () -> new ChalkBase(getBaseProps(), ModBlocks.GOLD_GLYPH));
    public static final RegistryObject<Item> RITUAL_CHALK =                     createItem("ritual_chalk", () -> new ChalkBase(getBaseProps(), ModBlocks.RITUAL_GLYPH));
    public static final RegistryObject<Item> OTHERWHERE_CHALK =                 createItem("otherwhere_chalk", () -> new ChalkBase(getBaseProps(), ModBlocks.OTHERWHERE_GLYPH));
    public static final RegistryObject<Item> INFERNAL_CHALK =                   createItem("infernal_chalk", () -> new ChalkBase(getBaseProps(), ModBlocks.INFERNAL_GLYPH));
    public static final RegistryObject<Item> GYPSUM =                           createItem("gypsum");
    public static final RegistryObject<Item> OIL_OF_VITRIOL =                   createItem("oil_of_vitriol");
    public static final RegistryObject<Item> QUICKLIME =                        createItem("quicklime");

    public static final RegistryObject<Item> POPPET =                           createItem("poppet");
    public static final RegistryObject<Item> EARTH_PROTECTION_POPPET =          createItem("earth_protection_poppet", () -> new PoppetBase(getBaseProps()));
    public static final RegistryObject<Item> WATER_PROTECTION_POPPET =          createItem("water_protection_poppet", () -> new PoppetBase(getBaseProps()));
    public static final RegistryObject<Item> FIRE_PROTECTION_POPPET =           createItem("fire_protection_poppet", () -> new PoppetBase(getBaseProps()));
    public static final RegistryObject<Item> HUNGER_PROTECTION_POPPET =         createItem("hunger_protection_poppet", () -> new PoppetBase(getBaseProps()));
    public static final RegistryObject<Item> DEATH_PROTECTION_POPPET =          createItem("death_protection_poppet", () -> new PoppetBase(getBaseProps()));
    public static final RegistryObject<Item> TOOL_PROTECTION_POPPET =           createItem("tool_protection_poppet", () -> new PoppetBase(getBaseProps()));
    public static final RegistryObject<Item> ARMOR_PROTECTION_POPPET =          createItem("armor_protection_poppet", () -> new PoppetBase(getBaseProps()));
    public static final RegistryObject<Item> DROP_OF_LUCK =                     createItem("drop_of_luck");
    public static final RegistryObject<Item> REFINED_EVIL =                     createItem("refined_evil");
    public static final RegistryObject<Item> DIAMOND_VAPOR =                    createItem("diamond_vapor");
    public static final RegistryObject<Item> TEAR_OF_THE_GODDESS =              createItem("tear_of_the_goddess");
    public static final RegistryObject<Item> WOOL_OF_BAT =                      createItem("wool_of_bat");
    public static final RegistryObject<Item> ARTHANA =                          createItem("arthana", () -> new Arthana(getBaseProps()));
    public static final RegistryObject<Item> WAYSTONE =                         createItem("waystone", () -> new Waystone(getBaseProps()));
    public static final RegistryObject<Item> BOUND_WAYSTONE =                   createItem("bound_waystone", () -> new BoundWaystone(new Item.Properties()));
    public static final RegistryObject<Item> ENDER_DEW =                        createItem("ender_dew");

    public static RegistryObject<Item> createItem(String name)
    {
        return RegistryHandler.ITEMS.register(name,
                () -> new Item( new Item.Properties().tab(WitcheryRewitched.WITCHERY_GROUP)));
    }

    public static Item.Properties getBaseProps(){
       return new Item.Properties().tab(WitcheryRewitched.WITCHERY_GROUP);
    }

    public static RegistryObject<Item> createItem(String name, Supplier<Item> supplier){
        return RegistryHandler.ITEMS.register(name, supplier);
    }

    private static Food createFood(int hunger, int saturation){
        return new Food.Builder().nutrition(hunger).saturationMod(saturation).build();
    }

    public static void register(){if(WitcheryRewitched.DEBUG){createItem("debug", ()  -> new Debug(getBaseProps()));}};
}
