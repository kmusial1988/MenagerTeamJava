package com.github.kmusial1988.teamManagerBeta.team.service.impl;

import com.github.kmusial1988.teamManagerBeta.team.exception.TeamIsAlreadyExistsException;
import com.github.kmusial1988.teamManagerBeta.team.exception.TeamIsNotFoundException;
import com.github.kmusial1988.teamManagerBeta.team.mapper.TeamMapper;
import com.github.kmusial1988.teamManagerBeta.team.model.Team;
import com.github.kmusial1988.teamManagerBeta.team.model.TeamArchive;
import com.github.kmusial1988.teamManagerBeta.team.model.TeamRequest;
import com.github.kmusial1988.teamManagerBeta.team.model.TeamResponse;
import com.github.kmusial1988.teamManagerBeta.team.repository.TeamArchivesRepository;
import com.github.kmusial1988.teamManagerBeta.team.repository.TeamRepository;
import com.github.kmusial1988.teamManagerBeta.team.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class TeamServiceImpl implements TeamService {

    private final TeamMapper teamMapper;
    private final TeamRepository teamRepository;
    private final TeamArchivesRepository teamArchivesRepository;

    public TeamServiceImpl(TeamMapper teamMapper, TeamRepository teamRepository, TeamArchivesRepository teamArchivesRepository) {
        this.teamMapper = teamMapper;
        this.teamRepository = teamRepository;
        this.teamArchivesRepository = teamArchivesRepository;
    }

    @Override
    public List<TeamResponse> listTeam() {
        log.info("List of Team downloaded");
        return teamRepository.findAll().stream()
                .map(teamMapper::mapFromEntityToResponse).collect(Collectors.toList());
    }

    @Override
    public TeamResponse getTeamById(Long id) {
        Team team = teamRepository.findById(id).orElseThrow(()->{
            throw new TeamIsNotFoundException();
        });
        log.info("Downloading the team: {}", id);
        return teamMapper.mapFromEntityToResponse(team);
    }

    @Override
    public TeamResponse createTeam(TeamRequest teamRequest) {
        Team team = teamMapper.mapFromRequestToEntity(teamRequest);
        teamRepository.findByName(team.getName()).ifPresent(pl -> {
            throw new TeamIsAlreadyExistsException(team.getName());
        });
        log.info("Saving new team: {}", team.getName());
        return teamMapper.mapFromEntityToResponse(teamRepository.save(team));
    }

    @Override
    public TeamResponse updateTeam(TeamRequest teamRequest) {
        Team team = teamRepository.findById(teamRequest.getId()).orElseThrow(() ->{
            throw new TeamIsNotFoundException();
        });
        teamRepository.findByName(teamRequest.getName()).ifPresent(pl -> {
            throw new TeamIsAlreadyExistsException(team.getName());
        });

        log.info("Updating team: {}", team.getName());
        return teamMapper.mapFromEntityToResponse(teamRepository.save(team));
    }

    @Override
    public void deleteTeam(Long id) {
        Team team = teamRepository.findById(id).orElseThrow(() ->{
            throw new TeamIsNotFoundException();
        });

        teamArchivesRepository.save(teamMapper.mapFromEntityToArchive(team));

        log.info("Deleting team by ID: {}", id);
        teamRepository.delete(team);
    }

    @Override
    public List<TeamArchive> listTeamArchives() {
        log.info("List of Team Archive downloaded");
        return teamArchivesRepository.findAll();
    }
}
