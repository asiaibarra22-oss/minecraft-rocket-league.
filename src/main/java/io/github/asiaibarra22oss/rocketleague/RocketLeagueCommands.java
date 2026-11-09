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
                        () -> Component.literal("Boost Fennec prototype: /rl car spawns your ride; use a carrot on a stick to steer and boost."),
                        false
                    );
                    return Command.SINGLE_SUCCESS;
                }))
                .then(Commands.literal("car").executes(context -> {
                    var source = context.getSource();
                    var server = source.getServer();

                    // A saddled pig is used as a temporary rideable chassis while the
                    // custom car entity/model is developed. The unbreakable carrot-on-a-stick
                    // uses Minecraft's built-in pig steering and boost controls.
                    server.getCommands().performPrefixedCommand(
                        source,
                        "summon minecraft:pig ~ ~ ~ {Saddle:1b,PersistenceRequired:1b,CustomName:'\"Boost Fennec\"'}"
                    );
                    server.getCommands().performPrefixedCommand(
                        source,
                        "give @s minecraft:carrot_on_a_stick[minecraft:unbreakable={}] 1"
                    );

                    source.sendSuccess(
                        () -> Component.literal("Boost Fennec spawned! Mount it, then use the carrot on a stick to steer and boost. This is a temporary pig-based prototype."),
                        false
                    );
                    return Command.SINGLE_SUCCESS;
                }))
            )
        );
    }
}
