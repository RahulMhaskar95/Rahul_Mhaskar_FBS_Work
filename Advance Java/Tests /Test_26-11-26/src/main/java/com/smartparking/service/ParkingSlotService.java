package com.smartparking.service;

import com.smartparking.dto.SlotRegistrationRequest;
import com.smartparking.entity.ParkingSlot;
import com.smartparking.enums.SlotStatus;
import com.smartparking.enums.VehicleType;
import com.smartparking.exception.ParkingException;
import com.smartparking.repository.ParkingSlotRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ParkingSlotService {

    private final ParkingSlotRepository parkingSlotRepository;

    public ParkingSlotService(ParkingSlotRepository parkingSlotRepository) {
        this.parkingSlotRepository = parkingSlotRepository;
    }

    @Transactional
    public ParkingSlot registerSlot(SlotRegistrationRequest request) {

        String slotNumber = request.getSlotNumber().trim().toUpperCase();

        if (parkingSlotRepository.existsBySlotNumber(slotNumber)) {
            throw new ParkingException("Slot number already exists");
        }

        ParkingSlot slot = new ParkingSlot(
                slotNumber,
                request.getVehicleType(),
                SlotStatus.AVAILABLE
        );

        return parkingSlotRepository.save(slot);
    }

    public List<ParkingSlot> getAvailableSlots(VehicleType type) {

        return parkingSlotRepository.findByStatusAndVehicleType(
                SlotStatus.AVAILABLE, type);
    }

    public List<ParkingSlot> getAllSlots() {
        return parkingSlotRepository.findAll();
    }
}