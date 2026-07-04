package io.github.mcpaimon.extension.server.papermc;

import io.github.mcpaimon.extension.server.tools.*;
import io.github.mcpaimon.mcextension.api.IMCExtension;
import io.github.mcpaimon.papermc.MCAgentsPlugin;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.Executor;

/**
 * The ServerTools extension class for the MCAgents system on PaperMC.
 * This class acts as the entry point for registering the server information
 * tools and their category into the runtime environment.
 */
public class ServerTools implements IMCExtension {

    /**
     * Invoked when the extension is loaded by the extension manager.
     * @param plugin   The host plugin instance executing this extension.
     * @param executor The executor thread provided for async operations if needed.
     */
    @Override
    public void onLoad(Object plugin, Executor executor) {
        if (plugin instanceof MCAgentsPlugin mcagentsPlugin) {

            // Create the server category
            mcagentsPlugin.getProvider().createCategory("server", "Tools for server information and status");

            // Register the server tools
            mcagentsPlugin.getProvider().registerTool(new GetServerTickTool());
            mcagentsPlugin.getProvider().registerTool(new GetServerPingTool());
            mcagentsPlugin.getProvider().registerTool(new GetServerIpTool());
            mcagentsPlugin.getProvider().registerTool(new GetServerPluginTool());

            mcagentsPlugin.getLogger().info("ServerTools extension loaded successfully on PaperMC. Tools registered.");
        } else if (plugin instanceof JavaPlugin javaPlugin) {
            javaPlugin.getLogger().severe("Failed to load ServerTools extension: Host plugin is not MCAgentsPlugin.");
        }
    }

    /**
     * Invoked when the extension is disabled.
     * @param plugin   The host plugin instance executing this extension.
     * @param executor The executor thread provided for async operations if needed.
     */
    @Override
    public void onDisable(Object plugin, Executor executor) {
        if (plugin instanceof JavaPlugin javaPlugin) {
            javaPlugin.getLogger().info("ServerTools extension has been disabled on PaperMC.");
        }
    }
}
