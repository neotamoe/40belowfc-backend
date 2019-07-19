package com.fortybelow.backend;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="player_id_seq")
    @SequenceGenerator(name="player_id_seq", sequenceName="player_id_seq", allocationSize=1)
    Long id;
    String first_name;
    String last_name;
    Integer jersey_number;
    Boolean is_current;

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
