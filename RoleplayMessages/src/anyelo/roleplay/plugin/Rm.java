package anyelo.roleplay.plugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import anyelo.central.plugin.Main;
import anyelo.events.plugin.Lang;

public class Rm implements CommandExecutor {

	private Main plugin;

	public Rm(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String Iable, String[] args) {
		Lang TXT = new Lang(plugin);
		if (!(sender instanceof Player)) { TXT.ERROR_CONSOLE(); return false;
		} else {
			Player player = (Player) sender;
			if (player.hasPermission(plugin.getConfig().getString("permission.rm_permission"))) {
				if (args.length > 0) {
					if (args[0].equalsIgnoreCase("version")) {
						player.sendMessage("\n" + plugin.name + "\n" + ChatColor.AQUA + plugin.version + "\n"
								+ ChatColor.GREEN + "By: Anyelo120" + "\n");

						return true;
					} else if (args[0].equalsIgnoreCase("help")) {
						player.sendMessage("\n   " + plugin.name + ChatColor.AQUA + "\n Help" + ChatColor.YELLOW
								+ " - All available commands.\n" + ChatColor.YELLOW + "/rm" + ChatColor.DARK_GRAY
								+ " - overall command. \n" + ChatColor.YELLOW + "/Tinder MESSAGE" + ChatColor.DARK_GRAY
								+ " - Tinder platform global message. \n" + ChatColor.YELLOW + "/911 MESSAGE"
								+ ChatColor.DARK_GRAY + " - help signal. \n" + ChatColor.YELLOW + "/Amazon MESSAGE"
								+ ChatColor.DARK_GRAY + " - Amazon platform global message. \n" + ChatColor.YELLOW
								+ "/Twt MESSAGE" + ChatColor.DARK_GRAY + " - Twitter platform global message.\n"
								+ ChatColor.YELLOW + "/Instagram MESSAGE" + ChatColor.DARK_GRAY
								+ " - Instagram platform global message.\n" + ChatColor.YELLOW + "/Anon MESSAGE"
								+ ChatColor.DARK_GRAY + " - anonymous message. \n" + ChatColor.YELLOW
								+ "/Wsp PLAYER MESSAGE" + ChatColor.DARK_GRAY + " - private messages via whatsapp. \n"
								+ ChatColor.YELLOW + "/Ent PLAYER MESSAGE" + ChatColor.DARK_GRAY
								+ " - environment of a role.\n" + ChatColor.YELLOW + "/Ooc MESSAGE"
								+ ChatColor.DARK_GRAY + " - out of role message. \n" + ChatColor.YELLOW
								+ "/Taxi MESSAGE" + ChatColor.DARK_GRAY
								+ " - look for transportation around the world. \n");

						return true;
					} else if (args[0].equalsIgnoreCase("reload")) {
						plugin.reloadConfig();
						player.sendMessage(plugin.name + ChatColor.GREEN + " Plugin loaded successfully!");

						return true;
					} else { TXT.ERROR(sender); return false; }
				} else {
					player.sendMessage(
							"\n" + plugin.name + "\n      " + ChatColor.AQUA + plugin.version + "\n" + ChatColor.WHITE
									+ "/rm help" + ChatColor.YELLOW + " - if you need help with the commands. \n"
									+ ChatColor.WHITE + "/rm reload" + ChatColor.YELLOW + " - reload the plugin. \n"
									+ ChatColor.WHITE + "/rm version" + ChatColor.YELLOW
									+ " - Are you interested in knowing the current version of the plugin?. \n");

					return true;
				}
			} else { TXT.ERROR(sender); }
		}
		return false;
	}

}