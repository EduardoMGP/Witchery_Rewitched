package com.hero.witchery_rewitched.entity.ent;

import com.hero.witchery_rewitched.init.ModEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.FMLPlayMessages;

public class EntEntity extends MonsterEntity {
    private int variant = 0;


    public EntEntity(EntityType<? extends MonsterEntity> type, World worldIn){super(type, worldIn);}
    public EntEntity(FMLPlayMessages.SpawnEntity message, World world){this(ModEntities.ENT.get(), world);}

    public static AttributeModifierMap.MutableAttribute registerAttributes(){
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 12.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.1F)
                .add(Attributes.ATTACK_DAMAGE, 7)
                .add(Attributes.KNOCKBACK_RESISTANCE, 11);
    }

    @Override
    protected void registerGoals() {
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
