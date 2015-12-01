/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapday10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Dinh Trong Tuyen
 */
public class baitap_thread extends Thread {

    File in = new File("E:/input.txt");
    File outputFile1 = new File("E:/dung.txt");
    File outputFile2 = new File("E:/sai.txt");

    /**
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public void run() {
        String s;

        try {
            BufferedReader br = new BufferedReader(new FileReader(in));
            while ((s = br.readLine()) != null) {
                String[] a = s.split("2015");

                for (String r : a) {
//                    for (int i = 0; i < a[i].length(); i++) {
//                        System.out.println(a[1]);
//                    }
//                      System.out.println(r);
                    String[] b = r.split("[ |]");

                    for (String y : b) {
                        if ((y.equals("fuck")) || (y.equals("shit")) || (y.equals("DCM"))) {
                            BufferedWriter out1 = new BufferedWriter(new FileWriter(outputFile2));
                            out1.write(r);
                            out1.newLine();
                            System.out.println(r);
                        
                        }
                    }
                }
            }

        } catch (Exception ex) {
        }
    }

    public static void main(String[] args) throws IOException {
        baitap_thread t = new baitap_thread();
        t.start();
        // t.outPut();

    }
}
