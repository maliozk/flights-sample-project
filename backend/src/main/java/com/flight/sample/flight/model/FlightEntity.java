package com.flight.sample.flight.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flights")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FlightEntity {
    @Id
    Long id;
    String number;
    String name;
}
