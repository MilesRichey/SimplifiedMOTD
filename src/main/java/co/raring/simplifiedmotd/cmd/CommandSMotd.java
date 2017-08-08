package co.raring.simplifiedmotd.cmd;

import co.raring.simplifiedmotd.Core;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;

public class CommandSMotd extends Command {
    private static BaseComponent HELP_MESSAGE;

    static {
        HELP_MESSAGE = new TextComponent();
        TextComponent tc = new TextComponent();
        HELP_MESSAGE.addExtra("/smotd reload");
        HELP_MESSAGE = tc;
    }

    private final Core core;

    public CommandSMotd(Core core) {
        super("simplifiedmotd", "smotd.admin", "smotd");
        this.core = core;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 0) {
            sendHelp(sender);
        } else if (args.length == 1) {
            if (args[0].equalsIgnoreCase("reload")) {
                if (sender.hasPermission("smotd.admin")) {
                    core.getConfig().reload();
                }
            }
        }
    }

    private void sendHelp(CommandSender sender) {
        sender.sendMessage(HELP_MESSAGE);
    }
}
