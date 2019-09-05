/*
 * National University of Singapore
 * AY19/20 CS2113T Module Project
 * Copyright © 2019 by Zheng Kaining
 */

import java.util.Scanner;

public class Duke {

    private Storage storage;
    private TaskList tasks = new TaskList();
    private Ui ui;

    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        /*try {
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }*/
    }

    public void run() {
        ui.showWelcome();
        Scanner s = new Scanner(System.in);
        while(s.hasNextLine()) {
            ui.showLine();
            String inputLine = s.nextLine();
            Parser parser = new Parser(tasks,storage);
            parser.parse(inputLine);
            ui.showLine();
            if (parser.isBye()) {
                break;
            }
        }
        /*boolean isBye = false;
        while (!isBye) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isBye = c.isBye();
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }*/
    }

    public static void main(String[] args) {
        new Duke("F:\\lenovo\\Desktop\\CS2113T\\Duke\\data.txt").run();
    }



    /*public static void main(String[] args) {
        User user = new User();
        new Duke().welcomeScreen();

        Scanner s = new Scanner(System.in);
        while(s.hasNextLine()) {
            String inputLine = s.nextLine();
            user.parseCommand(inputLine);
            if (user.isBye()) {
                break;
            }
        }
    }*/
}