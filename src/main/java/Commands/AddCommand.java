/*
 * Copyright © 2019 by Zheng Kaining
 */
package Commands;

import General.Storage;
import General.Ui;
import Tasks.*;

/**
 * Add task to list
 */
public class AddCommand {

    /**
     * Constructor
     */
    public AddCommand() {
    }

    /**
     * Add task to list
     * @param tasks list
     * @param storage save the file
     * @param task task to add
     * @param ui print task info
     */
    public void execute(TaskList tasks, Storage storage, Task task, Ui ui) {
        tasks.add(task);
        storage.appendTask(task);
        ui.showMessage("Got it. I've added this task:",task.taskInfo(),"Now you have "+tasks.size()+" tasks in your list.");
    }
}
