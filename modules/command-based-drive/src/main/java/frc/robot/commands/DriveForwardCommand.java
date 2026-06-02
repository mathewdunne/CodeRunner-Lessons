package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.drive.Drive;

public class DriveForwardCommand extends Command {
  private final Drive drive;
  private final double distanceMeters;

  public DriveForwardCommand(Drive drive, double distanceMeters) {
    this.drive = drive;
    this.distanceMeters = distanceMeters;
    addRequirements(drive);
  }

  @Override
  public void initialize() {
    drive.driveForward(distanceMeters);
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}
