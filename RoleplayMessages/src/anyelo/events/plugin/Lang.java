package anyelo.events.plugin;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import anyelo.central.plugin.Main;

public class Lang {
	
	private Main plugin;

	public Lang(Main plugin) {
		this.plugin = plugin;
	}
	
	public void ERROR(CommandSender sender) {
		sender.sendMessage(plugin.name + ChatColor.translateAlternateColorCodes('&',
				plugin.getConfig().getString("Lang.Error_alert")));
	}
}
