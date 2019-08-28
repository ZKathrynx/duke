/*
 * Copyright © 2019 by Zheng Kaining
 */

import java.util.Date;
import java.util.Vector;

public class Command {

    public void printLine () {
        System.out.println("____________________________________________________________");
    }

    public void addToDo (Vector<Task> toDoList, String taskName) {
        Task task = new Task(taskName,TaskType.T);
        toDoList.add(task);
        printLine();
        System.out.println("Got it. I've added this task:");
        System.out.println(task.taskInfo());
        System.out.println("Now you have "+toDoList.size()+" tasks in your list.");
        printLine();
    }

    public void addDeadline (Vector<Task> toDoList, String taskName, Date ddl) {
        Task task = new Deadline(taskName,TaskType.D,ddl);
        toDoList.add(task);
        printLine();
        System.out.println("Got it. I've added this task:");
        System.out.println(task.taskInfo());
        System.out.println("Now you have "+toDoList.size()+" tasks in your list.");
        printLine();
    }

    public void addEvent (Vector<Task> toDoList, String taskName, Date date) {
        Task task = new Event(taskName,TaskType.E,date);
        toDoList.add(task);
        printLine();
        System.out.println("Got it. I've added this task:");
        System.out.println(task.taskInfo());
        System.out.println("Now you have "+toDoList.size()+" tasks in your list.");
        printLine();
    }

    public void listOut (Vector<Task> toDoList) {
        printLine();
        System.out.println("Here are the tasks in your list:");
        for (int i = 1; i <= toDoList.size(); i++) {
            System.out.print(i+".");
            System.out.println(toDoList.elementAt(i-1).taskInfo());
        }
        printLine();
    }

    public void markAsDone (Vector<Task> toDoList, int i) {
        toDoList.elementAt(i-1).markAsDone();
        printLine();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("[\u2713] "+toDoList.elementAt(i-1).getTaskName());
        printLine();
    }

    public void sayBye () {
        printLine();
        System.out.println("Bye. Hope to see you again soon!");
        printLine();
    }

    public void unknownCommand (String command) {
        printLine();
        System.out.println("OOPS! I haven't studied the \""+command+"\" command yet. So sad :(");
        System.out.println("Probably you can check your spelling or key in \"help\" to see what commands I know! :)");
        printLine();
    }

    public void showHelp () {
        printLine();
        System.out.println("a new feature waiting to be developed... :P");
        printLine();
    }
}
