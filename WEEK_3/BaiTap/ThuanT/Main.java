/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Week3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ThuanTD
 */
public class Main {

    public static void main(String[] args) {
        Bai1 b1 = new Bai1();
        b1.isProcess("D:/inPut1.txt");
        b1.IsUpper();
        b1.numberofcharacters();
        b1.writer1();
        b1.deleteSpace();
        b1.insert("o con ga cua toi");
    }
}

class Bai1 {

    String line = null;
    StringBuffer lines = new StringBuffer();
    String str;

    public String isProcess(String fileName) {
        File file = new File(fileName);
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            while ((line = br.readLine()) != null) {
                lines.append(line);
                lines.append(" ");

                // System.out.println(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Bai1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Bai1.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                br.close();
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(Bai1.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return lines.toString();
    }

    // System.out.println(lines);
    public void IsUpper() {
        System.out.print("Ký tự viết hoa: ");
        for (int i = 0; i < lines.length(); i++) {
            if (lines.charAt(i) >= 'A' && lines.charAt(i) <= 'Z') {
                System.out.print(lines.charAt(i) + " ");
            }
        }

        System.out.println("\n===================================================");
    }

    public int numberofcharacters() {
        System.out.println("Số lượng ký tự: " + lines.length());
        int count = 0;
        for (int i = 0; i < lines.length(); i++) {
            if (lines.charAt(i) >= 'a' && lines.charAt(i) <= 'z') {
                count++;

            }

        }

        System.out.println("===================================================");
        System.out.println("Số lượng ký tự thường là: " + count);
        return count;
    }

    public String writer1() {
// ghi ra file outPut1.txt

        str = (lines.replace(50, 70, (lines.substring(50, 70)).toUpperCase())).toString();
        //System.out.println(str);
        FileWriter outPut = null;
        try {
            outPut = new FileWriter("D:/outPut1.txt");
            outPut.write(str);
            outPut.flush();
        } catch (IOException ex) {
            Logger.getLogger(Bai1.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                outPut.close();
            } catch (IOException ex) {
                Logger.getLogger(Bai1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return str;
    }

    public String deleteSpace() {
//        System.out.println(str);
        str = (str.replaceAll("\\s+", " ")).trim();
        // System.out.println(str);
        FileWriter outPut = null;
        try {
            outPut = new FileWriter("D:/outPut1.txt");
            outPut.write(str);
            outPut.flush();
        } catch (IOException ex) {
            Logger.getLogger(Bai1.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                outPut.close();
            } catch (IOException ex) {
                Logger.getLogger(Bai1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return str;
    }

    public void insert(String insert) {
        StringBuilder str2 = new StringBuilder(str);
        FileWriter outPut = null;
        //System.out.println(str2.indexOf("$"));
        str2 = str2.insert(str2.indexOf("$") + 1, insert);
        //        System.out.println(str2);
        try {
            
            outPut = new FileWriter("D:/outPut1.txt");
            outPut.write(str2.toString());
            outPut.flush();
        } catch (IOException ex) {
            Logger.getLogger(Bai1.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                outPut.close();
            } catch (IOException ex) {
                Logger.getLogger(Bai1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
}
