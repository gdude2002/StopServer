StopServer
==========

My plugins: [WordWarning](https://github.com/gdude2002/WordWarning) | [Painter](https://github.com/gdude2002/Painter) | [LotteryBox](https://github.com/gdude2002/LotteryBox)

---

**This plugin was created by request for [runner_z](http://dev.bukkit.org/profiles/runner_z/).**

StopServer is a simple plugin that allows you to stop the server after a certain amount of inactivity.
The latest jar is always available [here](http://bamboo.gserv.me/browse/PLUG-STOP/latest/artifact/JOB1/Version-agnostic-jar/StopServer.jar).

**As per request, this plugin now supports Java 6. You should still update to Java 7 if possible, though, as it contains numerous
security fixes and speed improvements.**

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

Buy me a soda
=============

Sometimes people ask me to accept donations. If you like what I do, you can donate [here](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=85GN242EDQSCJ).

---

My plugins: [WordWarning](https://github.com/gdude2002/WordWarning) | [Painter](https://github.com/gdude2002/Painter) | [LotteryBox](https://github.com/gdude2002/LotteryBox)
