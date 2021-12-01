package club.aspect.api.command;

import club.aspect.api.event.EventAPI;
import club.aspect.impl.events.EventChat;
import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import rip.hippo.lwjeb.annotation.Handler;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {
    /**
     * List of clients saved commands
     */
    private static final List<Command> commands = new ArrayList<Command>();


    public CommandManager() {
        initCommands();
    }

    /**
     * getter of commands arraylist
     *
     */
    public static List<Command> getCommands() {
        return commands;
    }

    /**
     * Inits all client commands
     */
    public void initCommands()
    {
        EventAPI.register(this);
    }

    /**
     * Main method of executing client commands
     */
    @Handler
    public void onEventSendMessage(EventChat event) {
        String message = event.getMessage();
        if (event.getMessage().startsWith(".")) {
            event.setCancelled(true);
            String withoutPrefix = message.substring(1);
            String[] args = withoutPrefix.split(" ");
            if (!withoutPrefix.isEmpty() && args.length > 0) {
                String commmand = withoutPrefix.substring(args[0].length()).trim();;
                for (Command command : commands) {
                    for (String names : command.getName()) {
                        if (names.equalsIgnoreCase(args[0])) {
                            command.execute(commmand,args);
                            return;
                        }
                    }
                }
                sendInGameMessage("'" + args[0] + "' is not a command.");
            } else
                sendInGameMessage("No arguments provided!");
        }
    }
    public static void sendInGameMessage(String msg)
    {
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(ChatFormatting.DARK_GRAY + "[" + ChatFormatting.DARK_AQUA + "Brucite" + ChatFormatting.DARK_GRAY + "] " + ChatFormatting.DARK_AQUA + msg.replace(" ", " " + ChatFormatting.DARK_AQUA)));
    }
}
