import smart_city_traffic_monitoring_system.model.VehicleEntry;
import smart_city_traffic_monitoring_system.service.VehicleEntryServices;
import smart_city_traffic_monitoring_system.utils.VehicleEntryReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class VehicleEntrySystemMain {
    public static void main(String[] args) throws IOException {
        String vehicleEntriesDataFilepath="22-05-CollectionsAndStreams/src/smart_city_traffic_monitoring_system/utils/vehicle_entries.csv";
        List<VehicleEntry> vehicleEntries= VehicleEntryReader.vehicleEntriesReader(vehicleEntriesDataFilepath);

        //vehicles that overstayed (more than 3 hours).
        System.out.println("vehicles that overstayed (more than 3 hours):");
        VehicleEntryServices.findOverstayedVehicles(vehicleEntries).forEach(System.out::println);
        System.out.println("-----------------------------------------------------");

        //total time spent by each vehicle grouped by location.
        System.out.println("total time spent by each vehicle grouped by location:");
        Map<String, Map<String, Double>> totalTimeSpentByVehicleGroupedByLocation= VehicleEntryServices.findTotalTimeSpentByVehicleGroupedByLocation(vehicleEntries);
        totalTimeSpentByVehicleGroupedByLocation.forEach((x,y)-> System.out.println("Location:"+x+"\ntotal time spent by vehicles:"+y.entrySet()));
    }
}