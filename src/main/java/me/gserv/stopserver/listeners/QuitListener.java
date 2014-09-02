package me.gserv.stopserver.listeners;

import me.gserv.stopserver.StopServer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;


public class QuitListener implements Listener {

    // Instance of the plugin
    private final StopServer plugin;

    public QuitListener(StopServer plugin) {
        // Store the plugin instance
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onQuit(PlayerQuitEvent event) {
        this.plugin.checkTask(false, true);
    }
}
