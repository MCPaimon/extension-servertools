# Repository Index

This file is the entry point for any agent working in this repository. Read it first, then [`AGENTS.md`](AGENTS.md) and [`README.md`](README.md).

`extension-servertools` is an extension for the MCAgents plugin that gives AI agents tools for querying the Minecraft server's status, performance, and configuration. Keep this index accurate whenever files or directories are added, removed, or restructured.

## Root Files

| Path | Purpose |
|---|---|
| AGENTS.md | Primary agent instruction set; routes to `agents/`. |
| README.md | Project overview, registered tools, and build instructions. |
| LICENSE | License. |
| settings.gradle | Gradle project definition. |
| build.gradle | Build configuration, repositories, and dependencies. |
| gradle.properties | Project identity and versioning. |
| gradlew / gradlew.bat / gradle/ | Gradle wrapper and version catalog. |

## Source

| Path | Purpose |
|---|---|
| src/main/java/io/github/mcpaimon/extension/server/ServerExtension.java | Extension entry point: creates the `server` category and registers all tools. |
| src/main/java/io/github/mcpaimon/extension/server/tools/GetServerTickTool.java | `get_server_tick` — server TPS averages. |
| src/main/java/io/github/mcpaimon/extension/server/tools/GetServerPingTool.java | `get_server_ping` — latency of the calling player. |
| src/main/java/io/github/mcpaimon/extension/server/tools/GetServerIpTool.java | `get_server_ip` — server address and port (OP only). |
| src/main/java/io/github/mcpaimon/extension/server/tools/GetServerPluginTool.java | `get_server_plugin` — installed plugin list (OP only). |
| src/main/resources/extension.yml | Extension descriptor: name, version, and main class. |

## Other Directories

| Path | Purpose |
|---|---|
| agents/ | Specialized agent instructions (credentials, git, gradle, rules). See `agents/README.md`. |
| .devcontainer/ | Development container definition. |
