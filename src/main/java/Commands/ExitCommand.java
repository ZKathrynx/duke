/*
 * Copyright © 2019 by Zheng Kaining
 */

package Commands;

import General.Ui;

public class ExitCommand {

    public ExitCommand() {
    }

    public void execute(Ui ui){
        ui.showMessage("Bye. Hope to see you again soon!");
    }
}
