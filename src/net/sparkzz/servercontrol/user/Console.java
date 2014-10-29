package net.sparkzz.servercontrol.user;

import net.sparkzz.servercontrol.entity.Source;
import net.sparkzz.servercontrol.util.Utility;

/**
 * @author Brendon
 */
public class Console extends Utility implements Source {

	private static final Console console = new Console();
	private User lastConversed;

	public static Console getConsole() {
		return console;
	}

	public boolean reply(String message) {
		if (lastConversed != null && lastConversed.isOnline()) {
			// TODO: Implement message sending
			return true;
		}

		return false;
	}

	@Override
	public void send(String message) {
		logger.info("[MESSAGE] " + message);
	}

	@Override
	public void send(User target, String message) {
		// TODO: Implement message sending
	}

	@Deprecated
	public void sendMessage(String message) {
		send(message);
	}

	@Override
	public Object getLastConversed() {
		return lastConversed;
	}

	@Override
	public boolean isPermitted(String node) {
		return true;
	}
}