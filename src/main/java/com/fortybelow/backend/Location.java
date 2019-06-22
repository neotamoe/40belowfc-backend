package com.fortybelow.backend;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Location {
    @Id
    @GeneratedValue
    Integer id;
    String location_name;

    Location() {}

    Location(String locationName) {
        this.location_name = locationName;
    }

}
