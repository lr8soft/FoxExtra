package net.lrsoft.foxbladeex;

import mods.flammpfeil.slashblade.SlashBlade;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {


	  
	 public void preInit(FMLPreInitializationEvent event)
	    {

	     SlashBlade.InitEventBus.register(new ItemSlashblade_foxex());	
	     SlashBlade.InitEventBus.register(new ItemSlashblade_foxex2());	 
	     SlashBlade.InitEventBus.register(new ItemSlashblade_finalfox());
		
     	}
	   public void init(FMLInitializationEvent event)
	   {


	   }

	   public void postInit(FMLPostInitializationEvent event)
	   {

	   }

	
}

