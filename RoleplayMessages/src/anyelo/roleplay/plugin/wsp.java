package anyelo.roleplay.plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import anyelo.central.plugin.Main;
import anyelo.events.plugin.Lang;

public class wsp implements CommandExecutor {

	private Main plugin;

	public wsp(Main plugin) {
		this.plugin = plugin;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String Iable, String[] args) {
		Lang TXT = new Lang(plugin);

		if (!(sender instanceof Player)) { TXT.ERROR_CONSOLE(); return false;
		} else {
			if (args.length > 0) {
				if (Bukkit.getOfflinePlayer(args[0]).getPlayer() != null) {
					Player messager = (Player) sender;
					if (messager.hasPermission(plugin.getConfig().getString("permission.wsp_permission"))) {
						Player reciever = Bukkit.getOfflinePlayer(args[0]).getPlayer();
						plugin.getmM().setReplyTarget(messager, reciever);
						args[0] = "";
						String message = "";
						for (int i = 0; i < args.length; i++) {
							message += "" + args[i];
						}
						messager.sendMessage(ChatColor.translateAlternateColorCodes('&',
								plugin.getConfig().getString("Messages." + Iable + ".messager")
										.replace("%player%", reciever.getName()).replace("%message%", message)));
						reciever.sendMessage(ChatColor.translateAlternateColorCodes('&',
								plugin.getConfig().getString("Messages." + Iable + ".reciever")
										.replace("%player%", messager.getName()).replace("%message%", message)));
						return true;
					} else { TXT.ERROR(sender); }
				} else { TXT.ERROR_ONLINE(sender); return false; }
			}
		}
		return false;
	}

}
