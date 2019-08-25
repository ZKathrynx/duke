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

        /*Scanner s = new Scanner(System.in);
        String command = s.nextLine();
        UserInstr user = new UserInstr(command);
        while(!user.sayBye()) {
            user.echo();
        }*/
    }
}

class UserInstr {
    private String instr;
    private boolean isBye = false;

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
        System.out.println(instr);
    }
}