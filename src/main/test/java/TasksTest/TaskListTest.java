/*
 * Copyright © 2019 by Zheng Kaining
 */

package TasksTest;

import Tasks.TaskList;
import Tasks.ToDo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskListTest {
    private TaskList testTaskList1 = new TaskList();
    private TaskList testTaskList2 = new TaskList();

    @Test
    public void testSize () {
        assertEquals(0, testTaskList1.size());
        testTaskList2.add(new ToDo("test"));
        assertEquals(1, testTaskList2.size());
    }

    @Test
    public void testElementAt () {
        testTaskList1.add(new ToDo("test"));
        assertEquals(new ToDo("test").taskInfo(), testTaskList1.elementAt(0).taskInfo());
    }
}
