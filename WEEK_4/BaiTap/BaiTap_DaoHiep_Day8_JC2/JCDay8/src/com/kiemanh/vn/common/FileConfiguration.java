/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kiemanh.vn.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author kiempq
 */
public class FileConfiguration {
    private String configFilePath;
    private Properties properties = new Properties();
    private boolean isXML;

    public FileConfiguration(String configFilePath, boolean isXML) throws IOException {
        this.configFilePath = configFilePath;
        this.isXML = isXML;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(configFilePath);
            if (isXML) {
                properties.loadFromXML(fis);
            } else {
                properties.load(fis);
            }
        } catch (FileNotFoundException ex) {
            // creates the configuration file and set default properties
            setDefaults();
            save();
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
    }

    private void setDefaults() {
        properties.put("INPUT_FOLDER", "/home/kiempq/config/doisoatcdr/input");
        properties.put("OUTPUT_FOLDER", "/home/kiempq/config/doisoatcdr/output");
    }

    public void save() throws IOException {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(configFilePath);
            if (isXML) {
                properties.storeToXML(fos, "My Application Settings","UTF-8");
            } else {
                properties.store(fos, "My Application Settings");
            }
        } finally {
            if (fos != null) {
                fos.close();
            }
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
    
    public int getIntProperty(String key, int defaultValue) {
        String strValue = properties.getProperty(key, defaultValue + "");
        int result = defaultValue;
        try {
            result = Integer.parseInt(strValue);
        } catch (Exception e) {
        }
        return result;
    }
    
    public long getLongProperty(String key, long defaultValue) {
        String strValue = properties.getProperty(key, String.valueOf(defaultValue));
        long result = defaultValue;
        try {
            result = Long.parseLong(strValue);
        } catch (Exception e) {
        }
        return result;
    }
    
    public float getFloatProperty(String key, float defaultValue) {
        String strValue = properties.getProperty(key, String.valueOf(defaultValue));
        float result = defaultValue;
        try {
            result = Float.parseFloat(strValue);
        } catch (Exception e) {
        }
        return result;
    }
    
    public double getDoubleProperty(String key, double defaultValue) {
        String strValue = properties.getProperty(key, String.valueOf(defaultValue));
        double result = defaultValue;
        try {
            result = Double.parseDouble(strValue);
        } catch (Exception e) {
        }
        return result;
    }
    
    public boolean getBooleanProperty(String key, boolean defaultValue) {
        String strValue = properties.getProperty(key, String.valueOf(defaultValue));
        boolean result = defaultValue; 
        try {
            result = Boolean.parseBoolean(strValue);
        } catch (Exception e) {
        }
        return result;
    }

    public void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }
}
