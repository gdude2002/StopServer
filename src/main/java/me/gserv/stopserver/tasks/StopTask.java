package me.gserv.stopserver.tasks;

import me.gserv.stopserver.StopServer;
import org.bukkit.scheduler.BukkitRunnable;

public class StopTask extends BukkitRunnable {

    private final StopServer plugin;

    public StopTask(StopServer plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        this.plugin.stopServer();
    }
}
