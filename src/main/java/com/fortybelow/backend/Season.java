package com.fortybelow.backend;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="season_id_seq")
    @SequenceGenerator(name="season_id_seq", sequenceName="season_id_seq", allocationSize=1)
    Integer id;
    Integer year;
    String month_start;

    Season() {}

    Season(String monthStart, Integer year) {
        this.month_start = monthStart;
        this.year = year;
    }

}