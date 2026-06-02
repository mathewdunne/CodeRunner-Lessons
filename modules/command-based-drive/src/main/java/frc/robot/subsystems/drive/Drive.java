package frc.robot.subsystems.drive;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.Logger;

public class Drive extends SubsystemBase {
  private static final Pose2d STARTING_POSE = new Pose2d(2.0, 2.0, Rotation2d.kZero);

  private Pose2d pose = STARTING_POSE;

  @Override
  public void periodic() {
    Logger.recordOutput("Drive/Pose", pose);
  }

  public void driveForward(double distanceMeters) {
    move(distanceMeters, pose.getRotation());
  }

  public void driveBackward(double distanceMeters) {
    move(-distanceMeters, pose.getRotation());
  }

  public void driveLeft(double distanceMeters) {
    move(distanceMeters, pose.getRotation().plus(Rotation2d.fromDegrees(90.0)));
  }

  public void driveRight(double distanceMeters) {
    move(distanceMeters, pose.getRotation().plus(Rotation2d.fromDegrees(-90.0)));
  }

  public void turnLeft(double degrees) {
    rotate(Rotation2d.fromDegrees(degrees));
  }

  public void turnRight(double degrees) {
    rotate(Rotation2d.fromDegrees(-degrees));
  }

  public void resetPose() {
    pose = STARTING_POSE;
  }

  private void move(double meters, Rotation2d direction) {
    Translation2d delta = new Translation2d(meters, direction);
    pose = new Pose2d(pose.getTranslation().plus(delta), pose.getRotation());
  }

  private void rotate(Rotation2d delta) {
    pose = new Pose2d(pose.getTranslation(), pose.getRotation().plus(delta));
  }
}
