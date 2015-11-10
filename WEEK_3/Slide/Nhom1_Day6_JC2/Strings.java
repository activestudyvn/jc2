/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhom1_day6;

/**
 *
 * @author Elitebook
 */
public class Strings {
    public static void main(String[] args) {
        char[] char1={'a','c','b'};
        String chara=new String(char1);
        String string=new String("abc");
        String again=new String("ab"
                + "c");
        String string2=" abc bca";
        String s1=string+string2;
        System.out.println(chara);
        System.out.println(s1);
        System.out.println(again);
        System.out.println(string2);
        // method of the String class
        System.out.println(string.length());
        System.out.println(string==again);
        
        System.out.println(string2.trim());
         System.out.println(string2.substring(4));
          System.out.println(string2.replace('c','b'));
           System.out.println(string2+" The original string is not changed");
           System.out.println(string.concat(string2));
           System.out.println(string2.toUpperCase());
           String string3=string2.toUpperCase();
            System.out.println("string3 "+string3);
     
        if(string.equals(again)){
            System.out.println("true");
            
           
        }
        System.out.println(string.indexOf("a")); // return -1 neu khong tim thay
         System.out.println(string2.indexOf("a",3));
        System.out.println(string.toString());
        System.out.println(string.charAt(1));
        System.out.println(string.startsWith("b"));
        
        
    }
    
}
