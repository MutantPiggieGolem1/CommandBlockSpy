package me.pew.commandblockspy;

import org.bukkit.Location;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerCommandEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandBlockSpy extends JavaPlugin {
    @Override
    public void onEnable() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new CmdListener(), this);
    }

    class CmdListener implements Listener {
        @EventHandler
        public void onCmd(ServerCommandEvent event) {
            if (!(event.getSender() instanceof BlockCommandSender source)) return;
            Location loc = source.getBlock().getLocation();
            getServer().broadcast("[" + source.getBlock().getType().toString() + " @ " + loc.toString() + "]: " + event.getCommand(), "commandblockspy.spy");
        }
    }
}

