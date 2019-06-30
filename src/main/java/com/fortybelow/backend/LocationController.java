package com.fortybelow.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/")
public class LocationController {
    @Autowired
    LocationRepository repository;

    LocationController(LocationRepository repository){ this.repository = repository; }

    @GetMapping("/locations")
    List<Location> all() {
        return repository.findAll();
    }

    @PostMapping("/locations")
    Location newLocation(@RequestBody Location newLocation) {
        return repository.save(newLocation);
    }

    @GetMapping("/locations/{id}")
    Location one(@PathVariable Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Location with requested id not found: " + id));
    }

    @PutMapping("/locations/{id}")
    Location replaceGame(@RequestBody Location newLocation, @PathVariable Integer id) {

        return repository.findById(id)
                .map(location -> {
                    location.setLocation_name(newLocation.getLocation_name());
                    return repository.save(newLocation);
                })
                .orElseGet(() -> {
                    newLocation.setId(id);
                    return repository.save(newLocation);
                });
    }

    @DeleteMapping("/locations/{id}")
    void deleteLocation(@PathVariable Integer id) {
        repository.deleteById(id);
    }
 }
