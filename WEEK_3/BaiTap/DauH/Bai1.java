
package dau;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Bai1 {
	public void inHoa() throws FileNotFoundException, IOException {
		File file = new File("E:/input1.txt");
		BufferedReader bff = new BufferedReader(new FileReader(file));
		String string;
		while ((string = bff.readLine()) != null) {
			String[] stringArray = string.split(" ");		
			for (String str : stringArray) {
				String str2 = str.replaceAll("[^a-zA-Z]+", "");
				for (int i = 0; i < str2.length(); i++) {

					if (String.valueOf(str2.charAt(i)).equals(String.valueOf(str2.charAt(i)).toUpperCase())) {
						System.out.print(str2.charAt(i) + " ");
					}
				}
			}
		}
		bff.close();
	}
	public void count() throws FileNotFoundException, IOException {
		int kyTuThuong = 0, soKytu = 0;
		File file = new File("E:/input1.txt");
		BufferedReader bff = new BufferedReader(new FileReader(file));
		String string;
		while ((string = bff.readLine()) != null) {
			soKytu += string.length();
			String[] stringArray = string.split(" ");
			for (String str : stringArray) {
				String str2 = str.replaceAll("[^a-zA-Z]+", "");
				for (int i = 0; i < str2.length(); i++) {
					if (String.valueOf(str2.charAt(i)).equals(String.valueOf(str2.charAt(i)).toLowerCase())) {
						kyTuThuong++;
					}
				}
			}
		}
		System.out.println("So ky tu la " + soKytu);
		System.out.println("So ky tu thuong la " + kyTuThuong);
		bff.close();
	}
	public void fix()throws FileNotFoundException, IOException{
		File file = new File("E:/input1.txt");
		BufferedReader bff = new BufferedReader(new FileReader(file));
		BufferedWriter bw=new BufferedWriter(new FileWriter("E:/output1.txt"));
		String string;
		while ((string = bff.readLine()) != null) {
			
			if(string.equals("Toi 	yeu ha	 noi pho")){
				bw.write(string.toUpperCase());
				bw.flush();
			}else if(string.equals("De im ngu ty 	con di  $")){
				bw.write(string.concat("o con ga cua toi"));
				bw.flush();
			
			}
			else{
				bw.write(string);
				bw.flush();
			}
			
		}
		
		bff.close();
		bw.close();
	}
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Bai1 bt = new Bai1();
		try {
//			 bt.inHoa();
//			 System.out.println();
//			bt.count();
			bt.fix();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

}
