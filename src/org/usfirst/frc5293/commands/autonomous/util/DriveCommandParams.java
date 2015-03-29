package org.usfirst.frc5293.commands.autonomous.util;

import org.usfirst.frc5293.translations.util.DriveState;

public class DriveCommandParams {
    public double seconds;
    public DriveState movement;

    public DriveCommandParams() {
        movement = new DriveState();
    }
}
