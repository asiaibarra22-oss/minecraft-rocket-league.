package io.github.asiaibarra22oss.rocketleague;

import com.mojang.brigadier.Command;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraft.server.level.ServerPlayer;

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
                    var source = context.getSource();
                    var level = source.getLevel();
                    Minecart car = EntityType.MINECART.create(level);
                    if (car == null) {
                        source.sendFailure(Component.literal("Could not create the car."));
                        return 0;
                    }
                    car.setPos(source.getPosition().x, source.getPosition().y, source.getPosition().z);
                    car.setCustomName(Component.literal("Boost Fennec"));
                    car.setCustomNameVisible(true);
                    level.addFreshEntity(car);
                    source.sendSuccess(() -> Component.literal("Your starter car spawned! Right-click to ride."), false);
                    return Command.SINGLE_SUCCESS;
                }))
                .then(Commands.literal("ball").executes(context -> {
                    var source = context.getSource();
                    var level = source.getLevel();
                    Slime ball = EntityType.SLIME.create(level);
                    if (ball == null) {
                        source.sendFailure(Component.literal("Could not create the ball."));
                        return 0;
                    }
                    ball.setSize(1, true);
                    ball.setNoAi(true);
                    ball.setCustomName(Component.literal("Rocket Ball"));
                    ball.setCustomNameVisible(true);
                    ball.setPos(source.getPosition().x, source.getPosition().y + 1.0, source.getPosition().z);
                    ball.setDeltaMovement(source.getRotation().getDirection().scale(0.8));
                    level.addFreshEntity(ball);
                    source.sendSuccess(() -> Component.literal("Rocket Ball spawned!"), false);
                    return Command.SINGLE_SUCCESS;
                }))
            )
        );
    }
}
