package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.drive.Drive;
import org.littletonrobotics.junction.networktables.LoggedDashboardChooser;

public class RobotContainer {
  private final Drive drive = new Drive();
  private final CommandXboxController controller = new CommandXboxController(0);
  private final LoggedDashboardChooser<Command> autoChooser =
      new LoggedDashboardChooser<>("Auto Choices");

  public RobotContainer() {
    autoChooser.addDefaultOption("Do Nothing", Commands.none());
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    // B resets the pose so you can re-run a path. Add the rest of your bindings here.
    controller.b().onTrue(Commands.runOnce(drive::resetPose, drive));
  }

  public Command getAutonomousCommand() {
    return autoChooser.get();
  }
}
