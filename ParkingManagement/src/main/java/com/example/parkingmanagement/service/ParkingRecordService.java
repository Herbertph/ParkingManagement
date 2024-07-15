package com.example.parkingmanagement.service;

import com.example.parkingmanagement.model.ParkingRecord;
import com.example.parkingmanagement.model.VehicleType;
import com.example.parkingmanagement.repository.ParkingRecordRepository;
import com.example.parkingmanagement.repository.EstablishmentRepository;
import com.example.parkingmanagement.repository.VehicleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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
        // Verificar a capacidade do estacionamento
        long vehicleCount = parkingRecordRepository.countByExitTimeIsNull();
        long carCapacity = establishmentRepository.findById(establishmentId).get().getCarSpots();
        long motorcycleCapacity = establishmentRepository.findById(establishmentId).get().getMotorcycleSpots();

        if (vehicleRepository.findById(vehicleId).get().getType() == VehicleType.CAR && vehicleCount < carCapacity ||
                vehicleRepository.findById(vehicleId).get().getType() == VehicleType.MOTORCYCLE && vehicleCount < motorcycleCapacity) {
            ParkingRecord parkingRecord = new ParkingRecord(vehicleId, LocalDateTime.now());
            return parkingRecordRepository.save(parkingRecord);
        } else {
            throw new IllegalStateException("Parking lot is full");
        }
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
