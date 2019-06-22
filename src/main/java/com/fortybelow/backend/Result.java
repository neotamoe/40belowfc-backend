package com.fortybelow.backend;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Result {
    @Id
    @GeneratedValue
    Integer id;
    String result;
    Integer points;

    Result() {}

}
