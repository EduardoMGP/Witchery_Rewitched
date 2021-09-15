package com.hero.witchery_rewitched.data.loot;

import com.hero.witchery_rewitched.WitcheryRewitched;
import com.hero.witchery_rewitched.init.ModLootTableModifiers;
import net.minecraft.data.DataGenerator;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

public class ModLootModifierProvider extends GlobalLootModifierProvider {
    public ModLootModifierProvider(DataGenerator gen) {
        super(gen, WitcheryRewitched.MODID);
    }

    @Override
    protected void start() {
        add("grass", ModLootTableModifiers.GRASS_DROPS.get(), new GrassDropModifier.SeedDropModifier(new ILootCondition[]{}));
    }
}
