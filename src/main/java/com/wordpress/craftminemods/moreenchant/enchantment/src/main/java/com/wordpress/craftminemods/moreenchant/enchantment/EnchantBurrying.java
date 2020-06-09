package com.wordpress.craftminemods.moreenchant.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;

public class EnchantBurrying extends Enchantment{

	public EnchantBurrying() {
		super(Rarity.VERY_RARE, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND});
		this.setRegistryName("burrying");
		this.setName("burrying");
		;
		// TODO Auto-generated constructor stub
	}
    @Override
    public boolean canApplyTogether(Enchantment ench) {
    	if(ench == ModEnchantments.lifting) {
    		return false;
    	}
    	else
    	{
    		return true;
    	}
	}
    @Override
	public void onEntityDamaged(EntityLivingBase user, Entity target, int level)
    {
        if (target instanceof EntityLivingBase)
        {
        		target.setPositionAndUpdate(target.posX, target.posY - level*0.5, target.posZ);
                //target.motionY = target.motionY - 0.25;

                //ExampleMod.logger.info("duck");

        }
    }
    
	@Override
	public int getMaxLevel()
	{
		return 2;
	}
	public boolean isTreasureEnchantment() {
		return true;
	}
}
