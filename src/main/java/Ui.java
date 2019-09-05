/*
 * Copyright © 2019 by Zheng Kaining
 */

import java.util.Scanner;

public class Ui {

    public void showWelcome () {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("____________________________________________________________");
        System.out.println("Hello from\n" + logo);
        System.out.println("What can I do for you?");
        System.out.println("____________________________________________________________");
    }

    public void showLine () {
        System.out.println("____________________________________________________________");
    }

    /*public void showError (String message) {
        System.out.println(message);
    }

    public String readCommand () {
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }*/
}
