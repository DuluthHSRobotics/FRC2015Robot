package org.usfirst.frc5293.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc5293.Prefs;
import org.usfirst.frc5293.commands.autonomous.util.DriveCommandParams;
import org.usfirst.frc5293.commands.autonomous.util.DriveCommandParser;
import org.usfirst.frc5293.prefs.Root;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AutonomousCommandGroup extends CommandGroup {

    private final static Root prefs = Prefs.getRoot();

    public AutonomousCommandGroup() {
        List<TimedAutonomousCommand> commands = getCommands().collect(Collectors.toList());

        System.out.printf(String.format("Command input `%s`", commands.size()), false);
        System.out.printf("Loaded %d commands for autonomous", commands.size());
        commands.forEach(this::addSequential);
    }

    private Stream<TimedAutonomousCommand> getCommands() {
        String commandText = prefs.getAutonomousCommand().get();

        List<DriveCommandParams> params = DriveCommandParser.parse(commandText);

        return params.stream().map(TimedAutonomousCommand::new);
    }
}
