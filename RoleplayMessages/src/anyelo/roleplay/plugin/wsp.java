package anyelo.roleplay.plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import anyelo.central.plugin.Main;

public class wsp implements CommandExecutor {

	private Main plugin;

	public wsp(Main plugin) {
		this.plugin = plugin;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command command, String Iable, String[] args) {

		if (!(sender instanceof Player)) {
			Bukkit.getConsoleSender().sendMessage(plugin.name
					+ ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Lang.Console_alert")));

			return false;
		} else {
			Player player = (Player) sender;

			if (args.length > 0 && player.hasPermission(plugin.getConfig().getString("permission.Wsp_permission"))) {
				if (Bukkit.getOfflinePlayer(args[0]).getPlayer() != null) {
					Player messager = (Player) sender;
					Player reciever = Bukkit.getOfflinePlayer(args[0]).getPlayer();
					plugin.getmM().setReplyTarget(messager, reciever);

					args[0] = "";
					String message = "";

					for (int i = 0; i < args.length; i++) {
						message += " " + args[i];
					}
					messager.sendMessage(
							ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Messages.Wsp"))
									+ ChatColor.GRAY + "+" + ChatColor.GRAY + reciever.getName() + ChatColor.DARK_GRAY
									+ " >" + ChatColor.DARK_GREEN + message);
					reciever.sendMessage(ChatColor.YELLOW + "[!]"
							+ ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Messages.Wsp"))
							+ ChatColor.GRAY + "+" + ChatColor.GRAY + messager.getName() + ChatColor.DARK_GRAY + " >"
							+ ChatColor.DARK_GREEN + message);

					return true;
				} else {
					sender.sendMessage(plugin.name + ChatColor.translateAlternateColorCodes('&',
							plugin.getConfig().getString("Lang.No_online")));

					return true;
				}

			} else {
				sender.sendMessage(plugin.name + ChatColor.translateAlternateColorCodes('&',
						plugin.getConfig().getString("Lang.Error_alert")));

				return true;
			}
		}
	}
}
