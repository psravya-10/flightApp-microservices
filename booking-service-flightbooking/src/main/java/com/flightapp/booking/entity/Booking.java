package com.flightapp.booking.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "bookings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    private String id;

    private String pnr;
    private String customerName;
    private String email;
    private int numberOfSeats;
    private String seatNumbers;
    private String mealPreference;
    private boolean cancelled;
    private LocalDate journeyDate;
    private LocalDateTime bookingTime;
    private String flightId;
    private List<Passenger> passengers;
}
