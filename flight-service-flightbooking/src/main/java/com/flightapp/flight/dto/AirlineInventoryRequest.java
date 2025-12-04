package com.flightapp.flight.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AirlineInventoryRequest {

    @NotBlank(message = "Airline name cannot be blank")
    private String airlineName;

    @NotBlank(message = "From place cannot be blank")
    private String fromPlace;

    @NotBlank(message = "To place cannot be blank")
    private String toPlace;

    @NotNull(message = "Departure time is required")
    private LocalDateTime departureTime;

    @NotNull(message = "Arrival time is required")
    private LocalDateTime arrivalTime;

    @NotBlank(message = "Trip type cannot be blank")
    private String tripType;

    @Min(value = 1, message = "One-way price must be positive")
    private double priceOneWay;

    private Double priceRoundTrip;

    @Min(value = 1, message = "Total seats must be positive")
    private int totalSeats;
}
