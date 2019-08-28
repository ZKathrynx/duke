/*
 * Copyright © 2019 by Zheng Kaining
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

enum TaskType {
    T,D,E;
}

class Task {
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

class Deadline extends Task {
    private Date ddl;

    public Deadline(String taskName, TaskType taskType, Date ddl) {
        super(taskName,taskType);
        this.ddl = ddl;
    }

    public Date getDdl() {
        return ddl;
    }

    @Override
    public String taskInfo() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy.mm.dd hh.mm");
        if (super.isDone()) {
            return "[\u2713] [D] " + super.getTaskName() + " (by: " + dateFormat.format(ddl);
        } else {
            return "[\u2717] [D] " + super.getTaskName() + " (by: " + dateFormat.format(ddl);
        }
    }

}

class Event extends Task {
    private Date date;

    public Event(String taskName, TaskType taskType, Date date) {
        super(taskName,taskType);
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String taskInfo() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy.mm.dd hh.mm");
        if (super.isDone()) {
            return "[\u2713] [E] " + super.getTaskName() + " (at: " + dateFormat.format(date);
        } else {
            return "[\u2717] [E] " + super.getTaskName() + " (at: " + dateFormat.format(date);
        }
    }

}
