import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("____________________________________________________________");
        System.out.println("Hello from\n" + logo);
        System.out.println("What can I do for you?");
        System.out.println("____________________________________________________________");

        User user = new User();

        while(true) {
            Scanner s = new Scanner(System.in);
            String inputline = s.nextLine();
            StringTokenizer st = new StringTokenizer(inputline);
            String command = st.nextToken();
            switch (command) {
                case "bye":
                    user.sayBye();
                    break;
                case "list":
                    user.listOut();
                    break;
                case "done":
                    int i = Integer.parseInt(st.nextToken());
                    user.markAsDone(i);
                    break;
                default:
                    user.add(inputline);
            }
            if (user.isBye()) {
                break;
            }
        }
    }
}

class User {
    private String command;
    private Vector<Task> todolist = new Vector<Task>();
    private boolean isBye;

    User () {
        this.isBye = false;
    }

    public void printLine () {
        System.out.println("____________________________________________________________");
    }

    public boolean isBye () {
        return isBye;
    }

    public void sayBye () {
        printLine();
        System.out.println("Bye. Hope to see you again soon!");
        printLine();
        isBye = true;
    }

    public void listOut () {
        printLine();
        System.out.println("Here are the tasks in your list:");
        for (int i = 1; i <= todolist.size(); i++) {
            System.out.print(i+".");
            if (todolist.elementAt(i-1).isDone()) {
                System.out.print("[✓] ");
            } else {
                System.out.print("[✗] ");
            }
            System.out.println(todolist.elementAt(i-1).getTaskName());
        }
        printLine();
    }

    public void markAsDone (int i) {
        todolist.elementAt(i-1).markAsDone();
        printLine();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("[✓] "+todolist.elementAt(i-1).getTaskName());
        printLine();
    }

    public void add (String command) {
        Task t = new Task (command);
        todolist.add(t);
        printLine();
        System.out.println("added: " + command);
        printLine();
    }
}

class Task {
    private String taskName;
    private boolean isDone;

    Task (String taskName) {
        this.taskName = taskName;
        this.isDone = false;
    }

    public boolean isDone () {
        return isDone;
    }

    public String getTaskName () {
        return taskName;
    }

    public void markAsDone () {
        isDone = true;
    }
}