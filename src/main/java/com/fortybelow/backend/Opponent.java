package com.fortybelow.backend;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Opponent {
    @Id
    @GeneratedValue
    Integer id;
    String team_name;

    Opponent() {}

    Opponent(String teamName) {
        this.team_name = teamName;
    }

}
