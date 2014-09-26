package net.sparkzz.servercontrol.util;

import net.sparkzz.servercontrol.Main;
import org.spongepowered.api.Game;

/**
 * Created by Brendon on 9/25/2014.
 */
public class Utility {

	public Color color = Color.getColor();
	public FileManager files = Main.getFileManager();
	public Game game = Main.getGame();
	public Logger logger = Main.getLogger();
	public Messenger msg = Messenger.getMessenger();
	public WorldManager world = WorldManager.getManager();
}