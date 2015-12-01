/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.hiepdv.filter;


import dev.hiepdv.file.WriteFile;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author hellb
 */
public class LocTinSai extends Filter implements Runnable {

    public LocTinSai(List tinNhans) {
        super(tinNhans);
    }
    
    @Override
    public void run() {
        Iterator<String> itr = tinNhans.iterator();
        String temp;
        while(itr.hasNext()) {
            temp = itr.next();
            if (!checkForm(temp)) {
                tinDaLoc.add(temp);
            }
        }        
        WriteFile writeFile = new WriteFile("D:/output/File_Sai.txt",tinDaLoc);
            writeFile.start();    
            
    }
    
}
