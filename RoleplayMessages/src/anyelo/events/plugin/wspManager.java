package anyelo.events.plugin;

import java.util.HashMap;

import org.bukkit.entity.Player;

import anyelo.central.plugin.Main;

public class wspManager {

	public wspManager(Main plugin) {}

	HashMap<Player, Player> conversations = new HashMap<Player, Player>();

	public void setReplyTarget(Player messager, Player reciever) {

		conversations.put(messager, reciever);
		conversations.put(reciever, messager);
	}

	public Player getReplyTarget(Player messager) {
		return conversations.get(messager);
	}
}
