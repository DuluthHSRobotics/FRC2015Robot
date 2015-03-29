package org.usfirst.frc5293.prefs.util;

import edu.wpi.first.wpilibj.Preferences;

public class StringPref extends Pref<String> {
    public StringPref(String key, String defaultValue) {
        super(key, defaultValue);
    }

    @Override
    public String get() {
        return Preferences.getInstance().getString(key, defaultValue);
    }

    @Override
    public void set(String value) {
        Preferences.getInstance().putString(key, value);
    }
}
