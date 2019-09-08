/*
 * Copyright © 2019 by Zheng Kaining
 */

package Commands;

import General.Ui;

public class UnknownCommand {
    public UnknownCommand() {
    }

    public void execute (Ui ui, String command) {
        ui.showMessage("OOPS! I haven't studied the \""+command+"\" command yet. So sad :(","Probably you can check your spelling :)");
    }
}
