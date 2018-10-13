package taskorganizerpackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class TaskOrganizerTest {

    private ByteArrayInputStream bi;
    private ByteArrayOutputStream bo;
    private PrintStream originalOut;
    private InputStream originalIn;

    private TaskOrganizer toWithNoTasks;
    private TaskOrganizer toWithOneTask;
    private TaskOrganizer toWithThreeTasks;

    @Before
    public void setUp() throws Exception {
        originalOut = System.out;
        originalIn = System.in;
        bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));

        toWithNoTasks = new TaskOrganizer();
        toWithOneTask = new TaskOrganizer();
        addOneTaskForSetup();
        toWithThreeTasks = new TaskOrganizer();
        addThreeTasksForSetup();

    }

    @After
    public void tearDown() throws Exception {
        bo.close();
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    private void addOneTaskForSetup(){
        String data = "title1\n" +
                "project1\n" +
                "2018,10,13\n" +
                "desc1\n";
        bi = new ByteArrayInputStream(data.getBytes());
        System.setIn(bi);
        toWithOneTask.updateSystemIn();
        toWithOneTask.addTask();
    }

    private void addThreeTasksForSetup(){
        String data =
                "title1\n" +
                "project1\n" +
                "2018,10,13\n" +
                "desc1\n" +
                "title2\n" +
                "project2\n" +
                "2018,10,14\n" +
                "desc2\n" +
                "title3\n" +
                "project3\n" +
                "2018,10,15\n" +
                "desc3\n";
        bi = new ByteArrayInputStream(data.getBytes());
        System.setIn(bi);
        toWithThreeTasks.updateSystemIn();
        toWithThreeTasks.addTask();
    }

    @Test
    public void addTaskOneTask() {
        String data = "title1\n" +
                "project1\n" +
                "2018,10,13\n" +
                "desc1\n";
        bi = new ByteArrayInputStream(data.getBytes());
        System.setIn(bi);
        toWithNoTasks.updateSystemIn();
        toWithNoTasks.addTask();
        toWithNoTasks.sortProjectPrint();
        String res = bo.toString();
        assertTrue(res.contains("title1"));
        assertTrue(res.contains("project1"));
        assertTrue(res.contains("2018,10,13"));
        assertTrue(res.contains("desc1"));
    }

    @Test
    public void addTaskThreeTasks() {
        String data = "title1\n" +
                "project1\n" +
                "2018,10,13\n" +
                "desc1\n" +
                "title2\n" +
                "project2\n" +
                "2018,10,14\n" +
                "desc2\n" +
                "title3\n" +
                "project3\n" +
                "2018,10,15\n" +
                "desc3\n";

        bi = new ByteArrayInputStream(data.getBytes());
        System.setIn(bi);
        toWithNoTasks.updateSystemIn();
        toWithNoTasks.addTask();
        toWithNoTasks.addTask();
        toWithNoTasks.addTask();

        toWithNoTasks.sortProjectPrint();
        String res = bo.toString();
        assertTrue(res.contains("title1"));
        assertTrue(res.contains("project1"));
        assertTrue(res.contains("2018,10,13"));
        assertTrue(res.contains("desc1"));
        assertTrue(res.contains("title2"));
        assertTrue(res.contains("project2"));
        assertTrue(res.contains("2018,10,14"));
        assertTrue(res.contains("desc2"));
        assertTrue(res.contains("title3"));
        assertTrue(res.contains("project3"));
        assertTrue(res.contains("2018,10,15"));
        assertTrue(res.contains("desc3"));
    }

    @Test
    public void addTaskOneFalseDate(){
        String data = "title1\n" +
                "project1\n" +
                "2018,10/13\n" +
                "2018,10,13\n" +
                "desc1\n";

        bi = new ByteArrayInputStream(data.getBytes());
        System.setIn(bi);
        toWithNoTasks.updateSystemIn();
        toWithNoTasks.addTask();
        toWithNoTasks.sortProjectPrint();
        String res = bo.toString();
        assertTrue(res.contains("title1"));
        assertTrue(res.contains("project1"));
        assertFalse(res.contains("2018,10/13"));
        assertTrue(res.contains("2018,10,13"));
        assertTrue(res.contains("desc1"));
    }

    @Test
    public void addTaskThreeTasksThreeConflictTitleEntries(){
        String data =
                        "title1\n" +
                        "project1\n" +
                        "2018,10,13\n" +
                        "desc1\n" +
                         "title1\n" +
                        "title2\n" +
                        "project2\n" +
                        "2018,10,14\n" +
                        "desc2\n" +
                         "title1\n" +
                         "title2\n" +
                        "title3\n" +
                        "project3\n" +
                        "2018,10,15\n" +
                        "desc3\n";

        bi = new ByteArrayInputStream(data.getBytes());
        System.setIn(bi);
        toWithNoTasks.updateSystemIn();
        toWithNoTasks.addTask();
        toWithNoTasks.addTask();
        toWithNoTasks.addTask();

        toWithNoTasks.sortProjectPrint();
        String res = bo.toString();

        assertTrue(res.contains("title1"));
        assertTrue(res.contains("project1"));
        assertTrue(res.contains("2018,10,13"));
        assertTrue(res.contains("desc1"));
        assertTrue(res.contains("title2"));
        assertTrue(res.contains("project2"));
        assertTrue(res.contains("2018,10,14"));
        assertTrue(res.contains("desc2"));
        assertTrue(res.contains("title3"));
        assertTrue(res.contains("project3"));
        assertTrue(res.contains("2018,10,15"));
        assertTrue(res.contains("desc3"));
    }

    @Test
    public void addTaskOneTaskEmptyEntryAttempts(){
        String data =
                        "\n" +
                "title1\n" +
                        "\n" +
                        "\n" +
                "project1\n" +
                        "\n" +
                "2018,10,13\n" +
                        "\n" +
                "desc1\n";

        bi = new ByteArrayInputStream(data.getBytes());
        System.setIn(bi);
        toWithNoTasks.updateSystemIn();
        toWithNoTasks.addTask();
        toWithNoTasks.sortProjectPrint();
        String res = bo.toString();
        assertTrue(res.contains("title1"));
        assertTrue(res.contains("project1"));
        assertTrue(res.contains("2018,10,13"));
        assertTrue(res.contains("desc1"));
    }

    @Test
    public void addTaskOneTaskFourFalseDates(){
        String data =
                        "title1\n" +
                        "project1\n" +
                        "friday\n" +
                        "20181013\n" +
                        "2018 10 13\n" +
                         "\n" +
                        "2018,10,13\n" +
                        "desc1\n";

        bi = new ByteArrayInputStream(data.getBytes());
        System.setIn(bi);
        toWithNoTasks.updateSystemIn();
        toWithNoTasks.addTask();
        toWithNoTasks.sortProjectPrint();
        String res = bo.toString();
        assertTrue(res.contains("title1"));
        assertTrue(res.contains("project1"));
        assertTrue(res.contains("2018,10,13"));
        assertTrue(res.contains("desc1"));
    }
    @Test
    public void updateTaskOneTaskNoTitleChange(){
        String data =
                        "title1\n" +
                        "\n" +
                        "project2\n" +
                        "1\n" +
                        "2018,10,14\n" +
                        "desc2\n";

        bi = new ByteArrayInputStream(data.getBytes());
        System.setIn(bi);
        toWithOneTask.updateSystemIn();
        toWithOneTask.updateTask();
        toWithOneTask.sortProjectPrint();
        String res = bo.toString();
        assertTrue(res.contains("title1"));
        assertTrue(res.contains("project2"));
        assertTrue(res.contains("2018,10,14"));
        assertTrue(res.contains("desc2"));
    }

    @Test
    public void updateSameTaskThreeUpdates(){
        String data =
                       "title1\n" +
                        "\n" +
                        "project1111\n" +
                        "1\n"+
                        "2018,10,22\n" +
                        "desc555\n" +

                        "title1\n" +
                        "title1\n"+
                        "\n" +
                        "\n"+
                        "desc2\n" +

                        "title1\n" +
                        "title X\n" +
                        "\n"+
                        "\n"+
                        "desc3333\n";

        bi = new ByteArrayInputStream(data.getBytes());
        System.setIn(bi);
        toWithOneTask.updateSystemIn();
        toWithOneTask.updateTask();
        toWithOneTask.updateTask();
        toWithOneTask.updateTask();

        toWithOneTask.sortProjectPrint();
        String res = bo.toString();

        assertTrue(res.contains("title X"));
        assertTrue(res.contains("project1111"));
        assertTrue(res.contains("2018,10,22"));
        assertTrue(res.contains("desc3333"));

    }
}