package com.smartparking.repository;

import com.smartparking.entity.ParkingSlot;
import com.smartparking.enums.SlotStatus;
import com.smartparking.enums.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import jakarta.persistence.LockModeType;
import java.util.List;
import java.util.Optional;

public interface ParkingSlotRepository extends JpaRepository<ParkingSlot, Long> {

    boolean existsBySlotNumber(String slotNumber);

    List<ParkingSlot> findByStatusAndVehicleType(
            SlotStatus status, VehicleType vehicleType);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT s FROM ParkingSlot s WHERE s.status = :status AND s.vehicleType = :type ORDER BY s.id")
    List<ParkingSlot> findAvailableSlotsForUpdate(
            @Param("status") SlotStatus status,
            @Param("type") VehicleType type);

    Optional<ParkingSlot> findBySlotNumber(String slotNumber);
}