/*
 * Copyright © 2019 by Zheng Kaining
 */

package TasksTest;
import General.DukeException;
import Tasks.Deadline;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class DeadlineTest {

    private Deadline testDeadline = new Deadline("test", new SimpleDateFormat("yyyy.MM.dd HH.mm").parse("2000.11.14 12.00"));

    public DeadlineTest() throws ParseException {
    }

    @Test
    public void testGetTaskName() {
        assertEquals("test", testDeadline.getTaskName());
    }

    @Test
    public void testGetDdl() throws ParseException {
        assertEquals(new SimpleDateFormat("yyyy.MM.dd HH.mm").parse("2000.11.14 12.00"), testDeadline.getDdl());
    }

    @Test
    public void testTaskInfo() {
        assertEquals("[X] [D] test (by: 2000.11.14 12.00", testDeadline.taskInfo());
    }

    @Test
    public void testMarkAsDone() throws DukeException {
        testDeadline.markAsDone();
        assertEquals(true, testDeadline.isDone());
    }

    @Test
    public void testMarkAsDoneException() {
        try {
            testDeadline.markAsDone();
            testDeadline.markAsDone();
            fail();
        } catch (DukeException e) {
            assertEquals("OOPS! This task has been done already",e.getMessage());
        }
    }
}
