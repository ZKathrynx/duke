/*
 * Copyright © 2019 by Zheng Kaining
 */

import java.util.Date;

public class Command {

    public void addToDo (TaskList toDoList, String taskName) {
        Task task = new ToDo(taskName,TaskType.T);
        toDoList.add(task);
        System.out.println("Got it. I've added this task:");
        System.out.println(task.taskInfo());
        System.out.println("Now you have "+toDoList.size()+" tasks in your list.");
    }

    public void addDeadline (TaskList toDoList, String taskName, Date ddl) {
        Task task = new Deadline(taskName,TaskType.D,ddl);
        toDoList.add(task);
        System.out.println("Got it. I've added this task:");
        System.out.println(task.taskInfo());
        System.out.println("Now you have "+toDoList.size()+" tasks in your list.");
    }

    public void addEvent (TaskList toDoList, String taskName, Date date) {
        Task task = new Event(taskName,TaskType.E,date);
        toDoList.add(task);
        System.out.println("Got it. I've added this task:");
        System.out.println(task.taskInfo());
        System.out.println("Now you have "+toDoList.size()+" tasks in your list.");
    }

    public void listOut (TaskList toDoList) {
        System.out.println("Here are the tasks in your list:");
        for (int i = 1; i <= toDoList.size(); i++) {
            System.out.print(i+".");
            System.out.println(toDoList.elementAt(i-1).taskInfo());
        }
    }

    public void markAsDone (TaskList toDoList, int i) {
        toDoList.elementAt(i-1).markAsDone();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(toDoList.elementAt(i-1).taskInfo());
        System.out.println("Now you have "+toDoList.size()+" tasks in your list.");
    }

    public void find (TaskList toDoList, String key) {
        System.out.println("Here are the matching tasks in your list:");
        int count = 1;
        for (int i = 0; i < toDoList.size(); i ++) {
            if (toDoList.elementAt(i).getTaskName().contains(key)) {
                System.out.print(count+".");
                System.out.println(toDoList.elementAt(i).taskInfo());
                count ++;
            }
        }
    }

    public void delete (TaskList toDoList, int i) {
        String temp = toDoList.elementAt(i-1).taskInfo();
        toDoList.remove(i-1);
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(temp);
        System.out.println("Now you have "+toDoList.size()+" tasks in your list.");
    }

    public void sayBye () {
        System.out.println("Bye. Hope to see you again soon!");
    }

    public void unknownCommand (String command) {
        System.out.println("OOPS! I haven't studied the \""+command+"\" command yet. So sad :(");
        System.out.println("Probably you can check your spelling or key in \"help\" to see what commands I know! :)");
    }

    public void showHelp () {
        System.out.println("a new feature waiting to be developed... :P");
    }
}
