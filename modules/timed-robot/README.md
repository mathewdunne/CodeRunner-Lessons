# Timed Robot

Work in `src/main/java/frc/robot/RobotContainer.java`. Run this lesson with the CodeRunner Driver Station.

## Steps

1. Log `"RobotState"` as `"TeleopInit"` in `teleopInit()`.
2. Log `"RobotState"` as `"TeleopPeriodic"` in `teleopPeriodic()`.
3. Blink an LED value by flipping a boolean each periodic loop, then inspect the timing in AdvantageScope.
4. Use `Timer.getFPGATimestamp()` to blink more slowly based on elapsed time.
5. Create an Xbox controller object.
6. In `teleopPeriodic()`, log whether the A button is pressed.
7. Log a joystick value and use keyboard controls to change it.

## Bonus

- Make a boolean turn true only when all four face buttons are pressed.
- Log a `Pose2d` and increment X/Y when the joysticks move.
