package taskorganizerpackage;

/**
 * This class is part of the "TaskOrganizer" application. 
 * "TaskOrganizer" is a simple, task manager.    
 *
 * This class holds information about a command that was issued by the user.
 * A command currently consists of one integer .
 * 
 * The way this is used is: Commands are already checked for being valid
 * command words. If the user entered an invalid command (a word that is not
 * known) then the CommandWord is UNKNOWN.
 * 
 * @author Hossin algerf 
 * @version 1
 */

public class Command
{
    private CommandWord commandWord;
    

    /**
     * Create a command object. an integer must be supplied .
     * @param commandWord The CommandWord. UNKNOWN if the command word
     * was not recognised.
     */
    public Command(CommandWord commandWord)
    {
        this.commandWord = commandWord;
        
    }

    /**
     * Return the command word of this command.
     * @return The command word.
     */
    public CommandWord getCommandWord()
    {
        return commandWord;
    }

    

    /**
     * @return true if this command was not understood.
     */
    public boolean isUnknown()
    {
        return (commandWord == CommandWord.UNKNOWN);
    }

}