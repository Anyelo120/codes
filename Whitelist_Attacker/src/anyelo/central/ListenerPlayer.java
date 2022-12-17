package anyelo.central;

import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class ListenerPlayer implements Listener {

	private Main plugin;

	public ListenerPlayer(Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void Join(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		if (!WhitelistAtacckerAPI.Verify(player)) {
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
	    if (event.isCancelled()) {
	        return;
	    }

	    Player attacker = getPlayerFromEntity(event.getDamager());
	    Player damaged = getPlayerFromEntity(event.getEntity());
	    if (attacker != null && damaged != null) {
	        PlayerDamageByPlayerEvent newEvent = new PlayerDamageByPlayerEvent(attacker, damaged);
	        plugin.getServer().getPluginManager().callEvent(newEvent);
	        if (newEvent.isCancelled()) {
	            event.setCancelled(true);
	            return;
	        }
	    }
	}

	private Player getPlayerFromEntity(Entity entity) {
	    if (entity instanceof Player) {
	        return (Player) entity;
	    } else if (entity.getType().equals(EntityType.ARROW)) {
	        Arrow arrow = (Arrow) entity;
	        if (arrow.getShooter() instanceof Player) {
	            return (Player) arrow.getShooter();
	        }
	    }
	    return null;
	}

	@EventHandler
	public void PlayerEvent(PlayerDamageByPlayerEvent event) {
		Player atacante = event.getDamager();
		Player defensor = event.getTarget();
		FileConfiguration config = plugin.getConfig();
		if (atacante.getName().equals(defensor.getName())) {
			return;
		}

		if (!plugin.ContainsPlayers(atacante.getName())) {
			List<String> msg = config.getStringList("Messages.errorPvPDamager");
			for (String linea : msg) {
				atacante.sendMessage(ColorManager.SetColor(linea));
			}
			event.setCancelled(true);
			return;
		}
		if (!plugin.ContainsPlayers(defensor.getName())) {
			List<String> msg = config.getStringList("Messages.errorPvPTarget");
			for (String linea : msg) {
				atacante.sendMessage(ColorManager.SetColor(linea));
			}
			event.setCancelled(true);
			return;
		}
	}
}
