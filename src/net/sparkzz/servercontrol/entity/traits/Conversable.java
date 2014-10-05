package net.sparkzz.servercontrol.entity.traits;

import net.sparkzz.servercontrol.user.User;

/**
 * @author Brendon
 */
public interface Conversable {

	/*
	 * Sends a message <i>to</i> the last conversable object that messaged the conversable user in question.
	 * This will return false if there is previously conversed user
	 *
	 * @param	message	message to be sent
	 * @returns	whether or not the target is able to be messaged
	 */
	boolean reply(String message);

	// TODO: Implement sending types

	/*
	 * Sends a message <i>to</i> the conversable object
	 *
	 * @param	message	message to be sent
	 */
	void send(String message);

	/*
	 * Sends a message <i>from</i> the conversable user to a User instance
	 *
	 * @param	target	the messaging target
	 * @param	message	message to be sent
	 */
	void send(User user, String message);

	/*
	 * Returns the last conversable object that conversed with the conversable object in question
	 *
	 * @returns	the last conversable object that messaged the conversable object in question
	 */
	Object getLastConversed();
}