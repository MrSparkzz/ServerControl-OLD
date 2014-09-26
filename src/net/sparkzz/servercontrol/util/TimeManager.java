package net.sparkzz.servercontrol.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Brendon on 9/25/2014.
 */
public class TimeManager {

	protected static Map<String, Cooldown> cooldowns = new HashMap<String, Cooldown>();

	public static long currentTime() {
		return System.currentTimeMillis();
	}
}