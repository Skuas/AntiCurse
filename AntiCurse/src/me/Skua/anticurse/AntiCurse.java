package me.Skua.anticurse;

import java.util.List;

import org.bukkit.ChatColor;
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
		 * m = Message
		 * w = Warning
		 * f = Filter
		 * p = Player
		 */
		
        String m = e.getMessage();
        String w = getConfig().getString("Warning");
        List<String> f = getConfig().getStringList("Filter");
        
        Player p = e.getPlayer();
	    
        for(String string : f) {
            if(m.contains(" " + string + " ")) {
             	e.setCancelled(true);
            	p.sendMessage(ChatColor.RED + w);
        	  break;
            }
        }
    }
}
