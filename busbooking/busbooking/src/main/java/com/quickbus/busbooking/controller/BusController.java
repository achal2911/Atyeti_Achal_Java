package com.quickbus.busbooking.controller;


import com.quickbus.busbooking.dto.SearchRequest;
import com.quickbus.busbooking.entity.Bus;
import com.quickbus.busbooking.entity.Route;
import com.quickbus.busbooking.entity.Schedule;
import com.quickbus.busbooking.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buses")
public class BusController {

    @Autowired
    private BusService busService;

    @GetMapping("/get-all-buses")
    public List<Bus> getAllBuses() {
        return busService.getAllBuses();
    }

    @GetMapping("/get-all-schedules")
    public List<Schedule> getAllSchedules() {
        return busService.getAllSchedule();
    }

    @GetMapping("/get-all-routes")
    public List<Route> getAllRoutes() {
        return busService.getAllRoutes();
    }

    @PostMapping("/add-route")
    public Route addRoute(@RequestBody Route route) {
        return busService.addRoute(route);
    }

    @PostMapping("/add-bus")
    public Bus addBus(@RequestBody Bus bus) {
        return busService.addBus(bus);
    }

    @PostMapping("/add-schedule")
    public Schedule addSchedule(@RequestBody Schedule schedule) {
        return busService.addSchedule(schedule);
    }

    @PostMapping("/search")
    public ResponseEntity<List<Schedule>> searchBuses(@RequestBody SearchRequest request) {
        List<Schedule> schedules = busService.searchBuses(request);
        return ResponseEntity.ok(schedules);
    }
}

