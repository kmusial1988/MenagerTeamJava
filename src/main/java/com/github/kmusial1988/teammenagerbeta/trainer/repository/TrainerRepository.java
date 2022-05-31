package com.github.kmusial1988.teammenagerbeta.trainer.repository;


import com.github.kmusial1988.teammenagerbeta.trainer.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {



    Optional<Trainer> findByName(String name);


    Optional<Trainer> findByLogin(String login);
}
