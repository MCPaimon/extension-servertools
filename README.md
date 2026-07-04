# MCPaimon ServerTools Extension

This module is an extension for the MCAgents plugin, designed to provide AI agents with real-time data regarding the Minecraft server's status, performance, and configurations. It mirrors the structure of the [Core extension](https://github.com/MCPaimon/extension-core) and supports all three platforms: PaperMC, SpigotMC, and FoliaMC.

> **Note:** This extension only adds tools to the MCAgents plugin. It does not need its own route on the central API server ([`MCEngine/server-expressjs`](https://github.com/MCEngine/server-expressjs)); all persistence goes through the plugin's `/api/mcagents` route.

## Project Structure

* **`tools/`**: Platform-neutral AI tools shared by every platform module.
* **`platforms/papermc/`**: PaperMC entry point (`ServerTools`).
* **`platforms/spigotmc/`**: SpigotMC entry point (`ServerTools`).
* **`platforms/foliamc/`**: FoliaMC entry point (`ServerTools`).
* **`src/main/resources/`**: The global `extension.yml` descriptor with the per platform main classes.

## Features & AI Tools

This extension registers the following tools to the AI agent:

* **`get_server_tick`**: Retrieves the server's current TPS (Ticks Per Second) averages for the last 1m, 5m, and 15m. *(PaperMC and FoliaMC only; reports unavailability on SpigotMC)*
* **`get_server_ping`**: Checks the current connection latency (ping) of the player interacting with the AI.
* **`get_server_ip`**: Fetches the server's IP address and port. *(Requires OP permission)*
* **`get_server_plugin`**: Lists all currently installed and active plugins on the server. *(Requires OP permission)*

## Requirements

* Java 25
* PaperMC, SpigotMC, or FoliaMC (API 26.1.2)
* MCAgents Plugin (`io.github.mcpaimon` artifacts, version 2026.0.7-8)

## Build Instructions

To build the extension and create a merged JAR containing all platform implementations:

```bash
./gradlew build
```

The compiled artifact (Shadow JAR) will be located in `build/libs/`.
