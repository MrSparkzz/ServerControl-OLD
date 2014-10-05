package net.sparkzz.servercontrol.entity.traits;

import org.spongepowered.api.world.Location;

/**
 * @author Brendon
 */
public interface Positionable {

	// @returns	location of the positionable entity
	Location getLocation();

	// TODO: Implement other location features

	/*
	 * Sets the location of the positionable entity to a location
	 *
	 * @param	location	the location the positionable entity should be moved to
	 */
	void teleport(Location location);
}