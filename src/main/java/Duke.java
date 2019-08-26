/*
 * National University of Singapore
 * AY19/20 CS2113T Module Project
 * Copyright © 2019 by Zheng Kaining
 */

import java.util.Scanner;

public class Duke {

    public void welcomeScreen () {
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

    public static void main(String[] args) {

        User user = new User();
        new Duke().welcomeScreen();

        while(true) {
            Scanner s = new Scanner(System.in);
            String inputLine = s.nextLine();
            user.parseCommand(inputLine);
            if (user.isBye()) {
                break;
            }
        }
    }
}