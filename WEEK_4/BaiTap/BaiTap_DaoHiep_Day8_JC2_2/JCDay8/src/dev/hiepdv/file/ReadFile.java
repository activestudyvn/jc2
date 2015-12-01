/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.hiepdv.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Hell
 */
public abstract class ReadFile {

    protected Scanner scanner = null;
    protected String line;

    protected void setReader(String filepath) throws FileNotFoundException {
        scanner = new Scanner(new FileReader(filepath));
    }

    protected void readLine() throws IOException {
        line = scanner.nextLine();
    }
    
    public boolean hasNext() {
        return scanner.hasNext();
    }

    public abstract Object getNext();

}
