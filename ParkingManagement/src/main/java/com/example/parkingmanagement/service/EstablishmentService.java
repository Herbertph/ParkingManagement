package com.example.parkingmanagement.service;

import com.example.parkingmanagement.exception.ResourceNotFoundException;
import com.example.parkingmanagement.model.Establishment;
import com.example.parkingmanagement.repository.EstablishmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstablishmentService {

    @Autowired
    private EstablishmentRepository establishmentRepository;

    // Create
    public Establishment createEstablishment(Establishment establishment) {
        return establishmentRepository.save(establishment);
    }

    // Read
    public List<Establishment> getAllEstablishments() {
        return establishmentRepository.findAll();
    }

    public Optional<Establishment> getEstablishmentById(String id) {
        return establishmentRepository.findById(id);
    }

    // Update
    public Establishment updateEstablishment(String id, Establishment establishment) {
        if (establishmentRepository.existsById(id)) {
            establishment.setId(id);
            return establishmentRepository.save(establishment);
        } else {
            throw new ResourceNotFoundException("Establishment not found with id " + id);
        }
    }

    // Delete
    public void deleteEstablishment(String id) {
        if (establishmentRepository.existsById(id)) {
            establishmentRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Establishment not found with id " + id);
        }
    }
}
