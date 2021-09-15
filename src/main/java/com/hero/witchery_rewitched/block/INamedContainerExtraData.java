package com.hero.witchery_rewitched.block;

import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.network.PacketBuffer;

public interface INamedContainerExtraData extends INamedContainerProvider {
    void encodeExtraData(PacketBuffer buffer);
}
