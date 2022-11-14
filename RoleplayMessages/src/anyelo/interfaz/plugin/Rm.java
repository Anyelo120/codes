package anyelo.interfaz.plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import anyelo.central.plugin.Main;

public class Rm implements CommandExecutor {

	private Main plugin;

	public Rm(Main plugin) {
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
			if (player.hasPermission(plugin.getConfig().getString("permission.Rm_Permission"))) {
				if (args.length > 0) {
					if (args[0].equalsIgnoreCase("version")) {
						player.sendMessage(ChatColor.GRAY + "");
						player.sendMessage(plugin.name);
						player.sendMessage(ChatColor.AQUA + plugin.version);
						player.sendMessage(ChatColor.GRAY + "");
						player.sendMessage(ChatColor.GREEN + "By: Anyelo120");
						player.sendMessage(ChatColor.GRAY + "");

						return true;
					} else if (args[0].equalsIgnoreCase("help")) {
						player.sendMessage(ChatColor.GRAY + "");
						player.sendMessage("   " + plugin.name);
						player.sendMessage(ChatColor.AQUA + " Help" + ChatColor.YELLOW + " - All available commands.");
						player.sendMessage(ChatColor.GRAY + "");
						player.sendMessage(ChatColor.YELLOW + "/rm" + ChatColor.DARK_GRAY + " - overall command.");
						player.sendMessage(ChatColor.YELLOW + "/Tinder MESSAGE" + ChatColor.DARK_GRAY
								+ " - Tinder platform global message.");
						player.sendMessage(ChatColor.YELLOW + "/911 MESSAGE" + ChatColor.DARK_GRAY + " - help signal.");
						player.sendMessage(ChatColor.YELLOW + "/Amazon MESSAGE" + ChatColor.DARK_GRAY
								+ " - Amazon platform global message.");
						player.sendMessage(ChatColor.YELLOW + "/Twt MESSAGE" + ChatColor.DARK_GRAY
								+ " - Twitter platform global message.");
						player.sendMessage(ChatColor.YELLOW + "/Instagram MESSAGE" + ChatColor.DARK_GRAY
								+ " - Instagram platform global message.");
						player.sendMessage(
								ChatColor.YELLOW + "/Anon MESSAGE" + ChatColor.DARK_GRAY + " - anonymous message.");
						player.sendMessage(ChatColor.YELLOW + "/Wsp PLAYER MESSAGE" + ChatColor.DARK_GRAY
								+ " - private messages via whatsapp.");
						player.sendMessage(ChatColor.YELLOW + "/Ent PLAYER MESSAGE" + ChatColor.DARK_GRAY
								+ " - environment of a role.");
						player.sendMessage(ChatColor.YELLOW + "/Ooc PLAYER MESSAGE" + ChatColor.DARK_GRAY
								+ " - out of role message.");
						player.sendMessage(ChatColor.GRAY + "");

						return true;
					} else if (args[0].equalsIgnoreCase("reload")) {
						plugin.reloadConfig();
						player.sendMessage(plugin.name + ChatColor.GREEN + " Plugin loaded successfully!");

						return true;
					} else {
						player.sendMessage(plugin.name + ChatColor.translateAlternateColorCodes('&',
								plugin.getConfig().getString("Lang.Command_no_exist")));

						return true;
					}
				} else {
					player.sendMessage(ChatColor.GRAY + "");
					player.sendMessage("   " + plugin.name);
					player.sendMessage("        " + ChatColor.AQUA + plugin.version);
					player.sendMessage(ChatColor.GRAY + "");
					player.sendMessage(
							ChatColor.WHITE + "/rm help" + ChatColor.YELLOW + " - if you need help with the commands.");
					player.sendMessage(ChatColor.WHITE + "/rm reload" + ChatColor.YELLOW + " - reload the plugin.");
					player.sendMessage(ChatColor.WHITE + "/rm version" + ChatColor.YELLOW
							+ " - Are you interested in knowing the current version of the plugin?.");
					player.sendMessage(ChatColor.GRAY + "");

					return true;
				}

			} else {
				sender.sendMessage(plugin.name + ChatColor.translateAlternateColorCodes('&',
						plugin.getConfig().getString("Lang.No_permission")));
			}

		}
		return false;
	}

}