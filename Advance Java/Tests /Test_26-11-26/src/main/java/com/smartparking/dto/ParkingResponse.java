package com.smartparking.dto;

import java.time.LocalDateTime;

public class ParkingResponse {

    private String message;
    private String vehicleNumber;
    private String slotNumber;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private Long durationMinutes;
    private Double parkingFee;

    public ParkingResponse() {
    }

    public ParkingResponse(String message, String vehicleNumber,
                          String slotNumber, LocalDateTime entryTime,
                          LocalDateTime exitTime, Long durationMinutes,
                          Double parkingFee) {
        this.message = message;
        this.vehicleNumber = vehicleNumber;
        this.slotNumber = slotNumber;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.durationMinutes = durationMinutes;
        this.parkingFee = parkingFee;
    }

    public String getMessage() {
        return message;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getSlotNumber() {
        return slotNumber;
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
}