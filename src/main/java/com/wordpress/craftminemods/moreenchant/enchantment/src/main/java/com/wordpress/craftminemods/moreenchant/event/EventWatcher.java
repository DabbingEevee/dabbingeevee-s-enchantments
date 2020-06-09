package com.wordpress.craftminemods.moreenchant.event;

import com.wordpress.craftminemods.moreenchant.EnchantMod;
import com.wordpress.craftminemods.moreenchant.enchantment.ModEnchantments;

import net.minecraft.command.ICommandSender;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityTravelToDimensionEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = EnchantMod.MODID)
public class EventWatcher {
	@SubscribeEvent
	public static void onEntry(EntityTravelToDimensionEvent event) {
		if (!event.getEntity().world.isRemote) {
			int level = EnchantmentHelper.getMaxEnchantmentLevel(ModEnchantments.riftShield,
					(EntityLivingBase) event.getEntity());
			if (level > 0) {
				Entity e = event.getEntity();
				((EntityLivingBase) e).addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 600, 3));
				((EntityLivingBase) e).addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 600, 3));
				((EntityLivingBase) e).addPotionEffect(new PotionEffect(MobEffects.HASTE, 600, 3));
				event.getEntity().playSound(SoundEvents.ITEM_FIRECHARGE_USE, 1, 1);

			}
		}

	}

	@SubscribeEvent
	public static void doTick(LivingUpdateEvent event) {
		if (!event.getEntity().world.isRemote) {
			// Get the enchantment level the entity has
			int level = EnchantmentHelper.getMaxEnchantmentLevel(ModEnchantments.ignition, event.getEntityLiving());
			// We only continue if the entity has the enchantment and thus the level is
			// higher than 0
			// []===[ ꙰ ꙰ ꙰ ꙰ ꙰ ꙰ ꙰ ꙰ ꙰ ꙰ ꙰ ꙰ ꙰ ꙰ ꙰ ꙰ ꙰ ꙰ ꙰ ꙰ ꙰ ꙰ ꙰ ꙰ ꙰ ꙰ ꙰ ꙰ ꙰ ꙰ ꙰ ꙰ ꙰ ꙰ ꙰
			// ꙰ ꙰ ꙰ ꙰ ꙰ ꙰ ꙰ ꙰ ꙰ ꙰ ꙰ ꙰ ꙰
			if (level > 0) {
				Entity e = event.getEntity();
				e.setFire(1);
				((EntityLivingBase) e).addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 21, 1));
			}
		}	}


	@SubscribeEvent
	public static void onUse(UseHoeEvent event) {
		if (!event.getEntity().world.isRemote) {
			int level = EnchantmentHelper.getMaxEnchantmentLevel(ModEnchantments.watering, event.getEntityLiving());
			if (level > 0) {
				if ((event.getWorld().getBlockState(event.getPos()).getBlock()) == Blocks.FARMLAND) {
					if (event.getWorld().getBlockState(event.getPos()) != Blocks.FARMLAND.getStateById(7)) {
						event.getEntity().world.setBlockState(event.getPos(), Blocks.FARMLAND.getStateFromMeta(7), 7);
						event.getEntityLiving().swingArm(event.getEntityLiving().getActiveHand());
						event.getEntityLiving().playSound(SoundEvents.ITEM_BUCKET_EMPTY, 1, 1);
						event.getEntityLiving().getActiveItemStack().damageItem(1, event.getEntityLiving());

					}
				}

			}
		}
	}
}
