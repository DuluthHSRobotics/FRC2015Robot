package org.usfirst.frc5293.util.parsing;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class ParsedRobot extends IterativeRobot {
    private Preferences prefs = Preferences.getInstance();
    private final String commandName = "AutonomousCommand";
    private String autonomousString = "";
    private String defaultString = "";
    private CommandGroup autonomousCommand;

    //Creates the AutonomousCommand preference in RobotPreferences if it doesn't exist
    @Override
    public void robotInit(){
        if(!prefs.containsKey(commandName)){
            prefs.putString(commandName, defaultString);
            prefs.save();
        }
    }

    //Cancels any autonomous command when you disable the robot
    @Override
    public void disabledInit(){
        if(autonomousCommand != null){
            autonomousCommand.cancel();
        }
    }
    
    //Checks to see if you have changed the autonomous command while the robot is disabled
    @Override
    public void disabledPeriodic(){
        String currentString = prefs.getString(commandName, defaultString);
        if(!currentString.equals(autonomousString)){
            System.out.println("New command detected:: Old one was " + autonomousString + " New one was " + currentString);
            autonomousString = currentString;
            autonomousCommand = CommandParser.parseStringToCommandGroup(autonomousString);
        }
    }
    
    //Starts the autonomous command in Autonomous Mode
    @Override
    public void autonomousInit(){
        if(autonomousCommand != null){
            autonomousCommand.start();
        }
    }
    
    //Ends the autonomous command when Teleop starts
    @Override
    public void teleopInit(){
        if(autonomousCommand != null){
            autonomousCommand.cancel();
        }
    }

    /**
     * Call this in RobotInit, pass in an Array of all classes which implement IParsable.
     * Each of the classes must have a "dummy constructor" for which takes no arguments and does not need to do anything.
     * The arguments you would normally used will be passed to the command via SetArguments() where you can set the class variables
     * as you would in the normal constructor
     * @param list
     */
    protected void enterCommandList(IParsable[] list){
        ParsableCommandsList.setParsableCommands(list);
        autonomousCommand = CommandParser.parseStringToCommandGroup(prefs.getString(commandName, defaultString));
    }
    
   //Use the following three methods to parse the strings input to setArguments
    
    public static int parseInt(String str){
        try{
            return Integer.parseInt(str);
        }catch(Exception ex){
            System.out.println("Could not part integer from " + str);
            return 0;
        }
    }
    
    public static double parseDouble(String str){
        try{
            return Double.parseDouble(str);
        }catch(Exception ex){
            System.out.println("Could not part double from " + str);
            return 0;
        }
    }
    
    public static boolean parseBool(String str){
        if(str.toLowerCase().trim().equals("true")){
            return true;
        }else if (str.toLowerCase().trim().equals("false")){
            return false;
        }else{
            System.out.println("Could not parse boolean from " + str);
            return false;
        }
    }  

}