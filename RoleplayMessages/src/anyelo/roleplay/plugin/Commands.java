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
				MManager.MessageBasic(sender, player, messager, message, Iable);
				
				return true;
			} else { TXT.ERROR(sender); return false; }
		}
	}
}