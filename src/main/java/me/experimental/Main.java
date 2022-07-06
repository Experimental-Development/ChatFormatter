package me.experimental;
/*
    
    This file is licensed by ExperimentalX. Unless you have
    specific permission from ExperimentalX, you are not
    permitted to touch this file at all. It is open
    sourced so you can see how I did it, not for
    you to copy off of it.
    
    Please. If you are trying to learn, don't copy off of
    other people, see what they did, and try to do it better.
    See if you can figure out why it works the way it does.
    
    This was written by ExperimentalX on 7/5/2022 for
    ChatFormatter
    
*/

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
    public void onEnable() {
        getLogger().info("ChatFormatter Loading");
        if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") == null) {
            getLogger().severe("You are missing PlaceholderAPI. This plugin will not function properly.");
            this.getPluginLoader().disablePlugin(this);
        } else {
            Bukkit.getPluginManager().registerEvents(this, this);
        }
    }

    public void onDisable() {
        getLogger().severe("Unloading ChatFormatter");
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        String format = ChatColor.translateAlternateColorCodes('&', "%luckperms_prefix%"+e.getPlayer().getName().toString()+"%luckperms_suffix% &7>> "+e.getMessage());
        format = PlaceholderAPI.setPlaceholders(e.getPlayer(), format);
        e.setFormat(format);
    }
}
