package net.lrsoft.foxbladeex;

import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.named.event.LoadEvent;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = foxaddon.MODID,name="FoxBlade Extra",  version = foxaddon.VERSION,dependencies="required-after:flammpfeil.slashblade")
public class foxaddon
{
    public static final String MODID = "foxex";
    public static final String VERSION = "1.0.1";
	@SidedProxy(clientSide="net.lrsoft.foxbladeex.ClientProxy",
			serverSide="net.lrsoft.foxbladeex.CommonProxy")
    public static CommonProxy proxy; 
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }

	}

