package net.lrsoft.foxbladeex;


import mods.flammpfeil.slashblade.ItemSlashBladeNamed;
import mods.flammpfeil.slashblade.RecipeAwakeBlade;
import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import mods.flammpfeil.slashblade.named.Fox;
import mods.flammpfeil.slashblade.named.NamedBladeManager;
import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.named.event.LoadEvent.InitEvent;
import mods.flammpfeil.slashblade.stats.AchievementList;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
public class ItemSlashblade_foxex2 {
	public static ItemSlashBladeNamed bladeNamed;
	   @SubscribeEvent
	   public void init(InitEvent event) {
	      String name = "flammpfeil.slashblade.named.foxex2";
	      ItemStack customblade = new ItemStack(SlashBlade.bladeNamed, 1, 0);
///////////////////////////////////////////////////////////////////////////////////////////	   
	      ItemSlashBlade.specialAttacks.put(Integer.valueOf(12076), new SAspear_ex());
	      NBTTagCompound tag = new NBTTagCompound();//NBT
	      customblade.setTagCompound(tag);
	      ItemSlashBladeNamed.CurrentItemName.set(tag, name);
	      ItemSlashBladeNamed.CustomMaxDamage.set(tag, Integer.valueOf(141));//141
	      ItemSlashBlade.setBaseAttackModifier(tag, 12.0f);//+12s
	      ItemSlashBladeNamed.IsDefaultBewitched.set(tag, Boolean.valueOf(true));//
	      ItemSlashBlade.TextureName.set(tag, "named/foxex/texture2");
	      ItemSlashBlade.ModelName.set(tag, "named/foxex/model");
	      ItemSlashBlade.SpecialAttackType.set(tag, Integer.valueOf(12076));//saex
	      ItemSlashBlade.StandbyRenderType.set(tag, Integer.valueOf(1));//
	      SlashBlade.registerCustomItemStack(name, customblade);
	      ItemSlashBladeNamed.NamedBlades.add(name);
	      customblade.addEnchantment(Enchantments.POWER, 3);//
	      customblade.addEnchantment(Enchantments.SMITE, 5);
	      customblade.addEnchantment(Enchantments.BANE_OF_ARTHROPODS, 5);
	      customblade.addEnchantment(Enchantments.UNBREAKING, 3);
	      
          ItemStack custombladeReqired2 = SlashBlade.findItemStack(SlashBlade.modid,Fox.nameBlack,1); 
	      NBTTagCompound reqTag2 = ItemSlashBlade.getItemTagCompound(custombladeReqired2);//
	      ItemSlashBlade.KillCount.set(reqTag2, Integer.valueOf(1000));
	      ItemSlashBlade.ProudSoul.set(reqTag2, Integer.valueOf(12000));
          ItemSlashBlade.RepairCount.set(reqTag2, Integer.valueOf(6));
          ItemSlashBladeNamed.IsDefaultBewitched.set(reqTag2, Boolean.valueOf(true));
          ItemStack foxex = SlashBlade.findItemStack("flammpfeil.slashblade", name, 1);  
	      SlashBlade.addRecipe(name, new RecipeAwakeBlade(foxex, custombladeReqired2, 
	    		  new Object[]{"CAC",
	    		               "XBX",
	    		               "CXC",
	    		  Character.valueOf('A'), new ItemStack(Items.NETHER_STAR),
	    		  Character.valueOf('B'), custombladeReqired2,
	    		  Character.valueOf('C'), new ItemStack(Blocks.OBSIDIAN), 
	    		  Character.valueOf('X'),new ItemStack(Blocks.DIAMOND_BLOCK)
	    		  }));
////////////////////////////////////////////////////////////////////////////////////////////////////	      
	      NamedBladeManager.registerBladeSoul(tag, "foxex2");
	      AchievementList.registerCraftingAchievement(name, customblade, AchievementList.getAchievement(name));
          
	   }
}
