/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcday8;

/**
 *
 * @author Hell
 */
public class GenericClass <T> {
    private T temp;

    GenericClass() {
   }

    public void setTemp(T t){
        this.temp = t;
    }

    public T getTemp() {
        return temp;
    }
    
}
 class Main {
     public static void main(String[] args) {
         GenericClass<Integer> genericInt = new GenericClass<Integer>();
         GenericClass<String> genericStr = new GenericClass<String>();
         
         genericInt.setTemp(4);
         genericStr.setTemp("Active Study");
         
         System.out.println(genericInt.getTemp());
         System.out.println(genericStr.getTemp());
     }
 }