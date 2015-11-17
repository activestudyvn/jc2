package org;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by 404NotFound on 11/4/2015.
 */
public class BigFile implements AutoCloseable,Closeable {
    Scanner sc;
    private File file;
    private FileInputStream fis;

    public BigFile(String filePath) throws FileNotFoundException {
        file = new File(filePath);
        fis = new FileInputStream(file);
        sc = new Scanner(fis);
    }

    public boolean hasNext() {
        return sc.hasNextLine();
    }

    public String next() {
        return sc.nextLine();
    }
    @Override
    public void close() {
        sc.close();
    }
}
