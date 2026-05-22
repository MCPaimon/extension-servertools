package io.github.mcpaimon.extension.server.tools;

import io.github.mcpaimon.api.model.AIAccount;
import io.github.mcpaimon.api.tools.AITool;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class GetServerPluginTool implements AITool {
    
    @Override
    public String getName() { 
        return "get_server_plugin"; 
    }

    @Override
    public String getDescription() { 
        return "Gets a list of all plugins currently installed and active on the server. Requires OP permission to execute."; 
    }

    @Override
    public String getParametersJsonSchema() { 
        return "{ \"type\": \"object\", \"properties\": {} }"; 
    }

    @Override
    public CompletableFuture<String> execute(Map<String, Object> arguments, AIAccount account) {
        Player sender = Bukkit.getPlayer(UUID.fromString(account.accountUuid()));
        if (sender == null) {
            return CompletableFuture.completedFuture("Error: Cannot find sender in game.");
        }

        // OP Permission Check
        if (!sender.isOp()) {
            return CompletableFuture.completedFuture("Error: Access Denied. You do not have OP permission to view the server plugins.");
        }

        Plugin[] plugins = Bukkit.getPluginManager().getPlugins();
        StringBuilder pluginList = new StringBuilder();
        
        for (int i = 0; i < plugins.length; i++) {
            pluginList.append(plugins[i].getName());
            if (i < plugins.length - 1) {
                pluginList.append(", ");
            }
        }

        return CompletableFuture.completedFuture("Installed Plugins (" + plugins.length + " total): " + pluginList.toString());
    }
}
