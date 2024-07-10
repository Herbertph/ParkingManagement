package com.example.parkingmanagement.repository;

import com.example.parkingmanagement.model.Establishment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstablishmentRepository extends MongoRepository<Establishment, String> {
}
