package com.hero.witchery_rewitched;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;

import javax.annotation.Nullable;

public interface IProxy {
    @Nullable
    PlayerEntity getClientPlayer();

    @Nullable
    MinecraftServer getServer();
}
