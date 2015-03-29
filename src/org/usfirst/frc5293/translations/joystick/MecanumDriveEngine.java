package org.usfirst.frc5293.translations.joystick;

import org.usfirst.frc5293.Input;
import org.usfirst.frc5293.Prefs;
import org.usfirst.frc5293.input.MecanumDrive;
import org.usfirst.frc5293.prefs.Drivetrain;
import org.usfirst.frc5293.translations.util.DriveState;
import org.usfirst.frc5293.translations.util.StreamingTranslationEngine;
import org.usfirst.frc5293.util.MathUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MecanumDriveEngine extends StreamingTranslationEngine<DriveState> {

    private static MecanumDriveEngine instance;

    public static MecanumDriveEngine getInstance() {
        if (instance == null) {
            instance = new MecanumDriveEngine();
        }
        return instance;
    }

    //

    private final MecanumDrive input = Input.getMecanumDrive();
    private final Drivetrain prefs = Prefs.getDrivetrain();

    private MecanumDriveEngine() {
    }

    @Override
    protected DriveState getInitial() {
        DriveState state = new DriveState();

        state.x = input.getStrafeJoystick().getX();
        state.y = input.getStrafeJoystick().getY();
        state.r = input.getRotationJoystick().getTwist();

        return state;
    }

    @Override
    protected List<Function<DriveState, DriveState>> getOperations() {
        List<Function<DriveState, DriveState>> ops = new ArrayList<>();

        ops.add(this::applySystemDisabling);
        ops.add(this::applyAxisDisabling);
        ops.add(this::applyAxisLocking);
        ops.add(this::applyQuadScaling);
        ops.add(this::applySensitiveScaling);
        ops.add(this::applyInversions);

        return ops;
    }

    private DriveState applySystemDisabling(DriveState state) {
        if (!prefs.isSystemEnabled().get()) {
            state.x = 0;
            state.y = 0;
            state.r = 0;
        }

        return state;
    }

    private DriveState applyAxisDisabling(DriveState state) {
        if (!prefs.isXEnabled().get()) {
            state.x = 0;
        }

        if (!prefs.isYEnabled().get()) {
            state.y = 0;
        }

        if (!prefs.isRotationEnabled().get()) {
            state.r = 0;
        }

        return state;
    }

    private DriveState applySensitiveScaling(DriveState state) {
        if (!Prefs.getRoot().isSensitiveScalingEnabled().get()
                || !Input.getSensitivityModeButton().get()) {
            return state;
        }

        state.x *= prefs.getScaleX().get();
        state.y *= prefs.getScaleY().get();
        state.r *= prefs.getScaleRotation().get();

        return state;
    }

    private DriveState applyAxisLocking(DriveState state) {
        if (prefs.isAxisLockingEnabled().get()) {
            if (input.getDriveXAxisButton().get()) {
                state.y = 0;
            } else if (input.getDriveYAxisButton().get()) {
                state.x = 0;
            }
        }

        return state;
    }

    private DriveState applyQuadScaling(DriveState state) {
        if (!prefs.isScalingFunctionsEnabled().get()) {
            return state;
        }

        double deadzone = prefs.getDeadzone().get();
        state.x = MathUtil.quadEaseWithDeadzone(state.x, deadzone);
        state.y = MathUtil.quadEaseWithDeadzone(state.y, deadzone);
        state.r = MathUtil.powerEaseWithDeadzone(state.r, 3, deadzone);
        return state;
    }

    private DriveState applyInversions(DriveState state) {
        state.x *=  1;
        state.y *=  1;
        state.r *= -1;
        return state;
    }
}
