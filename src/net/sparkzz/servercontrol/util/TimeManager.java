package net.sparkzz.servercontrol.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brendon
 */
public class TimeManager {

	protected static Map<String, Cooldown> cooldowns = new HashMap<String, Cooldown>();

	public static long currentTime() {
		return System.currentTimeMillis();
	}

	public static void clearCooldowns() {
		cooldowns.clear();
	}
}