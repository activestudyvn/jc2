/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kiemanh.vn;

import com.kiemanh.vn.common.AppLogger;

/**
 *
 * @author kiempq
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //AppConfig config = new AppConfig();
        AppLogger.getInstance().setLevel(AppLogger.DEBUG);
        AppLogger.getInstance().info("Start chuong trinh");
        DoiSoatCDR cDR = new DoiSoatCDR();
        cDR.doiSoatInput();
        cDR.doiSoatOutput();
        AppLogger.getInstance().info("Ket thuc chuong trinh");
    }
    
}
