package org.usfirst.frc5293.commands.autonomous;

import org.usfirst.frc5293.Subsystems;
import org.usfirst.frc5293.commands.autonomous.util.DriveCommandParams;
import org.usfirst.frc5293.commands.util.TimedCommand;
import org.usfirst.frc5293.translations.autonomous.MecanumDriveEngine;
import org.usfirst.frc5293.translations.util.DriveState;

public class TimedAutonomousCommand extends TimedCommand {

    private static MecanumDriveEngine engine = MecanumDriveEngine.getInstance();
    private final DriveState movement;

    public TimedAutonomousCommand(DriveCommandParams params) {
        this(params.seconds, params.movement);
    }

    public TimedAutonomousCommand(double seconds, DriveState movement) {
        super(seconds);
        this.movement = movement;
    }

    @Override
    protected void execute() {
        drive(movement);
    }

    @Override
    protected void end() {
        super.end();
        stop();
    }


    private void drive(DriveState state) {
        Subsystems.getDrivetrain().joystickDrive(state.x, state.y, state.r);
    }

    private void stop() {
        Subsystems.getDrivetrain().stop();
    }
}
