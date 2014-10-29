package net.sparkzz.servercontrol.entity;

import net.sparkzz.servercontrol.entity.traits.Conversable;
import net.sparkzz.servercontrol.entity.traits.Permissible;
import org.spongepowered.api.util.command.CommandSource;

/**
 * @author Brendon
 */
public interface Source extends CommandSource, Conversable, Permissible {

}