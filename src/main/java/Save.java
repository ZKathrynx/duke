/*
 * Copyright © 2019 by Zheng Kaining
 */

import java.io.File;
import java.io.FileWriter;
import java.util.Vector;

public class Save {
    String fileName;
    String filePath;

    //default filepath and name
    Save () {
        this.filePath = "";
        this.fileName = "data.txt";
        File file = new File(this.filePath+this.fileName);
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

    /*
    //customized filepath and name
    Save (String filePath, String fileName) {
        this.filePath = filePath;
        this.fileName = fileName;
    }*/


    public void appendTask (Task task)  {
        try {
            FileWriter fw = new FileWriter(this.filePath + this.fileName, true);
            fw.write(task.taskInfo());
            fw.write(System.getProperty("line.separator"));
            fw.close();
        } catch (Exception e) {
            System.out.println("OOPS! the programme encounters an I/O exception");
        }
    }

    public void updateTask (Vector<Task> toDoList) {
        try {
            FileWriter fw = new FileWriter(this.filePath + this.fileName);
            for (Task task : toDoList) {
                fw.write(task.taskInfo());
                fw.write(System.getProperty("line.separator"));
            }
            fw.close();
        } catch (Exception e) {
            System.out.println("OOPS! the programme encounters an I/O exception");
        }
    }
}
