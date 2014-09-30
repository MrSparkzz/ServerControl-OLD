package net.sparkzz.servercontrol;

import net.sparkzz.servercontrol.util.FileManager;
import net.sparkzz.servercontrol.util.Logger;
import org.spongepowered.api.Game;
import org.spongepowered.api.event.SpongeEventHandler;
import org.spongepowered.api.event.state.PreInitializationEvent;
import org.spongepowered.api.event.state.ServerStartingEvent;
import org.spongepowered.api.event.state.ServerStoppingEvent;
import org.spongepowered.api.plugin.Plugin;

/**
 * @author Brendon
 */
@Plugin(id = "ServerControl", name = this.NAME, version = this.VERSION)
public class Main {

	public final String NAME = "Server Control", VERSION = "0.0.1-PRE";

	private static FileManager files = new FileManager();
	private static Game game;
	private static Logger logger = new Logger("ServerControl");

	@SpongeEventHandler
	public void onConstruction(PreInitializationEvent event) {
		game = event.getGame();
	}

	@SpongeEventHandler
	public void onDisable(ServerStoppingEvent event) {
		logger.info(NAME + " v" + VERSION + " has been disabled");
	}

	@SpongeEventHandler
	public void onEnable(ServerStartingEvent event) {
		logger.info(NAME + " v" + VERSION + " has been enabled");
	}

	public static FileManager getFileManager() {
		return files;
	}

	public static Game getGame() {
		return game;
	}

	public static Logger getLogger() {
		return logger;
	}
}