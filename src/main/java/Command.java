/*
 * Copyright © 2019 by Zheng Kaining
 */

import java.util.Vector;

public class Command {

    public void printLine () {
        System.out.println("____________________________________________________________");
    }

    public void addToDo (Vector<Task> toDoList, String taskName) {
        Task task = new Task(taskName,TaskType.ToDo);
        toDoList.add(task);
        printLine();
        System.out.println("Got it. I've added this task:");
        task.printTask();
        System.out.println("Now you have "+toDoList.size()+" tasks in your list.");
        printLine();
    }

    public void addDeadline (Vector<Task> toDoList, String taskName, String ddl) {
        Task task = new Deadline(taskName,TaskType.Deadline,ddl);
        toDoList.add(task);
        printLine();
        System.out.println("Got it. I've added this task:");
        task.printTask();
        System.out.println("Now you have "+toDoList.size()+" tasks in your list.");
        printLine();
    }

    public void addEvent (Vector<Task> toDoList, String taskName, String date) {
        Task task = new Event(taskName,TaskType.Deadline,date);
        toDoList.add(task);
        printLine();
        System.out.println("Got it. I've added this task:");
        task.printTask();
        System.out.println("Now you have "+toDoList.size()+" tasks in your list.");
        printLine();
    }

    public void listOut (Vector<Task> toDoList) {
        printLine();
        System.out.println("Here are the tasks in your list:");
        for (int i = 1; i <= toDoList.size(); i++) {
            System.out.print(i+".");
            toDoList.elementAt(i-1).printTask();
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
        System.out.println("Or just wait for my lazy programmer to add this new feature haha :P");
        printLine();
    }

    public void showHelp () {
        printLine();
        System.out.println("a new feature waiting to be developed...");
        printLine();
    }
}
