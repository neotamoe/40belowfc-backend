package com.fortybelow.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/")
public class ResultController {

    @Autowired
    ResultRepository repository;

    ResultController(ResultRepository repository) { this.repository = repository; }

    @GetMapping("/results")
    List<Result> all() {
        return repository.findAll();
    }

    @GetMapping("/results/{id}")
    Result one(@PathVariable Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Result with requested id not found: " + id));
    }

}
