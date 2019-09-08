/*
 * Copyright © 2019 by Zheng Kaining
 */
//package duke.Tasks;

package Tasks;

import General.DukeException;

/**
 * Task
 */
public abstract class Task {
    private String taskName;
    private boolean isDone;

    /**
     * Constructor
     * @param taskName
     */
    public Task (String taskName) {
        this.taskName = taskName;
        this.isDone = false;
    }

    /**
     * Get task name
     * @return task name
     */
    public String getTaskName () {
        return taskName;
    }

    /**
     * Tell is done or not
     * @return ture if is done
     */
    public boolean isDone () {
        return isDone;
    }

    /**
     * Mark this task as done
     * @throws DukeException when this task is already done
     */
    public void markAsDone () throws DukeException {
        if (isDone) {
            throw new DukeException("OOPS! This task has been done already");
        }
        isDone = true;
    }

    /**
     * Get task info
     * @return task info
     */
    public String taskInfo() {
        if (isDone) {
            return "[V] [T] "+taskName;
        } else {
            return "[X] [T] "+taskName;
        }
    }
}


