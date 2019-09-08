/*
 * Copyright © 2019 by Zheng Kaining
 */

package Commands;

import General.Ui;
import Tasks.TaskList;

public class ListCommand {

    public ListCommand() {

    }

    public void execute(TaskList tasks, Ui ui) {
        ui.showMessage("Here are the tasks in your list:");
        for (int i = 1; i <= tasks.size(); i++) {
            System.out.print(i+".");
            System.out.println(tasks.elementAt(i-1).taskInfo());
        }
    }
}
