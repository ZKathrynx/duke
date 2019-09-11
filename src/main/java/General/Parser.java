/*
 * Copyright © 2019 by Zheng Kaining
 */
//package duke;
//import duke.Commands.Command;

package General;

import Commands.*;
import Tasks.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parse command
 */
public class Parser {

    private TaskList toDoList;
    private boolean isBye;
    private Storage save;
    private Ui ui;

    /**
     * Constructor
     * @param toDoList list of tasks
     * @param save save the list
     * @param ui show messages
     */
    public Parser(TaskList toDoList, Storage save, Ui ui) {
        this.toDoList = toDoList;
        this.isBye = false;
        this.save = save;
        this.ui = ui;
    }

    /**
     * Tell whether a command is exit or not
     * @return true when the command is exit
     */
    public boolean isBye () {
        return isBye;
    }

    /**
     * Extract task number from string
     * @param command the string to extract from
     * @return the task number
     * @throws DukeException when there is not appropriate task number
     */
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

    /**
     * Extract task deadline from string
     * @param command the string to extract from
     * @return the deadline
     * @throws DukeException when the deadline is not set
     * @throws ParseException when the deadline is not in correct format
     */
    public Date extractDdl (String command) throws DukeException, ParseException {
        command.trim();
        if(command.indexOf("\\by")==-1||command.indexOf("\\by") + 2 == command.length()-1) {
            throw new DukeException("OOPS! you haven't set the deadline");
        } else {
            //System.out.println(command.substring(command.indexOf("\\by") + 4));
            return new SimpleDateFormat("yyyy.MM.dd HH.mm").parse(command.substring(command.indexOf("\\by") + 4));
        }
    }

    /**
     * Extract task date from string
     * @param command the string to extract from
     * @return the date
     * @throws DukeException when the date is not set
     * @throws ParseException when the date is not in correct format
     */
    public Date extractDate (String command) throws DukeException, ParseException {
        command.trim();
        if(command.indexOf("\\at")==-1||command.indexOf("\\at") + 2 == command.length()-1) {
            throw new DukeException("OOPS! you haven't set the date");
        } else {
            return new SimpleDateFormat("yyyy.MM.dd HH.mm").parse(command.substring(command.indexOf("\\at") + 4));
        }
    }

    /**
     * Extract task name from string
     * @param command the string to extract from
     * @return the task name
     * @throws DukeException when the task name is not set
     */
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

    /**
     * Parse the command
     * @param command the command to parse
     */
    public void parse (String command) {
        String token;
        if (command.indexOf(" ")==-1) {
            token = command;
        } else {
            token = command.substring(0,command.indexOf(" "));
        }

        if (token.equals("bye")) {
            new ExitCommand().execute(ui);
            isBye = true;
        } else if (token.equals("done")) {
            try {
                int tempTaskNo = extractTaskNo(command);
                new DoneCommand().execute(toDoList,save,tempTaskNo,ui);
            } catch (DukeException e){
                ui.showError(e.getMessage());
            }
        } else if (token.equals("list")) {
            new ListCommand().execute(toDoList,ui);
        } else if (token.equals("todo")) {
            try {
                String tempName = extractTaskName(command);
                Task tempTask = new ToDo(tempName);
                new AddCommand().execute(toDoList,save,tempTask,ui);
            } catch (DukeException e){
                ui.showError(e.getMessage());
            }
        } else if (token.equals("deadline")) {
            try {
                String tempName = extractTaskName(command);
                Date tempDdl = extractDdl(command);
                Task tempTask = new Deadline(tempName,tempDdl);
                new AddCommand().execute(toDoList,save,tempTask,ui);
            } catch (DukeException e){
                ui.showError(e.getMessage());
            } catch (ParseException e) {
                ui.showError("OOPS! the format of date should be:yyyy.MM.dd HH.mm");
            }
        } else if (token.equals("event")) {
            try {
                String tempName = extractTaskName(command);
                Date tempDate = extractDate(command);
                Task tempTask = new Event(tempName,tempDate);
                new AddCommand().execute(toDoList,save,tempTask,ui);
            } catch (DukeException e){
                ui.showError(e.getMessage());
            } catch (ParseException e) {
                ui.showError("OOPS! the format of date should be:yyyy.MM.dd HH.mm");
            }
        } else if (token.equals("delete")) {
            try {
                int tempTaskNo = extractTaskNo(command);
                new DeleteCommand().execute(toDoList,tempTaskNo,save,ui);
            } catch (DukeException e){
                ui.showError(e.getMessage());
            }
        } else if (token.equals("find")) {
            try {
                String tempName = extractTaskName(command);
                new FindCommand().execute(toDoList,ui,tempName);
            } catch (DukeException e){
                ui.showError(e.getMessage());
            }
        } else {
            new UnknownCommand().execute(ui,token);
        }
    }

}
