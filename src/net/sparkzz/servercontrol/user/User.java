package net.sparkzz.servercontrol.user;

import org.spongepowered.api.Game;
import org.spongepowered.api.entity.Player;

import java.util.UUID;

/**
 * Created by Brendon on 9/24/2014.
 */
public class User extends UserData {

	private boolean invsee = false;
	private Player player;
	private String name, nickname;
	private User lastMSG;
	private UUID uuid;

	public User(Player player) {
		this.player = player;
		name = player.getName();
		uuid = player.getUniqueID();

		users.add(this);
	}

	public static User getUser(String name) {
		if (users.size() > 0) {
			for (int i = 0; i < users.size(); i++) {
				User user = users.get(i);

				if (user.getName().equalsIgnoreCase(name))
					return user;
			}
		}
		return null;
	}

	public static User getUser(Player player) {
		if (users.size() > 0) {
			for (int i = 0; i < users.size(); i++) {
				User user = users.get(i);

				if (user.getPlayer() == player)
					return user;
			}
		}
		return null;
	}

	public static User getUser(UUID uuid) {
		if (users.size() > 0) {
			for (int i = 0; i < users.size(); i++) {
				User user = users.get(i);

				if (user.getUUID() == uuid)
					return user;
			}
		}
		return null;
	}

	public static void rebuild() {
		for (Player player : game.getOnlinePlayers()) {
			new User(player);
		}
	}

	public boolean hasLastMSG() {
		if (lastMSG != null) return true;
		else return false;
	}

	public boolean isInvsee() {
		return invsee;
	}

	public int getSessionID() {
		if (users.size() > 0) {
			for (int i = 0; i < users.size(); i++) {
				User user = users.get(i);

				if (user == this)
					return i += 1;
			}
		}
		return -1;
	}

	public Player getPlayer() {
		return player;
	}

	public User getLastMSG() {
		return lastMSG;
	}

	public String getName() {
		return name;
	}

	public UUID getUUID() {
		return uuid;
	}

	public void deleteUser() {
		if (users.size() > 0) {
			for (int i = 0; i < users.size(); i++) {
				User user = users.get(i);

				if (user == this)
					users.remove(i);
			}
		}
	}

	public void setInvsee(boolean value) {
		invsee = value;
	}

	public void setLastMSG(User user) {
		lastMSG = user;
	}

	public void setLastMSG(Player player) {
		lastMSG = getUser(player);
	}
}