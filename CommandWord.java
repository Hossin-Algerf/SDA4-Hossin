


public enum CommandWord
{
    // A value for each command word along with its
    // corresponding user interface string.
    ShowTaskList("1"), AddNewTask("2"), EditTask("3"),SaveAndQuit("4"), UNKNOWN("?")
    ,ByDate ("d"), ByProject("p");
    
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