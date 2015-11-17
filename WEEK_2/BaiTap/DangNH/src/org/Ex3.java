package org;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Ex3 {
    static List<Double> airTempData = new ArrayList<>();
    static List<Double> windData = new ArrayList<>();
    public static void main(String[] args) throws MalformedURLException {
//        getFileData();
        long startTime = System.currentTimeMillis();
        getData();
        //Use new Java way with Map-Reduce to calculate average value in parallel
//        double windAvg = windData.parallelStream().mapToDouble(value -> value).average().getAsDouble();
//        double airTempAvg = airTempData.parallelStream().mapToDouble(value -> value).average().getAsDouble();
        double sum = 0;
        for (double wind: windData){
            sum += wind;
        }
        System.out.println("Average Wind Speed value: " + sum/windData.size());
        sum = 0;
        for (double air: airTempData){
            sum+=air;
        }
//        long endTime = System.currentTimeMillis();
        System.out.println("Average Wind Speed value: " + sum/airTempData.size());

//        long runTime = endTime - startTime;
//        System.out.println("Run Time: " + runTime + " milliseconds");
    }

    /**
     * Get data from specific URL to data.txt file
     *
     * @throws MalformedURLException when URL is invalid
     */
    static void getFileData() throws MalformedURLException {
        URL dataSource = new URL("http://lpo.dt.navy.mil/data/DM/Environmental_Data_Deep_Moor_2015.txt");
        try (BufferedInputStream inputStream = new BufferedInputStream(dataSource.openStream());
             BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("data.txt", false));
        ) {
            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write((char) c);
            }
        } catch (IOException e) {
            System.out.println("An I/O Error Occur:" + e.getMessage());
        }
    }

    /**
     * Get an array of Air Temp data
     *
     * @return List<Double>
     */
    static void getData() {
        File dataFile = new File("data.txt");
        try (BufferedReader data = new BufferedReader(new InputStreamReader(new FileInputStream(dataFile)))) {
            data.readLine();
            String inputLine;
            while ((inputLine = data.readLine()) != null) {
                airTempData.add(Double.parseDouble(inputLine.substring(20, 25)));
                windData.add(Double.parseDouble(inputLine.substring(56)));
            }
        } catch (IOException e) {
            System.out.println("An I/O Error Occur:" + e.getMessage());
        }
    }
}
