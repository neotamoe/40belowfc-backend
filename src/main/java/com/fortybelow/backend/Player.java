package com.fortybelow.backend;

import lombok.Data;

@Data
public class Player {
    String firstName;
    String lastName;
    Integer number;
    String position;

    String getFullName() {
        return firstName + " " + lastName;
    }
}
