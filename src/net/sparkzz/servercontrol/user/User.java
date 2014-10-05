package net.sparkzz.servercontrol.user;

import net.sparkzz.servercontrol.entity.Humanoid;
import net.sparkzz.servercontrol.entity.traits.Conversable;
import net.sparkzz.servercontrol.entity.traits.Permissible;
import org.spongepowered.api.entity.Player;
import org.spongepowered.api.world.Location;

import java.util.UUID;

/**
 * Created by Brendon on 9/24/2014.
 *
 * Public User API
 */
public class User extends UserData implements Conversable, Humanoid, Permissible {

	private boolean invsee = false;
	private boolean visible = true;
	private Player player;
	private String nickname;
	private Object lastConversed;
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

	public boolean isOnline() {
		for (Player player : game.getOnlinePlayers())
			if (player.equals(this.getPlayer()))
				return true;
		return false;
	}

	@Deprecated
	public boolean isOp() {
		//TODO: return player.isOp();
		return false;
	}

	@Deprecated
	@Override
	public boolean isPermitted(String node) {
		//TODO: return player.hasPermission(node);
		return false;
	}

	public boolean isVisible() {
		return visible;
	}

	@Override
	public boolean reply(String message) {
		if (lastConversed instanceof Console) {
			Console target = (Console) lastConversed;

			sendToConsole(message); // TODO: Ensure that in the ReplyCommand class that you format the message BEFORE sending
			return true;
		} else if (lastConversed instanceof User) {
			User target = (User) lastConversed;

			if (target.isOnline()) {
				// TODO: Implement message sending
				return true;
			}
		} else {

		}
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

	@Override
	public Location getLocation() {
		return null; // TODO: Implement location getter
	}

	public Player getPlayer() {
		return player;
	}

	public String getNickname() {
		return nickname;
	}

	@Override
	public Object getLastConversed() {
		return lastConversed;
	}

	public String getName() {
		return player.getName();
	}

	public UUID getUUID() {
		return uuid;
	}

	@Override
	public void send(String message) {
		// TODO: Implement message sending
	}

	@Override
	public void send(User user, String message) {
		// TODO: Implement message sending
	}

	public void sendToConsole(String message) {
		Console.getConsole().send(message);
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

	public void setVisibility(boolean value) {
		visible = value;
	}

	public void teleport(Location location) {
		this.getPlayer().setPosition(null); // TODO: Implement location setting
	}
}