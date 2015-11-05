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
import java.io.InputStreamReader;
import static javacore.Bai2.isCheck;

/**
 *
 * @author Dinh Trong Tuyen
 */
public class bai3 {

    public static void main(String[] args) throws IOException {
        int Air_Temp=0,Wind_Speed=0;
        try {
            java.net.URL url = new java.net.URL("http://lpo.dt.navy.mil/data/DM/Environmental_Data_Deep_Moor_2015.txt");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String s;
            while ((s = in.readLine()) != null) {
                String[] a = s.split(" ");
                for (String r : a) {
                    isCheck(r);
                    if (isCheck(r)) {
                        
                        Air_Temp = Integer.parseInt(r);
                      
                    };
                }
            }

        } catch (Exception ex) {
        }
        System.out.println("Nhiet do TB= " + Air_Temp);
        System.out.println("Toc do gio TB= " + Wind_Speed);
    }

}
