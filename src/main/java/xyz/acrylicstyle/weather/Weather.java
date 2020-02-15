package xyz.acrylicstyle.weather;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Weather extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        new BukkitRunnable() {
            public void run() {
                Bukkit.getWorlds().forEach(world -> {
                    world.setStorm(false);
                    world.setWeatherDuration(100000);
                });
            }
        }.runTaskLater(this, 1);
    }

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent e) {
        e.getWorld().setStorm(false);
        e.getWorld().setWeatherDuration(100000);
        e.setCancelled(true);
    }
}
