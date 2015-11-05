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

public class TamGiac {
	public static int c1;
	public static int c2;
	public static int c3;
	static boolean check = false;

	public TamGiac(int c1, int c2, int c3) throws TamGiacException ,Loi{
		this.c1 = c1;
		this.c2 = c2;
		this.c3 = c3;
                check=check(c1,c2,c3);
                if(check==true){
		if (c1 + c2 <= c3 || c1 + c3 <= c2 || c2 + c3 <= c1) {
			throw new TamGiacException();
		}
                }else{
                throw new Loi();
                }
	}

	public static void nhap() throws Loi,TamGiacException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Do dai canh thu nhat ");
		c1 = sc.nextInt();
		
		System.out.println("Do dai canh thu 2 ");
		c2 = sc.nextInt();
		
		System.out.println("Do dai canh thu 3 ");
		c3 = sc.nextInt();
              TamGiac tg=new TamGiac(c1,c2,c3);
		
	}

	public static boolean check(int a,int b,int c) {
		if(a>=0&&b>=0&&c>=0){
                return true;
                }
                return false;
	}

	public static void main(String[] arg) throws Loi,TamGiacException {
		
                try {
                    nhap();
		} 
		 catch (ArithmeticException e) {
			System.out.println("Loi  " + e.getMessage());
		} catch (InputMismatchException i) {
			System.out.println("Loi " + i.getMessage());
			
		}catch(TamGiacException tx){
                    System.out.println(tx.getMessage());
                }catch(Loi lx){
                    System.out.println(lx.getMessage());
                }
                }
	}



