package net.sparkzz.servercontrol.user;

import net.sparkzz.servercontrol.entity.Source;
import net.sparkzz.servercontrol.entity.traits.Conversable;

/**
 * @author Brendon
 */
public class ConnectedUser implements Source {

	// TODO: This class will be used for players who connect to chat via app/applet/messaging app (maybe kik integration?)/etc.

	@Override
	public boolean isPermitted(String node) {
		return false;
	}

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

	@Deprecated
	@Override
	public void sendMessage(String message) {
		send(message);
	}

	@Override
	public Object getLastConversed() {
		return null;
	}
}