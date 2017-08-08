package co.raring.simplifiedmotd;

import co.raring.simplifiedmotd.cmd.CommandSMotd;
import co.raring.simplifiedmotd.listener.PingListener;
import co.raring.simplifiedmotd.tool.SimplifiedConfig;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginManager;

public class Core extends Plugin {
    private SimplifiedConfig cfg;

    @Override
    public void onEnable() {
        PluginManager pm = getProxy().getPluginManager();
        cfg = new SimplifiedConfig(this, "config.yml", true);
        pm.registerCommand(this, new CommandSMotd(this));
        pm.registerListener(this, new PingListener(this));
    }

    public SimplifiedConfig getConfig() {
        return cfg;
    }
}
