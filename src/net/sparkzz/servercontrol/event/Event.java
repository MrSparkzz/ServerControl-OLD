package net.sparkzz.servercontrol.event;

import net.sparkzz.servercontrol.util.Utility;

/**
 * Created by Brendon on 9/26/2014.
 */
public class Event extends Utility {

	public static void registerListeners() {
		registerListener(new AttendanceListener());
		registerListener(new ChatListener());
	}

	public static void registerListener(Object listener) {
		game.getEventManager().register(listener);
	}

	public static void unregisterListeners() {
		unregisterListener(null); //wtf
	}

	public static void unregisterListener(Object listener) {
		game.getEventManager().unregister(listener);
	}
}
