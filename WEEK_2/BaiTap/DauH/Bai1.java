/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhom1_day5_jc2_btvn;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.nio.Buffer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elitebook
 */
public class Bai1 {
    public void download(){
        try {
            String str="http://m.uploadedit.com/ba3k/1444869858795.txt ";
            java.net.URL url = new java.net.URL(str);
            try {
                
               
                InputStream input=new DataInputStream(url.openStream());
              
                BufferedInputStream bf=new BufferedInputStream(input);
                BufferedOutputStream bo=new BufferedOutputStream(new FileOutputStream("E:Diem.txt"));
                int c;
                while((c=bf.read())!=-1)
                bo.write(c);
                bo.flush();
                bo.close();
            } catch (IOException ex) {
                System.out.println("Sai");
            }
        } catch (MalformedURLException ex) {
            System.out.println("Sai");
        }
    
    }
    public static void main(String[] aeh){
    Bai1 bt=new Bai1();
    bt.download();
    }
    
}
