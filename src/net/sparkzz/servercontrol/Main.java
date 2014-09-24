package net.sparkzz.servercontrol;

import net.sparkzz.servercontrol.util.FileManager;
import net.sparkzz.servercontrol.util.Logger;
import org.spongepowered.api.event.SpongeEventHandler;
import org.spongepowered.api.plugin.Plugin;

/**
 * Created by Brendon on 9/24/2014.
 */
@Plugin(id = "ServerControl", name = this.NAME, version = this.VERSION)
public class Main {

	public final String NAME = "Server Control", VERSION = "0.0.1-PRE";

	private static FileManager files = new FileManager();
	private static Logger logger = new Logger("ServerControl");

	@SpongeEventHandler
	public void onDisable() {
		logger.info(NAME + " v" + VERSION + " has been disabled");
	}

	@SpongeEventHandler
	public void onEnable() {
		logger.info(NAME + " v" + VERSION + " has been enabled");
	}

	public static FileManager getFileManager() {
		return files;
	}

	public static Logger getLogger() {
		return logger;
	}
}