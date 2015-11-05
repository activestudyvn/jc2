/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hell
 */
public class Ex2 {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://m.uploadedit.com/ba3k/1444869858795.txt");
            BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream()));

            String line = null;
            StringBuffer lines = new StringBuffer();
            int sum = 0, count = 0;

            while ((line = bf.readLine()) != null) {
                //System.out.println(line);
                lines.append(line);
                lines.append(" ");
            }
            String[] arr = lines.toString().split(" ");
            for (String temp : arr) {
                try {
                    sum += Integer.parseInt(temp);
                    count++;
                } catch (NumberFormatException n) {
                    continue;
                }
                System.out.println(temp);

            }

            System.out.println("Diem trung binh : " + (float) sum / count);

        } catch (MalformedURLException ex) {
            System.out.println("URL error!");;
        } catch (IOException io) {
            System.out.println("I/O Exception!");
        }
    }
}
