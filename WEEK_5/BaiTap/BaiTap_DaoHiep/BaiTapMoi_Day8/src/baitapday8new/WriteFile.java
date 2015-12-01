/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapday8new;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Hell
 */
public class WriteFile {

    private FileWriter writer;

    public WriteFile(String path) throws IOException {
        writer = new FileWriter(path, true);
    }

    public void writeList(ArrayList<TinNhan> tinNhans, int type) throws IOException {
        Iterator<TinNhan> itr = tinNhans.iterator();
        TinNhan tinNhan = null;
        SimpleDateFormat format = null;
        if (type == 1) {
            format = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
            while (itr.hasNext()) {
                tinNhan = itr.next();
                writer.write(tinNhan.getNoiDung() + "|"
                        + format.format(tinNhan.getNgayGui()) + "\n");
                
            }
        } else {
            format = new SimpleDateFormat("yyyyMMdd");
            while (itr.hasNext()) {
                tinNhan = itr.next();
                writer.write(tinNhan.getThueBao() + "|" + tinNhan.getNoiDung() 
                        + "|" + format.format(tinNhan.getNgayGui()) + "\n");
                
            }
        }
    
        writer.close();
    }
    

}
