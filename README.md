# MCPaimon Server Extension

This module is an extension for the MCPaimon AI Plugin, designed to provide AI agents with real-time data regarding the Minecraft server's status, performance, and configurations.

## Features & AI Tools

This extension registers the following tools to the AI agent:

* **`get_server_tick`**: Retrieves the server's current TPS (Ticks Per Second) averages for the last 1m, 5m, and 15m.
* **`get_server_ping`**: Checks the current connection latency (ping) of the player interacting with the AI.
* **`get_server_ip`**: Fetches the server's IP address and port. *(Requires OP permission)*
* **`get_server_plugin`**: Lists all currently installed and active plugins on the server. *(Requires OP permission)*

## Requirements
* Java 25
* PaperMC 1.21+ (Paper API 26.1.2)
* MCPaimon AI Plugin Core

## Build Instructions
To build the extension, use the included Gradle wrapper:
```bash
./gradlew build
```

The compiled artifact will be located in `build/libs/`.
