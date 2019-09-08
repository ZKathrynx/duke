/*
 * Copyright © 2019 by Zheng Kaining
 */
//package duke.Tasks;

package Tasks;

import General.DukeException;

public abstract class Task {
    private String taskName;
    private boolean isDone;

    public Task (String taskName) {
        this.taskName = taskName;
        this.isDone = false;
    }

    public String getTaskName () {
        return taskName;
    }
    public boolean isDone () {
        return isDone;
    }

    public void markAsDone () throws DukeException {
        if (isDone) {
            throw new DukeException("OOPS! This task has been done already");
        }
        isDone = true;
    }

    public String taskInfo() {
        if (isDone) {
            return "[V] [T] "+taskName;
        } else {
            return "[X] [T] "+taskName;
        }
    }
}


