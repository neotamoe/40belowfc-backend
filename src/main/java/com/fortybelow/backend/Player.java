package com.fortybelow.backend;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Player {
    @Id
    @GeneratedValue Long id;
    String first_name;
    String last_name;
    Integer jersey_number;

    Player() {}

    Player(String firstName, String lastName) {
        this.first_name = firstName;
        this.last_name = lastName;
    }

    Player(String firstName, String lastName, Integer number) {
        this.first_name = firstName;
        this.last_name = lastName;
        this.jersey_number = number;
    }

    String getFullName() {
        return first_name + " " + last_name;
    }
}
