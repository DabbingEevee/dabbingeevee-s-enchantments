package com.wordpress.craftminemods.moreenchant.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.enchantment.Enchantment.Rarity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.potion.PotionEffect;

public class EnchantLifting extends Enchantment {

	public EnchantLifting() {
		super(Rarity.UNCOMMON, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND});
		this.setRegistryName("lifting");
		this.setName("lifting");
		// this.onEntityDamaged(user, target, level){
		//
		// }
	}
	
    @Override
	public void onEntityDamaged(EntityLivingBase user, Entity target, int level)
    {
        if (target instanceof EntityLivingBase)
        {
                target.motionY += level*0.20;
            
        }
    }
    
	@Override
	public int getMaxLevel()
	{
		return 3;
	}



}
