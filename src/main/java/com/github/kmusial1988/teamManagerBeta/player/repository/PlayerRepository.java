package com.github.kmusial1988.teamManagerBeta.player.repository;


import com.github.kmusial1988.teamManagerBeta.player.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    Optional<Player> findByIdNotAndLogin(Long id, String login);

   List<Player> findAllByTeamName(String name);


    Optional<Player> findByLogin(String login);

}
