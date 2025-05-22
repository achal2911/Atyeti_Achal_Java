package smart_city_traffic_monitoring_system.service;

import smart_city_traffic_monitoring_system.model.VehicleEntry;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VehicleEntryServices {

    //
    public static List<VehicleEntry> findOverstayedVehicles(List<VehicleEntry> vehicleEntries) {
        List<VehicleEntry> listOfOverStayedVehicles= vehicleEntries.stream().filter(vehicle ->
        {
            Duration duration = Duration.between(vehicle.getEntryTime(), vehicle.getExitTime());
            return duration.toHours() > 3;
        }).toList();

        return listOfOverStayedVehicles;
    }

    public static  Map<String, Map<String, Double>> findTotalTimeSpentByVehicleGroupedByLocation(List<VehicleEntry> vehicleEntries) {
        Map<String, Map<String, Double>> totalTimeSpentByVehicle= vehicleEntries.stream().collect(Collectors.groupingBy(VehicleEntry::getLocation,
                Collectors.groupingBy(VehicleEntry::getVehicleId,
                        Collectors.summingDouble(vehicle ->
                                Duration.between(vehicle.getEntryTime(), vehicle.getExitTime()).toHours()))));

        return totalTimeSpentByVehicle;
    }
}
