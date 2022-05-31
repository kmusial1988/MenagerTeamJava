package com.github.kmusial1988.teamManagerBeta.team.mapper;
import com.github.kmusial1988.teamManagerBeta.global.globalEnum.RoleEnum;
import com.github.kmusial1988.teamManagerBeta.global.globalEnum.Status;
import com.github.kmusial1988.teamManagerBeta.player.model.Player;
import com.github.kmusial1988.teamManagerBeta.player.model.PlayerArchives;
import com.github.kmusial1988.teamManagerBeta.player.model.PlayerRequest;
import com.github.kmusial1988.teamManagerBeta.player.model.PlayerResponse;
import com.github.kmusial1988.teamManagerBeta.team.model.Team;
import com.github.kmusial1988.teamManagerBeta.team.model.TeamArchive;
import com.github.kmusial1988.teamManagerBeta.team.model.TeamRequest;
import com.github.kmusial1988.teamManagerBeta.team.model.TeamResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TeamMapper {

    public Team mapFromRequestToEntity(final TeamRequest request){
        final Team team = new Team();
        team.setName(request.getName());
        team.setCode(request.getCode());
        team.setImageUrl(request.getImageUrl());
        team.setJoined(request.getJoined());
        team.setStatus(Status.NO);

        return team;
    }

    public TeamResponse mapFromEntityToResponse(final Team team){
        final TeamResponse response = new TeamResponse();
        response.setId(team.getId());
        response.setName(team.getName());
        response.setCode(team.getCode());
        response.setImageUrl(team.getImageUrl());
        response.setJoined(team.getJoined());
        response.setStatus(team.getStatus());

        return response;
    }

    public TeamArchive mapFromEntityToArchive(final Team team){
        final TeamArchive archives = new TeamArchive();
        archives.setId(team.getId());
        archives.setName(team.getName());
        archives.setCode(team.getCode());
        archives.setTeamArchiveData(LocalDateTime.now());
        archives.setImageUrl(team.getImageUrl());
        archives.setJoined(team.getJoined());

        return archives;
    }

}
