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

public class EnchantBurning extends Enchantment {

	public EnchantBurning() {
		super(Rarity.VERY_RARE, EnumEnchantmentType.ARMOR, new EntityEquipmentSlot[] { EntityEquipmentSlot.HEAD,
				EntityEquipmentSlot.CHEST, EntityEquipmentSlot.LEGS, EntityEquipmentSlot.FEET });
		this.setRegistryName("ignition");
		this.setName("ignition");
		;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canApplyTogether(Enchantment ench) {
		if (ench == Enchantments.FIRE_PROTECTION) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void onEntityDamaged(EntityLivingBase user, Entity target, int level) {
		if (user.isBurning()) {
			target.setFire(5 + level * 2);
			target.attackEntityFrom(DamageSource.ON_FIRE, (float) level * 2);
		} else {
			target.playSound(SoundEvents.BLOCK_FIRE_EXTINGUISH, 1, 1);
		}
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}

	public boolean isTreasureEnchantment() {
		return true;
	}
}
