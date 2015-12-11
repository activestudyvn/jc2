package com.dangnh.com.dangnh.core;

import com.dangnh.com.dangnh.model.Alert;
import com.dangnh.com.dangnh.model.Area;
import com.dangnh.com.dangnh.model.Position;
import com.dangnh.com.dangnh.model.Ship;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.BlockingQueue;

/**
 * Created by dangxunb on 10/12/2015.
 */
public class ProcessTask implements Runnable {
    private final static String alertInMsg = "Canh bao xam nhap vung";
    private final static String alertOutMsg = "Canh bao ra khoi vung";
    private final BlockingQueue<Position> positionsQueue;
    private final List<Area> areaList;
    private final BlockingQueue<Alert> alerts;
    private final List<Ship> shipList = new ArrayList<>();

    public ProcessTask(BlockingQueue<Position> positionsQueue, List<Area> areaList, BlockingQueue<Alert> alerts) {
        this.positionsQueue = positionsQueue;
        this.areaList = areaList;
        this.alerts = alerts;
    }

    public void run() {
        try {
            while (true) {
                Position position = positionsQueue.take();
                Optional<Ship> shipOptional = shipList
                        .stream()
                        .filter(ship -> ship.getMmsi().equals(position.getMmsi()))
                        .findAny();
                if (shipOptional.isPresent()) {
                    Ship ship = shipOptional.get();
                    Position lastShipPosition = ship.getPosition();
                    if (lastShipPosition == null){
                        for (Area area: areaList){
                            if (isInArea(area, position)){
                                ship.setArea(area);
                                ship.setPosition(position);
                                Alert alert = createAlert(ship,area,true);
                                alerts.put(alert);
                                break;
                            }
                        }
                    } else {
                        for (Area area: areaList){
                            if (isInArea(area, position)){
                                if (!ship.getArea().equals(area)){
                                    alerts.put(createAlert(ship, area,false));
                                    alerts.put(createAlert(ship, area, true));
                                    ship.setPosition(position);
                                    ship.setArea(area);
                                    break;
                                }
                            }
                        }
                    }
                } else {
                    Ship ship = new Ship(position.getMmsi());
                    for (Area area: areaList){
                        if (isInArea(area, position)){
                            ship.setPosition(position);
                            ship.setArea(area);
                            shipList.add(ship);
                            Alert alert = createAlert(ship,area,true);
                            alerts.put(alert);
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Check if the ship is in the area
     *
     * @param area the area to check
     * @param p    the Position to check
     * @return true if the ship is in the area
     */
    private boolean isInArea(Area area, Position p) {
        long shipLongitude = p.getLongitude();
        long shipLatitude = p.getLatitude();

        if (shipLongitude >= area.getLongLeft() && shipLongitude <= area.getLongRight()
                && shipLatitude >= area.getLatBottom() && shipLatitude <= area.getLatTop()) {
            return true;
        }
        return false;
    }

    /**
     * Create an alert object
     *
     * @param ship Alert's ship
     * @param area Alert's area
     * @param in   set this to true if the ship is going in the area, otherwise set to false
     * @return Alert
     */
    private Alert createAlert(Ship ship, Area area, boolean in) {
        String mmsi = ship.getMmsi();
        long longitude = ship.getPosition().getLongitude();
        long latitude = ship.getPosition().getLatitude();
        String areaName = in ? area.getAreaName() : ship.getArea().getAreaName();
        LocalDateTime time = ship.getPosition().getTime();
        String alertMsg = in ? alertInMsg : alertOutMsg;
        Alert alert = new Alert(mmsi, alertMsg, areaName, longitude, latitude, time);
        return alert;
    }
}
