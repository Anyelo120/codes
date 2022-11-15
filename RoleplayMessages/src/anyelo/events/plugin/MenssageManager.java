package anyelo.events.plugin;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import anyelo.central.plugin.Main;

public class MenssageManager {

	private Main plugin;

	public MenssageManager(Main plugin) {
		this.plugin = plugin;
	}

	public void MessageBasic(Player messager, String message, String Iable) {
		messager.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig()
				.getString("Messages." + Iable).replace("%player%", messager.getName()).replace("%message%", message)));
	}
}
