package com.example.parkingmanagement.controller;

import com.example.parkingmanagement.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/summary")
    public ResponseEntity<String> getSummary() {
        long totalEntries = reportService.getTotalEntries();
        long totalExits = reportService.getTotalExits();
        return ResponseEntity.ok("Total Entries: " + totalEntries + ", Total Exits: " + totalExits);
    }


}
