/*
 * Copyright © 2019 by Zheng Kaining
 */

package Commands;

import General.DukeException;
import General.Storage;
import General.Ui;
import Tasks.TaskList;

/**
 * Mark task as done
 */
public class DoneCommand {

    /**
     * Constructor
     */
    public DoneCommand() {

    }

    /**
     * Mark task as done
     * @param tasks list
     * @param storage update the file
     * @param taskNo task to mark as done
     * @param ui print message
     * @throws DukeException when the task is already done
     */
    public void execute(TaskList tasks, Storage storage, int taskNo, Ui ui) throws DukeException {
        tasks.elementAt(taskNo - 1).markAsDone();
        ui.showMessage("Nice! I've marked this task as done:", tasks.elementAt(taskNo - 1).taskInfo(), "Now you have " + tasks.size() + " tasks in your list.");
        storage.appendTask(tasks.elementAt(taskNo - 1));
    }
}
