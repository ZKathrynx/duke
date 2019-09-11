/*
 * Copyright © 2019 by Zheng Kaining
 */
package Tasks;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Deadline
 */
public class Deadline extends Task {
    private Date ddl;

    /**
     * Constructor
     * @param taskName
     * @param ddl
     */
    public Deadline(String taskName, Date ddl) {
        super(taskName);
        this.ddl = ddl;
    }

    /**
     * Get deadline
     * @return deadline
     */
    public Date getDdl() {
        return ddl;
    }

    /**
     * Get task info
     * @return task info
     */
    @Override
    public String taskInfo() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH.mm");
        if (super.isDone()) {
            return "[V] [D] " + super.getTaskName() + " (by: " + dateFormat.format(ddl);
        } else {
            return "[X] [D] " + super.getTaskName() + " (by: " + dateFormat.format(ddl);
        }
    }

}
