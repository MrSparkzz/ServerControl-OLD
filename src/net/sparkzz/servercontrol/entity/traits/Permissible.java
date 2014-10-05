package net.sparkzz.servercontrol.entity.traits;

/**
 * @author Brendon
 */
public interface Permissible {

	/*
	 * This method will return whether or not a user is permitted to perform an action.
	 *
	 * @param 	node	a permission node
	 * @return	whether or not the user has permission
	 */
	boolean isPermitted(String node);
}