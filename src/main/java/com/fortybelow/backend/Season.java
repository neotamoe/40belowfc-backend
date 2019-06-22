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
    Integer month_start;

    Season() {}

    Season(Integer monthStart, Integer year) {
        this.month_start = monthStart;
        this.year = year;
    }

}