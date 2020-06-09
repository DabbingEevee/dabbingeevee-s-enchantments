package com.wordpress.craftminemods.moreenchant.enchantment;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.wordpress.craftminemods.moreenchant.other.CooldownManager;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Enchantments;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.potion.PotionEffect;

public class EnchantBlasting extends Enchantment{

	public EnchantBlasting() {
		super(Rarity.VERY_RARE, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND});
		this.setRegistryName("blasting");
		this.setName("blasting");
		;
		// TODO Auto-generated constructor stub
	}
    @Override
    public boolean canApplyTogether(Enchantment ench) {
    		return true;
    	
	}
    @Override
	public void onEntityDamaged(EntityLivingBase user, Entity target, int level)
    {
        int fireaspectlevel = EnchantmentHelper.getMaxEnchantmentLevel(Enchantments.FIRE_ASPECT, user);

        //We only continue if the entity has the enchantment and thus the level is higher than 0
        if(fireaspectlevel!=0) {
            target.world.newExplosion(user, target.posX, target.posY, target.posZ, 2, true, false);
        } else {
            target.world.newExplosion(user, target.posX, target.posY, target.posZ, 2, false, false);
        }
        ((EntityLivingBase) user).addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 15, 20));
        user.getActiveItemStack().damageItem(5, user);
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
