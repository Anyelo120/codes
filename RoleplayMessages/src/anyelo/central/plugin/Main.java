package anyelo.central.plugin;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import anyelo.events.plugin.wspManager;
import anyelo.roleplay.plugin.Commands;
import anyelo.roleplay.plugin.Rm;

public class Main extends JavaPlugin {

	private wspManager mM;
	private String rutaConfig;

	PluginDescriptionFile pdffile = getDescription();
	public String version = pdffile.getVersion();

	public String name = ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("plugin_name"));
	FileConfiguration config;

	@Override
	public void onEnable() {

		Bukkit.getConsoleSender()
				.sendMessage(name + ChatColor.WHITE + "\n\n plugin loaded... (Version: " + ChatColor.YELLOW + version
						+ ChatColor.WHITE + ") \n" + name + ChatColor.YELLOW
						+ " Hello, this is my first addon I hope you like it. \n" + name + ChatColor.YELLOW
						+ " Any suggestion can send to our discord. \n" + name + ChatColor.AQUA
						+ " https://discord.gg/tny6zvh4EC \n" + name + ChatColor.WHITE + " BY: @Anyelo120 \n");
		InsertConfig();
		RegisterCommand();
		mM = new wspManager(this);
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
						+ " Hello, this is my first addon I hope you like it. \n" + name + ChatColor.YELLOW
						+ " Any suggestion can send to our discord. \n" + name + ChatColor.AQUA
						+ " https://discord.gg/tny6zvh4EC \n" + name + ChatColor.WHITE + "BY: @Anyelo120 \n" + name
						+ ChatColor.GREEN + "Plugin closed successfully \n\n");
	}

	public void RegisterCommand() {
		this.getCommand("rm").setExecutor(new Rm(this));
		this.getCommand("wsp").setExecutor(new Commands(this));
		this.getCommand("instagram").setExecutor(new Commands(this));
		this.getCommand("twt").setExecutor(new Commands(this));
		this.getCommand("anon").setExecutor(new Commands(this));
		this.getCommand("911").setExecutor(new Commands(this));
		this.getCommand("amazon").setExecutor(new Commands(this));
		this.getCommand("tinder").setExecutor(new Commands(this));
		this.getCommand("admin").setExecutor(new Commands(this));
		this.getCommand("ooc").setExecutor(new Commands(this));
		this.getCommand("ent").setExecutor(new Commands(this));
		this.getCommand("taxi").setExecutor(new Commands(this));
	}

	public void InsertConfig() {
		File config = new File(this.getDataFolder(), "config.yml");
		setRutaConfig(config.getParent());

		if (!config.exists()) {
			this.getConfig().options().copyDefaults(true);
			saveDefaultConfig();
		}
	}

	public String getRutaConfig() {
		return rutaConfig;
	}

	public void setRutaConfig(String rutaConfig) {
		this.rutaConfig = rutaConfig;
	}

	public wspManager getmM() {
		return mM;
	}

	public void setmM(wspManager mM) {
		this.mM = mM;
	}

}
