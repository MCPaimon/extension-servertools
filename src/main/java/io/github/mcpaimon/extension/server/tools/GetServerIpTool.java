package io.github.mcpaimon.extension.server.tools;

import io.github.mcpaimon.api.model.AIAccount;
import io.github.mcpaimon.api.tools.AITool;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class GetServerIpTool implements AITool {
    
    @Override
    public String getName() { 
        return "get_server_ip"; 
    }

    @Override
    public String getDescription() { 
        return "Gets the server IP address and port. Requires OP permission to execute."; 
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
            return CompletableFuture.completedFuture("Error: Access Denied. You do not have OP permission to view the server IP.");
        }

        String ip = Bukkit.getIp();
        if (ip == null || ip.isEmpty()) {
            ip = "localhost (or hidden by server config)";
        }
        int port = Bukkit.getPort();

        return CompletableFuture.completedFuture("Server Address is " + ip + ":" + port);
    }
}
