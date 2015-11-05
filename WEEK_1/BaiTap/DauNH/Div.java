/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day3_Jc2;

/**
 *
 * @author Elitebook
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Div {
    public static void main(String[] args) throws MyException, Loi {
        try {
            nhap();

        } catch (MyException ex) {
            System.out.println(ex.getMessage());
        } catch (InputMismatchException ex) {
            System.out.println("Hello sai roi");
        } catch (Loi lx) {
            System.out.println(lx.getMessage());
        }
    }
    
    public static void nhap() throws MyException, Loi {
        int x, y;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap tu so ");
        x = sc.nextInt();
        System.out.println("Nhap mau so ");
        y = sc.nextInt();
        if (y == 0) {
            throw new MyException("Loi chia cho 0");
        }
        if (isPossitiveInteger(x, y)) {
            System.out.println(x / y);
        } else {
            throw new Loi();
        }

    }
    //check so nguyen duong
    public static boolean isPossitiveInteger(int a, int b) {
        if (a >= 0 && b >= 0) {
            return true;
        }
        return false;
    }
}
