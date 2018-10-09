import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Iterator;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
/**
 * The main class that to creates and manages tasks .
 *
 * @author Hossin algerf
 * @version 1
 */
public class TaskOrganizer
{
    // instance variables - replace the example below with your own
    private ArrayList<Task> taskList;
    private Parser parser;
    private static final String filepath="/Users/tmp-sda-1155/TaskOrganizerStorage1.txt"; 
    /**
     * Constructor for objects of class Task
     */
    public TaskOrganizer()
    {
        // initialise instance variables
        taskList = new ArrayList<>();
        parser = new Parser();
    }

    /**
     *  Main process routine.  Loops until app exit.
     */
       public void startTaskOrganizer()
    {
        printWelcome();

        /** Enter the main command loop.  Here we repeatedly read commands and
         execute them until the app exits.*/


        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        writeToFile(taskList);
        System.out.println("Thank you for using TaskOrganizer .Good bye.");

    }

    /**
     * Print out the opening message for the user.
     */
    private void printWelcome()
    {
        readFile ();
        int done ;
        done = gotDone(taskList);
        System.out.println();
        System.out.println("Welcome to Task editor!");
        System.out.println("You have "+ (taskList.size() - done) +" tasks todo and "+ done +" tasks are done!");/////// X Y
        System.out.println("Pick an option:");
        System.out.println("(1) Show Task List (by date or project)");
        System.out.println("(2) Add New Task");
        System.out.println("(3) Edit Task (update, mark as done, remove)");
        System.out.println("(4) Save and Quit");
        System.out.println();

    }
    
    //Exit app 
       private boolean quit(Command command) 
    {

            return true;  // signal that we want to quit

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
                
                wantToQuit = quit(command);
                break;

            case ByDate:
                ;
                break;

            case ByProject:
                readFile ();
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

        boolean titleWanted = true;
        String title = null;
        while(titleWanted){
            System.out.println("Enter title : ");
            title = parser.nextLine();
            if (!title.equals("")){
                
            if (taskListContainsTitle(title)){
                System.out.println("Titel ("+ (title) +") already used,enter a new title");
            } else {
                titleWanted = false;
            }
            }else {
            System.out.println("title must be entered ,retry ");   }
            
            }

        boolean project1 = true;
        String project = null  ;      
        while(project1){
            System.out.println("Enter project : ");
            project = parser.nextLine();
            if (project.equals("")){
              System.out.println("project must be entered ,retry ");    } 
              else {
                project1 = false;
            }}

        boolean dueDate1 = true;
        String dueDate = null  ;      
        while(dueDate1){
            System.out.println("Enter dueDate : ");
            dueDate = parser.nextLine();
            if (dueDate.equals("")){
              System.out.println("dueDate must be entered ,retry ");    } 
              else {
                dueDate1 = false;
            }}           
        boolean description1 = true;
        String description = null  ;      
        while(description1){
            System.out.println("Enter description : ");
            description = parser.nextLine();
            if (description.equals("")){
              System.out.println("description must be entered ,retry ");    } 
              else {
                description1 = false;
            }}        
            
        taskList.add(new Task(title,project,dueDate,description));
    }


    /** calculates how many tasks are done
     */
    public int gotDone(ArrayList<Task> tasklist)
    {
        int x = 0;
        for (Task t : tasklist) {
            if (t.getStatus() == true)
                x++;
        }
        return x;
    }

    public void removeATask ()
    {
        System.out.println("Plz enter title of a task to remove: ");
        String titleRemove = parser.nextLine();

        for (Iterator<Task> it = taskList.iterator() ; it.hasNext();){
            Task taskList = it.next();
            if(taskList.getTitle().equals(titleRemove)){
                it.remove();
                System.out.println("Task by title ( "+ (titleRemove) +" )is removed");
            }

        }
    }

    public void MarkItDone()
    {
        System.out.println("Plz enter title of a task to mark as Done: ");
        String titleDone = parser.nextLine();
        boolean finded = false;
        for (Task t : taskList){

            if ((t.getTitle().equals(titleDone))){
                finded = true;
                t.MarkDone();
                System.out.println("Task by title ( "+ (titleDone) +" )is marked as Done");
            }
            
        }
        if (finded == false)
            System.out.println("there is no task by this title");        
    }

    public void duplicate (String editTitle)
    {
        boolean duplicate1;
        for (Iterator<Task> it = taskList.iterator() ; it.hasNext();){
            Task taskList = it.next();
            if (!(taskList.getTitle().equals(editTitle))){
                duplicate1 = false ;
            }

        }
    }

    ///***** have to keep old if not entered , after else
    public void editTaskDeatails()
    {

        System.out.println("Plz enter title of a task to edit: ");
        String title2 = parser.nextLine();
        
        String newTitle = null;
        boolean finded = false;
        String newProject ;
        String newDueDate ;
        String newDescription;


        String getTitle;
        String getProject;
        String getDueDate;
        String getDescription;
        ArrayList<String> titles = getTitleList();
        //if (titles.contains(title2))
        for (Task t : taskList)
        {

            if ((t.getTitle().equals(title2)))
            {
                finded = true;
                System.out.println("Enter new title or press (Enter) to keep : ");
                String title3 =parser.nextLine();
                if(!title3.equals(""))
                {

                    for (Task q : taskList)
                    {

                        if ((q.getTitle().equals(title3)))
                        {
                            System.out.println("Titel ("+ (title3) +")already exists,so title has not changed,");
                            newTitle = title2;
                            break;

                        }
                    }
                    if (newTitle == null)
                    {
                        newTitle = title3;
                    }

                }
                else {
                    newTitle = t.getTitle() ;
                    System.out.println("title has not changed ,");
                }
                System.out.println("Enter new Project name or press (Enter) to keep : ");
                String project3 =parser.nextLine();
                if(!project3.equals("")){
                    newProject =  project3 ;
                }
                else{
                    newProject = t.getProject() ;
                    System.out.println("Project has not changed ,");
                }
                System.out.println("Enter new DueDate or press (Enter) to keep : ");
                String dueDate3=parser.nextLine();
                if(!dueDate3.equals("")){
                    newDueDate =  dueDate3 ;
                }
                else{
                    newDueDate = t.getDueDate() ;
                    System.out.println("DueDate has not changed ,");
                }
                System.out.println("Enter new Description or press (Enter) to keep : ");
                String description3=parser.nextLine();
                if(!description3.equals("")){
                    newDescription =  description3 ;
                }
                else{
                    newDescription = t.getDescription() ;
                    System.out.println("Description has not changed ,");
                }
                t.setDetails(newTitle,newProject ,newDueDate,newDescription);

            }
            /*else {
                System.out.println("there is no task by this title");
                return;
            }*/

        }
        if (finded == false)
            System.out.println("there is no task by this title");

    }

    // create arraylist of titles existing in existing Task objects .
    // i use it for other methods , to avoid exra loops and iterators , and other conflicts .
    private boolean taskListContainsTitle(String titleName)
    {
        for (Task t : taskList)
        {
            if (t.getTitle().equals(titleName))
            {
                return true;
            }

        }
        return false;
    }

    private ArrayList<String> getTitleList()
    {
        ArrayList<String> list = new ArrayList<>();
        for (Task t : taskList)
        {
            list.add(t.getTitle());
        }
        return list;
    }

    
    
    
    public void writeToFile (ArrayList<Task> tasklist){

      for (int i = 0; i < tasklist.size(); i++) {
	        try {

	            FileOutputStream fileOut = new FileOutputStream(filepath);
	            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
	            objectOut.writeObject(taskList.toString());
	            objectOut.close();
	            System.out.println("Tasks are saved");
	 
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
	   }
	   
	  
	
    public void readFile ()
    {
     try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filepath, true))))   {
     for(Task b:taskList)
     {
     //example  while(){} 
   
       
       
      
     }
    }catch (IOException e) {
       System.out.println(e);
     }   
        
        
        
        
    }
}



