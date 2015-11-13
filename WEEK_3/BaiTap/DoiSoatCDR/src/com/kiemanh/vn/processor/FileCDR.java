/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kiemanh.vn.processor;

import com.kiemanh.vn.common.AppLogger;
import com.kiemanh.vn.common.BigFile;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author kiempq
 */
public class FileCDR {

    private List<String> msisdns = null;
    private Pattern pattern = null;
    private Pattern patternMsisdn = null;

    public FileCDR(Pattern pattern, Pattern patternMsisdn) {
        this.msisdns = new ArrayList<String>();
        this.pattern = pattern;
        this.patternMsisdn = patternMsisdn;
    }

    public List<String> readFolder(String folderPath) {
        File folder = new File(folderPath);
        if (folder.isDirectory()) {
            File[] folderChilds = folder.listFiles();
            for (File folderChild : folderChilds) {
                if (folderChild.isDirectory()) {
                    String folderName = folderChild.getName();
                    File[] files = folderChild.listFiles();
                    for (File file : files) {
                        if (file.isFile()) {
                            String fileName = file.getName();
                            AppLogger.getInstance().debug("Mang file:" + file.getAbsolutePath() + " di kiem tra");
                            if (fileIsFomat(fileName, folderName)) {
                                AppLogger.getInstance().debug("Mang file:" + file.getAbsolutePath() + " kiem tra hop le");
                                readFile(file);
                            } else{
                                AppLogger.getInstance().debug("Mang file:" + file.getAbsolutePath() + " bi loai bo");
                            }
                        }
                    }
                }
            }
        }
        return msisdns;
    }

    private boolean fileIsFomat(String fileName, String folderName) {
        if (fileName.contains(folderName)) {
            Matcher matcher = this.pattern.matcher(fileName);
            if (matcher.matches()) {
                return true;
            }
        }
        return false;
    }

    private void readFile(File file) {
        BigFile f = null;
        try {
            f = new BigFile(file.getAbsolutePath());
            Iterator<String> items = f.iterator();
            while (items.hasNext()) {
                String msisdn = items.next();
                AppLogger.getInstance().debug("==>" + msisdn + " du lieu tu file");
                Matcher matcher = this.patternMsisdn.matcher(msisdn);
                if (matcher.find()) {
                    String value = matcher.group(0);
                    AppLogger.getInstance().debug("==>" + msisdn + " co so dien thoai la:" + value);
                    if (!this.msisdns.contains(value)) {
                        AppLogger.getInstance().debug("==>" + msisdn + " add vao list");
                        this.msisdns.add(value);
                    }
                }else{
                    AppLogger.getInstance().debug("==>" + msisdn + " khong ton tai so dien thoai dung dinh dang");
                }
            }
        } catch (Exception ex) {
            AppLogger.getInstance().error(ex.getMessage());
        } finally {
            if (f != null) {
                f.Close();
            }
        }
    }

}
