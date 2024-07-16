package com.example.parkingmanagement.service;

import com.example.parkingmanagement.model.ParkingRecord;
import com.example.parkingmanagement.repository.ParkingRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService {

    @Autowired
    private ParkingRecordRepository parkingRecordRepository;

    public long getTotalEntries() {
        return parkingRecordRepository.countEntries();
    }

    public long getTotalExits() {
        return parkingRecordRepository.countExits();
    }


}
