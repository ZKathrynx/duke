import java.util.Scanner;

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

        while(true) {
            Scanner s = new Scanner(System.in);
            String command = s.nextLine();
            UserInstr user = new UserInstr(command);
            user.echo();
            if (user.sayBye()) {
                break;
            }
        }
    }
}

class UserInstr {
    private String instr;
    private boolean isBye;

    UserInstr (String instr) {
        this.instr = instr;
    }

    public boolean sayBye () {
        return isBye;
    }
    public void printLine () {
        System.out.println("____________________________________________________________");
    }

    public void echo () {
        if(instr.equals("bye")) {
            printLine();
            System.out.println("Bye. Hope to see you again soon!");
            printLine();
            isBye = true;
        } else {
            printLine();
            System.out.println(instr);
            printLine();
            isBye = false;
        }

    }
}