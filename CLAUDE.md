# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## What this repo is

A catalog of self-contained **CodeRunner lesson projects** for teaching Java and FRC
robot programming. Each lesson lives under `modules/<id>/` and is registered in the
top-level `modules.json` manifest. There is no root build — every module is an
independent project, and commands run *inside* a module directory, not at the repo root.

The lesson source files are intentionally incomplete **student scaffolds**: `Main.java`/
`Robot.java` contain TODO-style comments, and each module's `README.md` has `## Steps`
(the assignment) and `## Bonus`. When editing a module, preserve this scaffold nature —
don't "complete" a lesson unless explicitly asked.

## modules.json

The manifest tooling reads. Each entry has `id`, `title`, `description`, `subdir`, `order`
(display sort), and `kind`, which is the most important field:

- `kind: "plain-java"` — a bare Java project (`hello-name`, `number-guessing`,
  `perimeter-area`). Source is `src/Main.java`. **No Gradle.** Run from the editor's Run
  button (`.vscode/launch.json` launches `mainClass: "Main"`; `java.import.gradle.enabled`
  is false). The main class lives in the default package with no `package` line.
- `kind: "robot"` — a GradleRIO + AdvantageKit FRC project. Source is under
  `src/main/java/frc/robot/`. Run from the CodeRunner Driver Station (simulation), not a
  Run button.

Any new module must be added to both `modules/` and `modules.json`.

## Robot module commands (run from inside the module dir)

```bash
./gradlew build          # compile + format + run tests
./gradlew test           # JUnit 5 (jupiter) only
./gradlew simulateJava   # run in simulation / for the Driver Station
./gradlew spotlessApply  # format (also runs automatically on compileJava)
```

`./gradlew test --tests "ClassName"` runs a single test class. Spotless (googleJavaFormat,
2-space indent) runs on every `compileJava`, so committed Java is already formatted.

Toolchain: Java 17, GradleRIO `2026.x`. The first build downloads the WPILib/vendordep
toolchain and is slow.

## Robot module architecture (AdvantageKit IO pattern)

The `robot` modules follow the AdvantageKit hardware-abstraction convention. Understanding
one (e.g. `kitbot-controls`) explains them all:

- **`Constants.java`** defines `Mode` (`REAL`/`SIM`/`REPLAY`). `currentMode` is `REAL` on a
  real roboRIO, otherwise `simMode`. Code branches on this to pick hardware vs. sim IO.
- **Subsystems** (under `subsystems/<name>/`) split into three layers:
  - `<Name>.java` — the WPILib `SubsystemBase`; holds an `<Name>IO` and calls
    `io.updateInputs(inputs)` each loop.
  - `<Name>IO.java` — an interface with an `@AutoLog` `<Name>IOInputs` inner class
    (AdvantageKit generates the logging boilerplate) plus `default` command methods.
  - `<Name>IOSim` / `<Name>IOSpark` / `<Name>IOTalonFX` / `<Name>IOTalonSRX` — concrete
    implementations selected by `currentMode` / robot hardware.
- **Commands** live in `commands/` (e.g. `DriveCommands.java`). `RobotContainer.java` wires
  subsystems to controller button bindings; `Robot.java` (a `LoggedRobot`/`TimedRobot`)
  drives the lifecycle and starts AdvantageKit logging.
- `command-based-drive` is the simpler teaching version (one `Drive` subsystem, individual
  `*Command` classes); `kitbot-controls` and `pid-controllers` are the full AdvantageKit
  kitbot with multiple IO backends, PathPlanner, and vendordeps for REV/CTRE/NavX.

The AdvantageKit-derived files carry a Littleton Robotics copyright header and are
formatted by Spotless — match that style when touching them.
