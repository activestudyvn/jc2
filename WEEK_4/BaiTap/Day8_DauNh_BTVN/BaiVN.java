/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day8_jc2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Elitebook
 */
public class BaiVN {
    public void readFileStruct() throws FileNotFoundException, IOException{
    File file=new File("E:\\BaiTapDay8\\input\\struct.txt");
    BufferedReader br=new BufferedReader(new FileReader(file));
    String string;
    while((string=br.readLine())!=null){
         Pattern outputPattern = Pattern.compile("\\(.*\\)");
         Pattern outputPattern2 = Pattern.compile("\\d{3,4}+");
         Matcher matcher1=outputPattern.matcher(string);
          Matcher matcher2=outputPattern2.matcher(string);
          if(matcher1.find()&&matcher2.find()){
              String string2=matcher1.group(0);
              string2=string2.substring(1, string2.length()-1);
              
              System.out.println(matcher2.group(0)+": "+string2);
          }
    
    }
    }
    public void filter() throws FileNotFoundException, IOException{
    File file=new File("E:\\BaiTapDay8\\input\\message.txt");
    BufferedReader br=new BufferedReader(new FileReader(file));
    String string;
    //int coutLine = 0;
     ArrayList<String> arr = new ArrayList();
    while((string=br.readLine())!=null){
    arr.add(string);
    }
       for(int i=0;i<arr.size()-1;i++){
           for(int j=i+1;j<arr.size();j++){
        if(isPosition0(arr.get(i),arr.get(j))){
        
        }
       }
           
       }
    }
    
    public boolean isPosition0(String str,String str2){
    String[] string=str.split(" [|()]+");
    String[] string2=str2.split(" [|()]+");
    if(string[0].equals(string2[0])){
    return true;
    }else
    return false;
    }
    public boolean isPositionAffter(String str,String str2){
    String[] string=str.split(" [|()]+");
    String[] string2=str2.split(" [|()]+");
    if(string[string.length-1].equals(string2[string2.length-1])){
    return true;
    }else
    return false;
    }
    public boolean isTime(String str,String str2){
     String[] string=str.split("[|()]+");
    String[] string2=str2.split("[|()]+");
    Date date=new Date();
    SimpleDateFormat simple=new SimpleDateFormat(string[2]);
    SimpleDateFormat simple2=new SimpleDateFormat(string2[2]);
    return false;
    }
    public static void main(String[] args) throws IOException {
        BaiVN bt=new BaiVN();
        bt.readFileStruct();
        bt.filter();
    }
}
