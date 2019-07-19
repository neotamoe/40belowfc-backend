package com.fortybelow.backend;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Opponent {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="location_id_seq")
    @SequenceGenerator(name="location_id_seq", sequenceName="location_id_seq", allocationSize=1)
    Integer id;
    String team_name;

    Opponent() {}

    Opponent(String teamName) {
        this.team_name = teamName;
    }

}
