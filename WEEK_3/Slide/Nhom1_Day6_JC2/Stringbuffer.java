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
public class Stringbuffer {
    public static void main(String[] args) {
        String string="Hello ngay moi";
        StringBuffer buff=new StringBuffer(string);
        
        System.out.println(buff.capacity()); // dung luong hien tai
        buff.append("( String moi duoc noi)");
        
        System.out.println(buff);
        
        System.out.println(buff.charAt(2));
        buff.setCharAt(0, 'h');
        System.out.println(buff);
        buff.setLength(100);
        System.out.println(buff);
//        buff.insert(5, "( vua duoc chen)");
//        System.out.println(buff);
//        buff.replace(5, 22, " :) ");
//        System.out.println(buff);
//        buff.delete(0, 5);
//        System.out.println(buff);
//        buff.reverse();
//        System.out.println(buff);
//        System.out.println(buff.length());
//        
//        System.out.println(buff.capacity());
//        buff.ensureCapacity(63);
//        System.out.println(buff.capacity());
//        
    }
    
}
