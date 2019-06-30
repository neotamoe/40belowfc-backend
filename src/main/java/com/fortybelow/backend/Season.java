package com.fortybelow.backend;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Season {
    @Id
    @GeneratedValue
    Integer id;
    Integer year;
    String month_start;

    Season() {}

    Season(String monthStart, Integer year) {
        this.month_start = monthStart;
        this.year = year;
    }

}