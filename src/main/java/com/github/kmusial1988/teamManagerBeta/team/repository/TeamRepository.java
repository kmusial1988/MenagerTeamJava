package com.github.kmusial1988.teamManagerBeta.team.repository;


import com.github.kmusial1988.teamManagerBeta.team.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.ObjectStreamClass;
import java.util.Observable;
import java.util.Observer;
import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long> {

    Optional<Team> findByName(String name);


}
