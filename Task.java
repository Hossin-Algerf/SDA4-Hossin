import java.util.Scanner;
import java.util.*; 
import java.lang.*; 
import java.io.*;
import java.util.Iterator;
/**
 * A class that contructs tasks.
 *
 * @author (Hossin algerf)
 * @version (1)
 */
public class Task
 {
 private String title ;

 private String project ;

 private String dueDate ;

 private String description ;

 private boolean status;
 //Constructor
 public Task (String taskTitle,String taskProject ,String taskDueDate,String taskDescription )
 {
 title = taskTitle;
 project=taskProject;
 dueDate=taskDueDate;
 description=taskDescription;
 status= false;

 }
  public String getTitle()
    {
    return title ;
    }
  
  public String getProject()
    {
    return project ;
    }
    
  public String getDueDate()
    {
    return dueDate ;
    }
   
  public String getDescription()
    {
    return description ;
    }  
  
  public boolean getStatus()
    {
    return status ;
    }  
    
    
}

 
