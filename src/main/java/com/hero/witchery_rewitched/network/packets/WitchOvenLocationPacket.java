package com.hero.witchery_rewitched.network.packets;

import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class WitchOvenLocationPacket {
    public final BlockPos pos;

    public WitchOvenLocationPacket(BlockPos pos){
        this.pos = pos;
    }

    public static WitchOvenLocationPacket decode(PacketBuffer buffer){
        return new WitchOvenLocationPacket(buffer.readBlockPos());
    }

    public void encode(PacketBuffer buffer){
        buffer.writeBlockPos(pos);
    }

    public void handle(Supplier<NetworkEvent.Context> context){
        context.get().setPacketHandled(true);
    }
}
