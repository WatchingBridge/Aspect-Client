package club.aspect.api;

import club.aspect.api.event.Event;
import club.aspect.api.mod.ModManager;
import club.aspect.impl.events.EventTick;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

import rip.hippo.lwjeb.annotation.Handler;
import rip.hippo.lwjeb.bus.PubSub;
import rip.hippo.lwjeb.configuration.BusConfigurations;
import rip.hippo.lwjeb.configuration.config.impl.BusPubSubConfiguration;
import rip.hippo.lwjeb.message.publish.impl.StandardMessagePublisher;
import rip.hippo.lwjeb.message.scan.impl.MethodAndFieldBasedMessageScanner;
import rip.hippo.lwjeb.subscribe.impl.StrongReferencedListenerSubscriber;
import club.aspect.api.command.CommandManager;

import java.awt.*;

/**
 * Brucite Client Class
 */
public enum Client {

    INSTANCE;

    private final Boolean devBuild = true;
    
    public Minecraft mc = Minecraft.getMinecraft();

    private final String clientName = "Aspect";

    private final Double clientVersion = 0.1D;

    private final String clientVersionToString = clientVersion + nameBuilder();

    private final String[] clientAuthorsArray = new String[]{"slosa","monitor"};

    private final String clientAuthor;

    private CommandManager commandManager;

    private final Color clientColor = new Color(196, 193, 193);
    
    private DiscordManager discordManager  = new DiscordManager();

   public final void onStart() {
       Display.setTitle(clientName + " " + clientVersionToString);
       ModManager.initMods();
       commandManager = new CommandManager();
   }
   
   public void init() {
	   discordManager.start();
   }
   
   public void shutdown() {
	   discordManager.shutdown();
   }

    private final PubSub<Event> eventPubSub = new PubSub<>(
            new BusConfigurations.Builder().setConfiguration(BusPubSubConfiguration.class, () -> {
                BusPubSubConfiguration busPubSubConfiguration = new BusPubSubConfiguration();
                busPubSubConfiguration.setPublisher(new StandardMessagePublisher<>());
                busPubSubConfiguration.setSubscriber(new StrongReferencedListenerSubscriber<>());
                busPubSubConfiguration.setScanner(new MethodAndFieldBasedMessageScanner<>());
                return busPubSubConfiguration;
            }).build());

    private String nameBuilder() {
        return devBuild ? " DEV" : "E Stable";
    }

    public String getClientVersion() {
        return clientVersionToString;
    }

    public String getClientName() {
        return clientName;
    }

    public Color getClientColor() {
        return clientColor;
    }

    public Integer getClientColorToInt() {
        return clientColor.getRGB();
    }

    public String getClientAuthor() {
        return clientAuthor;
    }

    public PubSub<Event> getEventPubSub()
    {
        return eventPubSub;
    }
    {
        final StringBuilder builder = new StringBuilder();

        for (int i = 0; i < clientAuthorsArray.length; ++i)
        {
            builder.append(clientAuthorsArray[i]).append(i == clientAuthorsArray.length - 1 ? "" : " & ");
        }

        clientAuthor = builder.toString();
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }

    public Boolean isInDevBuild() {
        return devBuild;
    }
    
    public DiscordManager getDiscordManager() {
		return discordManager;
	}
}
