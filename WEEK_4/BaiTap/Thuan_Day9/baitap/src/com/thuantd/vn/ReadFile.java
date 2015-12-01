/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thuantd.vn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ThuanTD
 */
public class ReadFile {

    private Map<String, List<Message>> map = new HashMap<>();

    public void readFile() {
        String filePath = "D:/messages.txt";
        String line;
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                Message tn = convertToMessage(line);
                if (map.containsKey(tn.getMsisdn())) {
                    List<Message> lstTn = map.get(tn.getMsisdn());
                    lstTn.add(tn);
                } else {
                    List<Message> lstTn = new ArrayList<>();
                    map.put(tn.getMsisdn(), lstTn);
                    lstTn.add(tn);

                }

            }
        } catch (IOException ex) {

        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public Message convertToMessage(String msg) {
        String[] str = msg.split("\\|");
        Message tn = new Message();
        tn.setMsisdn(str[0]);
        tn.setContent(str[1]);
        tn.setTime(str[2]);
        return tn;
    }

    public void writeFile() {
        for (String key : map.keySet()) {
            String file = "D:/output/" + key + ".txt";
            File filePath = new File(file);
            BufferedWriter bw = null;
            try {
                bw = new BufferedWriter(new FileWriter(filePath));
                List<Message> lst = map.get(key);
                for (Message a : lst) {
                    bw.write(a.getContent() + "|" + a.getTime() + "\n");
                }
            } catch (IOException ex) {
                Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
            }finally{

                try {
                    bw.flush();
                } catch (IOException ex) {
                    Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
                }

        }
    }

}

public static void main(String[] args) {
        ReadFile rf = new ReadFile();

      
            rf.readFile();
            rf.writeFile();
        
    }
}
