/*
 * Copyright © 2019 by Zheng Kaining
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event extends Task {
    private Date date;

    public Event(String taskName, TaskType taskType, Date date) {
        super(taskName, taskType);
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
