/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhom1_day5_jc2_btvn;

import java.io.BufferedReader;

import java.io.File;

import java.io.FileReader;

import java.io.IOException;

/**
 *
 * @author Elitebook
 */
public class Bai2 {

    public void tong() throws IOException {
        File in = new File("E:Diem.txt");
        int sum = 0;
        int dem=0;
        String s;
        BufferedReader br = new BufferedReader(new FileReader(in));
        while ((s = br.readLine()) != null) {
            String[] a = s.split(" ");

            for (String r : a) {
                isNumericOnlyNumber(r);
                if (isNumericOnlyNumber(r)) {
                    int t = Integer.parseInt(r);
                    sum += t;
                    dem++;
                };
            }

        }
        System.out.println("Tong la " + sum);
        System.out.println("Trung binh la " + ((float) sum / dem));
    }

    public static boolean isNumericOnlyNumber(String str) {
        return str.matches("\\d+");
    }

    public static void main(String[] arg) throws IOException {
        Bai2 bt = new Bai2();
        bt.tong();
       
    }
}
