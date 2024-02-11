package dev.bedcrab.events;

import net.minestom.server.event.GlobalEventHandler;
import net.minestom.server.event.player.AsyncPlayerConfigurationEvent;

public class ServerEvents {
    /**
     * Enable events on the server
     */
    public static void enable(GlobalEventHandler handler) throws RuntimeException {
        handler.addListener(AsyncPlayerConfigurationEvent.class, PlayerEvents::onJoin);
    }
}
