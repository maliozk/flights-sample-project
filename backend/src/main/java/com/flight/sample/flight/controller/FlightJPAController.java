package com.flight.sample.flight.controller;

import com.flight.sample.flight.model.Flight;
import com.flight.sample.flight.model.FlightEntity;
import com.flight.sample.flight.repository.FlightCrudRepository;
import com.flight.sample.flight.repository.FlightRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/fl")
public class FlightJPAController {

    private final FlightCrudRepository flightCrudRepository;

    public FlightJPAController(FlightCrudRepository flightCrudRepository) {
        this.flightCrudRepository = flightCrudRepository;
    }

    @GetMapping("/{id}")
    private Mono<FlightEntity> getFlightById(@PathVariable Long id) {
        return Mono.justOrEmpty(flightCrudRepository.findById(id));
    }

    @GetMapping
    private Flux<FlightEntity> getAllEmployees() {
        return Flux.fromIterable(flightCrudRepository.findAll());
    }

    @GetMapping("/insert/{id}")
    private Mono<FlightEntity> insert(@PathVariable Long id)
    {
        return Mono.just(flightCrudRepository.save(new FlightEntity(id, "name " + id, "number " + id)));
    }

//    @PostMapping("/update")
//    private Mono<Flight> updateEmployee(@RequestBody Flight flight) {
//        return flightCrudRepository.updateFlight(flight);
//    }

}
