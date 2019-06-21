package com.fortybelow.backend;

public class PlayerNotFoundException extends RuntimeException {

    PlayerNotFoundException(Long id) {
        super("Could not find player " + id);
    }
}
