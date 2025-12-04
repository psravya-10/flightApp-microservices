package com.flightapp.flight.repository;

import com.flightapp.flight.entity.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface FlightRepository extends MongoRepository<Flight, String> {

    List<Flight> findByFromPlaceIgnoreCaseAndToPlaceIgnoreCaseAndDepartureTimeBetweenAndTripTypeIgnoreCase(
            String fromPlace,
            String toPlace,
            LocalDateTime start,
            LocalDateTime end,
            String tripType
    );

    Optional<Flight> findByAirlineIdAndFromPlaceIgnoreCaseAndToPlaceIgnoreCaseAndDepartureTime(
            String airlineId,
            String fromPlace,
            String toPlace,
            LocalDateTime departureTime
    );
}
