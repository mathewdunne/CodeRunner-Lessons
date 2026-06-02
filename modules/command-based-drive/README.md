# Command-Based Robot

Work mainly in `src/main/java/frc/robot/RobotContainer.java`, `commands/`, and `subsystems/drive/Drive.java`.

## Steps

1. Change the premade autonomous command from `Commands.none()` into a sequence that drives in a square.
2. Run autonomous from the Driver Station and watch `Drive/Pose` in AdvantageScope.
3. Bind the drive commands to controller buttons with `onTrue`.
4. Create a figure-eight path around the field and bind it to A.
5. Keep B as a reset-pose button so you can try the path again.

## Bonus

- Try `whileTrue` by moving forward in very small increments.
- Add more command classes for other driving patterns.
