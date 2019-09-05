/*
 * Copyright © 2019 by Zheng Kaining
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private TaskList toDoList;
    private boolean isBye;
    private Storage save;

    Parser (TaskList toDoList, Storage save) {
        this.toDoList = toDoList;
        this.isBye = false;
        this.save = save;
    }

    public boolean isBye () {
        return isBye;
    }

    public int extractTaskNo (String command) throws DukeException {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(command);
        if(!m.find()) {
            throw new DukeException("OOPS! the command needs a number as parameter");
        } else {
            int ans = Integer.parseInt(m.group());
            if (ans > toDoList.size()) {
                throw new DukeException("OOPS! the current maximum number of tasks is "+ toDoList.size());
            } else if (toDoList.elementAt(ans-1).isDone()) {
                throw new DukeException("OOPS! you have already finished this task");
            }
            return ans;
        }
    }

    public Date extractDdl (String command) throws DukeException, ParseException {
        command.trim();
        if(command.indexOf("\\by")==-1||command.indexOf("\\by") + 2 == command.length()-1) {
            throw new DukeException("OOPS! you haven't set the deadline");
        } else {
            return new SimpleDateFormat("yyyy.mm.dd hh.mm").parse(command.substring(command.indexOf("\\by") + 4));
        }
    }

    public Date extractDate (String command) throws DukeException, ParseException {
        command.trim();
        if(command.indexOf("\\at")==-1||command.indexOf("\\at") + 2 == command.length()-1) {
            throw new DukeException("OOPS! you haven't set the date");
        } else {
            return new SimpleDateFormat("yyyy.mm.dd hh.mm").parse(command.substring(command.indexOf("\\at") + 4));
        }
    }

    public String extractTaskName (String command) throws DukeException{
        if (command.indexOf(" ")==-1) {
            throw new DukeException("OOPS! the task name cannot be empty");
        } else {
            if (!command.contains("\\by")&&!command.contains("\\at")) {
                String temp = command.substring(command.indexOf(" "));
                if (temp.trim().length()==0) {
                    throw new DukeException("OOPS! the task name cannot be empty");
                } else {
                    return temp;
                }
            } else {
                String temp = command.substring(command.indexOf(" "),command.indexOf("\\"));
                if (temp.trim().length()==0) {
                    throw new DukeException("OOPS! the task name cannot be empty");
                } else {
                    return temp;
                }
            }
        }
    }

    public void parse (String command) {
        if (command.matches("bye(.*)")) {
            new Command().sayBye();
            isBye = true;
        } else if (command.matches("done(.*)")) {
            try {
                int tempTaskNo = extractTaskNo(command);
                new Command().markAsDone(toDoList,tempTaskNo);
                save.updateTask(toDoList);
            } catch (DukeException e){
                e.printMessage();
            }
        } else if (command.matches("list(.*)")) {
            new Command().listOut(toDoList);
        } else if (command.matches("todo(.*)")) {
            try {
                String tempName = extractTaskName(command);
                new Command().addToDo(toDoList,tempName);
                save.appendTask(toDoList.elementAt(toDoList.size()-1));
            } catch (DukeException e){
                e.printMessage();
            }
        } else if (command.matches("deadline(.*)")) {
            try {
                String tempName = extractTaskName(command);
                Date tempDdl = extractDdl(command);
                new Command().addDeadline(toDoList,tempName,tempDdl);
                save.appendTask(toDoList.elementAt(toDoList.size()-1));
            } catch (DukeException e){
                e.printMessage();
            } catch (ParseException e) {
                System.out.println("OOPS! the format of date should be:yyyy.mm.dd hh.mm");
            }
        } else if (command.matches("event(.*)")) {
            try {
                String tempName = extractTaskName(command);
                Date tempDate = extractDate(command);
                new Command().addEvent(toDoList,tempName,tempDate);
                save.appendTask(toDoList.elementAt(toDoList.size()-1));
            } catch (DukeException e){
                e.printMessage();
            } catch (ParseException e) {
                System.out.println("OOPS! the format of date should be:yyyy.mm.dd hh.mm");
            }
        } else if (command.matches("help(.*)")) {
            new Command().showHelp();
        } else if (command.matches("delete(.*)")) {
            try {
                int tempTaskNo = extractTaskNo(command);
                new Command().delete(toDoList,tempTaskNo);
                save.updateTask(toDoList);
            } catch (DukeException e){
                e.printMessage();
            }
        } else if (command.matches("find(.*)")) {
            try {
                String tempName = extractTaskName(command);
                new Command().find(toDoList,tempName);
            } catch (DukeException e){
                e.printMessage();
            }
        } else {
            if (command.indexOf(" ")==-1) {
                new Command().unknownCommand(command);
            } else {
                new Command().unknownCommand(command.substring(0,command.indexOf(" ")));
            }
        }
    }

}
