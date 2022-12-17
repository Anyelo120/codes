package anyelo.central;

import org.bukkit.entity.Player;

public class WhitelistAtacckerAPI {

	private static Main plugin;
	
	@SuppressWarnings("static-access")
	public WhitelistAtacckerAPI(Main plugin) {
		this.plugin = plugin;
	}
	
	public static boolean Verify(Player jugador) {
		return plugin.ContainsPlayers(jugador.getName());
	}
}
