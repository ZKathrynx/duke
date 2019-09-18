/*
 * Copyright © 2019 by Zheng Kaining
 */

package GeneralTest;

import General.DukeException;
import General.Storage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class StorageTest {
    private Storage storage = new Storage("F:\\lenovo\\Desktop\\CS2113T\\Duke\\data.txt","new");

    @Test
    public void testAppendTaskException () {
        try {
            throw new Exception("OOPS! the programme encounters an I/O exception");
        } catch (Exception e) {
            assertEquals("OOPS! the programme encounters an I/O exception",e.getMessage());
        }

    }
}
