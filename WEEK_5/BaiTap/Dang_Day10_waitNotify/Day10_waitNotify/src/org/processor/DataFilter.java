/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.processor;

import java.util.ArrayList;
import java.util.Iterator;
import org.common.AppLogger;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import util.MyQueue;

/**
 *
 * @author 404NotFound
 */
public class DataFilter implements Runnable {

    private static final Pattern pattern = Pattern.compile("84\\d+\\|[a-zA-Z0-9., ]+\\|[\\d//]+ [\\d:]+");
    private final MyQueue<String> inputData;
    private final MyQueue<String> successData;
    private final MyQueue<String> failedData;
    private static final String[] EXCEPT_WORD = {"fuck", "DCM", "shit"};

    public DataFilter(MyQueue<String> inputData, MyQueue<String> successData, MyQueue<String> failedData) {
        this.inputData = inputData;
        this.successData = successData;
        this.failedData = failedData;
    }

    @Override
    public void run() {
        String s = "";
        while (true) {
            s = inputData.poll();
            AppLogger.getInstance().debug("Checking String: " + s);
            long start = System.currentTimeMillis();
            if (pattern.matcher(s).matches() && !isStringContainsItemFromList(s, EXCEPT_WORD)) {
                AppLogger.getInstance().debug("Sucess String: " + s);
                System.out.println("Time: " + (System.currentTimeMillis() - start));
                successData.offer(s);
                System.out.println("Success data queue size: " + successData.size());
            } else {
                failedData.offer(s);
                System.out.println("Failed data queue size: " + failedData.size());
                System.out.println("Time: " + (System.currentTimeMillis() - start));
                AppLogger.getInstance().debug("Failed String: " + s);
            }
        }
    }

    private boolean isStringContainsItemFromList(String inputString, String[] items) {
        for (String item : items) {
            if (inputString.contains(item)) {
                return true;
            }
        }
        return false;
    }

}
