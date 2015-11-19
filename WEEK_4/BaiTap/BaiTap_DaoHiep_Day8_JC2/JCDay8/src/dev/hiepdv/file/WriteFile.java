/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.hiepdv.file;

import com.kiemanh.vn.common.AppLogger;
import dev.hiepdv.message.TinNhan;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hell
 */
public class WriteFile {
    private FileWriter writer = null;

    
    public void write(TinNhan tn) {
        try {
            AppLogger.getInstance().debug("- Mo file " + tn.getDauSo() + " de ghi");
            String path = "E:/output/" + tn.getDauSo() + ".txt";
            writer = new FileWriter(path,true);
        } catch (IOException ex) {
            AppLogger.getInstance().debug("- Loi mo file de ghi");
        } 
        AppLogger.getInstance().debug("- Ghi " + tn + " ra file" + tn.getDauSo());
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        try {
            writer.write("+"+tn.getThueBao()+"("+tn.getNdTin()
                    +"|"+format.format(tn.getThoiGianGui())+"|"+tn.getDauSo()+")\n");
            writer.flush();
        } catch (IOException ex) {
            AppLogger.getInstance().debug("- Loi ghi " + tn);
        }
        
    }
    
    public void close() {
        try {
            AppLogger.getInstance().debug("- Dong file ghi");
            writer.close();
        } catch (IOException ex) {
            AppLogger.getInstance().debug("- Loi dong file ghi");
        }
    }
    
}
