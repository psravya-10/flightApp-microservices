package com.flightapp.flight.service;

import com.flightapp.flight.dto.*;
import java.util.List;

public interface FlightService {
    String addInventory(AirlineInventoryRequest req);
    List<FlightSearchResponse> searchFlights(FlightSearchRequest req);
    FlightSearchResponse getFlightById(String id);
    void reserveSeats(String id, int seats);
    void releaseSeats(String id, int seats);
}
