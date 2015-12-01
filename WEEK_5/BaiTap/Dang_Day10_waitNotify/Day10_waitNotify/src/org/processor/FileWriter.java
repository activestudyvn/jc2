/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.processor;

import org.common.AppLogger;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import util.MyQueue;

/**
 *
 * @author 404NotFound
 */
public class FileWriter implements Runnable {

    private final String filePath;
    private final MyQueue<String> data;
    private final File file;

    public FileWriter(String filePath, MyQueue<String> data) {
        this.filePath = filePath;
        this.data = data;
        this.file = new File(filePath);
    }

    @Override
    public void run() {
        while (true) {
            try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(file, true))) {
                String s = data.poll();
                AppLogger.getInstance().debug("Writing data to file: " + filePath);
                writer.write(s);
//                System.out.println("Number of item writen: " + count);
            } catch (IOException ex) {
                AppLogger.getInstance().error(ex.getMessage());
            }
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                AppLogger.getInstance().error(ex.getMessage());
            }
        }
    }
}


