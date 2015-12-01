/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapday8new;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hell
 */
public class Execute {

    private ReadFile read;
    Map<String, ArrayList<TinNhan>> map = new HashMap<String, ArrayList<TinNhan>>();

    public Execute(String path) {
        read = new ReadFile(path);
    }

    public void setMap() {
        TinNhan temp = null;
        ArrayList<TinNhan> listTn;
        while (read.hasNext()) {
            temp = read.getNext();
            listTn = map.get(temp.getThueBao());
            if (listTn != null) {
                listTn.add(temp);
            } else {
                listTn = new ArrayList<>();
                listTn.add(temp);
                map.put(temp.getThueBao(), listTn);
            }
        }
    }

    public void write() {
        WriteFile writer = null;
        Iterator<String> itr1 = map.keySet().iterator();

        while (itr1.hasNext()) {

            try {
                String sdt = itr1.next();
                ArrayList<TinNhan> listTinNhan = map.get(sdt);
                writer = new WriteFile("D:/output/" + sdt + ".txt");

                writer.writeList(listTinNhan,1);
            } catch (IOException ex) {
                Logger.getLogger(Execute.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
