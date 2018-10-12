package taskorganizerpackage;

import java.io.InputStream;
import java.util.Scanner;

/**
 * This class is part of the "TaskOrganizer" application. 

 * This parser reads user input
 *
 * The parser has a set of known command numbers. It checks user input against
 * the known commands, and if the input is not one of the known commands, it
 * returns a command object that is marked as an unknown command.
 * @author  Michael Kölling and David J. Barnes and Hossin algerf
 * @version 1
 */
public class Parser 
{
    private CommandWords commands;
    private Scanner reader;
  
    public Parser() 
    {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }
     
    public Command getCommand() 
    {
        String inputLine;   // will hold the full input line
        String word1 = null;
        

        System.out.print("> ");     // print prompt

        inputLine = reader.nextLine();

        // Find up to two words on the line.
        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();      // get first word
        }

         return new Command(commands.getCommandWord(word1));
    }

    
    public String nextLine(){
         return reader.nextLine();
    }

    public void updateSystemIn(){
        reader = new Scanner(System.in);
    }

}