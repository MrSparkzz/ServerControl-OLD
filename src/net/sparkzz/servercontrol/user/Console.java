package net.sparkzz.servercontrol.user;

import net.sparkzz.servercontrol.entity.traits.Conversable;

/**
 * @author Brendon
 */
public class Console implements Conversable {

	private static final Console console = new Console();
	private User lastConversed;

	public static Console getConsole() {
		return console;
	}

	@Override
	public boolean reply(String message) {
		if (lastConversed != null && lastConversed.isOnline()) {
			// TODO: Implement message sending
			return true;
		}

		return false;
	}

	@Override
	public void send(String message) {
		System.out.println(message);
	}

	@Override
	public void send(User target, String message) {
		// TODO: Implement message sending
	}

	@Override
	public Object getLastConversed() {
		return lastConversed;
	}
}