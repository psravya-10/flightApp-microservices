package com.flightapp.flight.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "flights")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight {

    @Id
    private String id;

    private String fromPlace;
    private String toPlace;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String tripType;
    private double priceOneWay;
    private Double priceRoundTrip;
    private int totalSeats;
    private int availableSeats;

    private String airlineId;
    private String airlineName;

    @Version
    private Long version;
}
