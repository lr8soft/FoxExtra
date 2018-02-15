package net.lrsoft.foxbladeex;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import mods.flammpfeil.slashblade.entity.EntitySakuraEndManager;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import mods.flammpfeil.slashblade.specialattack.SpecialAttackBase;

public class SAsakuraend_ex extends SpecialAttackBase {
    @Override
    public String toString() {
        return "sakuraend_ex";
    }

    @Override
    public void doSpacialAttack(ItemStack stack, EntityPlayer player) {
        World world = player.world;

        NBTTagCompound tag = ItemSlashBlade.getItemTagCompound(stack);

        if(!world.isRemote){

            final int cost = -15;
            if(!ItemSlashBlade.ProudSoul.tryAdd(tag,cost,false)){
                ItemSlashBlade.damageItem(stack, 8, player);
            }
            player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH,80,2,true,false));
            player.addPotionEffect(new PotionEffect(MobEffects.SPEED,200,2,true,false));
            ItemSlashBlade blade = (ItemSlashBlade)stack.getItem();

            EntitySakuraEndManager entityDA = new EntitySakuraEndManager(world, player);
            if (entityDA != null) {
                world.spawnEntity(entityDA);
            }
        }

        ItemSlashBlade.setComboSequence(tag, ItemSlashBlade.ComboSequence.SlashEdge);
    }
}