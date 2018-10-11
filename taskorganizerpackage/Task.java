<<<<<<< HEAD:taskorganizerpackage/Task.java
package taskorganizerpackage;

=======
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Comparator;
>>>>>>> f715c8f7a9a474e46dec115a8dd769981e751229:Task.java
/**
 * A class that constructs tasks.
 *
 * @author (Hossin algerf)
 * @version (1)
 */
<<<<<<< HEAD:taskorganizerpackage/Task.java
  public class Task
  {
  private String title ;
=======
public class Task
 {
 private String title ;

 private String project ;
>>>>>>> f715c8f7a9a474e46dec115a8dd769981e751229:Task.java

  private String project ;

  private String dueDate ;
  
  private String description ;

  private String status  ;
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
    ".  done ?: "+(status));
     System.out.println ("description: "+(description)); 

    }   
 
    public void TaskInfoByDate()
   {
    System.out.println  ("Due Date : "+(dueDate)+". Task title: "+(title)+".  project: "+(project)+
    ".  Done ?: "+(status));
     System.out.println ("Description: "+(description)); 

    }   
    
    public void TaskInfoByProject()
   {
    System.out.println  ("project: "+(project)+". Task title: "+(title)+".  Due Date : "+(dueDate)+
    ".  done ?: "+(status));
     System.out.println ("description: "+(description)); 

    }   

   
   /** used for save function (method writeFile in class TaskOrganizer)
     */
    public String toString() {
    return title + "   " + project + "   " + dueDate + "   " + description+ "   " + status;
<<<<<<< HEAD:taskorganizerpackage/Task.java
    }
  
=======
  }
  
  
}
>>>>>>> f715c8f7a9a474e46dec115a8dd769981e751229:Task.java

}