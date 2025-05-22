package smart_city_traffic_monitoring_system.model;

import java.time.LocalDateTime;

public class VehicleEntry {
    private String vehicleId;
    private String vehicleType;
    private String location;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;

    public VehicleEntry(String vehicleId, String vehicleType, String location, LocalDateTime entryTime, LocalDateTime exitTime) {
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
        this.location = location;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    @Override
    public String toString() {
        return
                "vehicleId='" + vehicleId +
                ", vehicleType='" + vehicleType +
                ", location='" + location +
                ", entryTime=" + entryTime +
                ", exitTime=" + exitTime ;
    }
}
