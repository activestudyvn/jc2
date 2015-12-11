package com.dangnh.com.dangnh.core;

import com.dangnh.com.dangnh.model.Position;
import com.dangnh.com.dangnh.model.Ship;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.regex.Pattern;

/**
 * Created by 404NotFound on 12/10/2015.
 */
public class ReadPositionTask implements Runnable, IReadOperation {
    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private static final Pattern pattern =
            Pattern.compile("\\d{7}\\|\\d+\\|\\d+\\|\\d{4}\\/\\d{2}\\/\\d{2} \\d{2}:\\d{2}:\\d{2}");
    private final BlockingQueue<Position> output;
    private final File inputFile;

    public ReadPositionTask(File inputFile, BlockingQueue<Position> output) {
        this.inputFile = inputFile;
        this.output = output;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.inputFile))) {
            String s;
            Position p;
            while (true){
                s = reader.readLine();
                if (s == null){
                    Thread.sleep(10000);
                }else {
                    if (isRightString(s)) {
                        p = parse(s);
                        output.put(p);
                    }
                }

                Thread.sleep(10);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Parse a ship from string
     *
     * @param s string to parse
     */
    public Position parse(String s) {
        String[] arr = s.split("\\|");
        String mmsi = arr[0];
        long longitude = Long.parseLong(arr[1]);
        long latitude = Long.parseLong(arr[2]);
        LocalDateTime time = LocalDateTime.parse(arr[3], formatter);
        return new Position(mmsi, longitude, latitude, time);
    }

    /**
     * Check if string is match pattern
     *
     * @param s String to check
     * @return true if string match
     */
    public boolean isRightString(String s) {
        return pattern.matcher(s).matches();
    }
}
