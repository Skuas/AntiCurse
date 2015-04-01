package me.Skua.anticurse;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class AntiCurse extends JavaPlugin implements Listener {

	public void onEnable() {
		
		getServer().getPluginManager().registerEvents(this, this);
		saveDefaultConfig(); 
		
	}
	
	public void onDisable() {
		
	}
	
	@EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
		
		/*
		 * m = message
		 * f = filter
		 * w = warning
		 * p = player
		 */
		
        String m = e.getMessage();
        String f = getConfig().getString("filter.1");
        String w = getConfig().getString("warning");
        
        Player p = e.getPlayer();
	    
        if (m.contains(f)) {
		
        	e.setCancelled(true);
        	p.sendMessage(w);
        	
	    }
	}
}
