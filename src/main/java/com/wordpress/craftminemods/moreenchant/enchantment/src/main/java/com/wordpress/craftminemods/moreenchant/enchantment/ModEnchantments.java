package com.wordpress.craftminemods.moreenchant.enchantment;

import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModEnchantments {
	public static final EnchantLifting lifting = new EnchantLifting();
	public static final EnchantBurrying burrying = new EnchantBurrying();
	public static final EnchantStriking striking = new EnchantStriking();
	public static final EnchantBlasting blasting = new EnchantBlasting();
	public static final EnchantBurning ignition = new EnchantBurning();
	public static final EnchantRiftShield riftShield = new EnchantRiftShield();
	public static final EnchantWatering watering = new EnchantWatering();


	public static void init() {
		ForgeRegistries.ENCHANTMENTS.registerAll(
				lifting,
				burrying,
				striking,
				blasting,
				ignition,
				riftShield,
				watering
		);
		
	}
}
