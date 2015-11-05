/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hell
 */
public class Ex4 {
    
}

class FileCDR {
    private int writeType;
    private int maxValue;
    private int fileType;
    private String fileName;
    private String filePath;
    
    public FileCDR(int writeType, int fileType, String fileName,String filePath) {
        this.writeType = writeType;
        this.fileType = writeType;
        this.fileName = fileName;
        this.filePath = filePath;
        this.maxValue = 200;
    }

    public void setWriteType(int writeType) {
        this.writeType = writeType;
    }

    public void setFileType(int fileType) {
        this.fileType = fileType;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    
    public void runType1() {
        int count = 0;
        
    
    }
    
    public FileWriter getWriteFileType1(int count){
        try {
            return new FileWriter(filePath + "/" + fileName + "." + count);
        } catch (IOException ex) {
            try {
                return new FileWriter(fileName + "." + count);
            } catch (IOException ex1) {
                System.out.println("Path Error");
            }
        }
        return null;
    }
    
    public FileWriter getWriteFileType2(){
        Calendar cal = Calendar.getInstance();
        StringBuffer strName = new StringBuffer();
        
        return null;
    }
    
}