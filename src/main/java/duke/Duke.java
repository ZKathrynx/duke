/*
 * Copyright © 2019 by Zheng Kaining
 */

package duke;

import General.*;
import Tasks.*;
import java.util.Scanner;

public class Duke {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

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

    public static void main(String[] args) {
        new Duke("F:\\lenovo\\Desktop\\CS2113T\\Duke\\data.txt","new").run();
    }
}