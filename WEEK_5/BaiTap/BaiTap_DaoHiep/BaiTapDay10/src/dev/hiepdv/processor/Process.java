/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.hiepdv.processor;

import dev.hiepdv.file.ReadFile;
import dev.hiepdv.filter.Filter;
import dev.hiepdv.filter.LocTinDung;
import dev.hiepdv.filter.LocTinSai;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hellb
 */
public class Process {

    public Process() {
        List<String> tinNhans = new ArrayList<>();
        
        ReadFile readFile = 
                new ReadFile("D:\\Tai Lieu\\Active Study\\BaiTap_Day10\\inPut.txt", tinNhans);
        readFile.start();
        try {
            readFile.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Process.class.getName()).log(Level.SEVERE, null, ex);
        }
        Runnable locTinDung = new LocTinDung(tinNhans);
        Runnable locTinSai = new LocTinSai(tinNhans);
        Thread loc1 = new Thread(locTinDung);
        Thread loc2 = new Thread(locTinSai);
        loc1.start();
        loc2.start();
        
    }
    
    
    
}
