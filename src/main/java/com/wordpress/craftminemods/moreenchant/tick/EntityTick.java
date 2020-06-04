package com.wordpress.craftminemods.moreenchant.tick;

import com.wordpress.craftminemods.moreenchant.enchantment.ModEnchantments;

import net.minecraft.block.BlockDirt;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import com.wordpress.craftminemods.moreenchant.EnchantMod;
@Mod.EventBusSubscriber(modid=EnchantMod.MODID)
public class EntityTick {
	@SubscribeEvent
	public static void growGrassness(LivingUpdateEvent event) {
	  if(!event.getEntity().world.isRemote) {
	    //Get the enchantment level the entity has
	    int level = EnchantmentHelper.getMaxEnchantmentLevel(ModEnchantments.ignition, event.getEntityLiving());

	    //We only continue if the entity has the enchantment and thus the level is higher than 0
	    if(level>0) {
	      Entity e = event.getEntity();
	      e.setFire(1);
	      ((EntityLivingBase) e).addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 21, 1));

	    }
	  }
	}
}
