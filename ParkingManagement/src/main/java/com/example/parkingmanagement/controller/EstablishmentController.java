package com.example.parkingmanagement.controller;

import com.example.parkingmanagement.model.Establishment;
import com.example.parkingmanagement.service.EstablishmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/establishments")
public class EstablishmentController {

    @Autowired
    private EstablishmentService establishmentService;

    // Create
    @PostMapping
    public ResponseEntity<Establishment> createEstablishment(@Valid @RequestBody Establishment establishment) {
        Establishment createdEstablishment = establishmentService.createEstablishment(establishment);
        return ResponseEntity.ok(createdEstablishment);
    }

    // Read all
    @GetMapping
    public ResponseEntity<List<Establishment>> getAllEstablishments() {
        List<Establishment> establishments = establishmentService.getAllEstablishments();
        return ResponseEntity.ok(establishments);
    }

    // Read by ID
    @GetMapping("/{id}")
    public ResponseEntity<Establishment> getEstablishmentById(@PathVariable String id) {
        return establishmentService.getEstablishmentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Establishment> updateEstablishment(@PathVariable String id, @RequestBody Establishment establishment) {
        Establishment updatedEstablishment = establishmentService.updateEstablishment(id, establishment);
        if (updatedEstablishment != null) {
            return ResponseEntity.ok(updatedEstablishment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstablishment(@PathVariable String id) {
        establishmentService.deleteEstablishment(id);
        return ResponseEntity.noContent().build();
    }
}
