package com.wordpress.craftminemods.moreenchant;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

import com.wordpress.craftminemods.moreenchant.enchantment.ModEnchantments;

@Mod(modid = EnchantMod.MODID, name = EnchantMod.NAME, version = EnchantMod.VERSION)
public class EnchantMod
{
    public static final String MODID = "deenchantmod";
    public static final String NAME = "Dabbingeevee's More Enchants";
    public static final String VERSION = "1.0";

    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	ModEnchantments.init();
    	logger.log(Level.INFO, "DE Enchant Init Begins now");
        // some example code
    }
}
