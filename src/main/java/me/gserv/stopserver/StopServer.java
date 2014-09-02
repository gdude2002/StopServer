package me.gserv.stopserver;

/**
 * StopServer plugin
 *
 * This allows one to schedule server stops after a certain amount of inactivity.
 */

import me.gserv.stopserver.listeners.LoginListener;
import me.gserv.stopserver.listeners.QuitListener;
import me.gserv.stopserver.storage.ConfigHandler;
import me.gserv.stopserver.storage.Time;
import me.gserv.stopserver.tasks.StopTask;
import org.bukkit.plugin.java.JavaPlugin;

public final class StopServer extends JavaPlugin {

    // Config handler
    private ConfigHandler config;

    // Task and time
    private Time time;
    private StopTask task;
    private boolean started = false;

    // Event listeners
    private LoginListener loginListener;
    private QuitListener quitListener;

    @Override
    public void onEnable() {
        // Load up the config
        this.config = new ConfigHandler(this);
        this.time = this.config.getTicks();
        this.task = new StopTask(this);

//        this.getLogger().info(String.format("Scheduling shutdown in %s", this.time.getFormattedTime()));
        this.checkTask();

        this.loginListener = new LoginListener(this);
        this.quitListener = new QuitListener(this);

        this.getServer().getPluginManager().registerEvents(this.loginListener, this);
        this.getServer().getPluginManager().registerEvents(this.quitListener, this);
    }

    public void reload() {
        this.config.reload();
    }

    public ConfigHandler getConfigHandler() {
        return this.config;
    }

    public void cancelTask() {
        if (this.started) {
            this.started = false;
            this.task.cancel();
            this.task = new StopTask(this);

            this.getLogger().info("Timer reset - not shutting down.");
        }
    }

    public void startTask() {
        if (!this.started) {
            this.started = true;
            this.task.runTaskLater(this, this.time.getTicks());

            this.getLogger().info(String.format("Timer started - shutting down in %s.", this.time.getFormattedTime()));
        }
    }

    public void checkTask() {
        this.checkTask(false, false);
    }

    public void checkTask(boolean extraPlayer, boolean missingPlayer) {
        if (extraPlayer) {
            this.cancelTask();
        } else if (missingPlayer) {
            if (this.getServer().getOnlinePlayers().length > 1) {
                this.cancelTask();
            } else {
                this.startTask();
            }
        } else {
            if (this.getServer().getOnlinePlayers().length > 0) {
                this.cancelTask();
            } else {
                this.startTask();
            }
        }
    }

    public void stopServer() {
        this.getLogger().info("Timer expired - shutting down!");
        this.getServer().shutdown();
    }
}
