package com.hero.witchery_rewitched.api.capabilities.player;

import java.util.UUID;

public interface IPlayer {
    void setPlayerID(UUID id);
    UUID getPlayerID();
}
