package net.lrsoft.foxbladeex.hypersystem;

import mods.flammpfeil.slashblade.ItemSlashBlade;
import mods.flammpfeil.slashblade.entity.EntityWitherSword;
import mods.flammpfeil.slashblade.specialeffect.ISpecialEffect;
import mods.flammpfeil.slashblade.specialeffect.SpecialEffects;
import mods.flammpfeil.slashblade.util.SlashBladeEvent;
import mods.flammpfeil.slashblade.util.SlashBladeHooks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

	public class HS_advance  implements ISpecialEffect {
	    private static final String EffectKey = "HS_advance";
	    private boolean useBlade(ItemSlashBlade.ComboSequence sequence){
	        if(sequence.useScabbard) return false;
	        if(sequence == ItemSlashBlade.ComboSequence.None) return false;
	        if(sequence == ItemSlashBlade.ComboSequence.Noutou) return false;
	        return true;
	    }
	    @SubscribeEvent
	    public void onUpdateItemSlashBlade(final SlashBladeEvent.OnUpdateEvent event){
	               if(!SpecialEffects.isPlayer(event.entity)) return; 
	               EntityPlayer player = (EntityPlayer) event.entity;
	               World world = player.worldObj;
	               NBTTagCompound tag = ItemSlashBlade.getItemTagCompound(event.blade);
	               if(!useBlade(ItemSlashBlade.getComboSequence(tag))) return;
	                
	          if(player.experienceLevel>=60){
	        	    player.addPotionEffect(new PotionEffect(Potion.damageBoost.getId(),100,3));
	        	    player.addPotionEffect(new PotionEffect(Potion.heal.getId(),100,3));
	        	    player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(),100,3));
	        //        for(int i = 0; i < 1;i++){
	                    if(!world.isRemote){
	                    	ItemSlashBlade blade = (ItemSlashBlade)event.blade.getItem();
	                    	boolean isBurst = (1 % 2 == 0);
	                    	EntityWitherSword entityDrive = new EntityWitherSword(world, player, 1.0f,blade.RepairCount.get(tag)*2);
	                        if (entityDrive != null) {
	                            entityDrive.setInterval(16);
	                            entityDrive.setLifeTime(20);
	                            int color = isBurst ? -0xFFFAF0 : -0xFFFFFF;
	                            entityDrive.setColor(color);
	                            entityDrive.setBurst(isBurst);
	                         //   entityDrive.setTargetEntityId(target.getEntityId());
	                            world.spawnEntityInWorld(entityDrive);
	                        }
	                    }
	         //       }

	            }else{
	            	player.addPotionEffect(new PotionEffect(Potion.damageBoost.getId(),80,2));
	            }

	    }

	    @Override
	    public void register() {
	        SlashBladeHooks.EventBus.register(this);
	    }

	    @Override
	    public int getDefaultRequiredLevel() {
	        return 60;
	    }

	    @Override
	    public String getEffectKey() {
	        return EffectKey;
	    }
	    

	}
