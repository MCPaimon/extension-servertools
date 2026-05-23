package io.github.mcpaimon.extension.server;

import io.github.mcpaimon.extension.server.tools.*;
import io.github.mcpaimon.mcextension.api.IMCExtension;
import io.github.mcpaimon.papermc.MCAIPlugin;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.Executor;

public class ServerExtension implements IMCExtension {

    @Override
    public void onLoad(JavaPlugin plugin, Executor executor) {
        if (plugin instanceof MCAIPlugin mcaiPlugin) {
            
            // Create the server category
            mcaiPlugin.getManager().createCategory("server", "Tools for server information and status");
            
            // Register your custom server tools here
            mcaiPlugin.getManager().registerTool(new GetServerTickTool());
            mcaiPlugin.getManager().registerTool(new GetServerPingTool());
            mcaiPlugin.getManager().registerTool(new GetServerIpTool());
            mcaiPlugin.getManager().registerTool(new GetServerPluginTool());
            
            plugin.getLogger().info("Server extension loaded successfully. Tools registered.");
        } else {
            plugin.getLogger().severe("Failed to load Server extension: Host plugin is not MCAIPlugin.");
        }
    }

    @Override
    public void onDisable(JavaPlugin plugin, Executor executor) {
        plugin.getLogger().info("Server extension has been disabled.");
    }
}
