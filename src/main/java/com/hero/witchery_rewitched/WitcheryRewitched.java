package com.hero.witchery_rewitched;

import com.hero.witchery_rewitched.init.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("witchery_rewitched")
public class WitcheryRewitched
{
    // Directly reference a log4j logger.
    public static final boolean DEBUG = false;
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "witchery_rewitched";
    public static IProxy PROXY;
    public static final ItemGroup WITCHERY_GROUP  = new WitcheryRewitchedGroup("witchrewitchedtab");
    public WitcheryRewitched() {
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        GeckoLib.initialize();
        PROXY = DistExecutor.safeRunForDist(() -> SideProxy.Client::new, () -> SideProxy.Server::new);
    }


    public static class WitcheryRewitchedGroup extends ItemGroup {

        public WitcheryRewitchedGroup(String label) {
            super(label);
        }

        @Override
        public ItemStack makeIcon() {
            return ModItems.UNCOOKED_CLAY_POT.get().getDefaultInstance();
        }
    }
}

