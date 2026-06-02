package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.drive.Drive;

public class DriveLeftCommand extends Command {
  private final Drive drive;
  private final double distanceMeters;

  public DriveLeftCommand(Drive drive, double distanceMeters) {
    this.drive = drive;
    this.distanceMeters = distanceMeters;
    addRequirements(drive);
  }

  @Override
  public void initialize() {
    drive.driveLeft(distanceMeters);
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}
