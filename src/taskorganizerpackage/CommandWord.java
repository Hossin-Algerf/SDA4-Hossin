package taskorganizerpackage;

/**
 * Representations for all the valid command words for the app
 * @author  Michael Kölling and David J. Barnes and Hossin algerf
 * @version 1
 */


public enum CommandWord
{
    // A value for each command word along with its
    // corresponding user interface string.
    ShowTaskList("1"), AddNewTask("2"), EditTask("3"),SaveAndQuit("4"), UNKNOWN("?")
    ,UpdateTask("5") ,MarkAsDone("6"),RemoveTask("9");

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