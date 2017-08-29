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

public class ZombieSpawnListener implements Listener {

	Random randomGenerator;
	
	public ZombieSpawnListener() {
		randomGenerator = new Random();
	}
	
	@EventHandler
	public void onSpawn(CreatureSpawnEvent event) {
		LivingEntity eventEntity = event.getEntity();
		if (shouldSpawnWithPickaxe()
				&& isZombieSpawning(eventEntity)
				&& isValidLocation(eventEntity)) {
			giveEntityPickaxeBasedOnLocation(eventEntity);
		}
	}

	private boolean shouldSpawnWithPickaxe() {
		return randomGenerator.nextInt(25) + 1 == 25;
	}
	
	private boolean isZombieSpawning(LivingEntity livingEntity) {
		EntityType entityType = livingEntity.getType();
		return entityType == EntityType.ZOMBIE;
	}
	
	private boolean isValidLocation(LivingEntity eventEntity) {
		Location spawnLocation = eventEntity.getLocation();
		int yLocationValue = spawnLocation.getBlockY();
		return yLocationValue <= 64;
	}

	private void giveEntityPickaxeBasedOnLocation(LivingEntity livingEntity) {
		Location spawnLocation = livingEntity.getLocation();
		int yCoordinateValue = spawnLocation.getBlockY();
		
		ItemStack itemToGiveEntity;
		if (yCoordinateValue > 50) {
			itemToGiveEntity = new ItemStack(Material.WOOD_PICKAXE);
		} else if (yCoordinateValue > 40) {
			itemToGiveEntity = new ItemStack(Material.STONE_PICKAXE);
		} else if (yCoordinateValue > 30) {
			itemToGiveEntity = new ItemStack(Material.IRON_PICKAXE);
		} else if (yCoordinateValue > 20 ) {
			itemToGiveEntity = new ItemStack(Material.GOLD_PICKAXE);
		} else {
			itemToGiveEntity = new ItemStack(Material.DIAMOND_PICKAXE);
		}
		
		livingEntity.getEquipment().setItemInMainHand(itemToGiveEntity);
	}
}
