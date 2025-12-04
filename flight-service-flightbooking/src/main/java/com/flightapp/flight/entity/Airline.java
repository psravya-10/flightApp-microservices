package com.flightapp.flight.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "airlines")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Airline {
    @Id
    private String id;
    private String name;
}
