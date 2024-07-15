package com.example.parkingmanagement.repository;

import com.example.parkingmanagement.model.ParkingRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRecordRepository extends MongoRepository<ParkingRecord, String> {
    ParkingRecord findByVehicleIdAndExitTimeIsNull(String vehicleId);
    long countByExitTimeIsNull();
}
