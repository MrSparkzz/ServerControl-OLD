package net.sparkzz.servercontrol.event;

import net.sparkzz.servercontrol.util.Utility;

/**
 * Created by Brendon on 9/26/2014.
 */
public class Event extends Utility {

	public static void registerEvents() {
		registerEvent(new AttendanceListener());
		registerEvent(new ChatListener());
	}

	public static void registerEvent(Object listener) {
		game.getEventManager().register(listener);
	}

	public static void unRegisterEvents() {
		unRegisterEvent(null);
	}

	public static void unRegisterEvent(Object object) {
		game.getEventManager().unregister(object);
	}
}