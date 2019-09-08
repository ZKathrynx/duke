/*
 * Copyright © 2019 by Zheng Kaining
 */

package Commands;

import General.DukeException;
import General.Storage;
import General.Ui;
import Tasks.TaskList;

public class DoneCommand {

    public DoneCommand() {

    }

    public void execute(TaskList tasks, Storage storage, int taskNo, Ui ui) throws DukeException {
        tasks.elementAt(taskNo - 1).markAsDone();
        ui.showMessage("Nice! I've marked this task as done:", tasks.elementAt(taskNo - 1).taskInfo(), "Now you have " + tasks.size() + " tasks in your list.");
        storage.appendTask(tasks.elementAt(taskNo - 1));
    }
}
