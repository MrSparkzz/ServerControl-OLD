package net.sparkzz.servercontrol.user;

import net.sparkzz.servercontrol.entity.traits.Conversable;

/**
 * @author Brendon
 */
public class ConnectedUser implements Conversable {

	// TODO: This class will be used for players whom connect via app/applet/messaging app (maybe kik integration?)/etc.

	@Override
	public boolean reply(String message) {
		return false;
	}

	@Override
	public void send(String message) {

	}

	@Override
	public void send(User user, String message) {

	}

	@Override
	public Object getLastConversed() {
		return null;
	}
}