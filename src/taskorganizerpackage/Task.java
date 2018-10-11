package taskorganizerpackage;

/**
 * A class that constructs tasks.
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
   //Constructor
  public Task (String taskTitle,String taskProject ,String taskDueDate,String taskDescription,String taskStatus)
  {
  title = taskTitle;
  project=taskProject;
  dueDate=taskDueDate;
  description=taskDescription;
  status= taskStatus;

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

  /**mark a task as done 
     */
  public void MarkDone ()
   {
   status = "done" ;
   }

      public void taskInfo()
      {

          System.out.println("----------- Task title:  "+(title)+ "---------------");
          System.out.println("Project: "+(project)+" .  Due date : "+(dueDate)+ " . Status: "+(status));
          System.out.println("Description: "+(description));
      }

      /** used for save function (for method writeFile in class TaskOrganizer)
     */
    public String toString() {
    return title + "   " + project + "   " + dueDate + "   " + description+ "   " + status;
    }

}