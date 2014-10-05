package net.sparkzz.servercontrol.entity;

import net.sparkzz.servercontrol.entity.traits.Positionable;

/**
 * @author Brendon
 */
public interface Humanoid extends Positionable {

	//@returns the name of the humanoid
	String getName();
}