package com.fortybelow.backend;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class PlayerController {

    private final PlayerRepository repository;

    PlayerController(PlayerRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/players")
    List<Player> all() {
        return repository.findAll();
    }

    @PostMapping("/players")
    Player newPlayer(@RequestBody Player newPlayer) {
        return repository.save(newPlayer);
    }

    // Single item

//    @GetMapping("/players/{id}")
//    Player one(@PathVariable Long id) {
//
//        return repository.findById(id)
//                .orElseThrow(() -> new PlayerNotFoundException(id));
//    }

    @PutMapping("/players/{id}")
    Player replacePlayer(@RequestBody Player newPlayer, @PathVariable Long id) {

        return repository.findById(id)
                .map(player -> {
                    player.setFirstName(newPlayer.getFirstName());
                    player.setLastName(newPlayer.getLastName());
                    player.setNumber(newPlayer.getNumber());
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