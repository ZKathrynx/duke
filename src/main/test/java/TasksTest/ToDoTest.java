/*
 * Copyright © 2019 by Zheng Kaining
 */

package TasksTest;

import General.DukeException;
import Tasks.ToDo;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ToDoTest {
    private ToDo testToDo = new ToDo("test");

    public ToDoTest() throws ParseException {
    }

    @Test
    public void testGetTaskName() {
        assertEquals("test", testToDo.getTaskName());
    }

    @Test
    public void testTaskInfo() {
        assertEquals("[X] [T] test", testToDo.taskInfo());
    }

    @Test
    public void testMarkAsDone() throws DukeException {
        testToDo.markAsDone();
        assertEquals(true, testToDo.isDone());
    }

    @Test
    public void testMarkAsDoneException() {
        try {
            testToDo.markAsDone();
            testToDo.markAsDone();
            fail();
        } catch (DukeException e) {
            assertEquals("OOPS! This task has been done already",e.getMessage());
        }
    }
}
