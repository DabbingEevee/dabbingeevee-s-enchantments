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
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;

public class EnchantWatering extends Enchantment{

	public EnchantWatering() {
		super(Rarity.VERY_RARE, EnumEnchantmentType.ALL, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND});
		this.setRegistryName("watering");
		this.setName("watering");
		// TODO Auto-generated constructor stub
	}
    @Override
    public boolean canApplyTogether(Enchantment ench) {
    		return true;
    	
	}    
	@Override
	public int getMaxLevel()
	{
		return 1;
	}
	@Override
	public boolean isTreasureEnchantment() {
		return true;
	}
	@Override
	public boolean canApply(ItemStack stack) {
		if(stack.getItem() instanceof ItemHoe) {
			return true;
		} else {
			return false;
		}
	}
}
