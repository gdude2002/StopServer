StopServer
==========

My plugins: [WordWarning](https://github.com/gdude2002/WordWarning) | [Painter](https://github.com/gdude2002/Painter) | [LotteryBox](https://github.com/gdude2002/LotteryBox)

---

**This plugin was created by request for [plugin request thread by runner_z](http://dev.bukkit.org/profiles/runner_z/).**

StopServer is a simple plugin that allows you to stop the server after a certain amount of inactivity.

The latest jar is always available [here](http://bamboo.gserv.me/browse/PLUG-LOTBOX/latest/artifact/JOB1/Version-agnostic-jar/LotteryBox.jar).
Remember, your server must be running **Java 7 or later**. If you need me to compile for lower versions, let me know and I'll make it happen.

Usage
=====

1. Copy the plugin jar to your plugins folder
2. Restart your server
3. Fill out plugins/StopServer/config.yml
4. Restart your server again
5. Done!

Compiling
=========

Compilation of the plugin is fairly simple.

1. Install [the JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html) (version 1.7 or higher)
2. Install [Gradle](http://www.gradle.org/)
3. Ensure that the JDK and Gradle are on your system's PATH
4. Open a terminal, `cd` to the project files and `gradle clean build jar fatjar`
5. You'll find the jar in `build/libs/`

I use Gradle instead of Maven simply because I don't like Maven, and Gradle is much easier to work with.
If you need to do Maven things, you can do `gradle install`, which will generate poms and install the plugin
into your local maven repository. Poms are generated in `build/poms/`.

---

My plugins: [WordWarning](https://github.com/gdude2002/WordWarning) | [Painter](https://github.com/gdude2002/Painter) | [LotteryBox](https://github.com/gdude2002/LotteryBox)
