/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiTapDay6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import static javacore.Bai2.isCheck;

/**
 *
 * @author Dinh Trong Tuyen
 */
public class Ex1 {

    String s;
    int dem = 0, demhoa = 0;

    public void inPut() throws FileNotFoundException, IOException {
        Reader r = new FileReader("inPut1.txt");
        int i = -1;
        while ((i = r.read()) != -1) {
            if (i >= 'A' && i <= 'Z') {

                System.out.print((char) i + "   ");

            }
            for (int j = 0; j < i; j++) {
                demhoa++;
            }
        }
        System.out.println("\nSo luong ky tu hoa la: " + demhoa);
        r.close();

        File f = new File("inPut1.txt");
        FileInputStream input = new FileInputStream(f);
        byte[] buffer = new byte[1024];
        int read = -1;

        while ((read = input.read(buffer)) != -1) {

            for (int j = 0; j < read; j++) {
                dem++;
            }
            System.out.println("\nSo luong ky tu la: " + dem);
        }
        input.close();
    }

    public void outPut() throws FileNotFoundException, IOException {
        File file = new File("input1.txt");
        BufferedReader bff = new BufferedReader(new FileReader(file));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output1.txt"));
        String string;
        while ((string = bff.readLine()) != null) {

            if (string.equals("Toi 	yeu ha	 noi pho")) {
                bw.write(string.toUpperCase());
                bw.flush();
            } else if (string.equals("De im ngu ty 	con di  $")) {
                bw.write(string.concat("o con ga cua toi"));
                bw.flush();

            } else {
                bw.write(string);
                bw.flush();
            }

        }

        bff.close();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        Ex1 ex1 = new Ex1();
        ex1.inPut();
        ex1.outPut();
    }
}
