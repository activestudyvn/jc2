/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapday9;

import baitapday8new.TinNhan;
import baitapday8new.WriteFile;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hellb
 */
public class Processor {

    private Map<String, ArrayList<TinNhan>> mTinNhans = new HashMap<>();
    private List<TinNhan> lTinNhans = null;

    public Processor() {
        baitapday9.ReadInput input = new baitapday9.ReadInput("D:/input");
        lTinNhans = input.readAll();
    }

    public void filter() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Iterator<TinNhan> itr = lTinNhans.iterator();
        TinNhan temp = null;
        ArrayList<TinNhan> listTn = null;

        while (itr.hasNext()) {
            temp = itr.next();
            String key = format.format(temp.getNgayGui());
            
            listTn = mTinNhans.get(key);
            if (listTn == null) {
                listTn = new ArrayList<>();
                listTn.add(temp);
                mTinNhans.put(key, listTn);
            } else {
                listTn.add(temp);
            }
        }

    }

    public void write() {
       
        Iterator<String> key = mTinNhans.keySet().iterator();
        WriteFile writer;
        while (key.hasNext()) {
            
            String temp = key.next();
            
            
            try {
                writer = new WriteFile("D:/output/" + key + ".txt");
                writer.writeList(mTinNhans.get(key), 2);
            } catch (IOException ex) {
                Logger.getLogger(Processor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
