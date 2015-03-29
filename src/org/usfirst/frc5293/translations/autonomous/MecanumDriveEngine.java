package org.usfirst.frc5293.translations.autonomous;

import org.usfirst.frc5293.Prefs;
import org.usfirst.frc5293.prefs.Drivetrain;
import org.usfirst.frc5293.translations.util.DriveState;
import org.usfirst.frc5293.translations.util.InputTranslationEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MecanumDriveEngine extends InputTranslationEngine<DriveState> {

    private static MecanumDriveEngine instance;

    public static MecanumDriveEngine getInstance() {
        if (instance == null) {
            instance = new MecanumDriveEngine();
        }
        return instance;
    }

    //

    private final Drivetrain prefs = Prefs.getDrivetrain();

    private MecanumDriveEngine() {

    }

    @Override
    protected List<Function<DriveState, DriveState>> getOperations() {
        List<Function<DriveState, DriveState>> ops = new ArrayList<>();

        ops.add(this::invertYDirection);

        return ops;
    }

    private DriveState invertYDirection(DriveState state) {
        state.x *= -1;
        state.y *= -1;
        state.r *= +1;
        return state;
    }
}
