// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class ThreeBallAuton extends CommandBase {
  double initTime;
  /** Creates a new ThreeBallAuton. */
  public ThreeBallAuton() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.drivetrain, RobotContainer.intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    initTime = Timer.getFPGATimestamp();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(Timer.getFPGATimestamp() - initTime > 0 && Timer.getFPGATimestamp() - initTime < 0.75){
      RobotContainer.intake.AutonIntakeOut();
      RobotContainer.drivetrain.autonArcadeDrive(0, 0);
    }
    if(Timer.getFPGATimestamp() - initTime > 0.75 && Timer.getFPGATimestamp() - initTime < 1.9){
      RobotContainer.intake.IntakeStop();
      RobotContainer.drivetrain.autonArcadeDrive(-0.25, -0.18);
    }
    if(Timer.getFPGATimestamp() - initTime > 1.9 && Timer.getFPGATimestamp() - initTime < 2.3){
      RobotContainer.drivetrain.autonArcadeDrive(0, 0);
    }
    if(Timer.getFPGATimestamp() - initTime > 2.1 && Timer.getFPGATimestamp() - initTime < 2.149){
      RobotContainer.arm.setArmMode(true);
      RobotContainer.arm.ArmDown();
    }
    if(Timer.getFPGATimestamp() - initTime > 2.3 && Timer.getFPGATimestamp() - initTime < 3.45){
      RobotContainer.drivetrain.autonArcadeDrive(0.6, 0);
      RobotContainer.intake.AutonIntakeIn();
    }
    if(Timer.getFPGATimestamp() - initTime > 3.45 && Timer.getFPGATimestamp() - initTime < 4.0){
      RobotContainer.drivetrain.autonArcadeDrive(0, 0);
    }
    if(Timer.getFPGATimestamp() - initTime > 3.7 && Timer.getFPGATimestamp() - initTime < 3.9){
      RobotContainer.intake.IntakeStop();
    }
    if(Timer.getFPGATimestamp() - initTime > 4.0 && Timer.getFPGATimestamp() - initTime < 4.666){
      RobotContainer.drivetrain.autonArcadeDrive(0, -0.3);
    }
    if(Timer.getFPGATimestamp() - initTime > 4.666 && Timer.getFPGATimestamp() - initTime < 5.1){
      RobotContainer.drivetrain.autonArcadeDrive(0, 0);
    }
    if(Timer.getFPGATimestamp() - initTime > 5.1 && Timer.getFPGATimestamp() - initTime < 6.03){
      RobotContainer.drivetrain.autonArcadeDrive(0.52, 0);
      RobotContainer.intake.AutonIntakeIn();
    }
    if(Timer.getFPGATimestamp() - initTime > 6.03 && Timer.getFPGATimestamp() - initTime < 6.3){
      RobotContainer.drivetrain.autonArcadeDrive(0, 0);
    }
    if(Timer.getFPGATimestamp() - initTime > 6.3 && Timer.getFPGATimestamp() - initTime < 6.9){
      RobotContainer.drivetrain.autonArcadeDrive(0, -0.3);
    }
    if(Timer.getFPGATimestamp() - initTime > 6.9 && Timer.getFPGATimestamp() - initTime < 7.2){
      RobotContainer.drivetrain.autonArcadeDrive(0, 0);
      RobotContainer.intake.IntakeStop();
    }
    if(Timer.getFPGATimestamp() - initTime > 7.05 && Timer.getFPGATimestamp() - initTime < 7.1){
      RobotContainer.arm.ArmUp();
    }
    if(Timer.getFPGATimestamp() - initTime > 7.2 && Timer.getFPGATimestamp() - initTime < 8.2){
      RobotContainer.drivetrain.autonArcadeDrive(0.5, 0);
    }
    if(Timer.getFPGATimestamp() - initTime > 8.2 && Timer.getFPGATimestamp() - initTime < 8.5){
      RobotContainer.drivetrain.autonArcadeDrive(0, 0);
    }
    if(Timer.getFPGATimestamp() - initTime > 8.3 && Timer.getFPGATimestamp() - initTime < 8.8){
      RobotContainer.intake.AutonIntakeOut();
    }
    if(Timer.getFPGATimestamp() - initTime > 8.8 && Timer.getFPGATimestamp() - initTime < 9.0){
      RobotContainer.intake.IntakeStop();
    }
  }

  // Called once the command ends or is interrupted.
  
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
