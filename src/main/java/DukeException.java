/*
 * Copyright © 2019 by Zheng Kaining
 */

public class DukeException extends Exception {
    public DukeException(String message) {
        super(message);
    }

    public void printMessage() {
        System.out.println(getMessage());
    }

}
