package anyelo.roleplay.plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import anyelo.central.plugin.Main;
import anyelo.events.plugin.Lang;

public class Commands implements CommandExecutor {

	private Main plugin;

	public Commands(Main plugin) {
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
			
			Lang TXT = new Lang(plugin);
			Player player = (Player) sender;

			if (args.length > 0) {
				Player messager = (Player) sender;

				String message = "";

				for (int i = 0; i < args.length; i++) {
					message += " " + args[i];
				}
				
				switch (Iable) {
				case "admin":
					if (player.hasPermission(plugin.getConfig().getString("permission.Admin_permission"))) {
						messager.getServer()
								.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
										plugin.getConfig().getString("Messages.Admin")) + ChatColor.GRAY
										+ messager.getName() + ChatColor.GRAY + " +> [" + ChatColor.YELLOW + message
										+ ChatColor.GRAY + " ]");
					} else { TXT.ERROR(sender); }
					break;
				case "instagram":
					if (player.hasPermission(plugin.getConfig().getString("permission.Instagram_permission"))) {
						messager.getServer()
								.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
										plugin.getConfig().getString("Messages.Instagram")) + ChatColor.GRAY + "@"
										+ ChatColor.GRAY + messager.getName() + ChatColor.DARK_GRAY + " >"
										+ ChatColor.YELLOW + message);
					} else { TXT.ERROR(sender); }
					break;
				case "ooc":
					if (player.hasPermission(plugin.getConfig().getString("permission.Ooc_permission"))) {
						messager.getServer()
								.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
										plugin.getConfig().getString("Messages.Ooc")) + ChatColor.GRAY
										+ messager.getName() + ChatColor.DARK_GRAY + "> " + ChatColor.GRAY + message);
					} else { TXT.ERROR(sender); }
					break;
				case "amazon":
					if (player.hasPermission(plugin.getConfig().getString("permission.Amazon_permission"))) {
						messager.getServer()
								.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
										plugin.getConfig().getString("Messages.Amazon")) + ChatColor.GRAY + "@"
										+ ChatColor.GRAY + messager.getName() + ChatColor.GRAY + " >>" + ChatColor.RED
										+ message);
					} else { TXT.ERROR(sender); }
					break;
				case "anon":
					if (player.hasPermission(plugin.getConfig().getString("permission.Anon_permission"))) {
						messager.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&',
								plugin.getConfig().getString("Messages.Anon")) + ChatColor.RED + message);
					} else { TXT.ERROR(sender); }
					break;
				case "911":
					if (player.hasPermission(plugin.getConfig().getString("permission.Emergency_permission"))) {
						messager.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&',
								plugin.getConfig().getString("Messages.Emergency")) + ChatColor.RED + message);
					} else { TXT.ERROR(sender); }
					break;
				case "ent":
					if (player.hasPermission(plugin.getConfig().getString("permission.Environment_permission"))) {
						messager.getServer()
								.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
										plugin.getConfig().getString("Messages.Environment")) + ChatColor.GRAY
										+ messager.getName() + ChatColor.DARK_GRAY + "> " + ChatColor.YELLOW + message);
					} else { TXT.ERROR(sender); }
					break;
				case "tinder":
					if (player.hasPermission(plugin.getConfig().getString("permission.Tinder_permission"))) {
						messager.getServer()
								.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
										plugin.getConfig().getString("Messages.Tinder")) + ChatColor.GRAY + "@"
										+ ChatColor.GRAY + messager.getName() + ChatColor.GRAY + " ->"
										+ ChatColor.LIGHT_PURPLE + message);
					} else { TXT.ERROR(sender); }
					break;
				case "twt":
					if (player.hasPermission(plugin.getConfig().getString("permission.Twt_permission"))) {
						messager.getServer()
								.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
										plugin.getConfig().getString("Messages.Twt")) + ChatColor.GRAY + "@"
										+ ChatColor.GRAY + messager.getName() + ChatColor.DARK_GRAY + " |>"
										+ ChatColor.AQUA + message);
					} else { TXT.ERROR(sender); }
					break;
				case "wsp":
					if (player.hasPermission(plugin.getConfig().getString("permission.Wsp_permission"))) {
						if (Bukkit.getOfflinePlayer(args[0]).getPlayer() != null) {
							Player reciever = Bukkit.getOfflinePlayer(args[0]).getPlayer();
							plugin.getmM().setReplyTarget(messager, reciever);

							messager.sendMessage(
									ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Messages.Wsp"))
											+ ChatColor.GRAY + "+" + ChatColor.GRAY + reciever.getName() + ChatColor.DARK_GRAY
											+ " >" + ChatColor.DARK_GREEN + message);
							reciever.sendMessage(ChatColor.YELLOW + "[!]"
									+ ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Messages.Wsp"))
									+ ChatColor.GRAY + "+" + ChatColor.GRAY + messager.getName() + ChatColor.DARK_GRAY + " >"
									+ ChatColor.DARK_GREEN + message);
						} else {sender.sendMessage(plugin.name + ChatColor.translateAlternateColorCodes('&',
								plugin.getConfig().getString("Lang.No_online")));}
					} else {TXT.ERROR(sender); }
					break;
				case "taxi":
					if (player.hasPermission(plugin.getConfig().getString("permission.Taxi_permission"))) {
						messager.getServer()
								.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
										plugin.getConfig().getString("Messages.Taxi")) + ChatColor.GRAY + "@"
										+ ChatColor.GRAY + messager.getName() + ChatColor.DARK_GRAY + " >"
										+ ChatColor.YELLOW + message);
					} else { TXT.ERROR(sender); }
					break;
				}
				
				return true;
			} else {
				TXT.ERROR(sender);
				return false;
			}
		}
	}
}