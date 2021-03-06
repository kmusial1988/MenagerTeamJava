package com.github.kmusial1988.teamManagerBeta.trainer.repository;


import com.github.kmusial1988.teamManagerBeta.player.model.Player;
import com.github.kmusial1988.teamManagerBeta.trainer.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {

    Optional<Trainer> findByIdNotAndLogin(Long id, String login);

    List<Trainer> findAllByTeamName(String name);

    Optional<Trainer> findByName(String name);


    Optional<Trainer> findByLogin(String login);
}
