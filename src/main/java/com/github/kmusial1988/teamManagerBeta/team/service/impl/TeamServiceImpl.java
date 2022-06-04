package com.github.kmusial1988.teamManagerBeta.team.service.impl;

import com.github.kmusial1988.teamManagerBeta.player.exception.PlayerIsNotFoundException;
import com.github.kmusial1988.teamManagerBeta.player.model.Player;
import com.github.kmusial1988.teamManagerBeta.player.repository.PlayerRepository;
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
import com.github.kmusial1988.teamManagerBeta.trainer.exception.TrainerNotFoundException;
import com.github.kmusial1988.teamManagerBeta.trainer.model.Trainer;
import com.github.kmusial1988.teamManagerBeta.trainer.repository.TrainerRepository;
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
    private final PlayerRepository playerRepository;
    private final TrainerRepository trainerRepository;

    public TeamServiceImpl(TeamMapper teamMapper, TeamRepository teamRepository, TeamArchivesRepository teamArchivesRepository, PlayerRepository playerRepository, TrainerRepository trainerRepository) {
        this.teamMapper = teamMapper;
        this.teamRepository = teamRepository;
        this.teamArchivesRepository = teamArchivesRepository;
        this.playerRepository = playerRepository;
        this.trainerRepository = trainerRepository;
    }

    @Override
    public List<Team> listTeam() {
        log.info("List of Team downloaded");
        return teamRepository.findAll();
    }

    @Override
    public Team getTeamById(Long id) {
        Team team = teamRepository.findById(id).orElseThrow(() -> {
            throw new TeamIsNotFoundException();
        });
        log.info("Downloading the team: {}", id);
        return team;
    }

    @Override
    public Team createTeam(TeamRequest teamRequest) {
        Team team = teamMapper.mapFromRequestToEntity(teamRequest);
        teamRepository.findByName(team.getName()).ifPresent(pl -> {
            throw new TeamIsAlreadyExistsException(team.getName());
        });


//        Player player =  playerRepository.findByLogin(teamRequest.getPlayerLogin()).orElseThrow(()->{
//            throw new PlayerIsNotFoundException();
//        });
//
//        Trainer trainer = trainerRepository.findByLogin(teamRequest.getTrainerLogin()).orElseThrow(()->{
//            throw new TeamIsNotFoundException();
//        });
//        System.out.println("tego szukam player" + player);
//        System.out.println("tego szukam trainera" + trainer);
//
//
//        team.getPlayerList().add(player);
//        team.getTrainerList().add(trainer);
//
//        System.out.println(team.getPlayerList().size()  +  " rozmiar listy player");
//        System.out.println(team.getTrainerList().size() + " rozmiar listy trainer");
//
//        teamRepository.save(team);
//
//        System.out.println("Efekt zapisu " + team.getTrainerList().size());

        log.info("Saving new team: {}", team.getName());
        return teamRepository.save(team);

    }

    @Override
    public Team updateTeam(TeamRequest teamRequest) {
        Team team = teamRepository.findById(teamRequest.getId()).orElseThrow(() -> {
            throw new TeamIsNotFoundException();
        });


        log.info("Updating team: {}", team.getName());
        return teamRepository.save(team);
    }

    @Override
    public Team addToTeam(TeamRequest teamRequest) {

        Team team = teamRepository.findById(teamRequest.getId()).orElseThrow(() -> {
            throw new TeamIsNotFoundException();
        });

//       Player player =  playerRepository.findByLogin(teamRequest.getPlayerLogin()).orElseThrow(()->{
//           throw new PlayerIsNotFoundException();
//       });
//
//       Trainer trainer = trainerRepository.findByLogin(teamRequest.getTrainerLogin()).orElseThrow(()->{
//          throw new TeamIsNotFoundException();
//       });
//        System.out.println("tego szukam player" + player);
//        System.out.println("tego szukam trainera" + trainer);
//
//
//        team.getPlayerList().add(player);
//        team.getTrainerList().add(trainer);
//
//        System.out.println(team.getPlayerList().size()  +  " rozmiar listy player");
//        System.out.println(team.getTrainerList().size() + " rozmiar listy trainer");
//
//        teamRepository.save(team);
//
//        System.out.println("Efekt zapisu " + team.getTrainerList().size());

        log.info("Add To team: {}", team.getName());
        return team;
    }


    @Override
    public void deleteTeam(Long id) {
        Team team = teamRepository.findById(id).orElseThrow(() -> {
            throw new TeamIsNotFoundException();
        });


        teamArchivesRepository.save(teamMapper.mapFromEntityToArchive(team));

        log.info("Deleting team by ID: {}", team.getName());
        teamRepository.delete(team);
    }

    @Override
    public List<TeamArchive> listTeamArchives() {
        log.info("List of Team Archive downloaded");
        return teamArchivesRepository.findAll();
    }
}
