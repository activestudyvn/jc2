/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.hiepdv.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author Hell
 */
public class ReadFile extends Thread {

    private Scanner scanner;
    private List<String> tinNhans;

    public ReadFile(String path,List tinNhans) {
        try {
            scanner = new Scanner(new File(path));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.tinNhans = tinNhans;
    }


    @Override
    public void run() {
        while(scanner.hasNext()) {
            tinNhans.add(scanner.nextLine());
        }
        scanner.close();
    }

}
