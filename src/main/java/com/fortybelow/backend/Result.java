package com.fortybelow.backend;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="result_id_seq")
    @SequenceGenerator(name="result_id_seq", sequenceName="result_id_seq", allocationSize=1)
    Integer id;
    String result;
    Integer points;

    Result() {}

}
