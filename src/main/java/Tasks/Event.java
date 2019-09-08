/*
 * Copyright © 2019 by Zheng Kaining
 */
package Tasks;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Event
 */
public class Event extends Task {
    private Date date;

    /**
     * Constructor
     * @param taskName
     * @param date
     */
    public Event(String taskName, Date date) {
        super(taskName);
        this.date = date;
    }

    /**
     * Get date
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Get task info
     * @return task info
     */
    @Override
    public String taskInfo() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy.mm.dd hh.mm");
        if (super.isDone()) {
            return "[V] [E] " + super.getTaskName() + " (at: " + dateFormat.format(date);
        } else {
            return "[X] [E] " + super.getTaskName() + " (at: " + dateFormat.format(date);
        }
    }
}
