package com.example.parkingmanagement.service;

import com.example.parkingmanagement.model.Establishment;
import com.example.parkingmanagement.model.ParkingRecord;
import com.example.parkingmanagement.model.Vehicle;
import com.example.parkingmanagement.model.VehicleType;
import com.example.parkingmanagement.repository.ParkingRecordRepository;
import com.example.parkingmanagement.repository.EstablishmentRepository;
import com.example.parkingmanagement.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParkingRecordService {

    @Autowired
    private ParkingRecordRepository parkingRecordRepository;

    @Autowired
    private EstablishmentRepository establishmentRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    // Register entry
    public ParkingRecord registerEntry(String vehicleId, String establishmentId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(() -> new IllegalStateException("Vehicle not found"));
        Establishment establishment = establishmentRepository.findById(establishmentId).orElseThrow(() -> new IllegalStateException("Establishment not found"));

        long currentCarCount = parkingRecordRepository.countByExitTimeIsNullAndVehicleType(VehicleType.CAR);
        long currentMotorcycleCount = parkingRecordRepository.countByExitTimeIsNullAndVehicleType(VehicleType.MOTORCYCLE);

        if (vehicle.getType() == VehicleType.CAR && currentCarCount >= establishment.getCarSpots()) {
            throw new IllegalStateException("Car parking spots are full");
        } else if (vehicle.getType() == VehicleType.MOTORCYCLE && currentMotorcycleCount >= establishment.getMotorcycleSpots()) {
            throw new IllegalStateException("Motorcycle parking spots are full");
        }

        ParkingRecord parkingRecord = new ParkingRecord(vehicleId, LocalDateTime.now());
        return parkingRecordRepository.save(parkingRecord);
    }

    // Register exit
    public ParkingRecord registerExit(String vehicleId) {
        ParkingRecord parkingRecord = parkingRecordRepository.findByVehicleIdAndExitTimeIsNull(vehicleId);
        if (parkingRecord != null) {
            parkingRecord.setExitTime(LocalDateTime.now());
            return parkingRecordRepository.save(parkingRecord);
        } else {
            throw new IllegalStateException("Vehicle not found in parking lot");
        }
    }

    public List<ParkingRecord> getAllRecords() {
        return parkingRecordRepository.findAll();
    }
}
