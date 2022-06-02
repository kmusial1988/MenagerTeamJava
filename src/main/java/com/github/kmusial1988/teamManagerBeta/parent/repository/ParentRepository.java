package com.github.kmusial1988.teamManagerBeta.parent.repository;


import com.github.kmusial1988.teamManagerBeta.parent.model.Parent;
import com.github.kmusial1988.teamManagerBeta.player.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParentRepository extends JpaRepository<Parent, Long> {

    Optional<Parent> findByIdNotAndLogin(Long id, String login);

    Optional<Parent> findByName(String name);


    Optional<Parent> findByLogin(String login);
}
