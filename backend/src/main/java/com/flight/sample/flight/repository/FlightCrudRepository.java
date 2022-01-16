package com.flight.sample.flight.repository;

import com.flight.sample.flight.model.FlightEntity;
import org.springframework.data.repository.CrudRepository;

public interface FlightCrudRepository extends CrudRepository<FlightEntity, Long> {
}
