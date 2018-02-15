package net.lrsoft.foxbladeex;
import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import mods.flammpfeil.slashblade.ItemRendererBaseWeapon;
import mods.flammpfeil.slashblade.SlashBlade;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.client.MinecraftForgeClient;
import net.lrsoft.foxbladeex.ItemSlashblade_foxex;
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