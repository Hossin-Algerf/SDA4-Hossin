import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.Serializable;
/**
 * A class that contructs tasks.
 *
 * @author (Hossin algerf)
 * @version (1)
 */
public class Task implements Serializable
 {
 private String title ;

 private String project ;

 private String dueDate ;

 private String description ;

 private boolean status;
 
 private static final long serialVersionUID = 1L;
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
    
  // setter for all Task details exluding Done  
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
  
  public void setStatus ( Boolean newStatus ) 
   {
    status= newStatus ;  
   }  
  
  //mark as done
  public void MarkDone ()
   {
   status= true ;
   }
  
   public void TaskInfo()
   {
    System.out.println  ("Task title: "+(title)+".  project: "+(project)+".  dueDate : "+(dueDate)+
     ".  description: "+(description)+".  done ?: "+(status)); 

    }   
  // to write 
  /*
  public String toString() {

   return new StringBuffer("Task title: ").append(this.title)
   .append("project: ").append(this.project).append("dueDate : ").append(this.dueDate).append
   (" description: ").append(this.description).append(" done ?: ").append(this.status).toString();
    }
*/    
    public String toString() {

   return new StringBuffer(this.title + "\n").append
   (this.project+ "\n").append(this.dueDate+ "\n").append(this.description+ "\n").append(this.status+ "\n").toString();
    }
}

 
