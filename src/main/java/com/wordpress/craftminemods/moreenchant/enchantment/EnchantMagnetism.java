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

public class EnchantMagnetism extends Enchantment {

	public EnchantMagnetism() {
		super(Rarity.VERY_RARE, EnumEnchantmentType.ARMOR, new EntityEquipmentSlot[] { EntityEquipmentSlot.HEAD,
				EntityEquipmentSlot.CHEST, EntityEquipmentSlot.LEGS, EntityEquipmentSlot.FEET });
		this.setRegistryName("magnetism");
		this.setName("magnetism");
		;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canApplyTogether(Enchantment ench) {
			return true;
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}

	public boolean isTreasureEnchantment() {
		return true;
	}
}
