package com.github.kmusial1988.teamManagerBeta.player.repository;


import com.github.kmusial1988.teamManagerBeta.player.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Long> {



    Optional<Player> findByName(String name);


    Optional<Player> findByLogin(String login);
}
