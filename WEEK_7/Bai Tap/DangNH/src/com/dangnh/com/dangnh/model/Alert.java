package com.dangnh.com.dangnh.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by 404NotFound on 12/10/2015.
 */
public class Alert {
    private String mmsi;
    private String alertMsg;
    private String areaName;
    private long longtitude;
    private long latitude;
    private LocalDateTime time;
    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    public Alert() {
    }

    public Alert(String mmsi, String alertMsg, String areaName,
                 long longtitude, long latitude, LocalDateTime time) {
        this.mmsi = mmsi;
        this.alertMsg = alertMsg;
        this.areaName = areaName;
        this.longtitude = longtitude;
        this.latitude = latitude;
        this.time = time;
    }

    public String getMmsi() {
        return mmsi;
    }

    public String getAlertMsg() {
        return alertMsg;
    }

    public String getAreaName() {
        return areaName;
    }

    public long getLongtitude() {
        return longtitude;
    }

    public long getLatitude() {
        return latitude;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String toString(){
        return new StringBuilder(this.mmsi)
                .append("|").append(this.alertMsg)
                .append("|").append(this.areaName)
                .append("|").append(this.longtitude)
                .append("|").append(this.latitude)
                .append("|").append(this.time.format(formatter))
                .toString();
    }
}
