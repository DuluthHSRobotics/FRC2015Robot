package org.usfirst.frc5293.translations.autonomous;

import org.usfirst.frc5293.Prefs;
import org.usfirst.frc5293.prefs.Drivetrain;
import org.usfirst.frc5293.translations.MecanumDriveEngine;
import org.usfirst.frc5293.translations.util.DrivingState;
import org.usfirst.frc5293.translations.util.InputTranslationEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class DriveEngine extends MecanumDriveEngine {

    @Override
    protected List<Function<DrivingState, DrivingState>> getOperations() {
        List<Function<DrivingState, DrivingState>> ops = new ArrayList<>();

        ops.add(this::applySystemDisabling);
        ops.add(this::applyAxisDisabling);
        ops.add(this::applyAxisLocking);
        ops.add(this::applyQuadScaling);
        ops.add(this::applySensitiveScaling);
        ops.add(this::applyInversions);

        return ops;
    }
}
