/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.Day4;

import java.io.*;
import java.net.URL;

/**
 *
 * @author luanvucong
 */
public class Bai3 {

    public static void main(String[] args) {

        File outputFile = new File("bai3.txt");
        try {
            URL url = new URL("http://lpo.dt.navy.mil/data/DM/Environmental_Data_Deep_Moor_2015.txt");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            BufferedWriter out = new BufferedWriter(new FileWriter(outputFile));
            String line;
            while ((line = in.readLine()) != null) {
                out.write(line);
                out.newLine();
            }
            in.close();
            out.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
