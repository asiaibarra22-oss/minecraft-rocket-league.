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
                        () -> Component.literal("Minecraft Rocket League: /rl car and /rl ball"),
                        false
                    );
                    return Command.SINGLE_SUCCESS;
                }))
                .then(Commands.literal("car").executes(context -> {
                    context.getSource().sendFailure(Component.literal(
                        "The starter car is being rebuilt for Minecraft 26.3 and is not ready yet."
                    ));
                    return 0;
                }))
                .then(Commands.literal("ball").executes(context -> {
                    context.getSource().sendFailure(Component.literal(
                        "The Rocket Ball is being rebuilt for Minecraft 26.3 and is not ready yet."
                    ));
                    return 0;
                }))
            )
        );
    }
}
