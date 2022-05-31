package com.github.kmusial1988.teamManagerBeta.team.service;

import com.github.kmusial1988.teamManagerBeta.team.model.TeamArchive;
import com.github.kmusial1988.teamManagerBeta.team.model.TeamRequest;
import com.github.kmusial1988.teamManagerBeta.team.model.TeamResponse;

import java.util.List;

public interface TeamService {
    List<TeamResponse> listTeam();

    TeamResponse getTeamById(Long id);

    TeamResponse createTeam(TeamRequest teamRequest);

    TeamResponse updateTeam(TeamRequest teamRequest);

    void deleteTeam(Long id);

    List<TeamArchive> listTeamArchives();
}
