package com.hero.witchery_rewitched.entity.mandrake;

import com.hero.witchery_rewitched.entity.ai.MandrakePanicGoal;
import com.hero.witchery_rewitched.init.ModEntities;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.FMLPlayMessages;

public class MandrakeEntity extends CreatureEntity {
    private MandrakePanicGoal panicGoal;

    public MandrakeEntity(EntityType<? extends  CreatureEntity> type, World worldIn){super(type, worldIn);}
    public MandrakeEntity(FMLPlayMessages.SpawnEntity message, World world) {
        this(ModEntities.MANDRAKE.get(), world);
    }

    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 3.0D).add(Attributes.MOVEMENT_SPEED, (double)0.23F);
    }


    @Override
    protected void registerGoals() {
        this.panicGoal = new MandrakePanicGoal(this, 2D);
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, panicGoal);
        super.registerGoals();
    }

    @Override
    public boolean checkSpawnRules(IWorld worldIn, SpawnReason spawnReasonIn) {
        switch (spawnReasonIn){
            case EVENT:
            case TRIGGERED:
            case MOB_SUMMONED:
            case DISPENSER:
            case COMMAND:
                return true;
            default:
                return false;
        }
    }



}
