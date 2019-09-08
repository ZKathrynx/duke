/*
 * Copyright © 2019 by Zheng Kaining
 */

package Commands;

import General.Storage;
import General.Ui;
import Tasks.TaskList;

public class DeleteCommand {

    public DeleteCommand() {

    }

    public void execute(TaskList tasks, int taskNo, Storage storage, Ui ui){
        String temp = tasks.elementAt(taskNo-1).taskInfo();
        tasks.remove(taskNo);
        storage.updateTask(tasks);
        ui.showMessage("Nice! I've marked this task as done:",temp,"Now you have "+tasks.size()+" tasks in your list.");
    }
}
