// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.Arm;

public class ArmHandler extends CommandBase {
  /** Creates a new ArmHandler. */
  private Arm m_arm;
  private JoystickButton downButton;
  private JoystickButton upButton;
  final double armHoldUp = 0.01;//arm up holding torque
  final double armHoldDown = 0;//.13;//torque the arm pushed down with in lowered position(stop it from jumping when it intakes)
  final double armTravel = 0.6;//arm travel torque

  final double armTimeUp = 0.5;//0.5;//time it takes the arm to lift
  final double armTimeDown = 0.2;//0.35;//time it takes the arm to lower

  boolean armIsUp;
  double lastBurstTime = 0;




  public ArmHandler(Arm sub, JoystickButton downButton, JoystickButton upButton) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.downButton = downButton;
    this.upButton = upButton;
    m_arm = sub;
    addRequirements(m_arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if (armIsUp) {
      if(Timer.getFPGATimestamp() - lastBurstTime < armTimeUp){
        m_arm.setSpeed(armTravel);
      }
      else{
        m_arm.setSpeed(armHoldUp);
      }
    } else {
      if(Timer.getFPGATimestamp() - lastBurstTime < armTimeUp){
        m_arm.setSpeed(-armTravel);
      }
      else{
        m_arm.setSpeed(-armHoldDown);
      }
    }

    if (downButton.get() && (armIsUp == false)) {
      lastBurstTime = Timer.getFPGATimestamp();
      armIsUp = true;
    } else if(upButton.get() && armIsUp == true) {
      lastBurstTime = Timer.getFPGATimestamp();
      armIsUp = false;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_arm.armStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
