package net.sparkzz.servercontrol.util;

import org.spongepowered.api.world.World;

import java.io.File;

/**
 * @author Brendon
 */
public class WorldManager extends Utility {

	private static WorldManager manager = new WorldManager();

	public static WorldManager getManager() {
		return manager;
	}

	public boolean isWorld(String name) {
		if (game.getWorld(name) != null) return true;
		else return false;
	}

	public void copyWorld(String name) {
		//TODO: implement copying of worlds

		copyWorldFiles(null, null);
	}

	public void copyWorldFiles(File source, File target) {
		//TODO: implement file managing
	}


	public void unloadWorld(World world) {
		//TODO: implement unloading of worlds
	}

	public boolean deleteWorld(String name) {
		if (!isWorld(name)) return false;

		//TODO: implement deleting of worlds
		return deleteWorldFiles(null);
	}

	public boolean deleteWorldFiles(File source) {
		//TODO: implement file managing
		return false;
	}
}