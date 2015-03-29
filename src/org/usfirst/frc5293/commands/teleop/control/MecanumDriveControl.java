package org.usfirst.frc5293.commands.teleop.control;

import org.usfirst.frc5293.Subsystems;
import org.usfirst.frc5293.commands.util.ContinuousCommand;
import org.usfirst.frc5293.translations.util.DriveState;
import org.usfirst.frc5293.translations.joystick.MecanumDriveEngine;

public class MecanumDriveControl extends ContinuousCommand {

    public MecanumDriveControl() {
        requires(Subsystems.getDrivetrain());
    }

    @Override
    protected void execute() {
        drive(MecanumDriveEngine.getInstance().getResult());
    }

    private void drive(DriveState state) {
        Subsystems.getDrivetrain().joystickDrive(state.x, state.y, state.r);
    }

    @Override
    protected void end() {
    	Subsystems.getDrivetrain().stop();
    }
}
