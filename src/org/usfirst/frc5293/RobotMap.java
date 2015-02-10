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

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static final class ToteElevator {
        public static SpeedController talonSRX0;
        public static SpeedController talonSRX1;
        public static DigitalInput bottomLimitSwitch;

        public static void init() {
            talonSRX0 = new CANTalon(0);
            // TODO: For what ever reason we cannot directly connect the CANTalon to LiveWindow since it does not implement
            // TODO: the LiveWindowSendable interface.
            //LiveWindow.addActuator("Tote Elevator", "TalonSRX 4", (CANTalon) talonSRX0);

            talonSRX1 = new CANTalon(1);
            //LiveWindow.addActuator("Tote Elevator", "TalonSRX 5", (CANTalon) talonSRX1);

            bottomLimitSwitch = new DigitalInput(4);
            LiveWindow.addSensor("Tote Elevator", "Button Limit Switch", ToteElevator.bottomLimitSwitch);
        }
    }

    public static final class Drivetrain {
        public static SpeedController frontLeftTalon;
        public static SpeedController backLeftTalon;
        public static SpeedController frontRightTalon;
        public static SpeedController backRightTalon;
        public static RobotDrive control;

        public static void init() {
            frontLeftTalon = new Talon(0);
            LiveWindow.addActuator("Drivetrain", "Front Left (Talon)", (Talon) frontLeftTalon);

            backLeftTalon = new Talon(1);
            LiveWindow.addActuator("Drivetrain", "Back Left (Talon)", (Talon) backLeftTalon);

            frontRightTalon = new Talon(2);
            LiveWindow.addActuator("Drivetrain", "Front Right (Talon)", (Talon) frontRightTalon);

            backRightTalon = new Talon(3);
            LiveWindow.addActuator("Drivetrain", "Back Right (Talon)", (Talon) backRightTalon);

            control = new RobotDrive(
                    frontLeftTalon, backLeftTalon,
                    frontRightTalon, backRightTalon);

            control.setSafetyEnabled(true);
            control.setExpiration(0.1);
            control.setSensitivity(0.5);
            control.setMaxOutput(1.0);
        }
    }

    public static final class BinElevator {
        public static SpeedController victor;
        public static DoubleSolenoid solenoidGrabber;

        public static void init() {
            victor = new VictorSP(6);
            LiveWindow.addActuator("Bin Elevator", "Victor SP 6", (VictorSP) victor);

            solenoidGrabber = new DoubleSolenoid(0, 0, 1);
            LiveWindow.addActuator("Bin Grabber", "Double Sol Grabber 0", solenoidGrabber);
        }
    }

    public static void init() {
        Drivetrain.init();
        ToteElevator.init();
        BinElevator.init();
    }
}
