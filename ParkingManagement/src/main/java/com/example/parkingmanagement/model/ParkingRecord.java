package com.example.parkingmanagement.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "parkingRecords")
public class ParkingRecord {

    @Id
    private String id;
    private String vehicleId;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;

    public ParkingRecord() {}

    public ParkingRecord(String vehicleId, LocalDateTime entryTime) {
        this.vehicleId = vehicleId;
        this.entryTime = entryTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }
}
