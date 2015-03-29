package org.usfirst.frc5293.prefs;

import org.usfirst.frc5293.prefs.util.BooleanPref;
import org.usfirst.frc5293.prefs.util.Pref;
import org.usfirst.frc5293.prefs.util.PrefGroup;
import org.usfirst.frc5293.prefs.util.StringPref;

import java.util.ArrayList;
import java.util.List;

public class Root implements PrefGroup {
    private final List<Pref<?>> all = new ArrayList<>();

    private final BooleanPref isSensitiveScalingEnabled = new BooleanPref(
            "root:is_sensitive_scaling_enabled",
            true
    ); { all.add(isSensitiveScalingEnabled); }

    private final StringPref autonomousCommand = new StringPref(
            "root:autonomous_command",
            "0.5 sec (0.5 x, 0.0 y, 0.0 z)"
    ); { all.add(autonomousCommand); }

    @Override
    public List<Pref<?>> getAll() {
        return all;
    }

    public BooleanPref isSensitiveScalingEnabled() {
        return isSensitiveScalingEnabled;
    }

    public StringPref getAutonomousCommand() {
        return autonomousCommand;
    }
}
