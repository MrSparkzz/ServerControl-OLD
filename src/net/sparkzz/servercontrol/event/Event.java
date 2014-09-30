package net.sparkzz.servercontrol.event;

import net.sparkzz.servercontrol.util.Utility;

/**
 * @author Brendon
 */
public class Event extends Utility {

	public static void registerListeners() {
		registerListener(new AttendanceListener());
		registerListener(new ChatListener());
	}

	public static void registerListener(Object listener) {
		game.getEventManager().register(listener);
	}
}
