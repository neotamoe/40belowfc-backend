package com.fortybelow.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
class PlayerController {

    @Autowired
    PlayerRepository repository;

    PlayerController(PlayerRepository repository) {
        this.repository = repository;
    }

    // Aggregate root
    @GetMapping("/players")
    List<Player> all() {
        System.out.println("get all players hit me!");
        return repository.findAll();
    }

    @PostMapping("/players")
    Player newPlayer(@RequestBody Player newPlayer) {
        return repository.save(newPlayer);
    }

    @GetMapping("/players/{id}")
    Player one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException(id));
    }

    @PutMapping("/players/{id}")
    Player replacePlayer(@RequestBody Player newPlayer, @PathVariable Long id) {

        return repository.findById(id)
                .map(player -> {
                    player.setFirst_name(newPlayer.getFirst_name());
                    player.setLast_name(newPlayer.getLast_name());
                    player.setJersey_number(newPlayer.getJersey_number());
                    return repository.save(player);
                })
                .orElseGet(() -> {
                    newPlayer.setId(id);
                    return repository.save(newPlayer);
                });
    }

    @DeleteMapping("/players/{id}")
    void deletePlayer(@PathVariable Long id) {
        repository.deleteById(id);
    }
}