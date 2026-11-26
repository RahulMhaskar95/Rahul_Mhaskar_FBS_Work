package com.smartparking.entity;

import com.smartparking.enums.VehicleType;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "parking_records")
public class ParkingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String vehicleNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VehicleType vehicleType;

    @ManyToOne
    @JoinColumn(name = "slot_id", nullable = false)
    private ParkingSlot parkingSlot;

    @Column(nullable = false)
    private LocalDateTime entryTime;

    private LocalDateTime exitTime;

    private Long durationMinutes;

    private Double parkingFee;

    public ParkingRecord() {
    }

    public ParkingRecord(String vehicleNumber, VehicleType vehicleType,
                        ParkingSlot parkingSlot, LocalDateTime entryTime) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.parkingSlot = parkingSlot;
        this.entryTime = entryTime;
    }

    public Long getId() {
        return id;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public Long getDurationMinutes() {
        return durationMinutes;
    }

    public Double getParkingFee() {
        return parkingFee;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public void setDurationMinutes(Long durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public void setParkingFee(Double parkingFee) {
        this.parkingFee = parkingFee;
    }
}