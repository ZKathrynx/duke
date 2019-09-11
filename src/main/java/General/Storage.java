/*
 * Copyright © 2019 by Zheng Kaining
 */

package General;

import Tasks.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

/**
 * Save the list to file
 */
public class Storage {
    String filePath;

    /**
     * Constructor
     * @param filePath the path to save file
     * @param mode new a file or open existing one
     */
    public Storage(String filePath, String mode) {
        this.filePath = filePath;
        if (mode.equals("new")) {
            File file = new File(this.filePath);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Exception e) {
                    System.out.println("OOPS! the programme encounters an I/O exception");
                }
            }
            try {
                FileWriter fw = new FileWriter(file);
                fw.write("Your task list:");
                fw.write(System.getProperty("line.separator"));
                fw.close();
            } catch (Exception e) {
                System.out.println("OOPS! the programme encounters an I/O exception");
            }
        }
    }

    /**
     * Append new task to file
     * @param task the task to append
     */
    public void appendTask (Task task)  {
        try {
            FileWriter fw = new FileWriter(this.filePath, true);
            fw.write(task.taskInfo());
            fw.write(System.getProperty("line.separator"));
            fw.close();
        } catch (Exception e) {
            System.out.println("OOPS! the programme encounters an I/O exception");
        }
    }

    /**
     * Update whole file
     * @param toDoList the new ToDoList
     */
    public void updateTask (TaskList toDoList) {
        try {
            FileWriter fw = new FileWriter(this.filePath);
            for (int i = 0; i < toDoList.size(); i ++) {
                Task task = toDoList.elementAt(i);
                fw.write(task.taskInfo());
                fw.write(System.getProperty("line.separator"));
            }
            fw.close();
        } catch (Exception e) {
            System.out.println("OOPS! the programme encounters an I/O exception");
        }
    }

    /**
     * Load from file
     * @return a vector of tasks from existing file
     */
    public Vector<Task> load () {
        Vector<Task> tasks = null;
        Task tempTask;
        String line;
        Boolean isDone;
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.filePath));
            line = br.readLine();
            line = br.readLine();
            while(!line.equals(null)) {
                if(line.charAt(1)=='V') {
                    isDone = true;
                } else {
                    isDone = false;
                }
                if(line.charAt(4)=='T') {
                    String tempName = line.substring(6);
                    tempTask = new ToDo(tempName);
                    if (isDone) {
                        tempTask.markAsDone();
                    }
                    tasks.add(tempTask);
                } else if (line.charAt(4)=='E') {
                    String tempName = line.substring(6,line.indexOf("(at"));
                    Date date = new SimpleDateFormat("yyyy.MM.dd HH.mm").parse(line.substring(line.indexOf("(at") + 4));
                    tempTask = new Event(tempName,date);
                    if (isDone) {
                        tempTask.markAsDone();
                    }
                    tasks.add(tempTask);
                } else {
                    String tempName = line.substring(6,line.indexOf("(by"));
                    Date date = new SimpleDateFormat("yyyy.MM.dd HH.mm").parse(line.substring(line.indexOf("(by") + 4));
                    tempTask = new Deadline(tempName,date);
                    if (isDone) {
                        tempTask.markAsDone();
                    }
                    tasks.add(tempTask);
                }

            }
            br.close();
        } catch (Exception e) {
            System.out.println("OOPS! the programme encounters an I/O exception");
        }
        return tasks;
    }
}
