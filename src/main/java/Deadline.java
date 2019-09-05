/*
 * Copyright © 2019 by Zheng Kaining
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deadline extends Task {
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
