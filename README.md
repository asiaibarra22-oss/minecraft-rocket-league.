# Minecraft Rocket League

A Fabric mod project for **Minecraft Java Edition 26.3**.

The goal is a Minecraft-style arcade car-and-ball experience that can be played in ordinary survival worlds:

- A compact, Fennec-inspired blocky car with unlimited rocket boost.
- A spawnable, round arena ball with bouncing and rolling behavior.
- Ball impacts that can damage hostile mobs.
- Vanilla Minecraft-compatible visuals and survival-world spawning.

The vehicle and ball will be original Minecraft-style designs rather than copied Rocket League game assets. Physics will aim for a fun Rocket League-like feel, not claim to reproduce the proprietary game simulation exactly.

## Development requirements

- Minecraft Java Edition 26.3
- Fabric Loader 0.20.1 or newer
- Java 25
- Gradle 9.6.0
- Fabric API 0.165.2+26.3

## Build

After installing Java 25 and Gradle 9.6.0, run:

```sh
gradle build
```

The mod JAR will be created in `build/libs/`.

## Planned controls and commands

The first playable milestone will add commands to spawn the car and ball. Driving, boost, collision behavior, and client-side models/rendering will be added in follow-up milestones.
