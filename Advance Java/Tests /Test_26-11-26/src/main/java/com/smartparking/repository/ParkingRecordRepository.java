package com.smartparking.repository;

import com.smartparking.entity.ParkingRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ParkingRecordRepository extends JpaRepository<ParkingRecord, Long> {

    boolean existsByVehicleNumberAndExitTimeIsNull(String vehicleNumber);

    Optional<ParkingRecord> findByVehicleNumberAndExitTimeIsNull(String vehicleNumber);

    List<ParkingRecord> findByVehicleNumberOrderByEntryTimeDesc(String vehicleNumber);
}