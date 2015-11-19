/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kiemanh.vn.common;

import java.io.IOException;

/**
 *
 * @author kiempq
 */
public class AppConfig {
    private static FileConfiguration fileConfig = null;
    public AppConfig() {
    }
    
    public static FileConfiguration getConfig() {
        if (fileConfig == null) {
            try {
                fileConfig = new FileConfiguration(Constant.CONFIG_FOLDER+ "appsettings.xml", true);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return fileConfig;
    }
}
