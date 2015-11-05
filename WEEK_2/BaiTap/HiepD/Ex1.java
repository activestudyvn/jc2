/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise;

import java.io.BufferedInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


/**
 *
 * @author Hell
 */
public class Ex1 {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://m.uploadedit.com/ba3k/1444869858795.txt");
            BufferedInputStream bf = new BufferedInputStream(url.openStream());
            FileWriter fw = new FileWriter("E:\\out.txt");
            
            int temp;
            while ((temp = bf.read()) != -1) {
                fw.write((char)temp);
            }
            fw.close();
            System.out.println("Success!");
            
        } catch (MalformedURLException ex) {
            System.out.println("Can't Open URL");;
        } catch (IOException i) {
            System.out.println("Can't write data");
        }
    }
}
