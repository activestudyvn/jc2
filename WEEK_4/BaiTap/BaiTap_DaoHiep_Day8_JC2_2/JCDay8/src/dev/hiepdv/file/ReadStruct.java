/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.hiepdv.file;

import com.kiemanh.vn.common.AppLogger;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import dev.hiepdv.message.CuPhapTinNhan;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Hell
 */
public class ReadStruct extends ReadFile{
    private BufferedReader reader = null;

    public ReadStruct(String filePath) {
        try {
            setReader(filePath);
            AppLogger.getInstance().debug("- Mo file Struct");
        } catch (FileNotFoundException ex) {
            AppLogger.getInstance().debug("- Loi duong dan file struct");;
        }
    }
    
    
    private String getDauSo() {
        Matcher match = Pattern.compile("\\+\\d*").matcher(line);
        match.find();
        return line.substring(match.start()+1, match.end());
    }
    
    private String getThongTin() {
        Matcher match  = Pattern.compile("\\:.*\\(").matcher(line);
        match.find();
        return line.substring(match.start()+2, match.end()-2);
    }
    
    private String[] getCuPhap() {
        Matcher match = Pattern.compile("\\(.*\\)").matcher(line);
        match.find();
        String temp = line.substring(match.start()+1, match.end()-1);
        String[] cuPhap = temp.split(",");
        for (int i = 0; i < cuPhap.length; i++) {
            cuPhap[i] = cuPhap[i].trim();
        }
        return cuPhap;
    }
    
    @Override
    public CuPhapTinNhan getNext() {
        try {
            CuPhapTinNhan cuPhap = new CuPhapTinNhan();
            readLine();
            cuPhap.setDauSo(getDauSo());
            cuPhap.setThongTin(getThongTin());
            cuPhap.setCuPhap(getCuPhap());
            return cuPhap;
        } catch (IOException ex) {
            AppLogger.getInstance().debug("- Loi doc file struct");
            return null;
        }
     }
    
}
