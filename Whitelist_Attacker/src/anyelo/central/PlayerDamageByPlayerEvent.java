package anyelo.central;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerDamageByPlayerEvent extends Event implements Cancellable {

	private Player damager;
	private Player target;
	private boolean isCancelled;
	private static final HandlerList handlers = new HandlerList();

	public PlayerDamageByPlayerEvent(Player damager, Player target) {
		this.damager = damager;
		this.target = target;
		this.isCancelled = false;
	}

	public Player getDamager() {
		return damager;
	}

	public Player getTarget() {
		return target;
	}

	public boolean isCancelled() {
		return this.isCancelled;
	}

	public void setCancelled(boolean arg0) {
		this.isCancelled = arg0;
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}
}
