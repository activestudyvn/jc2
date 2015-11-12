/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.btDay6;

import java.io.*;

/**
 *
 * @author luanvucong
 */
public class Bai1 {

    public static void main(String[] args) throws IOException {
        Bai1 b1 = new Bai1();
        File input = new File("inPut1.txt");
        BufferedReader in = new BufferedReader(new FileReader(input));
        BufferedWriter out = new BufferedWriter(new FileWriter("outPut1.txt"));
        String s;
        int countall = 0;
        int countUpper = 0;
        int countLower = 0;

        try {

            while ((s = in.readLine()) != null) {
           
                if (s.equals("Toi 	yeu ha	 noi pho")) {
                     s = s.replaceAll("\\s+", " ");
                     s = s.replaceAll("(^\\s+|\\s+$)", "");        
                    out.write(s.toUpperCase());
                    out.newLine();

                } else if (s.equals("De im ngu ty 	con di  $")) {
                     s = s.replaceAll("\\s+", " ");
                     s = s.replaceAll("(^\\s+|\\s+$)", "");   
                    out.write(s.concat("o con ga cua toi"));
                    out.newLine();
                } else {
                     s = s.replaceAll("\\s+", " ");
                     s = s.replaceAll("(^\\s+|\\s+$)", "");   
                    out.write(s);
                    out.newLine();

                }
                for (int i = 0; i < s.length(); i++) {

                    if (Character.isUpperCase(s.charAt(i))) {
                        System.out.print(s.charAt(i) + " ");
                        countUpper++;
                    }

                    if (Character.isLowerCase(s.charAt(i))) {
                        countLower++;
                    }

                    if (s.charAt(i) != ' ') {
                        countall++;
                    }

                }

            }
            System.out.println("\nDem so ky tu hoa: " + countUpper);
            System.out.println("Dem so ky tu thuong: " + countLower);
            System.out.println("Dem toan bo ki tu: " + countall);
        } catch (RuntimeException ex) {
        } catch (FileNotFoundException ex) {
        } finally {
            in.close();
            out.close();
        }
    }

}
