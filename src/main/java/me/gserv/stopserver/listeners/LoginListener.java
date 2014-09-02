package me.gserv.stopserver.listeners;

import me.gserv.stopserver.StopServer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;


public class LoginListener implements Listener {

    // Instance of the plugin
    private final StopServer plugin;

    public LoginListener(StopServer plugin) {
        // Store the plugin instance
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onLogin(PlayerLoginEvent event) {
        // Check to see if the player is allowed to connect
        if (event.getResult() != PlayerLoginEvent.Result.ALLOWED) {
            return;
        }

        this.plugin.checkTask(true, false);
    }
}
