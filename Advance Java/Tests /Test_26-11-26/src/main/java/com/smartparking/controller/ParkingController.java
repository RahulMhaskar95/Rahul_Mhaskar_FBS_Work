package com.smartparking.controller;

import com.smartparking.dto.ParkingHistoryResponse;
import com.smartparking.dto.ParkingResponse;
import com.smartparking.dto.VehicleRequest;
import com.smartparking.service.ParkingService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parking")
public class ParkingController {

    private final ParkingService parkingService;

    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @PostMapping("/allocate")
    public ParkingResponse allocateSlot(
            @Valid @RequestBody VehicleRequest request) {
        return parkingService.allocateSlot(request);
    }

    @PostMapping("/release/{vehicleNumber}")
    public ParkingResponse releaseSlot(
            @PathVariable String vehicleNumber) {
        return parkingService.releaseSlot(vehicleNumber);
    }

    @GetMapping("/history/{vehicleNumber}")
    public List<ParkingHistoryResponse> getParkingHistory(
            @PathVariable String vehicleNumber) {
        return parkingService.getParkingHistory(vehicleNumber);
    }
}