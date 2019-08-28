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

    public int extractTaskNo (String command) throws DukeException {
        if (command.length()<5) {
            throw new DukeException("OOPS! the command needs a number as parameter");
        } else {
            try {
                int ans = Integer.parseInt(command.substring(5));
            } catch (Exception e) {
                throw new DukeException("OOPS! your input is not an integer");
            }
            int ans = Integer.parseInt(command.substring(5));
            if (ans > toDoList.size()) {
                throw new DukeException("OOPS! the current maximum number of tasks is "+ toDoList.size());
            } else if (toDoList.elementAt(ans-1).isDone()) {
                throw new DukeException("OOPS! you have already finished this task");
            }
            return ans;
        }
    }

    public String extractDdl (String command) throws DukeException{
        if(command.indexOf("\\by")==-1) {
            throw new DukeException("OOPS! you haven't set the deadline");
        } else {
            return command.substring(command.indexOf("\\by") + 4);
        }
    }

    public String extractDate (String command) throws DukeException{
        if(command.indexOf("\\at")==-1) {
            throw new DukeException("OOPS! you haven't set the date");
        } else {
            return command.substring(command.indexOf("\\by") + 4);
        }
    }

    public String extractTaskName (String command) throws DukeException{
        if (command.indexOf(" ")==-1) {
            throw new DukeException("OOPS! the task name cannot be empty");
        } else {
            if (!command.contains("\\by")&&!command.contains("\\at")) {
                return command.substring(command.indexOf(" "));
            } else {
                return command.substring(command.indexOf(" "),command.indexOf("\\"));
            }
        }
    }

    public void parseCommand (String command) {
        if (command.matches("bye(.*)")) {
            new Command().sayBye();
            isBye = true;
        } else if (command.matches("done(.*)")) {
            try {
                int tempTaskNo = extractTaskNo(command);
                new Command().markAsDone(toDoList,tempTaskNo);
            } catch (DukeException e){
                e.printMessage();
            }
        } else if (command.matches("list(.*)")) {
            new Command().listOut(toDoList);
        } else if (command.matches("todo(.*)")) {
            try {
                String tempName = extractTaskName(command);
                new Command().addToDo(toDoList,tempName);
            } catch (DukeException e){
                e.printMessage();
            }
        } else if (command.matches("deadline(.*)")) {
            try {
                String tempName = extractTaskName(command);
                String tempDdl = extractDdl(command);
                new Command().addDeadline(toDoList,tempName,tempDdl);
            } catch (DukeException e){
                e.printMessage();
            }
        } else if (command.matches("event(.*)")) {
            try {
                String tempName = extractTaskName(command);
                String tempDate = extractDate(command);
                new Command().addDeadline(toDoList,tempName,tempDate);
            } catch (DukeException e){
                e.printMessage();
            }
        } else if (command.matches("help(.*)")) {
            new Command().showHelp();
        } else {
            if (command.indexOf(" ")==-1) {
                new Command().unknownCommand(command);
            } else {
                new Command().unknownCommand(command.substring(0,command.indexOf(" ")));
            }
        }
    }
}
