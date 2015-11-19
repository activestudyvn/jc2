/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baiTap_day8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Date;
import static javacore.Bai2.isCheck;
import sun.applet.Main;

/**
 *
 * @author Dinh Trong Tuyen
 */
public class Ex1 {

    File in = new File("E:/input/message.txt");
    Date date;

    public void inPut() throws FileNotFoundException, IOException {

        String s;
        try {
            BufferedReader br = new BufferedReader(new FileReader(in));
            while ((s = br.readLine()) != null) {
                String[] a = s.split("[| )]");
                System.out.println(a[3]);
            }

        } catch (Exception ex) {
        }
    }

    public void outPut() {
        String s;
        try {
            BufferedReader br = new BufferedReader(new FileReader(in));
            File outputFile = new File("E:/output/102.txt");
            BufferedWriter out = new BufferedWriter(new FileWriter(outputFile));
            while ((s = br.readLine()) != null) {
                String[] a = s.split("[| )]");
                for (int i = 0; i < a[1].length(); i++) {
//                    if(a[1]<date){
//                        
//                    }
                }
                     System.out.println(a[1]);
                out.write(s);
                out.newLine();
            }

            br.close();
            out.close();
        } catch (Exception ex) {
        } finally {

        }
    }

    public static void main(String[] args) throws IOException {
        Ex1 e1 = new Ex1();
        e1.inPut();
        e1.outPut();

    }
}
