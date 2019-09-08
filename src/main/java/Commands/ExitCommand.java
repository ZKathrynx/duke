/*
 * Copyright © 2019 by Zheng Kaining
 */

package Commands;

import General.Ui;

/**
 * Exit from app
 */
public class ExitCommand {

    /**
     * Constructor
     */
    public ExitCommand() {
    }

    /**
     * Exit from app
     * @param ui print message
     */
    public void execute(Ui ui){
        ui.showMessage("Bye. Hope to see you again soon!");
    }
}
