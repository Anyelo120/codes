package anyelo.central.plugin;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import anyelo.events.plugin.wspManager;
import anyelo.interfaz.plugin.Rm;
import anyelo.roleplay.plugin.Admin;
import anyelo.roleplay.plugin.Amazon;
import anyelo.roleplay.plugin.Anon;
import anyelo.roleplay.plugin.Emergency;
import anyelo.roleplay.plugin.Environment;
import anyelo.roleplay.plugin.Instagram;
import anyelo.roleplay.plugin.Ooc;
import anyelo.roleplay.plugin.Tinder;
import anyelo.roleplay.plugin.Twt;
import anyelo.roleplay.plugin.wsp;

public class Main extends JavaPlugin {

	private wspManager mM;
    private String rutaConfig;

	PluginDescriptionFile pdffile = getDescription();
	public String version = pdffile.getVersion();

	public String name = ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("plugin_name"));
    FileConfiguration config;

	@Override
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage(name + ChatColor.WHITE + " plugin loaded...(Version: " + ChatColor.YELLOW
				+ version + ChatColor.WHITE + ")");
		Bukkit.getConsoleSender()
				.sendMessage(name + ChatColor.YELLOW + " Hello, this is my first addon I hope you like it.");
		Bukkit.getConsoleSender().sendMessage(name + ChatColor.YELLOW + " Any suggestion can send to our discord.");
		Bukkit.getConsoleSender().sendMessage(name + ChatColor.AQUA + " https://discord.gg/tny6zvh4EC");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage(name + ChatColor.WHITE + " BY: @Anyelo120");

		InsertConfig();
		RegisterCommand();
		mM = new wspManager(this);

		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage(name + ChatColor.GREEN + " Plugin loaded successfully");
	}

	@Override
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(name + ChatColor.WHITE + " plugin off...(Version: " + ChatColor.YELLOW
				+ version + ChatColor.WHITE + ")");
		Bukkit.getConsoleSender()
				.sendMessage(name + ChatColor.YELLOW + " Hello, this is my first addon I hope you like it.");
		Bukkit.getConsoleSender().sendMessage(name + ChatColor.YELLOW + " Any suggestion can send to our discord.");
		Bukkit.getConsoleSender().sendMessage(name + ChatColor.AQUA + " https://discord.gg/tny6zvh4EC");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage(name + ChatColor.WHITE + " BY: @Anyelo120");
		Bukkit.getConsoleSender().sendMessage(name + ChatColor.GREEN + " Plugin closed successfully");
	}

	public void RegisterCommand() {
		this.getCommand("wsp").setExecutor(new wsp(this));
		this.getCommand("instagram").setExecutor(new Instagram(this));
		this.getCommand("twt").setExecutor(new Twt(this));
		this.getCommand("anon").setExecutor(new Anon(this));
		this.getCommand("911").setExecutor(new Emergency(this));
		this.getCommand("amazon").setExecutor(new Amazon(this));
		this.getCommand("tinder").setExecutor(new Tinder(this));
		this.getCommand("rm").setExecutor(new Rm(this));
		this.getCommand("admin").setExecutor(new Admin(this));
		this.getCommand("ooc").setExecutor(new Ooc(this));
		this.getCommand("ent").setExecutor(new Environment(this));
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
