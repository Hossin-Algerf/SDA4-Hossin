/**
 * Representations for all the valid command words for the game
 * along with a string in a particular language.
 * @author Hossin algerf 
 * @version 1
 */


public enum CommandWord
{
    // A value for each command word along with its
    // corresponding user interface string.
    ShowTaskList("1"), AddNewTask("2"), EditTask("3"),SaveAndQuit("4"), UNKNOWN("?")
    ,ByDate ("6"), ByProject("7");
    
    // The command string.
    private String commandString;
    
    /**
     * Initialise with the corresponding command string.
     * @param commandString The command string.
     */
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    /**
     * @return The command word as a string.
     */
    public String toString()
    {
        return commandString;
    }
}