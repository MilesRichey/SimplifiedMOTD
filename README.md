SimplifiedMOTD
==============
*_A simple motd plugin for BungeeCord_*

[SpigotMC Resource Link](https://www.spigotmc.org/resources/simplifiedmotd.45340/ "SimplifiedMOTD on Spigot")

Have you ever wanted to customize your motd on BungeeCord, but couldn't find the right plugin or configuration that just fit? Well this plugin is for you then.

For Server Owners/Admins
------------------------

### Commands
* _/smotd_:
  - _/smotd reload_: Reloads the config file, applying motd changes upon next ping.

### Permissions
* _smotd.admin_: Allows use of the /smotd command

### Configuration
```yaml
# Placeholders:
#   '\n': creates a newline
#   '<current_players>': Number of players currently on all servers
#   '<max_players>': Number of the maximum players the server can hold
# We will choose one of these motds to show a player randomly.
# If there's only one motd then only one will be shown.
motds:
  - '&a&lWelcome to\n    &b&lMy Server'
  - '&b&lWelcome to\n    &a&lMy Server'
```

### Requirements
* BungeeCord
* Java 8

For Developers
--------------

### Building
Building is pretty easy if you know your way around maven.

In order to build, run this command: 
```bash
mvn clean package 
```

This will produce a jar file that you can place in your BungeeCord plugin folder.


