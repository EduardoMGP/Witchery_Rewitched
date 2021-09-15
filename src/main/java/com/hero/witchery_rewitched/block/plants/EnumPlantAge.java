package com.hero.witchery_rewitched.block.plants;

import net.minecraft.util.IStringSerializable;

import java.util.Locale;

public enum EnumPlantAge implements IStringSerializable{
    AGE0,
    AGE1,
    AGE2;

    @Override
    public String getSerializedName() {
        return name().toLowerCase(Locale.ENGLISH);
    }

    public EnumPlantAge getMaxAge(){return AGE2;}

    public EnumPlantAge getMinAge(){return AGE0;}

    @Override
    public String toString() {
        return getSerializedName();
    }

    public EnumPlantAge next()
    {
        switch(this)
        {
            case AGE0:
                return AGE1;
            case AGE1:
                return AGE2;
            case AGE2:
            default:
                return this;
        }
    }
}
