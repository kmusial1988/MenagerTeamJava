package com.github.kmusial1988.teamManagerBeta.team.mapper;

import com.github.kmusial1988.teamManagerBeta.player.repository.PlayerRepository;
import com.github.kmusial1988.teamManagerBeta.team.model.Team;
import com.github.kmusial1988.teamManagerBeta.team.model.TeamArchive;
import com.github.kmusial1988.teamManagerBeta.team.model.TeamRequest;
import com.github.kmusial1988.teamManagerBeta.team.model.TeamResponse;
import com.github.kmusial1988.teamManagerBeta.trainer.repository.TrainerRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TeamMapper {

    private final PlayerRepository playerRepository;
    private final TrainerRepository trainerRepository;

    public TeamMapper(PlayerRepository playerRepository, TrainerRepository trainerRepository) {
        this.playerRepository = playerRepository;
        this.trainerRepository = trainerRepository;
    }

    public Team mapFromRequestToEntity(final TeamRequest request){
        final Team team = new Team();
        team.setId(request.getId());
        team.setName(request.getName());
        team.setCode(request.getCode());
        team.setEmail(request.getEmail());
        team.setImageUrl(request.getImageUrl());
        team.setJoined(request.getJoined());
        team.setStatus(request.getStatus());

        return team;
    }

    public TeamResponse mapFromEntityToResponse(final Team team){
        final TeamResponse response = new TeamResponse();
        response.setId(team.getId());
        response.setName(team.getName());
        response.setCode(team.getCode());
        response.setEmail(team.getEmail());
        response.setImageUrl(team.getImageUrl());
        response.setJoined(team.getJoined());
        response.setStatus(team.getStatus());
        response.setCountPlayer( playerRepository.findAllByTeamName(team.getName()).size());
        response.setCountTrainer( trainerRepository.findAllByTeamName(team.getName()).size());

        return response;
    }

    public TeamArchive mapFromEntityToArchive(final Team team){
        final TeamArchive archives = new TeamArchive();
        archives.setId(team.getId());
        archives.setName(team.getName());
        archives.setCode(team.getCode());
        archives.setEmail(team.getEmail());
        archives.setTeamArchiveData(LocalDateTime.now());
        archives.setImageUrl(team.getImageUrl());
        archives.setJoined(team.getJoined());

        return archives;
    }



}
