package net.sparkzz.servercontrol.util;

import net.sparkzz.servercontrol.Main;
import org.spongepowered.api.Game;

/**
 * @author Brendon
 */
public class Utility {

	public static Color color = Color.getColor();
	public static FileManager files = Main.getFileManager();
	public static Game game = Main.getGame();
	public static Logger logger = Main.getLogger();
	public static Messenger msg = Messenger.getMessenger();
	public static WorldManager world = WorldManager.getManager();
}