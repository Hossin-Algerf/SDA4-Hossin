import java.util.HashMap;

/**
 * This class is part of the "TaskOrganizer" application. 
 * "TaskOrganizer" is a simple, task manager. 
 * 
 * This class holds an enumeration of all command words known to the app.
 * It is used to recognise commands as they are typed in.
 *
 * @author Hossin algerf 
 * @version 1
 */

public class CommandWords
{
  private HashMap<String, CommandWord> validCommands; 
  
  public CommandWords()
    {
        validCommands = new HashMap<>();
        for(CommandWord command : CommandWord.values()) {
            if(command != CommandWord.UNKNOWN) {
                validCommands.put(command.toString(), command);
            }
        }
    }
  
    
    public CommandWord getCommandWord(String commandWord)
    {
        CommandWord command = validCommands.get(commandWord);
        if(command != null) {
            return command;
        }
        else {
            return CommandWord.UNKNOWN;
        }
    }
    
    public boolean isCommand(String aString)
    {
        return validCommands.containsKey(aString);
    }
public void showAll() 
    {
        for(String command : validCommands.keySet()) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
