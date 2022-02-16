// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.ArmHandler;
import frc.robot.commands.Climb;
import frc.robot.commands.TestAuton;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public static final Drivetrain drivetrain = Drivetrain.getInstance(); //creates drivetrain
  public static final Intake intake = Intake.getInstance(); //creates intake
  public static final Arm arm = Arm.getInstance(); //creates arm

  public static final Joystick joystick = new Joystick(0); //creates joystick
  public final JoystickButton button1 = new JoystickButton(joystick, 1); //creates joystick buttons
  public final JoystickButton button2 = new JoystickButton(joystick, 2);
  public final JoystickButton button9 = new JoystickButton(joystick, 9);
  public final JoystickButton button10 = new JoystickButton(joystick, 10);
  public final JoystickButton button11 = new JoystickButton(joystick, 11);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    drivetrain.setDefaultCommand(new ArcadeDrive()); //sets default command of drivetrain to arcadedrive
    intake.setDefaultCommand(new RunCommand(intake::IntakeStop, intake)); //sets default command of intake to IntakeStop *continuous
    arm.setDefaultCommand(new ArmHandler(arm, button9, button10)); //sets default command of arm to arm handler
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    button2.whileHeld(new RunCommand(intake::IntakeIn, intake));
    button1.whileHeld(new RunCommand(intake::IntakeOut, intake));
    button11.whileHeld(new Climb());
    //dfghjk
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return new TestAuton();//m_autoCommand;
  }
}