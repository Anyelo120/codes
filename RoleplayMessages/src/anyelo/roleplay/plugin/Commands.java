package anyelo.roleplay.plugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import anyelo.central.plugin.Main;
import anyelo.events.plugin.Lang;
import anyelo.events.plugin.MenssageManager;

public class Commands implements CommandExecutor {

	private Main plugin;

	public Commands(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String Iable, String[] args) {
		Lang TXT = new Lang(plugin);
		if (!(sender instanceof Player)) { TXT.ERROR_CONSOLE(); return false;
		} else {
			Player player = (Player) sender;

			if (args.length > 0) {
				Player messager = (Player) sender;

				String message = "";

				for (int i = 0; i < args.length; i++) {
					message += "" + args[i];
				}
				MenssageManager MManager = new MenssageManager(plugin);
				switch (Iable) {
				case "admin":
					if (player.hasPermission(plugin.getConfig().getString("permission.Admin_permission"))) {
						MManager.MessageBasic(messager, message, Iable);
					} else { TXT.ERROR(sender); }
					break;
				case "instagram":
					if (player.hasPermission(plugin.getConfig().getString("permission.Instagram_permission"))) {
						MManager.MessageBasic(messager, message, Iable);
					} else { TXT.ERROR(sender); }
					break;
				case "ooc":
					if (player.hasPermission(plugin.getConfig().getString("permission.Ooc_permission"))) {
						MManager.MessageBasic(messager, message, Iable);
					} else { TXT.ERROR(sender); }
					break;
				case "amazon":
					if (player.hasPermission(plugin.getConfig().getString("permission.Amazon_permission"))) {
						MManager.MessageBasic(messager, message, Iable);
					} else { TXT.ERROR(sender); }
					break;
				case "anon":
					if (player.hasPermission(plugin.getConfig().getString("permission.Anon_permission"))) {
						MManager.MessageBasic(messager, message, Iable);
					} else { TXT.ERROR(sender); }
					break;
				case "911":
					if (player.hasPermission(plugin.getConfig().getString("permission.911_permission"))) {
						MManager.MessageBasic(messager, message, Iable);
					} else { TXT.ERROR(sender); }
					break;
				case "ent":
					if (player.hasPermission(plugin.getConfig().getString("permission.Ent_permission"))) {
						MManager.MessageBasic(messager, message, Iable);
					} else { TXT.ERROR(sender); }
					break;
				case "tinder":
					if (player.hasPermission(plugin.getConfig().getString("permission.Tinder_permission"))) {
						MManager.MessageBasic(messager, message, Iable);
					} else { TXT.ERROR(sender); }
					break;
				case "twt":
					if (player.hasPermission(plugin.getConfig().getString("permission.Twt_permission"))) {
						MManager.MessageBasic(messager, message, Iable);
					} else { TXT.ERROR(sender); }
					break;
				case "taxi":
					if (player.hasPermission(plugin.getConfig().getString("permission.Taxi_permission"))) {
						MManager.MessageBasic(messager, message, Iable);
					} else { TXT.ERROR(sender); }
					break;
				}
				return true;
			} else { TXT.ERROR(sender); return false; }
		}
	}
}