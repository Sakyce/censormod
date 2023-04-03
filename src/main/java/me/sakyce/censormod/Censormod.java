package me.sakyce.censormod;

import com.mojang.logging.LogUtils;
import me.sakyce.censormod.block.ModBlocks;
import me.sakyce.censormod.item.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("censormod")
public class Censormod {

    // Directly reference a slf4j logger
    public static final String MODID = "censormod";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Censormod() {
        // Register ourselves for server and other game events we are interested in
        IEventBus EventBussy = FMLJavaModLoadingContext.get().getModEventBus();
        
        ModBlocks.register(EventBussy);
        ModItems.register(EventBussy);

        MinecraftForge.EVENT_BUS.addListener(CensorshipProcedure::onChat);

        MinecraftForge.EVENT_BUS.register(this);
    }

}