package com.flight.sample.flight.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "flightsNew")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FlightEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    int number;
    String name;
    Instant date = Instant.now();
}
