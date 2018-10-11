package taskorganizerpackage;
import java.util.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
/**
 * The main driver class  .
 *
 * @author Hossin algerf
 * @version 1
 */
public class TaskOrganizer
{

    private ArrayList<Task> taskList;
    private Parser parser;
    private static final String filepath="/Users/tmp-sda-1155/TaskOrganizerStorage1.txt";
    /**
     * Constructor for class operations .
     */
    public TaskOrganizer()
    {

        taskList = new ArrayList<>();
        parser = new Parser();
    }



    /**
     *  Main process routine.  Loops until app exit.
     */
    public void startTaskOrganizer()
    {
        readFile ();
        printWelcome();

        /** Enter the main command loop.  repeatedly read commands and
         execute them until the app exits.*/


        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        writeFile(taskList);
        System.out.println("Thank you for using TaskOrganizer .Good bye.");

    }

    /**
     * Print out the opening message for the user.
     */
    private void printWelcome()
    {
        int done ;
        done = gotDone(taskList);
        System.out.println();
        System.out.println("Welcome to Task Organizer !");
        System.out.println("You have "+ (taskList.size() - done) +" tasks todo and "+ done +" tasks are done!");
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
                System.out.println("Please enter a valid command: Show tasks(1), Add task(2),Edit task(3),Save And Quit(4)");
                break;
            case ShowTaskList:
                showTheList();
                break;
            case AddNewTask:
                addTask();
                break;
            case EditTask:
                editTask() ;
                break;
            case EditDetails:
                editTaskDetails();
                break;
            case SaveAndQuit:
                wantToQuit = quit(command);
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

    /** implementing Comparator to enable sorting  .
     */
    public class dueDateSorter implements Comparator<Task>{
        public int compare(Task o1, Task o2) {
            return o1.getDueDate().compareTo(o2.getDueDate());
        }
    }

    public class projectSorter implements Comparator<Task>{
        public int compare(Task o1, Task o2) {
            return o1.getProject().compareTo(o2.getProject());
        }
    }

    /** showing a sorted lists of tasks .
     */
    public void sortDueDatePrint()
    {
        System.out.println("list of tasks sorted by Due date :");
        Collections.sort(taskList, new dueDateSorter());
        for(Task d : taskList) {
            d.TaskInfoByDate();
        }
    }

    public void sortProjectPrint()
    {
        System.out.println("list of tasks sorted by Project :");
        Collections.sort(taskList, new projectSorter());
        for(Task p : taskList) {
            p.TaskInfoByProject();
        }
    }

    /**
     * executing command "1" , to show task list .
     */
    public void showTheList() {

        System.out.println("Please enter (d)to list tasks by Due date ");
        System.out.println("Or enter     (p)to list tasks by Project ");
        System.out.println("Or press (Enter) to cancel Showing Task List ");
        boolean show = true;
        String choice;
        while(show){
            choice = parser.nextLine();
            if (choice.equalsIgnoreCase("d")) {sortDueDatePrint();return; }
            if (choice.equalsIgnoreCase("p")) {sortProjectPrint();return; }
            if(!choice.equalsIgnoreCase("d") && !choice.equalsIgnoreCase("p")) {show = false;
                System.out.println("cancelled Showing Task List"); }
        }
    }
    public void editTask() {
        System.out.println("Please enter (5)to edit an existing task ");
        System.out.println("Or enter     (6)to mark a task as Done ");
        System.out.println("Or enter     (9)to Remove a task ");
    }
    /**
     * executing command "2" , adding a new Task .
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
                    System.out.println("Title ("+ (title) +") already used,enter a new title");
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
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter dueDate by format: yyyy,mm,dd  .for example : 2018,12,25");
        DateFormat dateFormat = new SimpleDateFormat("yyyy,mm,dd");
        Date date = null;
        while (date == null) {
            String line = scanner.nextLine();
            try {
                date = dateFormat.parse(line);
            } catch (ParseException e) {
                System.out.println("Sorry, that's not valid format. Please try again using: yyyy,mm,dd ");
                System.out.println("yyyy for year,mm for month,dd for day date,example : 2019,04,03 ");
            }
        }
        String dueDate = dateFormat.format(date);


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
        String status = "todo" ;
        taskList.add(new Task(title,project,dueDate,description,status));
        System.out.println("Task by title("+ (title) +") is created");
    }

    /** calculates how many tasks are done
     */
    public int gotDone(ArrayList<Task> taskList)
    {
        int x = 0;
        for (Task t : taskList) {
            if (t.getStatus().equals("done"))
                x++;
        }
        return x;
    }

    /** remove selected task.
     */
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

    /** to mark a task as done .
     */
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

    /** editing selected task
     */
    public void editTaskDetails()
    {

        System.out.println("Plz enter title of a task to edit: ");
        String title2 = parser.nextLine();

        String newTitle = null;
        boolean finded = false;
        String newProject ;
        String newDueDate ;
        String newDescription;

        ArrayList<String> titles = getTitleList();

        for (Task t : taskList)
        {
            if ((t.getTitle().equals(title2)))
            {
                finded = true;
                System.out.println("Enter new title or press (Enter) to keep it unchanged : ");
                String title3 =parser.nextLine();
                if(!title3.equals(""))
                {

                    for (Task q : taskList)
                    {

                        if ((q.getTitle().equals(title3)))
                        {
                            System.out.println("Title ("+ (title3) +")already exists,so title has not changed,");
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
                System.out.println("Project of this task is: "+(t.getProject()));
                System.out.println("Enter new Project name or press (Enter) to keep it unchanged: ");
                String project3 =parser.nextLine();
                if(!project3.equals("")){
                    newProject =  project3 ;
                }
                else{
                    newProject = t.getProject() ;
                    System.out.println("Project has not changed ,");
                }
                System.out.println("Due date of this task is: "+(t.getDueDate()));
                System.out.println("Type (1)to Enter new DueDate ,or press (Enter) to keep it unchanged: ");
                String choose =parser.nextLine();
                if(!choose.equals("")){
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Enter Due date by format: yyyy,mm,dd  .for example : 2018,12,25");
                    DateFormat dateFormat = new SimpleDateFormat("yyyy,mm,dd");
                    Date date = null;

                    while (date == null) {
                        String line = scanner.nextLine();

                        try {
                            date = dateFormat.parse(line);
                        } catch (ParseException e) {
                            System.out.println("Sorry, that's not valid format. Please try again using: yyyy,mm,dd ");
                            System.out.println("yyyy for year,mm for month,dd for day date,example : 2019,04,03 ");
                        }
                    }
                    newDueDate = dateFormat.format(date); }
                else{
                    newDueDate = t.getDueDate() ;
                    System.out.println("DueDate has not changed ,");
                }
                System.out.println("Description of this task : "+(t.getDescription())+" .");
                System.out.println("Enter new Description or press (Enter) to keep it unchanged: ");
                String description3=parser.nextLine();
                if(!description3.equals("")){
                    newDescription =  description3 ;
                }
                else{
                    newDescription = t.getDescription() ;
                    System.out.println("Description has not changed ,");
                }


                t.setDetails(newTitle,newProject ,newDueDate,newDescription);
                System.out.println("Editing task by title("+ (newTitle) +") is finished");
            }
        }
        if (finded == false)
            System.out.println("there is no task by this title");
    }

    /** check if a title already exists in existing Task objects
     */
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

    /** create arrayList of titles existing in existing Task objects .
     */
    private ArrayList<String> getTitleList()
    {
        ArrayList<String> list = new ArrayList<>();
        for (Task t : taskList)
        {
            list.add(t.getTitle());
        }
        return list;
    }

    /** save existing tasks into a text file.
     */
    private void writeFile(List<Task> taskList) {
        String fileName = "/Users/tmp-sda-1155/TaskOrganizerStorage1.txt";

        try {
            FileWriter fileWriter = new FileWriter(fileName);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Task ir : taskList) {

                bufferedWriter.write(ir.toString() + System.getProperty("line.separator"));

            }
            bufferedWriter.close();
        } catch (IOException ex) {
            System.out.println("Error writing to file (" + fileName + ")");
        }
    }
    /** load tasks from a text file that the app uses to save tasks.
     */
    private void readFile ()
    {
        try {
            Scanner s = new Scanner(new File("/Users/tmp-sda-1155/TaskOrganizerStorage1.txt"));

            while (s.hasNextLine()) {
                String[] split = s.nextLine().split("   ");
                taskList.add(new Task(split[0], split[1], split[2], split[3], split[4]));
            }
        } catch (IOException ex) {
            System.out.println("Error loading tasks");
        }
    }
}