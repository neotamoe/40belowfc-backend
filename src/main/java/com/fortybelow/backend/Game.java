package com.fortybelow.backend;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Game {
    @Id
    @GeneratedValue
    Integer id;
    Date date;
    Integer score_us;
    Integer score_them;
    Integer result_id;
    Integer location_id;
    Integer game_order;
    Integer opponent_id;

    Game() {}

    Game(Date date, Integer score_us, Integer score_them, Integer result_id, Integer location_id, Integer game_order, Integer opponent_id) {
        this.date = date;
        this.score_us = score_us;
        this.score_them = score_them;
        this.result_id = result_id;
        this.location_id = location_id;
        this.game_order = game_order;
        this.opponent_id = opponent_id;
    }

}