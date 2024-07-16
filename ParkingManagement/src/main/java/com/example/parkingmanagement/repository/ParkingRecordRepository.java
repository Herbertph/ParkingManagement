package com.example.parkingmanagement.repository;

import com.example.parkingmanagement.model.ParkingRecord;
import com.example.parkingmanagement.model.VehicleType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ParkingRecordRepository extends MongoRepository<ParkingRecord, String> {
    ParkingRecord findByVehicleIdAndExitTimeIsNull(String vehicleId);

    @Query(value = "{ 'entryTime': { $ne: null } }", count = true)
    long countEntries();

    @Query(value = "{ 'exitTime': { $ne: null } }", count = true)
    long countExits();

    @Query(value = "{ 'exitTime': null, 'vehicle.type': ?0 }", count = true)
    long countByExitTimeIsNullAndVehicleType(VehicleType vehicleType);

}
