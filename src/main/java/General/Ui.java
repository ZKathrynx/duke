/*
 * Copyright © 2019 by Zheng Kaining
 */
package General;

/**
 * Show messages
 */
public class Ui {

    /**
     * Welcome screen
     */
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

    /**
     * Line
     */
    public void showLine () {
        System.out.println("____________________________________________________________");
    }

    /**
     * Show error message
     * @param message error message
     */
    public void showError (String message) {
        System.out.println(message);
    }

    /**
     * Show messages
     * @param messages messages
     */
    public void showMessage (String... messages) {
        for (String message : messages) {
            System.out.println(message);
        }
    }

}
