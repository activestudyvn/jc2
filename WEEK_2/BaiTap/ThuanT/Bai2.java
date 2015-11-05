/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.ex2.string;

import com.java.entity.StudentEntity;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thanhncs
 */
public class Bai2 {

    public ArrayList<StudentEntity> read(String input) {
        BufferedReader br = null;
        ArrayList<StudentEntity> lstStudent = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(input));
            String line = "";

            while ((line = br.readLine()) != null) {
                String[] t = line.split(" ");
                ArrayList<String> lst = fomat(t);
                for (int i = 0; i < lst.size(); i++) {
                    StudentEntity student = new StudentEntity(lst.get(i),Float.parseFloat(lst.get(i+1)));
                     lstStudent.add(student);
                     i=i+1;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Bai2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Bai2.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstStudent;
    }

    public ArrayList<String> fomat(String[] t) {
        ArrayList<String> lst = new ArrayList<>();
        
        for (int i = 0; i < t.length; i++) {
            if (t[i].equals("") == false) {
                lst.add(t[i]);
            }
        }
        return lst;
    }

    public float sum(ArrayList<StudentEntity> lstStudent) {
        float sum = 0;
        for (int i = 0; i < lstStudent.size(); i++) {
            float diem = lstStudent.get(i).getDiem();
            sum += diem;
        }
        return sum;
    }

    public float diemTrungBinh(float sum, int n) {
        return sum / n;
    }

    public static void main(String[] args) {
        Bai2 iOFile = new Bai2();
        ArrayList lstStudent = iOFile.read("D:/diem.txt");
        float sum = iOFile.sum(lstStudent);
        float diemTb = iOFile.diemTrungBinh(sum, lstStudent.size());
        System.out.println("Tong diem  : " + sum + " Diem trung binh : " + diemTb +"sdfsfsfsf"+lstStudent.size());
       
    }
}
