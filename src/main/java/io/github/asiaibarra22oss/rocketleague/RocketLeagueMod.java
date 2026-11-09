package io.github.asiaibarra22oss.rocketleague;

import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class RocketLeagueMod implements ModInitializer {
    public static final String MOD_ID = "minecraft_rocket_league";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        RocketLeagueCommands.register();
        LOGGER.info("Minecraft Rocket League loaded. Use /rl help.");
    }

    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }
}
