/*
 * Copyright © 2019 by Zheng Kaining
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Storage {
    String filePath;

    //default filepath and name
    Storage () {
        this.filePath = "F:\\lenovo\\Desktop\\CS2113T\\Duke\\data.txt";
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


    //customized filepath and name
    Storage (String filePath) {
        this.filePath = filePath;
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

    /*public TaskList load () {
        TaskList tasks = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String tempStr = null;
            while(!(tempStr=br.readLine()).equals(null)) {
                Task tempTask;

            }
            br.close();
        } catch (Exception e) {
            System.out.println("OOPS! the programme encounters an I/O exception");
        }
        return tasks;
    }*/
}
