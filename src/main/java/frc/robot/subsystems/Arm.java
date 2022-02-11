// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
//import com.revrobotics.RelativeEncoder;
//import com.revrobotics.SparkMaxPIDController;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import frc.robot.Constants;


public class Arm extends SubsystemBase {
  /** Creates a new Arm. */
  CANSparkMax armMotor = new CANSparkMax(21, MotorType.kBrushless);
  //public RelativeEncoder armEncoder = armMotor.getEncoder();
  //SparkMaxPIDController pid = armMotor.getPIDController();
    
  public Arm() {
    
    //pid.setP(Constants.P);
    //pid.setOutputRange(-0.2, 0.2);
    armMotor.setIdleMode(IdleMode.kBrake);

  }

  public void setSpeed(double speed){
    armMotor.set(speed);
  }
  public void setPosition(double position) {
    //pid.setReference(position, CANSparkMax.ControlType.kPosition);
  }

  public void setBrake(IdleMode brakeState) {
    armMotor.setIdleMode(brakeState);

  }

  public void armStop(){
    armMotor.stopMotor();

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
