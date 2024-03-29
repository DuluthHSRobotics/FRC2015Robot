
package org.usfirst.frc5293.util.parsing;

//Change this import to your own CommandBase

public interface IParsable {
    /**
     *Return a one-character String which unique for this class.
     *This is the character you will use in a command string to call this class.
     */
    String getIdentifier();
    
    /**
     * Use this method to set variables which are set in your normal constructor
     * Keep track of the order, as that will be the order you use for the Input String.
     */
    void setArguments(String[] args);
}