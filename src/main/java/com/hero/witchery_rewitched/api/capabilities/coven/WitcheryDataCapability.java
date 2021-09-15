package com.hero.witchery_rewitched.api.capabilities.coven;

import com.hero.witchery_rewitched.WitcheryRewitched;
import com.hero.witchery_rewitched.api.capabilities.poppet_worlds.PoppetWorldCapability;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class WitcheryDataCapability implements IWitcheryData, ICapabilitySerializable<CompoundNBT> {
    @CapabilityInject(IWitcheryData.class)
    public static Capability<IWitcheryData> INSTANCE = null;
    public static ResourceLocation NAME = new ResourceLocation(WitcheryRewitched.MODID, "witchery_data");

    private static final String NBT_COVEN = "COVEN_SIZE";

    private final LazyOptional<IWitcheryData> holder = LazyOptional.of(() -> this);

    private int covenSize;


    @Override
    public int getCovenSize() {
        return covenSize;
    }

    @Override
    public void setCovenSize(int size) {
        covenSize = size;
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if(INSTANCE == null)
            throw new IllegalStateException("Capabilities failed to initialize");
        return INSTANCE.orEmpty(cap, holder);
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT nbt = new CompoundNBT();
        nbt.putInt(NBT_COVEN, covenSize);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        covenSize = nbt.getInt(NBT_COVEN);
    }

    public static void register(){
        CapabilityManager.INSTANCE.register(IWitcheryData.class, new Storage(), WitcheryDataCapability::new);
    }

    public static boolean canAttachTo(ICapabilityProvider obj){
        return obj instanceof PlayerEntity && !obj.getCapability(INSTANCE).isPresent();
    }

    private static class Storage implements Capability.IStorage<IWitcheryData> {
        @Nullable
        @Override
        public INBT writeNBT(Capability<IWitcheryData> capability, IWitcheryData instance, Direction side) {
            if (instance instanceof WitcheryDataCapability) {
                return ((WitcheryDataCapability) instance).serializeNBT();
            }
            return new CompoundNBT();
        }

        @Override
        public void readNBT(Capability<IWitcheryData> capability, IWitcheryData instance, Direction side, INBT nbt) {
            if (instance instanceof WitcheryDataCapability) {
                ((WitcheryDataCapability) instance).deserializeNBT((CompoundNBT) nbt);
            }
        }
    }

    @SubscribeEvent
    public static void onAttachEntityCapabilities(AttachCapabilitiesEvent<Entity> event) {
        Entity entity = event.getObject();
        if(canAttachTo(entity)) {
            event.addCapability(NAME, new WitcheryDataCapability());
            event.addCapability(PoppetWorldCapability.NAME, new PoppetWorldCapability());
        }
    }

    @SubscribeEvent
    public static void cloneEvent(PlayerEvent.Clone event){
        event.getOriginal().getCapability(WitcheryDataCapability.INSTANCE).ifPresent(source ->
                event.getPlayer().getCapability(WitcheryDataCapability.INSTANCE).ifPresent(dest ->
                        dest.setCovenSize(source.getCovenSize())));

        event.getOriginal().getCapability(PoppetWorldCapability.INSTANCE).ifPresent(source ->
                event.getPlayer().getCapability(PoppetWorldCapability.INSTANCE).ifPresent(dest ->
                        dest.setShelves(source.getShelves())));
    }
}

