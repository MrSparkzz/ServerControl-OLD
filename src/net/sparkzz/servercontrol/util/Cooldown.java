package net.sparkzz.servercontrol.util;

import net.sparkzz.servercontrol.user.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Brendon on 9/25/2014.
 *
 * Public Cooldown API
 */
public class Cooldown extends TimeManager {

	private Map<User, Long> cooldown = new HashMap<User, Long>();

	public Cooldown(String name) {
		cooldowns.put(name, this);
	}

	public static Cooldown getCooldown(String cooldown) {
		if (cooldowns.containsKey(cooldown)) return cooldowns.get(cooldown);
		return null;
	}

	public boolean isCoolingDown(User user) {
		if (cooldown.containsKey(user)) {
			if (cooldown.get(user) - currentTime() > 0)
				return true;
		}

		return false;
	}

	public int getTimeRemaining(User user) {
		int remaining = (int) ((cooldown.get(user)) - currentTime()) / 1000;

		if (remaining > 0) return remaining;
		else return 0;
	}

	public void add(User user, int time) {
		long future = currentTime() + (time * 1000);

		cooldown.put(user, future);
	}

	public void clear() {
		cooldown.clear();
	}

	public void remove(User user) {
		if (cooldown.containsKey(user))
			cooldown.remove(user);
	}
}