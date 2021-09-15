package com.hero.witchery_rewitched.entity.ai;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;

public class MandrakePanicGoal extends PanicGoal {
    public MandrakePanicGoal(CreatureEntity creature, double speedIn) {
        super(creature, speedIn);
    }

    @Override
    public void tick() {
        if(mob.level.random.nextInt(50) == 0){
            mob.playSound(SoundEvents.GHAST_WARN, 1.0F + mob.level.random.nextFloat(), mob.level.random.nextFloat() * .5F + 1F);
        }
        super.tick();
    }

    @Override
    public boolean canUse() {
        BlockPos blockpos = this.lookForWater(this.mob.level, this.mob, 5, 4);
        if (blockpos != null) {
            this.posX = (double)blockpos.getX();
            this.posY = (double)blockpos.getY();
            this.posZ = (double)blockpos.getZ();
        }

        return this.findRandomPosition();
    }
}
