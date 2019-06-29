package com.fortybelow.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/")
class GameController {

    @Autowired
    GameRepository repository;

    GameController(GameRepository repository) {
        this.repository = repository;
    }

    // Aggregate root
    @GetMapping("/games")
    List<Game> all() {
        return repository.findAll();
    }

    @PostMapping("/games")
    Game newGame(@RequestBody Game newGame) {
        return repository.save(newGame);
    }

    @GetMapping("/games/{id}")
    Game one(@PathVariable Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Game with requested id not found: " + id));
    }

    @PutMapping("/games/{id}")
    Game replaceGame(@RequestBody Game newGame, @PathVariable Integer id) {

        return repository.findById(id)
                .map(game -> {
                    game.setDate(newGame.getDate());
                    game.setGame_order(newGame.getGame_order());
                    game.setLocation(newGame.getLocation());
                    game.setOpponent(newGame.getOpponent());
                    game.setResult(newGame.getResult());
                    game.setScore_them(newGame.getScore_them());
                    game.setScore_us(newGame.getScore_us());
                    return repository.save(game);
                })
                .orElseGet(() -> {
                    newGame.setId(id);
                    return repository.save(newGame);
                });
    }

    @DeleteMapping("/games/{id}")
    void deleteGame(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}