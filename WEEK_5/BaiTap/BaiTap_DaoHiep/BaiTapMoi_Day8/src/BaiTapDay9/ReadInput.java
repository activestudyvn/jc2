/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapday9;

import baitapday8new.TinNhan;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hellb
 */
public class ReadInput {

    private String[] fileName;
    private String path;

    public ReadInput(String path) {
        fileName = new File(path).list();
        this.path = path;
        
    }

    public List<TinNhan> readAll() {
        List<TinNhan> tinNhans = new ArrayList<>();
        Scanner scanner = null;
        TinNhan tinNhan;

        for (String name : fileName) {
            try {
                scanner = new Scanner(new File(path + "\\" + name));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ReadInput.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (scanner.hasNext()) {
                tinNhans.add(getTinNhan(scanner.nextLine(),name));
            }
        }
        
        Collections.sort(tinNhans, new Comparator<TinNhan>() {
            @Override
            public int compare(TinNhan tn1, TinNhan tn2) {
                return tn1.getNgayGui().compareTo(tn2.getNgayGui());                
            }
        });
        
        scanner.close();
        return tinNhans;
    }

    private TinNhan getTinNhan(String line, String fileName) {
        TinNhan tinNhan = new TinNhan();
        
        String[] temp = line.split("\\|");
        tinNhan.setThueBao(fileName.substring(0,11));
        tinNhan.setNoiDung(temp[0]);

        Date ngayGui = null;
        try {
            ngayGui = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").parse(temp[1]);
        } catch (ParseException ex) {
            Logger.getLogger(ReadInput.class.getName()).log(Level.SEVERE, null, ex);
        }
        tinNhan.setNgayGui(ngayGui);

        return tinNhan;
    }

}
