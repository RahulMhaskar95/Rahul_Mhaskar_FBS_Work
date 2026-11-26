package com.smartparking.controller;

import com.smartparking.dto.SlotRegistrationRequest;
import com.smartparking.entity.ParkingSlot;
import com.smartparking.enums.VehicleType;
import com.smartparking.service.ParkingSlotService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parking-slots")
public class ParkingSlotController {

    private final ParkingSlotService parkingSlotService;

    public ParkingSlotController(ParkingSlotService parkingSlotService) {
        this.parkingSlotService = parkingSlotService;
    }

    @PostMapping
    public ParkingSlot registerSlot(
            @Valid @RequestBody SlotRegistrationRequest request) {
        return parkingSlotService.registerSlot(request);
    }

    @GetMapping
    public List<ParkingSlot> getAllSlots() {
        return parkingSlotService.getAllSlots();
    }

    @GetMapping("/available")
    public List<ParkingSlot> getAvailableSlots(
            @RequestParam VehicleType type) {
        return parkingSlotService.getAvailableSlots(type);
    }
}