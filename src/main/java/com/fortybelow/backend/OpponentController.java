package com.fortybelow.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/")
public class OpponentController {
    @Autowired
    OpponentRepository repository;

    OpponentController(OpponentRepository repository) { this.repository = repository; }

    @GetMapping("/opponents")
    List<Opponent> all() {
        return repository.findAll();
    }

    @PostMapping("/opponents")
    Opponent newOpponent(@RequestBody Opponent newOpponent) {
        return repository.save(newOpponent);
    }

    @GetMapping("/opponents/{id}")
    Opponent one(@PathVariable Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Opponent with requested id not found: " + id));
    }

    @PutMapping("/opponents/{id}")
    Opponent replaceOpponent(@RequestBody Opponent newOpponent, @PathVariable Integer id) {

        return repository.findById(id)
                .map(opponent -> {
                    opponent.setTeam_name(newOpponent.getTeam_name());
                    return repository.save(opponent);
                })
                .orElseGet(() -> {
                    newOpponent.setId(id);
                    return repository.save(newOpponent);
                });
    }

    @DeleteMapping("/opponents/{id}")
    void deleteOpponent(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
