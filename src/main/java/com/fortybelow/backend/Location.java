package com.fortybelow.backend;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="location_id_seq")
    @SequenceGenerator(name="location_id_seq", sequenceName="location_id_seq", allocationSize=1)
    Integer id;
    String location_name;

    Location() {}

    Location(String locationName) {
        this.location_name = locationName;
    }

}
