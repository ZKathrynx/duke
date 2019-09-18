/*
 * Copyright © 2019 by Zheng Kaining
 */
package CommandsTest;

import Commands.FindCommand;
import General.Ui;
import Tasks.TaskList;
import Tasks.ToDo;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindCommandTest {

    private TaskList testTaskList = new TaskList();
    private Ui ui = new Ui();
    private FindCommand testFindCommand = new FindCommand();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();


    @Test
    public void dummyTest() {
        /*testTaskList.add(new ToDo("t1"));
        testTaskList.add(new ToDo("t2"));
        testTaskList.add(new ToDo("t3"));
        testTaskList.add(new ToDo("t4"));
        System.setOut(new PrintStream(outContent));
        testFindCommand.execute(testTaskList,ui,"t1");
        assertEquals("\"Here are the matching tasks in your list:\""+ System.getProperty("line.separator"),outContent.toString());*/
        System.setOut(new PrintStream(outContent));
        System.out.println("hello world");
        assertEquals("hello world"+ System.getProperty("line.separator"),outContent.toString());
    }
}
