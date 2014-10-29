package net.sparkzz.servercontrol.event;

import net.sparkzz.servercontrol.user.User;
import org.spongepowered.api.entity.Player;
import org.spongepowered.api.event.SpongeEventHandler;

/**
 * @author Brendon
 */
public class PlayerListener {

	boolean gravestones = true; //TODO: configuration

	@SpongeEventHandler
	public void onInventoryClose() {
		User user = User.getUser("");

		if (user.isInvsee()) user.setInvsee(false);
	}

	@SpongeEventHandler
	public void onDeath() {
		if (gravestones) {
			// create a gravestone based on either a schematic or config where the player died with a chest full of their inventory
		}
	}

	@SpongeEventHandler
	public void onInventoryClick() {
		User user = User.getUser("");

		if (user.isInvsee()) {

		}
	}
}