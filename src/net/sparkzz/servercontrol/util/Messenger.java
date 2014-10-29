package net.sparkzz.servercontrol.util;

import net.sparkzz.servercontrol.entity.Source;
import net.sparkzz.servercontrol.user.User;
import org.spongepowered.api.entity.Player;
import org.spongepowered.api.util.command.CommandSource;

import java.util.UUID;

/**
 * @author Brendon
 *
 * Public Messaging API
 */
public class Messenger extends Utility {

	public static enum ArgType {
		INVALID(), LESS(), MORE();
	}

	private static Messenger msg = new Messenger();

	public static Messenger getMessenger() {
		return msg;
	}

	public String buildString(int start, String[] args) {
		StringBuilder str = new StringBuilder();

		for (int i = start; i < args.length; i++) {
			str.append(args[i] + " ");
		}

		return str.toString();
	}

	public void args(Source source, ArgType type) {
		switch (type) {
			case INVALID:
				source.send(/* TODO: color.RED +*/ "Invalid arguments!");
				break;
			case LESS:
				source.send(/* TODO: color.RED +*/ "Too few arguments!");
				break;
			case MORE:
				source.send(/* TODO: color.RED +*/ "Too many arguments!");
				break;
			default:
				break;
		}
	}

	public void broadcast(String message) {
		game.broadcastMessage(message);
	}

	public void deny(Source source, String message) {
		source.send(/* color.RED +*/ "You are not permitted to perform this action!");
	}

	public void massSend(Player[] players, String message) {
		for (int i = 0; i < players.length; i++) {
			User.getUser(players[i]).send(message);
		}
	}

	public void massSend(String[] playerNameList, String message) {
		for (int i = 0; i < playerNameList.length; i++) {
			User.getUser(playerNameList[i]).send(message);
		}
	}

	public void massSend(User[] users, String message) {
		for (int i = 0; i < users.length; i++) {
			users[i].send(message);
		}
	}

	public void noTarget(Source source, String targetName) {
		source.send(/* TODO: color.RED +*/ "Specified player " + /* TODO: color.GOLD +*/ targetName + /* TODO: color.RED +*/ " is not online!");
	}

	public void noTarget(Source source, UUID targetUUID) {
		source.send(/* TODO: color.RED +*/ "Specified player with the UUID of " + /* TODO: color.GOLD +*/ targetUUID + /* TODO: color.RED +*/ " is not online!");
	}

	public void send(Source source, String message) {
		source.send(message);
	}

	public void send(Player player, String message) {
		User.getUser(player).send(message);
	}

	public void send(String name, String message) {
		User.getUser(name).send(message);
	}

	public void send(UUID uuid, String message) {
		User.getUser(uuid).send(message);
	}

	public void warn(Source source, String message) {
		source.send(/* TODO: color.RED +*/ message);
	}
}