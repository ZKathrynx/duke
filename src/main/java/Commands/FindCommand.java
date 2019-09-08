/*
 * Copyright © 2019 by Zheng Kaining
 */

package Commands;

import General.Ui;
import Tasks.TaskList;

public class FindCommand {

    public FindCommand() {

    }

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
