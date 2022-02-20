//SUBSYSTEM

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  VictorSPX intakeRoller = new VictorSPX(20); //creates intake motor

  private static final Intake intake = new Intake();
  public static Intake getInstance(){
    return intake;
  }

  /** Creates a new Intake. */
  public Intake() {}

  public double getSpeed(){
    return intakeRoller.getMotorOutputPercent();
  }

  public void AutonIntakeIn(){
    intakeRoller.set(ControlMode.PercentOutput, -0.72);
  }

  public void IntakeIn(){
    if(intakeRoller.getMotorOutputPercent() != 0){
      intakeRoller.set(ControlMode.PercentOutput, 0);
    }
    else {
    intakeRoller.set(ControlMode.PercentOutput, -0.72);
    } //sets intake in speed
  }

  public void AutonIntakeOut(){
    intakeRoller.set(ControlMode.PercentOutput, 0.95);
  }

  public void IntakeOut(){
    if(intakeRoller.getMotorOutputPercent() != 0){
      intakeRoller.set(ControlMode.PercentOutput, 0);
    }
    else {
    intakeRoller.set(ControlMode.PercentOutput, 0.95);
    } //sets intake in speed
  }

  public void IntakeStop(){
      intakeRoller.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
