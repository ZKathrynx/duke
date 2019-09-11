/*
 * Copyright © 2019 by Zheng Kaining
 */

package TasksTest;

import General.DukeException;
import Tasks.Event;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class EventTest {
    private Event testEvent = new Event("test", new SimpleDateFormat("yyyy.MM.dd HH.mm").parse("2000.11.14 12.00"));

    public EventTest() throws ParseException {
    }

    @Test
    public void testGetTaskName() {
        assertEquals("test", testEvent.getTaskName());
    }

    @Test
    public void testGetDate() throws ParseException {
        assertEquals(new SimpleDateFormat("yyyy.MM.dd HH.mm").parse("2000.11.14 12.00"), testEvent.getDate());
    }

    @Test
    public void testTaskInfo() {
        assertEquals("[X] [E] test (at: 2000.11.14 12.00", testEvent.taskInfo());
    }

    @Test
    public void testMarkAsDone() throws DukeException {
        testEvent.markAsDone();
        assertEquals(true, testEvent.isDone());
    }

    @Test
    public void testMarkAsDoneException() {
        try {
            testEvent.markAsDone();
            testEvent.markAsDone();
            fail();
        } catch (DukeException e) {
            assertEquals("OOPS! This task has been done already",e.getMessage());
        }
    }
}
