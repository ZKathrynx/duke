/*
 * Copyright © 2019 by Zheng Kaining
 */

enum TaskType {
    ToDo,Deadline,Event;
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

    //Others
    public void printTask() {
        if (isDone) {
            System.out.print("[\u2713]");
        } else {
            System.out.print("[\u2717]");
        }
        System.out.println("[T] "+taskName);
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
    public void printTask() {
        if (super.isDone()) {
            System.out.print("[\u2713]");
        } else {
            System.out.print("[\u2717]");
        }
        System.out.println("[D] "+super.getTaskName()+" (by: "+ddl+")");
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
    public void printTask() {
        if (super.isDone()) {
            System.out.print("[\u2713]");
        } else {
            System.out.print("[\u2717]");
        }
        System.out.println("[E] "+super.getTaskName()+" (by: "+date+")");
    }
}
