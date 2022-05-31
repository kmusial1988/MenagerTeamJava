package com.github.kmusial1988.teamManagerBeta.team.repository;


import com.github.kmusial1988.teamManagerBeta.player.model.PlayerArchives;
import com.github.kmusial1988.teamManagerBeta.team.model.TeamArchive;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamArchivesRepository extends JpaRepository<TeamArchive, Long> {

}
