package com.flight.sample.flight.controller;

import com.flight.sample.flight.model.FlightEntity;
import com.flight.sample.flight.repository.FlightCrudRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.GET, RequestMethod.POST})
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

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    private Flux<FlightEntity> getAllEmployees() {
        return Flux.fromIterable(flightCrudRepository.findAll());
    }

    @PutMapping("/insert")
    private Mono<FlightEntity> insert(@RequestBody FlightEntity entity)
    {
        return Mono.just(flightCrudRepository.save(entity));
    }

    @DeleteMapping("/remove/{id}")
    private Mono<Boolean> remove(@PathVariable Long id)
    {
        flightCrudRepository.deleteById(id);
        return Mono.just(true);
    }

//    @PostMapping("/update")
//    private Mono<Flight> updateEmployee(@RequestBody Flight flight) {
//        return flightCrudRepository.updateFlight(flight);
//    }

}
