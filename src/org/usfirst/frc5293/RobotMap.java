// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5293;
    
import edu.wpi.first.wpilibj.*;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import java.util.Vector;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static SpeedController drivetrainTalonSR0;
    public static SpeedController drivetrainTalonSR1;
    public static SpeedController drivetrainTalonSR2;
    public static SpeedController drivetrainTalonSR3;
    public static RobotDrive drivetrainRobotDrive41;
    public static SpeedController toteElevatorTalonSRX4;
    public static SpeedController toteElevatorTalonSRX5;
    public static DigitalInput toteElevatorLimitTote0;
    public static DigitalInput toteElevatorLimitToteElev1;
    public static DigitalInput toteElevatorLimitToteElev2;
    public static SpeedController binElevatorVictorSP6;
    public static DigitalInput binElevatorLimitBinElev3;
    public static DigitalInput binElevatorLimitBinElev4;
    public static DigitalInput binElevatorLimitBinElev5;
    public static DigitalInput binElevatorLimitBinElev6;
    public static DigitalInput binElevatorLimitBinElev7;
    public static DoubleSolenoid binGrabberDoubleSolGrabber0;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        drivetrainTalonSR0 = new Talon(0);
        LiveWindow.addActuator("Drivetrain", "TalonSR 0", (Talon) drivetrainTalonSR0);
        
        drivetrainTalonSR1 = new Talon(1);
        LiveWindow.addActuator("Drivetrain", "TalonSR 1", (Talon) drivetrainTalonSR1);
        
        drivetrainTalonSR2 = new Talon(2);
        LiveWindow.addActuator("Drivetrain", "TalonSR 2", (Talon) drivetrainTalonSR2);
        
        drivetrainTalonSR3 = new Talon(3);
        LiveWindow.addActuator("Drivetrain", "TalonSR 3", (Talon) drivetrainTalonSR3);
        
        drivetrainRobotDrive41 = new RobotDrive(drivetrainTalonSR0, drivetrainTalonSR1,
              drivetrainTalonSR2, drivetrainTalonSR3);
        
        drivetrainRobotDrive41.setSafetyEnabled(true);
        drivetrainRobotDrive41.setExpiration(0.1);
        drivetrainRobotDrive41.setSensitivity(0.5);
        drivetrainRobotDrive41.setMaxOutput(1.0);

        toteElevatorTalonSRX4 = new TalonSRX(4);
        LiveWindow.addActuator("Tote Elevator", "TalonSRX 4", (TalonSRX) toteElevatorTalonSRX4);
        
        toteElevatorTalonSRX5 = new TalonSRX(5);
        LiveWindow.addActuator("Tote Elevator", "TalonSRX 5", (TalonSRX) toteElevatorTalonSRX5);
        
        toteElevatorLimitTote0 = new DigitalInput(0);
        LiveWindow.addSensor("Tote Elevator", "Limit Tote 0", toteElevatorLimitTote0);
        
        toteElevatorLimitToteElev1 = new DigitalInput(1);
        LiveWindow.addSensor("Tote Elevator", "Limit ToteElev 1", toteElevatorLimitToteElev1);
        
        toteElevatorLimitToteElev2 = new DigitalInput(2);
        LiveWindow.addSensor("Tote Elevator", "Limit ToteElev 2", toteElevatorLimitToteElev2);
        
        binElevatorVictorSP6 = new VictorSP(6);
        LiveWindow.addActuator("Bin Elevator", "Victor SP 6", (VictorSP) binElevatorVictorSP6);
        
        binElevatorLimitBinElev3 = new DigitalInput(3);
        LiveWindow.addSensor("Bin Elevator", "Limit BinElev 3", binElevatorLimitBinElev3);
        
        binElevatorLimitBinElev4 = new DigitalInput(4);
        LiveWindow.addSensor("Bin Elevator", "Limit BinElev 4", binElevatorLimitBinElev4);
        
        binElevatorLimitBinElev5 = new DigitalInput(5);
        LiveWindow.addSensor("Bin Elevator", "Limit BinElev 5", binElevatorLimitBinElev5);
        
        binElevatorLimitBinElev6 = new DigitalInput(6);
        LiveWindow.addSensor("Bin Elevator", "Limit BinElev 6", binElevatorLimitBinElev6);
        
        binElevatorLimitBinElev7 = new DigitalInput(7);
        LiveWindow.addSensor("Bin Elevator", "Limit BinElev 7", binElevatorLimitBinElev7);
        
        binGrabberDoubleSolGrabber0 = new DoubleSolenoid(0, 0, 1);      
        LiveWindow.addActuator("Bin Grabber", "Double Sol Grabber 0", binGrabberDoubleSolGrabber0);
        
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
