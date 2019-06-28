package com.fortybelow.backend;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
public class Game {
    @Id
    @GeneratedValue
    Integer id;
    LocalDate date;
    LocalTime time;
    Integer score_us;
    Integer score_them;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "result_id")
    Result result;
    Integer location_id;
    Integer game_order;
    Integer opponent_id;
    Integer season_id;

    Game() {}

    Game(LocalDate date, LocalTime time, Integer score_us, Integer score_them, Integer result_id, Integer location_id, Integer game_order, Integer opponent_id, Integer season_id) {
        this.date = date;
        this.time = time;
        this.score_us = score_us;
        this.score_them = score_them;
        this.result.id = result_id;
        this.location_id = location_id;
        this.game_order = game_order;
        this.opponent_id = opponent_id;
        this.season_id = season_id;
    }

}