package com.hero.witchery_rewitched.init;
import com.hero.witchery_rewitched.WitcheryRewitched;
import com.hero.witchery_rewitched.data.loot.GrassDropModifier;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = WitcheryRewitched.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModLootTableModifiers {
    public static final RegistryObject<GlobalLootModifierSerializer<GrassDropModifier.SeedDropModifier>> GRASS_DROPS = RegistryHandler.LOOT_MODIFIER_SERIALIZERS.register("grass", GrassDropModifier.Serializer::new);

    public static void register(){
    }

}
