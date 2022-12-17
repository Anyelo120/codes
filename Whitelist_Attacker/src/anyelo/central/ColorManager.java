package anyelo.central;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bukkit.Bukkit;

import net.md_5.bungee.api.ChatColor;

public class ColorManager {

	public static String SetColor(String texto) {
		if (Bukkit.getVersion().contains("1.16")) {
			Pattern pattern = Pattern.compile("#[a-fA-F0-9]{6}");
			Matcher match = pattern.matcher(texto);
			while (match.find()) {
				String color = texto.substring(match.start(), match.end());
				texto = texto.replace(color, ChatColor.of(color) + "");
				match = pattern.matcher(texto);
			}
		}
		return ChatColor.translateAlternateColorCodes('&', texto);
	}
}
