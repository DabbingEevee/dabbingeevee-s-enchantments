package com.wordpress.craftminemods.moreenchant.enchantment;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.wordpress.craftminemods.moreenchant.other.CooldownManager;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.init.Enchantments;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.potion.PotionEffect;

public class EnchantStriking extends Enchantment{

	public EnchantStriking() {
		super(Rarity.VERY_RARE, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND});
		this.setRegistryName("striking");
		this.setName("striking");
		;
		// TODO Auto-generated constructor stub
	}
    @Override
    public boolean canApplyTogether(Enchantment ench) {
    	if(ench == Enchantments.SHARPNESS) {
    		return false;
    	}
    	else
    	{
    		return true;
    	}
	}
    @Override
	public void onEntityDamaged(EntityLivingBase user, Entity target, int level)
    {
        //if (target instanceof EntityLivingBase)
        //{
    	//PotionEffect[] currentpotion = ((List<PotionEffect>) user.getActivePotionEffects()).toArray(new PotionEffect[0]);
    	
        ((EntityLivingBase) user).addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 15, 20));
        target.world.addWeatherEffect(new EntityLightningBolt(target.world, (int) target.posX,target.posY,target.posZ, false));
        user.getActiveItemStack().damageItem(2, user);
		//CooldownManager.cooldown(user, 600);
        /*try {
			TimeUnit.MINUTES.sleep((long) 0.75);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        for(PotionEffect p : currentpotion) {
        	if(p.getPotion() == MobEffects.RESISTANCE) {
                ((EntityLivingBase) user).addPotionEffect(p);
                break;
        	}
        }*/
        

        //ExampleMod.logger.info("duck");

        //}
    }
    
	@Override
	public int getMaxLevel()
	{
		return 1;
	}
	public boolean isTreasureEnchantment() {
		return true;
	}
}
