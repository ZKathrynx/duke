/*
 * Copyright © 2019 by Zheng Kaining
 */
package Tasks;

import java.util.Vector;

/**
 * Task list
 */
public class TaskList {
    private Vector<Task> tasks = new Vector<Task>();

    /**
     * Constructor
     */
    public TaskList() {
    }

    /**
     * Constructor
     * @param tasks an existing list of tasks
     */
    public TaskList (Vector<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Add task to list
     * @param task the task to add
     */
    public void add(Task task) {
        tasks.add(task);
    }

    /**
     * Remove task from list
     * @param index the task to remove
     */
    public void remove(int index) {
        tasks.remove(index);
    }

    /**
     * Get size of list
     * @return size of list
     */
    public int size() {
        return tasks.size();
    }

    /**
     * Random access
     * @param index index of task to access
     * @return the task
     */
    public Task elementAt(int index) {
        return tasks.elementAt(index);
    }
}
