package club.aspect.api;

import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;
import net.arikia.dev.drpc.DiscordUser;
import net.arikia.dev.drpc.DiscordRichPresence.Builder;
import net.arikia.dev.drpc.callbacks.ReadyCallback;

public class DiscordManager {

	private boolean running = false;
	private long created = 0;
	
	public void start() {

		this.created = System.currentTimeMillis();
		
		DiscordEventHandlers handlers = new DiscordEventHandlers.Builder().setReadyEventHandler(new ReadyCallback() {
			
			@Override
			public void apply(DiscordUser user) {
				
				System.out.println("Welcome " + user.username + "#" + user.discriminator);
				update("Booting Aspect", "");
			}
		}).build();
		
		DiscordRPC.discordInitialize("909431137808551986", handlers, true);
		
		new Thread("CallbackThread") {
		
			@Override
			public void run() {
				while (running) {
					DiscordRPC.discordRunCallbacks();
				}
			}
			
		}.start();
		
	}
	
	public void shutdown() {
		running = false;
		DiscordRPC.discordShutdown();
	}
	
	public void update(String line1, String line2) {
		DiscordRichPresence.Builder b = new DiscordRichPresence.Builder(line2);
		b.setBigImage("logo", "Aspect Client");
		b.setDetails(line1);
		b.setStartTimestamps(created);
		
		DiscordRPC.discordUpdatePresence(b.build());
	}
	
}
