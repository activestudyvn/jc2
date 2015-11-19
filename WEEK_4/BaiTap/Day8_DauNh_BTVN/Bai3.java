/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day8_jc2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Elitebook
 */
public class Bai3 {
    public static boolean isNumericOnlyNumber(String str) {
        return str.matches("\\d+");
    }
    public void filter() throws FileNotFoundException, IOException {
        File file = new File("E:\\BaiTapDay8\\input\\message.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
       // int n = 0 ;
        String string;
    //int coutLine = 0;
        //ArrayList<String> arr = new ArrayList();
        while ((string = br.readLine()) != null) {
            String[] str = string.split("[|()]+");
            
            if(isNumericOnlyNumber(str[3])){
                int n=Integer.parseInt(str[3]);
                System.out.println(str[3]);
            switch (n) {
                case 102:
                    BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\BaiTapDay8\\output\\102.txt",true));
                    
                    bw.write(string);
                    bw.write("\n");
                    System.out.println("Thanh cong");
                    //bw.flush();
                    bw.close();
                    break;
                case 105:
                    BufferedWriter bw2 = new BufferedWriter(new FileWriter("E:\\BaiTapDay8\\output\\105.txt",true));
                    bw2.write(string);
                    bw2.write("\n");
                    
                    //bw2.flush();
                    bw2.close();
                    break;
                case 138:
                    BufferedWriter bw3 = new BufferedWriter(new FileWriter("E:\\BaiTapDay8\\output\\138.txt",true));
                    bw3.write(string);
                    bw3.write("\n");
                  
                    
                    //bw3.flush();
                    bw3.close();
                    break;
                case 140:
                    BufferedWriter bw4 = new BufferedWriter(new FileWriter("E:\\BaiTapDay8\\output\\140.txt",true));
                    bw4.write(string);
                    bw4.write("\n");
                    //bw4.flush();
                    bw4.close();
                    break;
                
                    
            }
        }
        }
        br.close();

    }
    public static void main(String[] args) throws FileNotFoundException,IOException {
        try{
            Bai3 bt=new Bai3();
        bt.filter();
        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        
        }catch(IOException ec){
            System.out.println(ec.getMessage());
        }
        
        
    }
}
    
