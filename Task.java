import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Comparator;
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

 private String status  ;
 
 private static final long serialVersionUID = 1L;
 //Constructor
  public Task (String taskTitle,String taskProject ,String taskDueDate,String taskDescription,String taskstatus)
 {
 title = taskTitle;
 project=taskProject;
 dueDate=taskDueDate;
 description=taskDescription;
 status= taskstatus;

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
  
  public String getStatus()
    {
    return status ;
    }  
    
  /** setter for all Task details except status */ 
  public void setDetails(String newTitle,String newProject ,String newDueDate,String newDescription)
    {
        title =newTitle ;
        project=newProject ;
        dueDate = newDueDate;
        description = newDescription ;
    }
    
    // setter for each field individually
  public void setTitle (String newTitle)
  {
    title =newTitle ; 
  }
  
  public void setProject (String newProject)
   {
    project=newProject ;  
   }
  
  public void setDueDate (String newDueDate)
   {
    dueDate = newDueDate; 
   }  
  
  public void setDescription (String newDescription)
   {
    description = newDescription ;   
   }  
  
  public void setStatus ( String newStatus ) 
   {
    status= newStatus ;  
   }  
  
  /**mark a task as done 
     */
  public void MarkDone ()
   {
   status = "done" ;
   }
  
   public void TaskInfo()
   {
    System.out.println  ("Task title: "+(title)+".  project: "+(project)+".  dueDate : "+(dueDate)+
     ".  description: "+(description)+".  done ?: "+(status)); 

    }   

    /** used for save function 
     */
    public String toString() {
    return title + "   " + project + "   " + dueDate + "   " + description+ "   " + status;
  }
  
  
}

 
