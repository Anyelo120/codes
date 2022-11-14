package anyelo.roleplay.plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import anyelo.central.plugin.Main;

public class Admin implements CommandExecutor {

	private Main plugin;

	public Admin(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String Iable, String[] args) {

		if (!(sender instanceof Player)) {
			Bukkit.getConsoleSender().sendMessage(plugin.name
					+ ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Lang.Console_alert")));

			return false;
		} else {
			Player player = (Player) sender;

			if (args.length > 0 && player.hasPermission(plugin.getConfig().getString("permission.Admin_permission"))) {
				Player messager = (Player) sender;

				String message = "";

				for (int i = 0; i < args.length; i++) {
					message += " " + args[i];
				}
				messager.getServer()
						.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
								plugin.getConfig().getString("Messages.Admin")) + ChatColor.GRAY + messager.getName()
								+ ChatColor.GRAY + " +> [" + ChatColor.YELLOW + message + ChatColor.GRAY + " ]");

				return true;
			} else {
				sender.sendMessage(plugin.name + ChatColor.translateAlternateColorCodes('&',
						plugin.getConfig().getString("Lang.Error_alert")));

				return true;
			}
		}
	}
}