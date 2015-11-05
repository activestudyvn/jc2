/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.Day4;

/**
 *
 * @author luanvucong
 */
import java.io.*;


/**
 *
 * @author Elitebook
 */
public class Bai2 {

    public static boolean isCheck(String str) {
        return str.matches("\\d+");
    }

    public static void main(String[] arg) {
        File in = new File("diem.txt");
        int sum = 0;
        int dem = 0;
        String s;
        try {
            BufferedReader br = new BufferedReader(new FileReader(in));
            while ((s = br.readLine()) != null) {
                String[] a = s.split(" ");

                for (String r : a) {
                    isCheck(r);
                    if (isCheck(r)) {
                        dem++;
                        int t = Integer.parseInt(r);
                        sum += t;
                    };
                }

            }
        } catch (Exception ex) {
        }
        System.out.println("Tong= " + sum);
        System.out.println("TB= " + ((float) sum / dem));
    }
}
