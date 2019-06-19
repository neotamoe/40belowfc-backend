package com.fortybelow.backend;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Player {
    private @Id @GeneratedValue Long id;
    private String firstName;
    private String lastName;
    private Integer number;

    Player() {}

    Player(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    Player(String firstName, String lastName, Integer number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
    }

    String getFullName() {
        return firstName + " " + lastName;
    }
}
