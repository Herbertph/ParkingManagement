package com.example.parkingmanagement.service;

import com.example.parkingmanagement.exception.ResourceNotFoundException;
import com.example.parkingmanagement.model.Vehicle;
import com.example.parkingmanagement.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    // Create
    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    // Read all
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    // Read by ID
    public Optional<Vehicle> getVehicleById(String id) {
        return vehicleRepository.findById(id);
    }

    // Update
    public Vehicle updateVehicle(String id, Vehicle vehicle) {
        if (vehicleRepository.existsById(id)) {
            vehicle.setId(id);
            return vehicleRepository.save(vehicle);
        } else {
            throw new ResourceNotFoundException("Vehicle not found with id " + id);
        }
    }

    // Delete
    public void deleteVehicle(String id) {
        if (vehicleRepository.existsById(id)) {
            vehicleRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Vehicle not found with id " + id);
        }
    }
}
