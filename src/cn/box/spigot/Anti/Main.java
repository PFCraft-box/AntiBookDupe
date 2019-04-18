package cn.box.spigot.Anti;

import org.bukkit.plugin.java.*;
import org.bukkit.plugin.*;
import org.bukkit.event.player.*;
import org.bukkit.event.*;
import java.nio.charset.*;

public final class Main extends JavaPlugin implements Listener
{
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this);
    }
    
    @EventHandler
    public void onPlayerEditBook(final PlayerEditBookEvent event) {
        for (final String page : event.getNewBookMeta().getPages()) {
            if (!this.Charset(page)) {
                event.setCancelled(true);
                event.getPlayer().kickPlayer("利用漏洞");
            }
        }
    }
    
    public boolean Charset(final String input) {
        return Charset.forName("US-ASCII").newEncoder().canEncode(input);
    }
}
