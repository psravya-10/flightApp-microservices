package com.flightapp.booking.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class PassengerDto {

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotBlank(message = "Gender cannot be empty")
    private String gender;

    @Min(value = 1, message = "Age must be positive")
    private int age;
}
