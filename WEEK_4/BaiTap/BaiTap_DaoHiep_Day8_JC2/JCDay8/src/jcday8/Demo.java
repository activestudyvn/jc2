/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcday8;

import java.util.LinkedList;

/**
 *
 * @author Hell
 */
public class Demo {
    public static <A extends Number> void test(A a) {
        System.out.println("number : " + a);
        
    }
    
    public static void main(String[] args) {
        test(2);
        
    }
}
