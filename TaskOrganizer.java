import java.util.ArrayList;
/**
 * A class that to creat and manage tasks .
 *
 * @author (Hossin algerf)
 * @version (a version number or a date)
 */
    public class TaskOrganizer
    {
    // instance variables - replace the example below with your own
    private ArrayList<Task> TasksList;
    private Parser parser;

    /**
     * Constructor for objects of class Tasks
     */
        public TaskOrganizer()
    {
        // initialise instance variables
        TasksList = new ArrayList<>();
        parser = new Parser();
    }
     
    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }
    
    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to Task editor!");
        System.out.println("You have X tasks todo and Y tasks are done!");/////// X Y
        System.out.println("Pick an option:");
        System.out.println("(1) Show Task List (by date or project)");
        System.out.println("(2) Add New Task");
        System.out.println("(3) Edit Task (update, mark as done, remove)");
        System.out.println("(4) Save and Quit");
        System.out.println();
        
    }
    
    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("Please enter a valid command from the list");
                break;

            case ShowTaskList:
                ;
                break;

            case AddNewTask:
                 /// here i can ask the user to eneter details 1 by 1 
            
                 //new Task(String taskTitle,String taskProject ,String taskDueDate,String taskDescription);
                break;
                
            case EditTask:
                ;
                break;
                

            case SaveAndQuit:
                ;
                break;
            
            case ByDate:
                ;
                break;
            
            case ByProject:
                ;
                break;
                
                
        }
        return wantToQuit;
    }
    
    
}
    