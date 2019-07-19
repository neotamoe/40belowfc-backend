package com.fortybelow.backend;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="game_id_seq")
    @SequenceGenerator(name="game_id_seq", sequenceName="game_id_seq", allocationSize=1)
    Integer id;
    LocalDate date;
    LocalTime time;
    Integer score_us;
    Integer score_them;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "result_id")
    Result result;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "location_id")
    Location location;
    Integer game_order;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "opponent_id")
    Opponent opponent;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "season_id")
    Season season;
    Boolean is_playoff_game;

    Game() {}

    Game(LocalDate date, LocalTime time, Integer score_us, Integer score_them, Integer result_id, Integer location_id, Integer game_order, Integer opponent_id, Integer season_id, Boolean is_playoff_game) {
        this.date = date;
        this.time = time;
        this.score_us = score_us;
        this.score_them = score_them;
        this.result.id = result_id;
        this.location.id = location_id;
        this.game_order = game_order;
        this.opponent.id = opponent_id;
        this.season.id = season_id;
        this.is_playoff_game = is_playoff_game;
    }

    boolean isSeasonChampion(){
        return this.is_playoff_game && this.game_order == 8 && this.score_us > this.score_them;
    }

}