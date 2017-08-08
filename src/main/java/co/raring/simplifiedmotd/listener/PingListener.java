package co.raring.simplifiedmotd.listener;

import co.raring.simplifiedmotd.Core;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.event.EventHandler;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class PingListener implements Listener {
    private Core core;

    public PingListener(Core core) {
        this.core = core;
    }

    @EventHandler
    public void onPing(ProxyPingEvent e) {
        ServerPing res = e.getResponse();
        res.setDescriptionComponent(parseMotd());
        e.setResponse(res);

    }

    private TextComponent parseMotd() {
        Configuration cfg = core.getConfig().get();
        ThreadLocalRandom tlr = ThreadLocalRandom.current();

        List<String> motds = cfg.getStringList("motds");

        ProxyServer ps = core.getProxy();

        //
        String str = motds.get(tlr.nextInt(0, motds.size()));
        //Parsing variables/placeholders
        str = str.replace("\\n", "\n");
        str = str.replace("<current_players>", String.valueOf(ps.getPlayers().size()));
        str = str.replace("<player_limit>", String.valueOf(ps.getConfig().getPlayerLimit()));
        return new TextComponent(ChatColor.translateAlternateColorCodes('&', str));
    }
}
