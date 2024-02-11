package dev.bedcrab.events;

import dev.bedcrab.server.MinestomServer;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.entity.Player;
import net.minestom.server.event.player.AsyncPlayerConfigurationEvent;
import net.minestom.server.instance.AnvilLoader;
import net.minestom.server.instance.InstanceContainer;

public class PlayerEvents {
    /**
     * Called when a player joins
     */
    public static void onJoin(AsyncPlayerConfigurationEvent event) {
        final Player player = event.getPlayer();
        InstanceContainer instance = MinestomServer.getInstanceContainer();
        instance.setChunkLoader(new AnvilLoader(PlayerEvents.class.getClassLoader().getResource((String) MinestomServer.configuration.get("worlds-directory") + "/world").getPath()));

        player.setRespawnPoint(new Pos(0, 70, 0)); // Set the player spawn location
        event.setSpawningInstance(instance);
    }
}