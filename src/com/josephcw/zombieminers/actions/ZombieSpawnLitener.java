package com.josephcw.zombieminers.actions;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.ItemStack;

public class ZombieSpawnLitener implements Listener {

	@EventHandler
	public void onSpawn(CreatureSpawnEvent event) {
		if (!isUndergroundZombieEvent(event)) {
			return;
		}
		
		Random r = new Random();
		int randomNumber = r.nextInt(25)+1;
		if (randomNumber == 1) {
			giveEntityPickaxeBasedOnLocation(event.getEntity());
		}
	}

	private boolean isUndergroundZombieEvent(CreatureSpawnEvent event) {
		EntityType entityType = event.getEntityType();
		if (entityType != EntityType.ZOMBIE) {
			return false;
		}
		
		Location spawnLocation = event.getEntity().getLocation();
		int xLocationValue = spawnLocation.getBlockY();
		if (xLocationValue >= 64) {
			return false;
		}
		
		return true;
	}

	private void giveEntityPickaxeBasedOnLocation(LivingEntity livingEntity) {
		Location spawnLocation = livingEntity.getLocation();
		int xCoordinateValue = spawnLocation.getBlockY();
		
		ItemStack itemToGiveEntity;
		if (xCoordinateValue > 50) {
			itemToGiveEntity = new ItemStack(Material.WOOD_PICKAXE);
		} else if (xCoordinateValue > 40) {
			itemToGiveEntity = new ItemStack(Material.STONE_PICKAXE);
		} else if (xCoordinateValue > 30) {
			itemToGiveEntity = new ItemStack(Material.IRON_PICKAXE);
		} else if (xCoordinateValue > 20 ) {
			itemToGiveEntity = new ItemStack(Material.GOLD_PICKAXE);
		} else {
			itemToGiveEntity = new ItemStack(Material.DIAMOND_PICKAXE);
		}
		
		livingEntity.getEquipment().setItemInMainHand(itemToGiveEntity);
	}
}
