package taskorganizerpackage;

/**
 * A class holds tasks.
 *
 * @author Hossin algerf
 * @version 1
 */
  public class Task
  {
  private String title ;

  private String project ;

  private String dueDate ;
  
  private String description ;

  private String status  ;
      /** constructor for tasks ,holds title,project,due date and description
       */
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

  /** change status to ( done )
     */
  public void MarkDone ()
   {
   status = "done" ;
   }

      public void taskInfo()
      {

          System.out.println("----------- Task title:  "+(title)+ "  ---------------");
          System.out.println("Project: "+(project)+" .  Due date : "+(dueDate)+ " . Status: "+(status));
          System.out.println("Description: "+(description));
      }

      /** used for save function (for method writeToFile in class TaskOrganizer)
     */
    public String toString() {
    return title + " Ü° " + project + " Ü° " + dueDate + " Ü° " + description+ " Ü° " + status;
    }
}