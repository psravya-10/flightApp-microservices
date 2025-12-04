package com.flightapp.flight.repository;

import com.flightapp.flight.entity.Airline;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface AirlineRepository extends MongoRepository<Airline, String> {
    Optional<Airline> findByNameIgnoreCase(String name);
}
