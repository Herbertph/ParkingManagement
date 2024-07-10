package com.example.parkingmanagement.repository;

import com.example.parkingmanagement.model.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehicleRepository extends MongoRepository<Vehicle, String> {
}
