package net.lrsoft.foxbladeex;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import mods.flammpfeil.slashblade.ability.UntouchableTime;
import mods.flammpfeil.slashblade.entity.EntitySpearManager;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import mods.flammpfeil.slashblade.specialattack.SpecialAttackBase;
import mods.flammpfeil.slashblade.util.ReflectionAccessHelper;

public class SAspear_ex extends SpecialAttackBase {
    @Override
    public String toString() {
        return "spearex";
    }

    @Override
    public void doSpacialAttack(ItemStack stack, EntityPlayer player) {
        World world = player.world;

        NBTTagCompound tag = ItemSlashBlade.getItemTagCompound(stack);


        double playerDist = 7;
        float attackDist = (float)(playerDist / 3.0);


        if(!player.onGround)
            playerDist *= 0.35f;
        ReflectionAccessHelper.setVelocity(player,
                -Math.sin(Math.toRadians(player.rotationYaw)) * playerDist,
                player.motionY,
                Math.cos(Math.toRadians(player.rotationYaw)) * playerDist);

        if(!world.isRemote){

            final int cost = -20;
            if(!ItemSlashBlade.ProudSoul.tryAdd(tag,cost,false)){
                ItemSlashBlade.damageItem(stack, 10, player);
            }

            ItemSlashBlade blade = (ItemSlashBlade)stack.getItem();

            player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH,300,1,true,false));
            player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE,300,1,true,false));
            player.addPotionEffect(new PotionEffect(MobEffects.SPEED,250,1,true,false));

            
            EntitySpearManager entityDA = new EntitySpearManager(world, player, false);
            entityDA.setLifeTime(7);
            if (entityDA != null) {
                world.spawnEntity(entityDA);
            }
        }

        UntouchableTime.setUntouchableTime(player, 10);

        player.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F);
        ItemSlashBlade.setComboSequence(tag, ItemSlashBlade.ComboSequence.HiraTuki);
    }
}