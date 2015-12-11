package com.dangnh.com.dangnh.core;

import com.dangnh.com.dangnh.model.Alert;

import java.io.*;
import java.util.concurrent.BlockingQueue;

/**
 * Created by dangxunb on 10/12/2015.
 */
public class WriteTask implements Runnable {
    private final BlockingQueue<Alert> alertQueue;
    private final File file;
    private StringBuilder sBuilder = new StringBuilder();
    public WriteTask(BlockingQueue<Alert> alertQueue, File file) {
        this.alertQueue = alertQueue;
        this.file = file;
    }

    @Override
    public void run() {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            Alert alert;
            while (true){
                while ((alert = alertQueue.poll()) != null){
                    sBuilder.append(alert.toString() + "\n");
                }
                writer.write(sBuilder.toString());
                writer.flush();
                sBuilder = new StringBuilder();
                Thread.sleep(500);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
