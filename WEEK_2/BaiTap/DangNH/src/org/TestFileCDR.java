package org;

import java.io.IOException;

/**
 * Created by 404NotFound on 11/4/2015.
 */
public class TestFileCDR {
    public static void main(String[] args) throws IOException {
        try (FileCDR fileCDR = new FileCDR(1, 10, 2, "Date", "data/date")) {
            for (int i = 0; i < 10000; i++) {
                fileCDR.write("test string");
            }
        }
    }
}
