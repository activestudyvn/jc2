/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

/**
 *
 * @author Dinh Trong Tuyen
 */
public class Bai1 {

    public static void main(String[] args) throws IOException{

        File outputFile = new File("diem.txt");
        try {
            java.net.URL url = new java.net.URL("http://m.uploadedit.com/ba3k/1444869858795.txt");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            BufferedWriter out = new BufferedWriter(new FileWriter(outputFile));
            String S;
            while ((S = in.readLine()) != null) {
                out.write(S);
                out.newLine();
            }
            in.close();
            out.close();
        } catch (Exception ex) {
        }

    }
}
