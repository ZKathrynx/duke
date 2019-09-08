/*
 * Copyright © 2019 by Zheng Kaining
 */

package duke;

import General.*;
import Tasks.*;
import java.util.Scanner;

/**
 * Main class for Duke app
 * @author Zheng Kaining
 */
public class Duke {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    /**
     * Constructor
     * @param filePath path to save ToDoList passed by the user
     * @param mode new a file or open existing file
     */
    public Duke(String filePath, String mode) {
        ui = new Ui();
        storage = new Storage(filePath,mode);
        if (mode.equals("new")) {
            tasks = new TaskList();
        } else if (mode.equals("open")) {
            tasks = new TaskList(storage.load());
        } else{
            ui.showError("OOPS! The mode can only be \"new\" or \"open\"");
        }
    }

    /**
     * Run the Duke app
     */
    public void run() {
        ui.showWelcome();
        Scanner s = new Scanner(System.in);
        while(s.hasNextLine()) {
            ui.showLine();
            String inputLine = s.nextLine();
            Parser parser = new Parser(tasks,storage,ui);
            parser.parse(inputLine);
            ui.showLine();
            if (parser.isBye()) {
                break;
            }
        }
    }

    /**
     * Main method for Duke app
     * @param args command line argument
     */
    public static void main(String[] args) {
        new Duke("F:\\lenovo\\Desktop\\CS2113T\\Duke\\data.txt","new").run();
    }
}