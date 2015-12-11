package com.dangnh.com.dangnh.model;

import javax.swing.text.DateFormatter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by 404NotFound on 12/10/2015.
 */
public class Ship {
    private String mmsi;
    private Area area;
    private Position position;
    public Ship() {
    }

    public Ship(String mmsi) {
        this.mmsi = mmsi;
    }

    public String getMmsi() {
        return mmsi;
    }

    public void setMmsi(String mmsi) {
        this.mmsi = mmsi;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
