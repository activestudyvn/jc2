/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kiemanh.vn.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author kiempq
 */
public class DateTimeUtils {
    private static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
    public static String getCurrentDateTime(){
        String value = "";
        Date newDate = new Date();
        value = format.format(newDate);
        return value;
    }
}
