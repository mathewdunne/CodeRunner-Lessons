package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.drive.Drive;

public class TurnRightCommand extends Command {
  private final Drive drive;
  private final double degrees;

  public TurnRightCommand(Drive drive, double degrees) {
    this.drive = drive;
    this.degrees = degrees;
    addRequirements(drive);
  }

  @Override
  public void initialize() {
    drive.turnRight(degrees);
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}
