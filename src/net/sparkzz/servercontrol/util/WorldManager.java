package net.sparkzz.servercontrol.util;

import org.spongepowered.api.world.World;

import java.io.File;

/**
 * @author Brendon
 */
public class WorldManager extends Utility {

	private static final File WORLD_DIR = new File(""); // Folder in which the worlds are saved
	private static WorldManager manager = new WorldManager();

	public static WorldManager getManager() {
		return manager;
	}

	public boolean isWorld(String name) {
		return (game.getWorld(name) != null);
	}

	public static boolean copyWorld(World world, String newName, boolean overwrite) {
		return FileManager.copy(new File(WORLD_DIR, world.getName()), new File(WORLD_DIR, newName), overwrite);
	}

	public static boolean deleteWorld(World world) {
		if (unloadWorld(world))
			return FileManager.delete(new File(WORLD_DIR, world.getName()));
		else
			logger.warn("Could not unload world: " + world.getName() + " in order to delete it.");
		return false;
	}

	public static boolean unloadWorld(World world) {
		//TODO: implement unloading of worlds
		return false;
	}
}