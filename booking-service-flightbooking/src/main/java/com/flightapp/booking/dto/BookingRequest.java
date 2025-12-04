package com.flightapp.booking.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class BookingRequest {

    @NotBlank(message = "Customer name is required")
    private String customerName;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    @Min(value = 1, message = "Number of seats must be positive")
    private int numberOfSeats;

    @NotNull(message = "Journey date is required")
    private LocalDate journeyDate;

    @Valid
    @NotEmpty(message = "Passengers cannot be empty")
    private List<PassengerDto> passengers;

    @NotBlank(message = "Seat numbers cannot be empty")
    private String seatNumbers;

    @NotBlank(message = "Meal preference is required")
    private String mealPreference;
}
