/*
 * Copyright © 2019 by Zheng Kaining
 */

package Commands;

import General.Ui;

/**
 * Deal with unknown command
 */
public class UnknownCommand {

    /**
     * Constructor
     */
    public UnknownCommand() {
    }

    /**
     * Deal with unknown command
     * @param ui show message
     * @param command unknown command
     */
    public void execute (Ui ui, String command) {
        ui.showMessage("OOPS! I haven't studied the \""+command+"\" command yet. So sad :(","Probably you can check your spelling :)");
    }
}
