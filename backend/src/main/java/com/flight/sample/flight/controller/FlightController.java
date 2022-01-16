package com.flight.sample.flight.controller;

        import com.flight.sample.flight.model.Flight;
        import com.flight.sample.flight.repository.FlightRepository;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.RequestBody;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;
        import reactor.core.publisher.Flux;
        import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/flight")
public class FlightController {

    private final FlightRepository employeeRepository;

    public FlightController(FlightRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/{id}")
    private Mono<Flight> getFlightById(@PathVariable String id) {
        return employeeRepository.findFlightById(id);
    }

    @GetMapping
    private Flux<Flight> getAllEmployees() {
        return employeeRepository.findAllFlights();
    }

    @PostMapping("/update")
    private Mono<Flight> updateEmployee(@RequestBody Flight flight) {
        return employeeRepository.updateFlight(flight);
    }

}
