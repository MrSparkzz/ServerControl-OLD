package net.sparkzz.servercontrol.user;

import org.spongepowered.api.entity.Player;

import java.util.UUID;

/**
 * Created by Brendon on 9/24/2014.
 *
 * Public User API
 */
public class User extends UserData {

	private boolean invsee = false;
	private Player player;
	private String nickname;
	private User lastConversed;
	private UUID uuid;

	public User(Player player) {
		this.player = player;
		uuid = player.getUniqueId();

		users.add(this);
	}

	public static User getUser(String name) {
		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);

			if (user.getName().equalsIgnoreCase(name))
				return user;
		}

		return null;
	}

	public static User getUser(Player player) {
		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);

			if (user.getPlayer() == player)
				return user;
		}

		return null;
	}

	public static User getUser(UUID uuid) {
		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);

			if (user.getUUID() == uuid)
				return user;
		}

		return null;
	}

	public static void clearUsers() {
		users.clear();
	}

	public static void deleteUser(User user) {
		if (users.contains(user))
			users.remove(user);
	}

	public static void rebuild() {
		users.clear();

		for (Player player : game.getOnlinePlayers()) {
			new User(player);
		}
	}

	public boolean hasLastMSG() {
		return lastConversed != null;
	}

	public boolean isInvsee() {
		return invsee;
	}

	@Deprecated
	public boolean isOp() {
		//TODO: return player.isOp();
		return false;
	}

	@Deprecated
	public boolean isPermitted(String node) {
		//TODO: return player.hasPermission(node);
		return false;
	}

	public int getSessionID() {
		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);

			if (user == User.getUser(user.getUUID()))
				return i += 1;
		}

		return -1;
	}

	public Player getPlayer() {
		return player;
	}

	public String getNickname() {
		return nickname;
	}

	public User getLastMSG() {
		return lastConversed;
	}

	public String getName() {
		return player.getName();
	}

	public UUID getUUID() {
		return uuid;
	}

	public void send(String message) {
		// TODO: Implement message sending
	}

	public void setInvsee(boolean value) {
		invsee = value;
	}

	public void setLastConversed(User user) {
		lastConversed = user;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}