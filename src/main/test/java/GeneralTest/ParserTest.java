/*
 * Copyright © 2019 by Zheng Kaining
 */

package GeneralTest;

import General.DukeException;
import General.Parser;
import General.Storage;
import General.Ui;
import Tasks.TaskList;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {
    private TaskList toDoList = new TaskList();
    private boolean isBye;
    private Storage save;
    private Ui ui;
    private Parser testParser = new Parser(toDoList,save,ui);

    @Test
    public void testExtractDate () throws DukeException, ParseException {
        assertEquals(new SimpleDateFormat("yyyy.MM.dd HH.mm").parse("2000.11.14 12.00"), testParser.extractDate("event test1 \\at 2000.11.14 12.00"));
    }

    @Test
    public void testExtractTaskName () throws DukeException {
        assertEquals(" test1", testParser.extractTaskName("todo test1"));
    }
}
