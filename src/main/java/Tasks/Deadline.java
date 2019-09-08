/*
 * Copyright © 2019 by Zheng Kaining
 */
package Tasks;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deadline extends Task {
    private Date ddl;

    public Deadline(String taskName, Date ddl) {
        super(taskName);
        this.ddl = ddl;
    }

    public Date getDdl() {
        return ddl;
    }

    @Override
    public String taskInfo() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy.mm.dd hh.mm");
        if (super.isDone()) {
            return "[V] [D] " + super.getTaskName() + " (by: " + dateFormat.format(ddl);
        } else {
            return "[X] [D] " + super.getTaskName() + " (by: " + dateFormat.format(ddl);
        }
    }

}
