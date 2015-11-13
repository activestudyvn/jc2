/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kiemanh.vn;

import com.kiemanh.vn.common.AppConfig;
import com.kiemanh.vn.common.AppLogger;
import com.kiemanh.vn.processor.FileCDR;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author kiempq
 */
public class DoiSoatCDR {

    private List<String> inputMsisdns = null;
    private List<String> outputMsisdns = null;

    public DoiSoatCDR() {
        Pattern inputPattern = Pattern.compile("cdr_\\d{8}_8x56_\\d.txt");
        Pattern inputPatternMsisdn = Pattern.compile("849\\d{7}");
        FileCDR inputCdr = new FileCDR(inputPattern, inputPatternMsisdn);
        String inputFolderPath = AppConfig.getConfig().getProperty("INPUT_FOLDER", "");
        inputMsisdns = inputCdr.readFolder(inputFolderPath);

        Pattern outputPattern = Pattern.compile("cdr_\\d{8}_8x56_\\d.txt");
        Pattern outputPatternMsisdn = Pattern.compile("[849]\\d{9}");
        FileCDR outputCdr = new FileCDR(outputPattern, outputPatternMsisdn);
        String outFolderPath = AppConfig.getConfig().getProperty("OUTPUT_FOLDER", "");
        outputMsisdns = outputCdr.readFolder(outFolderPath);
    }

    public void doiSoatInput() {
        List<String> lIn = new ArrayList<>();
        for (String msisdn : this.inputMsisdns) {
            AppLogger.getInstance().debug("==>" + msisdn + " check ton tai voi thang out");
            boolean isExits = false;
            for (String s : this.outputMsisdns) {
                if (msisdn.equals(s)) {
                    isExits = true;
                    break;
                }
            }
            if (isExits == false && lIn.contains(msisdn) == false) {
                AppLogger.getInstance().debug("==>" + msisdn + " khong co trong thang out");
                lIn.add(msisdn);
            }else{
                AppLogger.getInstance().debug("==>" + msisdn + " co trong thang out");
            }
        }
        String inputFolderPath = AppConfig.getConfig().getProperty("INPUT_FOLDER", "");
        String fileWrite = inputFolderPath + File.separator + "input_co.txt";
        writeFile(lIn, fileWrite);
    }

    public void doiSoatOutput() {
        List<String> lIn = new ArrayList<>();
        for (String msisdn : this.outputMsisdns) {
            AppLogger.getInstance().debug("==>" + msisdn + " check ton tai voi thang in");
            boolean isExits = false;
            for (String s : this.inputMsisdns) {
                if (msisdn.equals(s)) {
                    isExits = true;
                    break;
                }
            }
            if (isExits == false && lIn.contains(msisdn) == false) {
                AppLogger.getInstance().debug("==>" + msisdn + " khong co trong thang in");
                lIn.add(msisdn);
            }else{
                AppLogger.getInstance().debug("==>" + msisdn + " co trong thang in");
            }
        }
        String inputFolderPath = AppConfig.getConfig().getProperty("OUTPUT_FOLDER", "");
        String fileWrite = inputFolderPath + File.separator + "output_co.txt";
        writeFile(lIn, fileWrite);
    }
    
    private void writeFile(List<String> l,String filePath){
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(new File(filePath)));
            for(String msisdn:l){
                AppLogger.getInstance().debug("==>" + msisdn + " ghi xuong file");
                writer.write(msisdn);
                writer.newLine();
            }
        } catch (IOException ex) {
            AppLogger.getInstance().error("Loi ghi file:" + ex.getMessage());
        }finally{
            if(writer != null){
                try {
                    writer.close();
                } catch (IOException ex) {
                    AppLogger.getInstance().error("Loi dong file:" + ex.getMessage());
                }
            }
        }
        
    }

}
