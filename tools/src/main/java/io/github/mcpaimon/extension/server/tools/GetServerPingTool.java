package io.github.mcpaimon.extension.server.tools;

import io.github.mcpaimon.api.model.AIAccount;
import io.github.mcpaimon.api.tools.AITool;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class GetServerPingTool implements AITool {
    
    @Override
    public String getName() { 
        return "get_server_ping"; 
    }

    @Override
    public String getDescription() { 
        return "Gets the current connection ping (latency in milliseconds) of the player interacting with the AI."; 
    }

    @Override
    public String getParametersJsonSchema() { 
        return "{ \"type\": \"object\", \"properties\": {} }"; 
    }

    @Override
    public List<String> getCategories() {
        return List.of("server");
    }

    @Override
    public CompletableFuture<String> execute(Map<String, Object> arguments, AIAccount account) {
        Player sender = Bukkit.getPlayer(UUID.fromString(account.accountUuid()));
        if (sender == null) {
            return CompletableFuture.completedFuture("Error: Cannot find sender in game.");
        }
        
        return CompletableFuture.completedFuture("Your current ping to the server is: " + sender.getPing() + "ms.");
    }
}
