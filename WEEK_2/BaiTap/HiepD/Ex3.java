/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Hell
 */
public class Ex3 {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://lpo.dt.navy.mil/data/DM/Environmental_Data_Deep_Moor_2015.txt");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));

            // bo qua dong dau
            bufferedReader.readLine();

            int count = 0;
            float airTemp = 0, winSpeed = 0;

            String[] arr = null;
            while (bufferedReader.read() != -1) {
                arr = bufferedReader.readLine().split("\t");
                //System.out.println(arr[1] + "\t" + arr[7]);
                try {
                    winSpeed += Float.parseFloat(arr[7].toString());
                    airTemp += Float.parseFloat(arr[1].toString());
                    count++;
                } catch (NumberFormatException ex) {
                    continue;
                }

            }

            System.out.println("Air Temp : " + airTemp / count);
            System.out.println("Win Speed : " + winSpeed / count);

        } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
