/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import static java.time.temporal.TemporalQueries.offset;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.jws.soap.SOAPBinding.Use;

/**
 *
 * @author Hell
 */
public class Ex1 {

    StringBuffer input;
    Matcher matcher = null;

    public Ex1() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("E:\\JC2\\jc2\\WEEK_3\\BaiTap\\inPut1.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ex1.class.getName()).log(Level.SEVERE, null, ex);
        }
        input = new StringBuffer();
        while (scanner.hasNext()) {
            input.append(scanner.nextLine());
            input.append("\n");
        }
        
        scanner.close();
    }

    public String removeDuplicateSpace(String inputStr) {
        String patternStr = "\\s+";
        String replaceStr = " ";
        matcher = Pattern.compile(patternStr).matcher(inputStr);
        return matcher.replaceAll(replaceStr);
    }

    public void printUpperCase() {
        matcher = Pattern.compile("[A-Z]").matcher(input);

        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }

    public int countCharacter(int type) {
        int count = 0;
        if (type == 1) {
            matcher = Pattern.compile(".").matcher(input);
        } else {
            matcher = Pattern.compile("[a-z]").matcher(input);
        }
        
        while (matcher.find()) {
            count ++;
        }
        return count;
    }

    public void repalceString(String replace) throws FileNotFoundException {
        matcher = Pattern.compile(replace).matcher(input);
        PrintWriter writer = new PrintWriter("E:\\out.txt");
        if (matcher.find()) {
            String temp = input.substring(matcher.start(), matcher.end());
            writer.write(matcher.replaceAll(temp.toUpperCase()));
            writer.close();
        }
    }

    public void insertString(String insert) throws FileNotFoundException {
        input.insert(input.indexOf("$") + 1, insert);
        PrintWriter writer = new PrintWriter("E:\\out.txt");
        writer.write(input.toString());
        writer.close();
        System.out.println(input);
    }

}

class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Ex1 ex1 = new Ex1();

//        ex1.printUpperCase();
        System.out.println(ex1.countCharacter(1));
//        ex1.repalceString("Toi.*yeu.*ha.*noi.*pho");
//       ex1.insertString("o con ga cua toi");
    }
}
