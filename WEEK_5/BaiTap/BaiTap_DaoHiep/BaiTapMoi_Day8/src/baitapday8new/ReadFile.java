/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapday8new;

import baitapday9.ReadInput;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Hell
 */
public class ReadFile {

    private Scanner scanner;
    private String line;

    public ReadFile(String path) {
        try {
            scanner = new Scanner(new File(path));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public TinNhan getNext() {
        TinNhan tinNhan = new TinNhan();
        line = scanner.nextLine();
        String[] temp = line.split("\\|");
        tinNhan.setThueBao(temp[0]);
        tinNhan.setNoiDung(temp[1]);
        Date ngayGui = null;
        
        try {
            ngayGui = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").parse(temp[2]);
        } catch (ParseException ex) {
            Logger.getLogger(ReadInput.class.getName()).log(Level.SEVERE, null, ex);
        }
        tinNhan.setNgayGui(ngayGui);

        return tinNhan;
    }

    public boolean hasNext() {
        return scanner.hasNext();
    }

}
