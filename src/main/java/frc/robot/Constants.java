// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //public static double P = 1;
    //public static double armUpPosition = 0.01;//0.25;
    //public static double armDownPosition = 0.03;//0.05;
    public static final double kDTRotatetoFeet = (1/75)*(6*Math.PI)*(1/12);

    public static final double armHoldUp = 0.06;//arm up holding torque
    public static final double armHoldDown = 0.08;//.13;//torque the arm pushed down with in lowered position(stop it from jumping when it intakes)
    public static final double armTravelUp = 0.4;//arm travel torque
    public static final double armTravelDown = -0.5;
  
    public static final double armTimeUp = 0.57;//0.5;//time it takes the arm to lift
    public static final double armTimeDown = 0.37;//0.35;//time it takes the arm to lower
}
//random comment testing github stuff