/*
 * Copyright © 2019 by Zheng Kaining
 */

package Commands;

import General.Ui;
import Tasks.TaskList;

/**
 * List existing tasks
 */
public class ListCommand {

    /**
     * Constructor
     */
    public ListCommand() {

    }

    /**
     * List existing tasks
     * @param tasks list
     * @param ui show tasks
     */
    public void execute(TaskList tasks, Ui ui) {
        ui.showMessage("Here are the tasks in your list:");
        for (int i = 1; i <= tasks.size(); i++) {
            System.out.print(i+".");
            System.out.println(tasks.elementAt(i-1).taskInfo());
        }
    }
}
