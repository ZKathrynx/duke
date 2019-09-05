/*
 * Copyright © 2019 by Zheng Kaining
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

enum TaskType {
    T,D,E;
}

public abstract class Task {
    private String taskName;
    private boolean isDone;
    private TaskType taskType;

    //Constructors
    public Task() {
    }

    public Task (String taskName, TaskType taskType) {
        this.taskName = taskName;
        this.isDone = false;
        this.taskType = taskType;
    }

    //Getters
    public String getTaskName () {
        return taskName;
    }
    public boolean isDone () {
        return isDone;
    }
    public TaskType getTaskType() {
        return taskType;
    }

    //Setters
    public void markAsDone () {
        isDone = true;
    }

    public String taskInfo() {
        if (isDone) {
            return "[\u2713] [T] "+taskName;
        } else {
            return "[\u2717] [T] "+taskName;
        }
    }
}


