# Repository Index

This file is the entry point for any agent working in this repository. Read it first, then [`AGENTS.md`](AGENTS.md) and [`README.md`](README.md).

`extension-servertools` is a Gradle multi project build that produces the ServerTools extension for the MCAgents plugin. It gives AI agents tools for querying the Minecraft server's status, performance, and configuration on PaperMC, SpigotMC, and FoliaMC. Keep this index accurate whenever files or directories are added, removed, or restructured.

## Root Files

| Path | Purpose |
|---|---|
| AGENTS.md | Primary agent instruction set; routes to `agents/`. |
| README.md | Project overview, registered tools, and build instructions. |
| LICENSE | License. |
| settings.gradle | Multi project definition and module includes. |
| build.gradle | Root build: shared repositories, publishing, and Shadow JAR merge. |
| gradle.properties | Project identity (`project-name`, `project-group`) and versioning. |
| gradlew / gradlew.bat / gradle/ | Gradle wrapper and version catalog. |

## Modules

| Path | Module | Purpose |
|---|---|---|
| tools/ | `tools` | Platform-neutral AI tools shared by every platform module. |
| platforms/papermc/ | `platforms:papermc` | PaperMC entry point (`ServerTools`). |
| platforms/spigotmc/ | `platforms:spigotmc` | SpigotMC entry point (`ServerTools`). |
| platforms/foliamc/ | `platforms:foliamc` | FoliaMC entry point (`ServerTools`). |

## Tools

| Path | Tool | Purpose |
|---|---|---|
| tools/src/.../tools/GetServerTickTool.java | `get_server_tick` | Server TPS averages (PaperMC/FoliaMC; graceful error on SpigotMC). |
| tools/src/.../tools/GetServerPingTool.java | `get_server_ping` | Latency of the calling player. |
| tools/src/.../tools/GetServerIpTool.java | `get_server_ip` | Server address and port (OP only). |
| tools/src/.../tools/GetServerPluginTool.java | `get_server_plugin` | Installed plugin list (OP only). |

## Resources

| Path | Purpose |
|---|---|
| src/main/resources/extension.yml | Extension descriptor: name, version, and per platform main classes. |

## Other Directories

| Path | Purpose |
|---|---|
| agents/ | Specialized agent instructions (credentials, git, gradle, rules). See `agents/README.md`. |
| .devcontainer/ | Development container definition. |
