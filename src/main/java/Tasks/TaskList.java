/*
 * Copyright © 2019 by Zheng Kaining
 */
package Tasks;

import java.util.Vector;

public class TaskList {
    private Vector<Task> tasks = new Vector<Task>();

    //Constructor
    public TaskList() {
    }
    public TaskList (Vector<Task> tasks) {
        this.tasks = tasks;
    }


    public void add(Task task) {
        tasks.add(task);
    }

    public void remove(int index) {
        tasks.remove(index);
    }

    public int size() {
        return tasks.size();
    }

    public Task elementAt(int index) {
        return tasks.elementAt(index);
    }
}
