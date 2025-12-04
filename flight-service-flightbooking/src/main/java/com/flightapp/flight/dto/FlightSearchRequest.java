package com.flightapp.flight.dto;

import lombok.Data;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Data
public class FlightSearchRequest {

    @NotBlank(message = "From place cannot be blank")
    private String fromPlace;

    @NotBlank(message = "To place cannot be blank")
    private String toPlace;

    @NotNull(message = "Journey date required")
    private LocalDate journeyDate;

    @NotBlank(message = "Trip type cannot be blank")
    private String tripType;
}
