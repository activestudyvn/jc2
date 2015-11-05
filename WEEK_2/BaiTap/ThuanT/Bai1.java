/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day4_IO;

/**
 *
 * @author ThuanTD
 */
import java.io.*;
import java.net.URL;
import java.util.Date;

public class Bai1 {

    public static void main(String args[]) throws IOException {
        long start = new Date().getTime();
        InputStream in = null;
        FileOutputStream out = null;
        BufferedReader br = null;
        String fileName = "D:/diem.txt";
        String link = "http://m.uploadedit.com/ba3k/1444869858795.txt ";
        try {
            URL url = new URL(link);
            
            in = new BufferedInputStream(url.openStream());
            br = new BufferedReader(new InputStreamReader(in));
            out = new FileOutputStream(fileName);
            int line;
            while ((line = br.read()) != -1) {
                out.write(line);
            }

        } finally {
            if (br != null) {
                br.close();
            }
            if (out != null) {
                out.close();
            }
        }
        long stop = new Date().getTime();
        System.out.println("Thời gian chạy: " + (stop - start));
        System.out.println("finish!");
    }
}
