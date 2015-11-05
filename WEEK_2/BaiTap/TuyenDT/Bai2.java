/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author Dinh Trong Tuyen
 */
public class Bai2 {

    public static boolean isCheck(String str) {
        return str.matches("\\d+");
    }

    public static void main(String[] arg) {
        File in = new File("diem.txt");
        int tong = 0, dem = 0;
        int diem;
        String s;
        try {
            BufferedReader br = new BufferedReader(new FileReader(in));
            while ((s = br.readLine()) != null) {
                String[] a = s.split(" ");
                for (String r : a) {
                    isCheck(r);
                    if (isCheck(r)) {
                        dem++;
                        diem = Integer.parseInt(r);
                        tong += diem;
                    };
                }
            }
        } catch (Exception ex) {
        }
        System.out.println("Tong diem= " + tong);
        System.out.println("Dien TB= " + ((float) tong / dem));
    }
}
