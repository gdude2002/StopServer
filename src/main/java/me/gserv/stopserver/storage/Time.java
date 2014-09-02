package me.gserv.stopserver.storage;

public class Time {

    private final long days, hours, minutes, seconds, ticks;
    private final long tickRate;

    public Time() {
        this.days = -1L;
        this.hours = -1L;
        this.minutes = -1L;
        this.seconds = -1L;
        this.ticks = -1L;
        this.tickRate = -1L;
    }

    public Time(long days, long hours, long minutes, long seconds, long ticks, long tickRate) {
        this.days = days;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.ticks = ticks;
        this.tickRate = tickRate;
    }

    public long getDays() {
        return this.days;
    }

    public long getHours() {
        return this.hours;
    }

    public long getMinutes() {
        return this.minutes;
    }

    public long getSeconds() {
        return this.seconds;
    }

    public long getTicks() {
        return this.ticks;
    }

    public long getTickRate() {
        return this.tickRate;
    }

    public String getFormattedTime() {
        if (this.ticks == -1L) {
            return "[Invalid time specified]";
        }

        return String.format(
                "%s days, %s hours, %s minutes, %s seconds (%s ticks at %s tps)",
                this.getDays(), this.getHours(), this.getMinutes(), this.getSeconds(),
                this.getTicks(), this.getTickRate()
        );
    }
}
