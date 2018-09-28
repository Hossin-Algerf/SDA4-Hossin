import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*; 
import java.lang.*; 
import java.io.*;
/**
 * The main class that to creates and manages tasks .
 *
 * @author Hossin algerf 
 * @version 1
 */
    public class TaskOrganizer
    {
    // instance variables - replace the example below with your own
    private ArrayList<Task> TaskList;
    private Parser parser;

    /**
     * Constructor for objects of class Task
     */
        public TaskOrganizer()
    {
        // initialise instance variables
        TaskList = new ArrayList<>();
        parser = new Parser();
    }
     
    /**
     *  Main process routine.  Loops until app exit.
     */
    public void play() 
    {            
        printWelcome();

        /** Enter the main command loop.  Here we repeatedly read commands and
         execute them until the app exits.*/
         
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }
    
    /**
     * Print out the opening message for the user.
     */
    private void printWelcome()
    {
        int done ;
        done = getDone(TaskList);
        System.out.println();
        System.out.println("Welcome to Task editor!");
        System.out.println("You have "+ (TaskList.size() - done) +" tasks todo and "+ done +" tasks are done!");/////// X Y
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
     * @return true If the command ends the app, false otherwise.
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
                showTheList();
                break;

            case AddNewTask:
                 addTask();/// here i can ask the user to eneter details 1 by 1 
                 
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
    
     /**
     * excuting command "1" , showin task list .
     */
    public void showTheList()
    {
    System.out.println("Please enter (6)to list tasks by date ");
    System.out.println("Or enter     (7)to list tasks by project ");
    }
    
     /**
     * excuting command "2" , adding a new Task .
     */
    public void addTask()
    {
       
        System.out.println("Plz enter title : ");
        String title = parser.nextLine();
        System.out.println("Plz enter project : ");
        String project = parser.nextLine();
        System.out.println("Plz enter dueDate : ");
        String dueDate = parser.nextLine();
        System.out.println("Plz enter description : ");
        String description = parser.nextLine();

       
        TaskList.add(new Task(title,project,dueDate,description)); 
        
    }
    
    /** calculates how many tasks are done 
    */
    public int getDone(ArrayList<Task> tasklist)
    {
    int x = 0;
    for (Task t : tasklist) { 
       if (t.getStatus() == true)
        x++;
    }
    return x;
    }
}
 

    