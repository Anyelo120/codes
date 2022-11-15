package anyelo.events.plugin;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import anyelo.central.plugin.Main;

public class MenssageManager {

	private Main plugin;

	public MenssageManager(Main plugin) {
		this.plugin = plugin;
	}

	public void MessageBasic(CommandSender sender, Player player, Player messager, String message, String Iable) {
		Lang TXT = new Lang(plugin);
		if (player.hasPermission(plugin.getConfig().getString("permission." + Iable + "_permission"))) {
			messager.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig()
					.getString("Messages." + Iable).replace("%player%", messager.getName()).replace("%message%", message)));
		} else { TXT.ERROR(sender); }
	}
}
