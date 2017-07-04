package com.josephcw.slowerskeletons.actions;

import org.bukkit.Color;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SkeletonFireListener implements Listener {

	@EventHandler
	public void onBowFiredEvent(EntityShootBowEvent e) {
		if (!isSkeletonFiringArrow(e)) {
			return;
		}
		
		applySlowDebuf(e.getEntity());
	}
	
	private boolean isSkeletonFiringArrow(EntityShootBowEvent bowFireEvent) {
		EntityType et = bowFireEvent.getEntityType();
		if (et == EntityType.SKELETON
				|| et == EntityType.WITHER_SKELETON) {
			return true;
		}
		return false;
	}
	
	private void applySlowDebuf(LivingEntity e) {
		e.addPotionEffect(
				new PotionEffect(PotionEffectType.SLOW, 100, 1, false, true, Color.WHITE));
	}
}
