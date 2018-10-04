import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*; 
import java.lang.*; 
import java.io.*;
import java.util.Iterator;
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
        done = gotDone(TaskList);
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
                
             case EditDetails:
                editTaskDeatails();
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
            case MarkAsDone:
                MarkItDone();
                break;                
            case RemoveTask:
                 removeATask();                
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
         
        
        System.out.println("Enter title : ");
        String title = parser.nextLine();
        for (Iterator<Task> it = TaskList.iterator() ; it.hasNext();){
            Task TaskList = it.next();
            if (!(TaskList.getTitle().equals(title))){
            }
            else{
            System.out.println("this Title is used already,please try new");
            addTask();
            return;
        }
          
            }
            
            
        System.out.println("Enter project : ");
        String project = parser.nextLine();
        System.out.println("Enter dueDate : ");
        String dueDate = parser.nextLine();
        System.out.println("Enter description : ");
        String description = parser.nextLine();

       
        TaskList.add(new Task(title,project,dueDate,description)); 
        
      }
   
    
    /** calculates how many tasks are done 
    */
    public int gotDone(ArrayList<Task> Tasklist)
    {
    int x = 0;
    for (Task t : Tasklist) { 
       if (t.getStatus() == true)
        x++;
    }
    return x;
    }

       public void removeATask ()
    {
        System.out.println("Plz enter title of a task to remove: ");
        String titleRemove = parser.nextLine();
        
        for (Iterator<Task> it = TaskList.iterator() ; it.hasNext();){
            Task TaskList = it.next();
            if(TaskList.getTitle().equals(titleRemove)){
                it.remove();
                System.out.println("Task by title ( "+ (titleRemove) +" )is removed");
            }
            
    }
   }  
    
  public void MarkItDone()
  {
        System.out.println("Plz enter title of a task to mark as Done: ");
        String titleDone = parser.nextLine();
        
        for (Iterator<Task> it = TaskList.iterator() ; it.hasNext();){
            Task TaskList = it.next();
            if(TaskList.getTitle().equals(titleDone)){
                TaskList.MarkDone();
                System.out.println("Task by title ( "+ (titleDone) +" )is marked as Done");
            }
            
    }      
  }
 
    ///***** have to keep old if not entered , after else
    public void editTaskDeatails()
    {
       
        System.out.println("Plz enter title of a task to edit: ");
        String title2 = parser.nextLine();  
         String newTitle;
         String newProject ;
         String newDueDate ;
         String newDescription;
         
         String getTitle;
         String getProject;
         String getDueDate;
         String getDescription;
        for (Iterator<Task> it = TaskList.iterator() ; it.hasNext();){
            Task TaskList = it.next();
            if(TaskList.getTitle().equals(title2)){
         System.out.println("Enter new title or press (Enter) to keep : ");
         String title3 = parser.nextLine();
         
     //       if (!(TaskList.getTitle().equals(title3))){
     //             if( title3 != null ){
      //                   newTitle =  title3 ;
      //              }
      //          else{
     //                   newTitle = TaskList.getTitle() ;
       //                 System.out.println("title has not changed");
      //              }
       //             }

         //           else{
         //               System.out.println("this Title is used already,please try new");
          //              return;
           //         }
             
        if( title3 != null ){
           newTitle =  title3 ;
        }
        else{
          newTitle = TaskList.getTitle() ;
         System.out.println("title has not changed");  
        }
        
        System.out.println("Enter new Project name or press (Enter) to keep : ");
        String project3 =parser.nextLine();
         if(project3 != null){
           newProject =  project3 ;
        }
        else{
          newProject = TaskList.getProject() ;
         System.out.println("Project has not changed");  
        }        
        System.out.println("Enter new DueDate or press (Enter) to keep : ");
        String dueDate3=parser.nextLine(); 
         if(dueDate3 != null){
           newDueDate =  dueDate3 ;
        }
        else{
          newDueDate = TaskList.getDueDate() ;
         System.out.println("DueDate has not changed");  
        }        
        System.out.println("Enter new Description or press (Enter) to keep : ");
        String description3=parser.nextLine();
         if(description3 != null){
           newDescription =  description3 ;
        }
        else{
          newDescription = TaskList.getDescription() ;
         System.out.println("DueDate has not changed");  
        }  
        
        
        TaskList.setDetails(newTitle,newProject ,newDueDate,newDescription);
        
     }
     
       
    }    
        


    
  }
   

}

 

    