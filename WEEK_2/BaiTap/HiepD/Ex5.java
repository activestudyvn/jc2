/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hell
 */
public class Ex5 {

    public static void main(String[] args) throws IOException {

        BigFile bigFile = null;
        try {
            bigFile = new BigFile("E:/out.txt");
            System.out.println(bigFile.hasNext());

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            bigFile.close();
        }

    }
}

class BigFile extends FileInputStream {

    private String filePath = null;

    public BigFile(String fileFath) throws FileNotFoundException {
        super(fileFath);
        this.filePath = fileFath;
    }

    public boolean hasNext() throws IOException {
        if (available() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public String next() throws IOException {
        StringBuffer str = new StringBuffer();
        int temp = 0;
        if (hasNext()) {

            while (true) {
                temp = read();
                if (temp == 13 || temp == -1) {
                    break;
                } else {
                    str.append((char) temp);
                }
            }
        }
        return str.toString().trim();
    }

    public void close() throws IOException {
        super.close();
    }
}
