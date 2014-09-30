package net.sparkzz.servercontrol.user;

import net.sparkzz.servercontrol.Main;
import org.spongepowered.api.Game;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brendon
 */
public class UserData {

	protected static Game game = Main.getGame();

	public static List<User> users = new ArrayList<User>();
}