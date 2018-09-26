
/**
 * Write a description of class Task here.
 *
 * @author (your name)
 * @version (a version number or a date)
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



}
