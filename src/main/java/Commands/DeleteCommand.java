/*
 * Copyright © 2019 by Zheng Kaining
 */

package Commands;

import General.Storage;
import General.Ui;
import Tasks.TaskList;

/**
 * Delete task from list
 */
public class DeleteCommand {

    /**
     * Constructor
     */
    public DeleteCommand() {

    }

    /**
     * Delete task from list
     * @param tasks list
     * @param taskNo task to delete
     * @param storage save the list
     * @param ui print message
     */
    public void execute(TaskList tasks, int taskNo, Storage storage, Ui ui){
        String temp = tasks.elementAt(taskNo-1).taskInfo();
        tasks.remove(taskNo);
        storage.updateTask(tasks);
        ui.showMessage("Nice! I've marked this task as done:",temp,"Now you have "+tasks.size()+" tasks in your list.");
    }
}
