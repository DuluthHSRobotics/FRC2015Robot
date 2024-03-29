package org.usfirst.frc5293.commands.util;

import edu.wpi.first.wpilibj.command.Subsystem;

import java.util.List;

public class InlineActionCommand extends ActionCommand {

    private final Runnable action;

    public InlineActionCommand(Subsystem subsystem, Runnable action) {
        super(subsystem);
        this.action = action;
    }

    public InlineActionCommand(List<Subsystem> subsystems, Runnable action) {
        super(subsystems);
        this.action = action;
    }

    @Override
    protected void action() {
        action.run();
    }
}
