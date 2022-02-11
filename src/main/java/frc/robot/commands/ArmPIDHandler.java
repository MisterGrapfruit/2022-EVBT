// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
/*
package frc.robot.commands;

import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants;
import frc.robot.subsystems.Arm;

public class ArmPIDHandler extends CommandBase {
  private Arm m_arm;
  private RelativeEncoder armEncoder;
  private JoystickButton downButton;
  private JoystickButton upButton;
  double downPos = Constants.armDownPosition;
  double upPos = Constants.armUpPosition;
  boolean armIsUp;

  /** Creates a new ArmHandler. 
  public ArmPIDHandler(Arm sub, JoystickButton downButton, JoystickButton upButton) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.downButton = downButton;
    this.upButton = upButton;
    m_arm = sub;
    this.armEncoder = m_arm.armEncoder;
    addRequirements(m_arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    armEncoder.setPosition(downPos);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(downButton.get() && armIsUp==true){
      armIsUp = false;
      m_arm.setPosition(downPos);
    }
    if( Math.abs(armEncoder.getPosition()-(downPos)) < 0.01) {
      m_arm.armStop();
      m_arm.setBrake(IdleMode.kCoast);
    }
    if(upButton.get() && armIsUp==false){
      m_arm.setBrake(IdleMode.kBrake);
      armIsUp = true;
      m_arm.setPosition(upPos);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_arm.setBrake(IdleMode.kBrake);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
*/