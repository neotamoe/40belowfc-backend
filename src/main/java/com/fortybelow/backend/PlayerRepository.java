package com.fortybelow.backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    @Query("SELECT p FROM Player p WHERE p.is_current = ?1")
    List<Player> findAllPlayersByIs_current(Boolean isCurrent);
}
