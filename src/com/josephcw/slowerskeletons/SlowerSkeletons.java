package com.josephcw.slowerskeletons;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.josephcw.slowerskeletons.actions.SkeletonFireListener;

public class SlowerSkeletons extends JavaPlugin {

	@Override
	public void onEnable() {
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(new SkeletonFireListener(), this);
	}
}
