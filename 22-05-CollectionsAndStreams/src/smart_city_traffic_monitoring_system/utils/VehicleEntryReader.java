package smart_city_traffic_monitoring_system.utils;

import smart_city_traffic_monitoring_system.model.VehicleEntry;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class VehicleEntryReader {
    public static List<VehicleEntry> vehicleEntriesReader(String filepath) throws IOException {
        List<VehicleEntry>vehicleEntries=new ArrayList<>();
        String  line="";


        BufferedReader br=new BufferedReader(new FileReader(filepath));
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        br.readLine();
        while ((line=br.readLine())!=null)
        {
            String[] split= line.split(",");
            String vehicle_id=split[0];
            String vehicle_type=split[1];
            String location= split[2];
            LocalDateTime entry_time= LocalDateTime.parse(split[3], formatter);
            LocalDateTime exit_time= LocalDateTime.parse(split[4], formatter);
            VehicleEntry vehicleEntry=new VehicleEntry(vehicle_id,vehicle_type,location,entry_time,exit_time);
            vehicleEntries.add(vehicleEntry);

        }
        return vehicleEntries;
    }

}
