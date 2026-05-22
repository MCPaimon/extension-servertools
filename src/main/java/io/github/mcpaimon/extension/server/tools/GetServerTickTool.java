package io.github.mcpaimon.extension.server.tools;

import io.github.mcpaimon.api.model.AIAccount;
import io.github.mcpaimon.api.tools.AITool;
import org.bukkit.Bukkit;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class GetServerTickTool implements AITool {
    
    @Override
    public String getName() { 
        return "get_server_tick"; 
    }

    @Override
    public String getDescription() { 
        return "Gets the current server TPS (Ticks Per Second) for the last 1m, 5m, and 15m. A perfect TPS is 20.0."; 
    }

    @Override
    public String getParametersJsonSchema() { 
        return "{ \"type\": \"object\", \"properties\": {} }"; 
    }

    @Override
    public CompletableFuture<String> execute(Map<String, Object> arguments, AIAccount account) {
        // Paper API allows getting TPS array directly
        double[] tps = Bukkit.getTPS();
        String result = String.format("Server TPS - 1m: %.2f, 5m: %.2f, 15m: %.2f", tps[0], tps[1], tps[2]);
        
        return CompletableFuture.completedFuture(result);
    }
}
