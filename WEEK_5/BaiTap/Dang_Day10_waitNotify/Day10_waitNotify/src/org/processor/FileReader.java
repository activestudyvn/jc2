/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.processor;

import org.common.AppLogger;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.MyQueue;

/**
 *
 * @author 404NotFound
 */
public class FileReader implements Runnable {

    private final String filePath;
    private final MyQueue<String> outputData;

    public FileReader(String filePath, MyQueue<String> outputData) {
        this.filePath = filePath;
        this.outputData = outputData;
    }

    @Override
    public void run() {
        File file = new File(filePath);
        AppLogger.getInstance().warm("Reading file" + filePath);
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            String s;
            while ((s = reader.readLine()) != null) {
                outputData.offer(s);
                System.out.println("Readed Queue size: " + outputData.size());
            }
        } catch (Exception e) {
            AppLogger.getInstance().error(e.getMessage());
        }
        AppLogger.getInstance().debug("File" + filePath + "readed");
    }
}
