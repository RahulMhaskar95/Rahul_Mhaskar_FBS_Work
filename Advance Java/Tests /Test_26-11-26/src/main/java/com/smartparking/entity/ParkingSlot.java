package com.smartparking.entity;

import com.smartparking.enums.SlotStatus;
import com.smartparking.enums.VehicleType;
import jakarta.persistence.*;

@Entity
@Table(name = "parking_slots")
public class ParkingSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String slotNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VehicleType vehicleType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SlotStatus status;

    public ParkingSlot() {
    }

    public ParkingSlot(String slotNumber, VehicleType vehicleType, SlotStatus status) {
        this.slotNumber = slotNumber;
        this.vehicleType = vehicleType;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(String slotNumber) {
        this.slotNumber = slotNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public SlotStatus getStatus() {
        return status;
    }

    public void setStatus(SlotStatus status) {
        this.status = status;
    }
}