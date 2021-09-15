package com.hero.witchery_rewitched.init;

import com.hero.witchery_rewitched.block.altar.AltarContainer;
import com.hero.witchery_rewitched.block.altar.AltarScreen;
import com.hero.witchery_rewitched.block.distillery.DistilleryContainer;
import com.hero.witchery_rewitched.block.distillery.DistilleryScreen;
import com.hero.witchery_rewitched.block.witch_oven.WitchOvenContainer;
import com.hero.witchery_rewitched.block.witch_oven.WitchOvenScreen;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.network.IContainerFactory;

public class ModContainers {

    public static final RegistryObject<ContainerType<WitchOvenContainer>> WITCH_OVEN = register("witch_oven",
            (id, playerInventory, buffer) -> new WitchOvenContainer(getWitchOven(),
                    id,
                    playerInventory,
                    buffer)
    );

    public static final RegistryObject<ContainerType<AltarContainer>> ALTAR = register( "altar",
            (id, playerInventory, buffer) -> new AltarContainer(getAltar(),
                    id,
                    buffer)
    );

    public static final RegistryObject<ContainerType<DistilleryContainer>> DISTILLERY = register("distillery",
            (id, playerInventory, buffer) -> new DistilleryContainer(getDistillery(),
                    id,
                    playerInventory,
                    buffer)
    );

    static void register(){}

    @OnlyIn(Dist.CLIENT)
    public static void registerScreens(FMLClientSetupEvent event){
        ScreenManager.register(WITCH_OVEN.get(), WitchOvenScreen::new);
        ScreenManager.register(ALTAR.get(), AltarScreen::new);
        ScreenManager.register(DISTILLERY.get(), DistilleryScreen::new);
    }

    public static <T extends Container> RegistryObject<ContainerType<T>> register(String name, IContainerFactory<T> factory){
        return RegistryHandler.CONTAINERS.register(name, () -> IForgeContainerType.create(factory));
    }

    private static ContainerType<?> getWitchOven(){
        return WITCH_OVEN.get();
    }
    private static ContainerType<?> getAltar() {return ALTAR.get();}
    private static ContainerType<?> getDistillery(){return DISTILLERY.get();}
}