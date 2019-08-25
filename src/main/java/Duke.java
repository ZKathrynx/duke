import java.util.Scanner;
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

        UserInstr user = new UserInstr();

        while(true) {
            Scanner s = new Scanner(System.in);
            String command = s.nextLine();
            user.add(command);
            if (user.isBye()) {
                break;
            }
        }
    }
}

class UserInstr {
    private String command;
    private Vector<String> todolist = new Vector<String>();
    private boolean isBye = false;

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
        for (int i = 1; i <= todolist.size(); i++) {
            System.out.println(i+". "+todolist.elementAt(i-1));
        }
        printLine();
    }

    public void add (String command) {
        if(command.equals("bye")) {
            sayBye();
        } else if(command.equals("list")) {
            listOut();
        } else {
            todolist.add(command);
            printLine();
            System.out.println("added: " + command);
            printLine();
        }
    }
}