//SUBSYSTEM

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {

  CANSparkMax leftFront = new CANSparkMax(13, MotorType.kBrushless);
  CANSparkMax rightFront = new CANSparkMax(11, MotorType.kBrushless);
  CANSparkMax leftBack = new CANSparkMax(12, MotorType.kBrushless);
  CANSparkMax rightBack = new CANSparkMax(10, MotorType.kBrushless);

  public Drivetrain() {
    leftFront.setInverted(false);
    rightFront.setInverted(true);
    leftBack.follow(leftFront);
    rightBack.follow(rightFront);
  }

  public void setSpeed(double leftSpeed, double rightSpeed){
    leftFront.set(leftSpeed);
    rightFront.set(rightSpeed);
  }

  public void printVals(){
    System.out.print(leftFront.get());
    System.out.print(" | " + leftBack.get());
    System.out.print(" | " + rightFront.get());
    System.out.println(" | " + rightBack.get());
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
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
