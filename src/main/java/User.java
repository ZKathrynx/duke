/*
 * Copyright © 2019 by Zheng Kaining
 */

import java.util.Vector;

public class  User {
    private Vector<Task> toDoList = new Vector<Task>();
    private boolean isBye;

    public User () {
        this.isBye = false;
    }

    public boolean isBye () {
        return isBye;
    }

    public String extractDdl (String command) {
        return command.substring(command.indexOf("\\by")+4);
    }

    public String extractDate (String command) {
        return command.substring(command.indexOf("\\at")+4);
    }

    public String extractTaskName (String command) {
        if (!command.contains("\\by")&&!command.contains("\\at")) {
            return command.substring(command.indexOf(" "));
        } else {
            return command.substring(command.indexOf(" "),command.indexOf("\\"));
        }
    }

    public void parseCommand (String command) {
        if (command.matches("bye(.*)")) {
            new Command().sayBye();
            isBye = true;
        } else if (command.matches("done(.*)")) {
            new Command().markAsDone(toDoList,Integer.parseInt(command.substring(5)));
        } else if (command.matches("list(.*)")) {
            new Command().listOut(toDoList);
        } else if (command.matches("todo(.*)")) {
            new Command().addToDo(toDoList,extractTaskName(command));
        } else if (command.matches("deadline(.*)")) {
            new Command().addDeadline(toDoList,extractTaskName(command),extractDdl(command));
        } else if (command.matches("event(.*)")) {
            new Command().addEvent(toDoList,extractTaskName(command),extractDate(command));
        } else if (command.matches("help(.*)")) {
            new Command().showHelp();
        } else {
            new Command().unknownCommand(command.substring(0,command.indexOf(" ")));
        }
    }
}
