	package com.wordpress.craftminemods.moreenchant.other;
	
	import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
	import net.minecraft.entity.EntityLivingBase;
	import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
	
	public class CooldownManager {
		public static void cooldown(Entity entity, int amount) {
			if (entity instanceof EntityLivingBase)
				((EntityPlayer) entity).getCooldownTracker()
						.setCooldown(((EntityLivingBase) entity).getHeldItemMainhand().getItem(), (int) amount);
		}
		public static void cooldown(Entity entity, int amount, Item item) {
			if (entity instanceof EntityLivingBase)
				((EntityPlayer) entity).getCooldownTracker()
						.setCooldown(item, (int) amount);
		}
		public static void cooldown(Entity entity, int amount, Block block) {
			if (entity instanceof EntityLivingBase)
				((EntityPlayer) entity).getCooldownTracker()
						.setCooldown(Item.getItemFromBlock(block), (int) amount);
		}
	}
