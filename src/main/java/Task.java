/*
 * Copyright © 2019 by Zheng Kaining
 */

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
    private String ddl;

    public Deadline(String taskName, TaskType taskType, String ddl) {
        super(taskName,taskType);
        this.ddl = ddl;
    }

    public String getDdl() {
        return ddl;
    }

    @Override
    public String taskInfo() {
        if (super.isDone()) {
            return "[\u2713] [D] " + super.getTaskName() + " (by: " + ddl;
        } else {
            return "[\u2717] [D] " + super.getTaskName() + " (by: " + ddl;
        }
    }

}

class Event extends Task {
    private String date;

    public Event(String taskName, TaskType taskType, String date) {
        super(taskName,taskType);
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String taskInfo() {
        if (super.isDone()) {
            return "[\u2713] [E] " + super.getTaskName() + " (at: " + date;
        } else {
            return "[\u2717] [E] " + super.getTaskName() + " (at: " + date;
        }
    }

}
