package frc.robot;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;

public final class FieldConstants {
  public static final Translation2d BLUE_HUB = new Translation2d(4.1, 4.0);
  public static final Pose2d BLUE_HUB_POSE = new Pose2d(BLUE_HUB, Rotation2d.kZero);

  private FieldConstants() {}
}
