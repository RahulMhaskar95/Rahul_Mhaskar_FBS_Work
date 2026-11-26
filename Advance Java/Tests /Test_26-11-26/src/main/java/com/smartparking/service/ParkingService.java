package com.smartparking.service;

import com.smartparking.dto.ParkingHistoryResponse;
import com.smartparking.dto.ParkingResponse;
import com.smartparking.dto.VehicleRequest;
import com.smartparking.entity.ParkingRecord;
import com.smartparking.entity.ParkingSlot;
import com.smartparking.enums.SlotStatus;
import com.smartparking.enums.VehicleType;
import com.smartparking.exception.ParkingException;
import com.smartparking.repository.ParkingRecordRepository;
import com.smartparking.repository.ParkingSlotRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ParkingService {

    private final ParkingSlotRepository parkingSlotRepository;
    private final ParkingRecordRepository parkingRecordRepository;

    public ParkingService(ParkingSlotRepository parkingSlotRepository,
                          ParkingRecordRepository parkingRecordRepository) {
        this.parkingSlotRepository = parkingSlotRepository;
        this.parkingRecordRepository = parkingRecordRepository;
    }

    @Transactional
    public ParkingResponse allocateSlot(VehicleRequest request) {

        String vehicleNumber = request.getVehicleNumber()
                .trim().toUpperCase();

        if (parkingRecordRepository.existsByVehicleNumberAndExitTimeIsNull(
                vehicleNumber)) {
            throw new ParkingException("Vehicle is already parked");
        }

        List<ParkingSlot> availableSlots =
                parkingSlotRepository.findAvailableSlotsForUpdate(
                        SlotStatus.AVAILABLE,
                        request.getVehicleType());

        if (availableSlots.isEmpty()) {
            throw new ParkingException("No available slot for vehicle type");
        }

        ParkingSlot slot = availableSlots.get(0);

        slot.setStatus(SlotStatus.OCCUPIED);

        LocalDateTime entryTime = LocalDateTime.now();

        ParkingRecord record = new ParkingRecord(
                vehicleNumber,
                request.getVehicleType(),
                slot,
                entryTime
        );

        parkingSlotRepository.save(slot);
        parkingRecordRepository.save(record);

        return new ParkingResponse(
                "Parking allocated successfully",
                vehicleNumber,
                slot.getSlotNumber(),
                entryTime,
                null,
                null,
                null
        );
    }

    @Transactional
    public ParkingResponse releaseSlot(String vehicleNumber) {

        vehicleNumber = vehicleNumber.trim().toUpperCase();

        ParkingRecord record = parkingRecordRepository
                .findByVehicleNumberAndExitTimeIsNull(vehicleNumber)
                .orElseThrow(() ->
                        new ParkingException("Vehicle is not currently parked"));

        LocalDateTime exitTime = LocalDateTime.now();

        long durationMinutes = Duration.between(
                record.getEntryTime(), exitTime).toMinutes();

        long totalHours = Math.max(1,
                (long) Math.ceil(Duration.between(
                        record.getEntryTime(), exitTime).toSeconds() / 3600.0));

        double fee = calculateFee(record.getVehicleType(), totalHours);

        record.setExitTime(exitTime);
        record.setDurationMinutes(durationMinutes);
        record.setParkingFee(fee);

        ParkingSlot slot = record.getParkingSlot();
        slot.setStatus(SlotStatus.AVAILABLE);

        parkingRecordRepository.save(record);
        parkingSlotRepository.save(slot);

        return new ParkingResponse(
                "Parking released successfully",
                record.getVehicleNumber(),
                slot.getSlotNumber(),
                record.getEntryTime(),
                exitTime,
                durationMinutes,
                fee
        );
    }

    private double calculateFee(VehicleType vehicleType, long totalHours) {

        long additionalHours = Math.max(0, totalHours - 1);

        if (vehicleType == VehicleType.TWO_WHEELER) {
            return 20 + additionalHours * 10;
        }

        return 50 + additionalHours * 30;
    }

    public List<ParkingHistoryResponse> getParkingHistory(
            String vehicleNumber) {

        vehicleNumber = vehicleNumber.trim().toUpperCase();

        List<ParkingRecord> records =
                parkingRecordRepository.findByVehicleNumberOrderByEntryTimeDesc(
                        vehicleNumber);

        return records.stream()
                .map(record -> new ParkingHistoryResponse(
                        record.getVehicleNumber(),
                        record.getVehicleType().name(),
                        record.getParkingSlot().getSlotNumber(),
                        record.getEntryTime(),
                        record.getExitTime(),
                        record.getDurationMinutes(),
                        record.getParkingFee()
                ))
                .toList();
    }
}