package anyelo.central;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	PluginDescriptionFile pdfFile = getDescription();
	public String version = pdfFile.getVersion();
	String name = ColorManager.SetColor(this.getConfig().getString("plugin_name"));
	private List<String> ListPlayers;

	@SuppressWarnings("unused")
	@Override
	public void onEnable() {
		Bukkit.getConsoleSender()
		.sendMessage(name + ChatColor.WHITE + "\n\n plugin loaded... (Version: " + ChatColor.YELLOW + version
				+ ChatColor.WHITE + ") \n" + name + ChatColor.YELLOW
				+ " Hello, Thank you very much for downloading my plugin. \n" + name + ChatColor.YELLOW
				+ " Any suggestion can send to our discord. \n" + name + ChatColor.AQUA
				+ " https://discord.gg/tny6zvh4EC \n" + name + ChatColor.WHITE + " BY: @Anyelo120 \n");
		RegisterEvents();
		RegisterCommands();
		RegisterConfig();
		saveDefaultConfig();

		FileConfiguration config = getConfig();
		if (config == null) {
			getLogger().severe("Error loading config.yml");
		} else {
			getLogger().info("Config.yml loaded successfully");
		}
		WhitelistAtacckerAPI api = new WhitelistAtacckerAPI(this);
		Bukkit.getConsoleSender()
		.sendMessage(ChatColor.GREEN + name + "\n========================================================"
				+ ChatColor.GREEN + "\n============== Plugin loaded successfully =============="
				+ ChatColor.GREEN + "\n======================================================== \n\n");
	}
	
	@Override
	public void onDisable() {
		Bukkit.getConsoleSender()
		.sendMessage(name + ChatColor.WHITE + "\n\n plugin off...(Version: " + ChatColor.YELLOW + version
				+ ChatColor.WHITE + ") \n" + name + ChatColor.YELLOW
				+ " Hello, I hope this plugin has helped and served you. \n" + name + ChatColor.YELLOW
				+ " Any suggestion can send to our discord. \n" + name + ChatColor.AQUA
				+ " https://discord.gg/tny6zvh4EC \n" + name + ChatColor.WHITE + "BY: @Anyelo120 \n" + name
				+ ChatColor.GREEN + "Plugin closed successfully \n\n");
		SaveConfig();
	}

	public void RegisterCommands(){
		this.getCommand("verify").setExecutor(new CommandAdmin(this));
	}
	
	public void RegisterEvents(){
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new ListenerPlayer(this), this);
	}
	
	public void RegisterConfig(){	
		File config = new File(this.getDataFolder(), "config.yml");
	    if(!config.exists()){
	    	this.getConfig().options().copyDefaults(true);
			saveConfig();  
	    }
	} 
	
	public void AddPlayer(String player) {
		this.ListPlayers.add(player);
	}
	
	public boolean ContainsPlayers(String player) {
		if(ListPlayers.contains(player.toLowerCase())) {
			return true;
		}else {
			return false;
		}
	}
	
	public void SaveConfig() {
		getConfig().set("Players", ListPlayers);
		saveConfig();
	}
	
	public void LoadConfig() {
		this.ListPlayers = new ArrayList<String>();
		FileConfiguration config = getConfig();
		if(config.contains("Players")) {
			this.ListPlayers = config.getStringList("Players");
		}
	}
}
