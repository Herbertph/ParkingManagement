package com.example.parkingmanagement.controller;

import com.example.parkingmanagement.model.ParkingRecord;
import com.example.parkingmanagement.service.ParkingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parkingRecords")
public class ParkingRecordController {

    @Autowired
    private ParkingRecordService parkingRecordService;

    @PostMapping("/entry")
    public ResponseEntity<ParkingRecord> registerEntry(@RequestParam String vehicleId, @RequestParam String establishmentId) {
        ParkingRecord parkingRecord = parkingRecordService.registerEntry(vehicleId, establishmentId);
        return ResponseEntity.ok(parkingRecord);
    }

    @PostMapping("/exit")
    public ResponseEntity<ParkingRecord> registerExit(@RequestParam String vehicleId) {
        ParkingRecord parkingRecord = parkingRecordService.registerExit(vehicleId);
        return ResponseEntity.ok(parkingRecord);
    }

    @GetMapping
    public ResponseEntity<List<ParkingRecord>> getAllRecords() {
        List<ParkingRecord> records = parkingRecordService.getAllRecords();
        return ResponseEntity.ok(records);
    }
}
