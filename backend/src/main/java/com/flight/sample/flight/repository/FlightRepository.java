package com.flight.sample.flight.repository;
import com.flight.sample.flight.model.Flight;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Repository
public class FlightRepository {
    static Map<String, Flight> FlightData;

    static Map<String, String> FlightAccessData;

    static {
        FlightData = new HashMap<>();
        FlightData.put("1", new Flight("1", "Flight 1"));
        FlightData.put("2", new Flight("2", "Flight 2"));
        FlightData.put("3", new Flight("3", "Flight 3"));
        FlightData.put("4", new Flight("4", "Flight 4"));
        FlightData.put("5", new Flight("5", "Flight 5"));
        FlightData.put("6", new Flight("6", "Flight 6"));
        FlightData.put("7", new Flight("7", "Flight 7"));
        FlightData.put("8", new Flight("8", "Flight 8"));
        FlightData.put("9", new Flight("9", "Flight 9"));
        FlightData.put("10", new Flight("10", "Flight 10"));

        FlightAccessData = new HashMap<>();
        FlightAccessData.put("1", "Flight 1 Access Key");
        FlightAccessData.put("2", "Flight 2 Access Key");
        FlightAccessData.put("3", "Flight 3 Access Key");
        FlightAccessData.put("4", "Flight 4 Access Key");
        FlightAccessData.put("5", "Flight 5 Access Key");
        FlightAccessData.put("6", "Flight 6 Access Key");
        FlightAccessData.put("7", "Flight 7 Access Key");
        FlightAccessData.put("8", "Flight 8 Access Key");
        FlightAccessData.put("9", "Flight 9 Access Key");
        FlightAccessData.put("10", "Flight 10 Access Key");
    }

    public Mono<Flight> findFlightById(String id) {
        return Mono.just(FlightData.get(id));
    }

    public Flux<Flight> findAllFlights() {
        return Flux.fromIterable(FlightData.values());
    }

    public Mono<Flight> updateFlight(Flight Flight) {
        Flight existingFlight = FlightData.get(Flight.getNumber());
        if (existingFlight != null) {
            existingFlight.setName(Flight.getName());
        }
        return Mono.just(existingFlight);
    }
}
