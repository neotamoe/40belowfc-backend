package com.fortybelow.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/")
public class SeasonController {

    @Autowired
    SeasonRepository repository;

    SeasonController(SeasonRepository repository) {
        this.repository = repository;
    }

    // Aggregate root
    @GetMapping("/seasons")
    List<Season> all() {
        return repository.findAll();
    }

    @PostMapping("/seasons")
    Season newSeason(@RequestBody Season newSeason) {
        return repository.save(newSeason);
    }

    @GetMapping("/seasons/{id}")
    Season one(@PathVariable Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Season with requested id not found: " + id));
    }

    @PutMapping("/seasons/{id}")
    Season replaceSeason(@RequestBody Season newSeason, @PathVariable Integer id) {

        return repository.findById(id)
                .map(season -> {
                    season.setMonth_start(newSeason.getMonth_start());
                    season.setYear(newSeason.getYear());
                    return repository.save(season);
                })
                .orElseGet(() -> {
                    newSeason.setId(id);
                    return repository.save(newSeason);
                });
    }

    @DeleteMapping("/seasons/{id}")
    void deleteSeason(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
