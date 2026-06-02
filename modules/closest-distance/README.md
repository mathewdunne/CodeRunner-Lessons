# Closest Distance

Work in `src/main/java/frc/robot/Robot.java`. Run this lesson with the CodeRunner Driver Station.

## Steps

1. Hardcode a new `Translation2d` as the point you want to check.
2. Loop through `fieldPoints` and find the closest point using the distance formula with `Math.sqrt`.
3. Replace the hardcoded point with a random point inside the field bounds.
4. Use `Logger.recordOutput` to show the array of field points, the random point, and the closest point.
5. Replace your manual distance formula with `Translation2d.distance()`.
6. Replace the whole loop with `Translation2d.nearest()`.

## Bonus

- Log the distance to the closest point.
- Add more points to the field.
