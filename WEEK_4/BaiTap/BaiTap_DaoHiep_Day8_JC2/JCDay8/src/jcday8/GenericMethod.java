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
public class GenericMethod {

    public static < T> void printArray(T[] inputArray) {
        // Hien thi cac phan tu mang              
        for (T element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }
    
    
    

    public static void main(String args[]) {
        // Tao cac mang Integer, Double va Character
        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        Character[] charArray = {'H', 'E', 'L', 'L', 'O'};

        System.out.println("Mang intArray bao gom:");
        printArray(intArray); // truyen mot mang Integer

        System.out.println("\nMang doubleArray bao gom:");
        printArray(doubleArray); // truyen mot mang Double

        System.out.println("\nMang charArray bao gom:");
        printArray(charArray); // truyen mot mang Character
    }
}
