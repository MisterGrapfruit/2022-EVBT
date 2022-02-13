// COMMAND

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
//import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;

public class CHEEZYDrive extends CommandBase {
  /** Creates a new ArcadeDrive. */
  Drivetrain m_drive;
  Joystick stick;
  JoystickButton climbButton = new JoystickButton(stick, 7);
  double throttle, twist;
  //double speed;
  public CHEEZYDrive() {
    m_drive = RobotContainer.drivetrain;
    this.stick = RobotContainer.joystick;
    addRequirements(m_drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    /*if (climbButton.get()) {
      speed = Constants.climbSpeed;
    } else {
      speed = -stick.getRawAxis(3);
    }*/

    throttle = stick.getRawAxis(1);
    twist = stick.getRawAxis(2);

    if(Math.abs(throttle) < 0.1){
      throttle = 0;
    }
    if(Math.abs(twist) < 0.1){
      twist = 0;
    }

    throttle *= Math.abs(throttle);// * speed;
    twist*=twist*=twist;// * speed;
    m_drive.setSpeed(throttle + (twist*Math.abs(throttle)) , throttle - (twist*Math.abs(throttle)) );
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




  /*
    Arcade Input Scaling - WIP

    double sInput;
    double lesserInput = Math.min(Math.abs(throttle), Math.abs(twist));
    double greaterInput = Math.max(Math.abs(throttle), Math.abs(twist));
    if(greaterInput > 0){
      sInput = lesserInput/greaterInput + 1;
    }
    else{
      sInput = 1;
    }
    throttle /= sInput;
    twist /= sInput;
    */
    //throttle *= Math.abs(throttle) * 0.8;
    //twist *= Math.abs(twist) * 0.6;
    