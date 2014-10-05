package net.sparkzz.servercontrol.user;

import net.sparkzz.servercontrol.Main;
import net.sparkzz.servercontrol.util.Utility;
import org.spongepowered.api.Game;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brendon
 */
public class UserData extends Utility {

	protected static final Game game = Main.getGame();

	public static List<User> users = new ArrayList<User>();
}