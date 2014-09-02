package me.gserv.stopserver.storage;

import me.gserv.stopserver.StopServer;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;

public class ConfigHandler {

    private final StopServer plugin;
    private final FileConfiguration config;

    public ConfigHandler(StopServer plugin) {
        this.plugin = plugin;
        File fh = new File(this.plugin.getDataFolder() + "/config.yml");

        if (!fh.isFile()) {
            // Only recreate if it's gone
            this.plugin.saveDefaultConfig();
        }

        this.config = this.plugin.getConfig();
        this.update();
    }

    public void update() {
        String version = this.getVersion();

        if (version.equals("")) { // No version in the config
            this.config.set("version", this.plugin.getDescription().getVersion());
            this.reload();

        } else if (!version.equals("0.0.1")) {
            this.plugin.getLogger().warning(
                    String.format("Unknown version in config: %s", version)
            );
            this.plugin.getLogger().warning(
                    String.format("Setting to %s", this.plugin.getDescription().getVersion())
            );

            this.config.set("version", this.plugin.getDescription().getVersion());
            this.reload();

        }
    }

    public void reload() {
        this.plugin.reloadConfig();
    }

    public String getVersion() {
        return this.config.getString("version", "");
    }

    public String getTime() {
        return this.config.getString("time");
    }

    public Time getTicks() {
        String time = this.getTime();
        long tickRate = this.getTickRate();

        long days, hours, minutes, seconds;

        String[] strings = time.split(":");

        if (strings.length != 4) {
            this.plugin.getLogger().warning("Invalid time format - Expected days:hours:minutes:seconds");
            return new Time();
        }

        try {
            days = Long.parseLong(strings[0]);
        } catch (NumberFormatException e) {
            this.plugin.getLogger().warning(String.format("Days: %s is not a number.", strings[0]));
            return new Time();
        }

        try {
            hours = Long.parseLong(strings[1]);
        } catch (NumberFormatException e) {
            this.plugin.getLogger().warning(String.format("Hours: %s is not a number.", strings[1]));
            return new Time();
        }

        try {
            minutes = Long.parseLong(strings[2]);
        } catch (NumberFormatException e) {
            this.plugin.getLogger().warning(String.format("Minutes: %s is not a number.", strings[2]));
            return new Time();
        }

        try {
            seconds = Long.parseLong(strings[3]);
        } catch (NumberFormatException e) {
            this.plugin.getLogger().warning(String.format("Seconds: %s is not a number.", strings[3]));
            return new Time();
        }

        long ticks = 0;

        ticks += seconds * tickRate;
        ticks += (minutes * 60) * tickRate;
        ticks += ((hours * 60) * 60) * tickRate;
        ticks += (((days * 24) * 60) * 60) * tickRate;

        return new Time(days, hours, minutes, seconds, ticks, tickRate);
    }

    public long getTickRate() {
        return this.config.getLong("tickrate");
    }
}
