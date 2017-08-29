package com.josephcw.zombieminers;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.josephcw.zombieminers.actions.ZombieSpawnListener;

public class ZombieMiners extends JavaPlugin {

	@Override
	public void onEnable() {
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(new ZombieSpawnListener(), this);
	}
}
