/*
 * Copyright © 2019 by Zheng Kaining
 */
package Commands;

import General.Storage;
import General.Ui;
import Tasks.*;

public class AddCommand {

    public AddCommand() {
    }

    public void execute(TaskList tasks, Storage storage, Task task, Ui ui) {
        tasks.add(task);
        storage.appendTask(task);
        ui.showMessage("Got it. I've added this task:",task.taskInfo(),"Now you have "+tasks.size()+" tasks in your list.");
    }
}
