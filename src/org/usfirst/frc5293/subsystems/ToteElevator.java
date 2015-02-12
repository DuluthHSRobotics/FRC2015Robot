// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc5293.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc5293.RobotMap;
import org.usfirst.frc5293.commands.CollectTote;

public class ToteElevator extends Subsystem {

	// TODO: Implement adjusting the speeds smoothly
    // TODO: Adjust speeds
    private static double RAISE_SPEED = 1.0;
    private static double LOWER_SPEED = -1.0;

    private final DigitalInput bottomLimitSwitch = RobotMap.ToteElevator.bottomLimitSwitch;
    private final SpeedController talonSRX0 = RobotMap.ToteElevator.talonSRX0;
    private final SpeedController talonSRX1 = RobotMap.ToteElevator.talonSRX1;

    public void raise() {
        raise(1.0);
    }

    public void raise(double percentage) {
    	talonSRX0.set(percentage * RAISE_SPEED);
    	talonSRX1.set(percentage * RAISE_SPEED);
    }

    public void lower() {
        lower(1.0);
    }

    public void lower(double percentage) {
        if (bottomLimitSwitch.get()) {
            stop();
            return;
        }

    	talonSRX0.set(percentage * LOWER_SPEED);
    	talonSRX1.set(percentage * LOWER_SPEED);
    }

    public void stop() {
    	talonSRX0.set(0);
    	talonSRX1.set(0);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new CollectTote());
    }
}

