package com.hero.witchery_rewitched.block.altar;


import com.hero.witchery_rewitched.init.ModContainers;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IntArray;

public class AltarContainer extends Container {
    private final IIntArray fields;

    public AltarContainer(ContainerType<?> type, int id,PacketBuffer data) {
        this(type, id, new IntArray(data.readByte()));
    }

    public AltarContainer(ContainerType<?> type, int id, IIntArray fields) {
        super(type, id);
        this.fields = fields;
        addDataSlots(this.fields);
    }

    public int getRechargeRate() {
        return fields.get(0);
    }

    public int getMaxEnergy() {
        return fields.get(1);
    }

    public int getEnergy() {
        return fields.get(2);
    }

    @Override
    public boolean stillValid(PlayerEntity playerIn) {
        return true;
    }

    public static Container createAltar(int id, IIntArray fields) {
        return new AltarContainer(ModContainers.ALTAR.get(), id, fields);
    }
}
