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

import org.usfirst.frc5293.autoncommands.AutonDrive;
import org.usfirst.frc5293.commands.*;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());

    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton bCollectTote;
    public JoystickButton bReleaseTote;
    public JoystickButton bGrabBin;
    public JoystickButton bReleaseBin;
    public JoystickButton bLevel1;
    public JoystickButton bLevel2;
    public JoystickButton bLevel3;
    public JoystickButton bLevel4;
    public JoystickButton bLevel5;
    public JoystickButton b180Turn;
    public Joystick joystick1;
    public Joystick joystick2;
    public Joystick joystick3;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        joystick3 = new Joystick(2);
        
        joystick2 = new Joystick(1);
        
        joystick1 = new Joystick(0);
        
        b180Turn = new JoystickButton(joystick1, 10);
        b180Turn.whenPressed(new degreeTurn());
        bLevel5 = new JoystickButton(joystick1, 9);
        bLevel5.whenPressed(new BinLevel5());
        bLevel4 = new JoystickButton(joystick1, 8);
        bLevel4.whenPressed(new BinLevel4());
        bLevel3 = new JoystickButton(joystick1, 7);
        bLevel3.whenPressed(new BinLevel3());
        bLevel2 = new JoystickButton(joystick1, 6);
        bLevel2.whenPressed(new BinLevel2());
        bLevel1 = new JoystickButton(joystick1, 5);
        bLevel1.whenPressed(new BinLevel1());
        bReleaseBin = new JoystickButton(joystick1, 4);
        bReleaseBin.whileHeld(new ReleaseBin());
        bGrabBin = new JoystickButton(joystick1, 3);
        bGrabBin.whenPressed(new GrabBin());
        bReleaseTote = new JoystickButton(joystick1, 2);
        bReleaseTote.whenPressed(new ReleaseTote());
        bCollectTote = new JoystickButton(joystick1, 1);
        bCollectTote.whenPressed(new CollectTote());

	    
        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());

        SmartDashboard.putData("Collect Tote", new CollectTote());

        SmartDashboard.putData("Release Tote", new ReleaseTote());

        SmartDashboard.putData("Grab Bin", new GrabBin());

        SmartDashboard.putData("Release Bin", new ReleaseBin());

        SmartDashboard.putData("BinLevel 1", new BinLevel1());

        SmartDashboard.putData("BinLevel 2", new BinLevel2());

        SmartDashboard.putData("BinLevel 3", new BinLevel3());

        SmartDashboard.putData("BinLevel 4", new BinLevel4());

        SmartDashboard.putData("BinLevel 5", new BinLevel5());

        SmartDashboard.putData("degree Turn", new degreeTurn());

        SmartDashboard.putData("Mecanum Drive", new MecanumDrive());

        SmartDashboard.putData("Auton Drive", new AutonDrive());


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getJoystick1() {
        return joystick1;
    }

    public Joystick getJoystick2() {
        return joystick2;
    }

    public Joystick getJoystick3() {
        return joystick3;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}
