package anyelo.central;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class CommandAdmin implements CommandExecutor {

	private Main plugin;

	public CommandAdmin(Main plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		FileConfiguration config = plugin.getConfig();
		if (!(sender instanceof Player)) {
			Bukkit.getConsoleSender()
					.sendMessage(ColorManager.SetColor(plugin.name + config.getString("Messages.ConsoleError")));
			return false;
		}
		Player player = (Player) sender;
		if (player.isOp() || player.hasPermission(plugin.getConfig().getString("Permission.Verify"))) {
			if (args.length >= 1) {
				// verificado <jugador>
				String nombre = args[0];
				if (plugin.ContainsPlayers(nombre)) {
					player.sendMessage(ColorManager.SetColor(
							plugin.name + config.getString("Messages.alreadyVerified").replace("%player%", nombre)));
					return true;
				}
				plugin.ContainsPlayers(nombre.toLowerCase());
				player.sendMessage(ColorManager.SetColor(
						plugin.name + config.getString("Messages.verifiedSuccessfully").replace("%player%", nombre)));
			} else {
				player.sendMessage(ColorManager.SetColor(plugin.name + config.getString("Messages.ErrorArgs")));
			}
		}
		return true;

	}
}
