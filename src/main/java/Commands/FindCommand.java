/*
 * Copyright © 2019 by Zheng Kaining
 */

package Commands;

import General.Ui;
import Tasks.TaskList;

/**
 * Find designated task
 */
public class FindCommand {

    /**
     * Constructor
     */
    public FindCommand() {

    }

    /**
     * Find designated task
     * @param tasks list
     * @param ui show outcome
     * @param key keyword to find
     */
    public void execute(TaskList tasks, Ui ui, String key) {
        ui.showMessage("Here are the matching tasks in your list:");
        int count = 1;
        for (int i = 0; i < tasks.size(); i ++) {
            if (tasks.elementAt(i).getTaskName().contains(key)) {
                System.out.print(count+".");
                System.out.println(tasks.elementAt(i).taskInfo());
                count ++;
            }
        }
    }
}
