package io.github.asiaibarra22oss.rocketleague;

import com.mojang.brigadier.Command;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

public final class RocketLeagueCommands {
    private RocketLeagueCommands() {}

    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) ->
            dispatcher.register(Commands.literal("rl")
                .then(Commands.literal("help").executes(context -> {
                    context.getSource().sendSuccess(
                        () -> Component.literal("Boost Fennec prototype: /rl car spawns your ride; mount it and use the carrot on a stick to steer and boost."),
                        false
                    );
                    return Command.SINGLE_SUCCESS;
                }))
                .then(Commands.literal("car").executes(context -> {
                    var source = context.getSource();
                    var server = source.getServer();

                    // Hidden saddled pig is the temporary vehicle controller.
                    // Block-display passengers form a simple orange/white car body
                    // and four dark wheels that move with the vehicle.
                    String carNbt = "{Saddle:1b,Invisible:1b,PersistenceRequired:1b,CustomName:'\"Boost Fennec\"',Passengers:[" +
                        "{id:\"minecraft:block_display\",block_state:{Name:\"minecraft:orange_concrete\"},transformation:{translation:[0f,0.65f,0f],scale:[1.45f,0.42f,2.25f]}}," +
                        "{id:\"minecraft:block_display\",block_state:{Name:\"minecraft:white_concrete\"},transformation:{translation:[0f,1.08f,-0.12f],scale:[1.12f,0.48f,1.18f]}}," +
                        "{id:\"minecraft:block_display\",block_state:{Name:\"minecraft:light_blue_stained_glass\"},transformation:{translation:[0f,1.12f,-0.12f],scale:[0.92f,0.32f,0.92f]}}," +
                        "{id:\"minecraft:block_display\",block_state:{Name:\"minecraft:black_concrete\"},transformation:{translation:[-0.78f,0.24f,0.68f],scale:[0.38f,0.42f,0.32f]}}," +
                        "{id:\"minecraft:block_display\",block_state:{Name:\"minecraft:black_concrete\"},transformation:{translation:[0.78f,0.24f,0.68f],scale:[0.38f,0.42f,0.32f]}}," +
                        "{id:\"minecraft:block_display\",block_state:{Name:\"minecraft:black_concrete\"},transformation:{translation:[-0.78f,0.24f,-0.68f],scale:[0.38f,0.42f,0.32f]}}," +
                        "{id:\"minecraft:block_display\",block_state:{Name:\"minecraft:black_concrete\"},transformation:{translation:[0.78f,0.24f,-0.68f],scale:[0.38f,0.42f,0.32f]}}" +
                    "]}";

                    server.getCommands().performPrefixedCommand(
                        source,
                        "summon minecraft:pig ~ ~ ~ " + carNbt
                    );
                    server.getCommands().performPrefixedCommand(
                        source,
                        "give @s minecraft:carrot_on_a_stick[minecraft:unbreakable={}] 1"
                    );

                    source.sendSuccess(
                        () -> Component.literal("Boost Fennec spawned! Mount the car and use the carrot on a stick to steer and boost. This is a block-display prototype."),
                        false
                    );
                    return Command.SINGLE_SUCCESS;
                }))
            )
        );
    }
}
