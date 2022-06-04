package com.github.kmusial1988.teamManagerBeta.team.service;

import com.github.kmusial1988.teamManagerBeta.team.model.Team;
import com.github.kmusial1988.teamManagerBeta.team.model.TeamArchive;
import com.github.kmusial1988.teamManagerBeta.team.model.TeamRequest;
import com.github.kmusial1988.teamManagerBeta.team.model.TeamResponse;

import java.util.List;

public interface TeamService {
    List<Team> listTeam();

    Team getTeamById(Long id);

    Team createTeam(TeamRequest teamRequest);

    Team updateTeam(TeamRequest teamRequest);

    Team addToTeam(TeamRequest teamRequest);

    void deleteTeam(Long id);

    List<TeamArchive> listTeamArchives();
}
