package com.wordpress.craftminemods.moreenchant.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Enchantments;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.DamageSource;
import net.minecraftforge.client.event.sound.SoundEvent;

public class EnchantRiftShield extends Enchantment {

	public EnchantRiftShield() {
		super(Rarity.VERY_RARE, EnumEnchantmentType.ARMOR, new EntityEquipmentSlot[] {EntityEquipmentSlot.CHEST});
		this.setRegistryName("riftShield");
		this.setName("riftShield");
	}

	@Override
	public boolean canApplyTogether(Enchantment ench) {
		return true;

	}

	@Override
	public int getMaxLevel() {
		return 1;
	}

	public boolean isTreasureEnchantment() {
		return true;
	}
}
