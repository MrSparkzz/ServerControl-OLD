package net.sparkzz.servercontrol.util;

/**
 * @author Brendon
 *
 * Public Messaging API
 */
public class Messenger extends Utility {

	private static Messenger msg = new Messenger();

	public static Messenger getMessenger() {
		return msg;
	}

	public String buildString(int start, String[] args) {
		StringBuilder str = new StringBuilder();

		for (int i = start; i < args.length; i++) {
			str.append(args[i] + " ");
		}

		return str.toString();
	}
}