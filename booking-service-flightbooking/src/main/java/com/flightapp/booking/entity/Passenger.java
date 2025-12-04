package com.flightapp.booking.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Passenger {
    private String name;
    private String gender;
    private int age;
}
