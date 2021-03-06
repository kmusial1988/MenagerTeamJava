package com.github.kmusial1988.teamManagerBeta.player.service.impl;

import com.github.kmusial1988.teamManagerBeta.parent.exception.ParentIsNotFoundException;
import com.github.kmusial1988.teamManagerBeta.parent.model.Parent;
import com.github.kmusial1988.teamManagerBeta.parent.repository.ParentRepository;
import com.github.kmusial1988.teamManagerBeta.player.exception.PlayerIsAlreadyExistsException;
import com.github.kmusial1988.teamManagerBeta.player.exception.PlayerIsNotFoundException;
import com.github.kmusial1988.teamManagerBeta.player.mapper.PlayerMapper;
import com.github.kmusial1988.teamManagerBeta.player.service.PlayerService;
import com.github.kmusial1988.teamManagerBeta.player.model.Player;
import com.github.kmusial1988.teamManagerBeta.player.model.PlayerArchives;
import com.github.kmusial1988.teamManagerBeta.player.model.PlayerRequest;
import com.github.kmusial1988.teamManagerBeta.player.model.PlayerResponse;
import com.github.kmusial1988.teamManagerBeta.player.repository.PlayerArchivesRepository;
import com.github.kmusial1988.teamManagerBeta.player.repository.PlayerRepository;
import com.github.kmusial1988.teamManagerBeta.team.exception.TeamIsNotFoundException;
import com.github.kmusial1988.teamManagerBeta.team.model.Team;
import com.github.kmusial1988.teamManagerBeta.team.repository.TeamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final ParentRepository parentRepository;
    private final PlayerMapper playerMapper;
    private final PlayerArchivesRepository playerArchivesRepository;
    private final TeamRepository teamRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository, ParentRepository parentRepository, PlayerMapper playerMapper, PlayerArchivesRepository playerArchivesRepository, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.parentRepository = parentRepository;
        this.playerMapper = playerMapper;
        this.playerArchivesRepository = playerArchivesRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    public List<PlayerResponse> listPlayer() {
        log.info("List of players downloaded");
        return playerRepository.findAll().stream()
                .map(playerMapper::mapFromEntityToResponse).collect(Collectors.toList());
    }

    @Override
    public PlayerResponse getPlayerById(Long id) {
        Player player = playerRepository.findById(id).orElseThrow(() -> {
            throw new PlayerIsNotFoundException();
        });
        log.info("Downloading the player: {}", id);
        return playerMapper.mapFromEntityToResponse(player);
    }

    @Override
    public PlayerResponse createPlayer(PlayerRequest playerRequest) {
        Player player = playerMapper.mapFromRequestToEntity(playerRequest);

        playerRepository.findByLogin(player.getLogin()).ifPresent(pl -> {
            throw new PlayerIsAlreadyExistsException(player.getLogin());
        });
        Parent parent = parentRepository.findByLogin(playerRequest.getParentLogin()).orElseThrow(() ->{throw new ParentIsNotFoundException();});


        player.setParent(parent);

        log.info("Saving new player: {}", player.getLogin());
        return playerMapper.mapFromEntityToResponse(playerRepository.save(player));
    }


    @Override
    public PlayerResponse updatePlayer(PlayerRequest playerRequest) {

        Player player = playerRepository.findById(playerRequest.getId()).orElseThrow(() -> {
            throw new PlayerIsNotFoundException();
        });
        playerRepository.findByIdNotAndLogin(playerRequest.getId(), playerRequest.getLogin()).ifPresent(pl -> {
            throw new PlayerIsAlreadyExistsException(playerRequest.getLogin());       });

        System.out.println("team name " + playerRequest.getTeamName());

        Team team = teamRepository.findByName(playerRequest.getTeamName()).orElseThrow(() -> {throw new TeamIsNotFoundException();
        });

        player.setName(playerRequest.getName());
        player.setSurname(playerRequest.getSurname());
        player.setPassword(playerRequest.getPassword());
        player.setImageUrl(playerRequest.getImageUrl());
        player.setJoined(playerRequest.getJoined());
        player.setStatus(playerRequest.getStatus());
        player.setTeamName(playerRequest.getTeamName());

        log.info("Updating player: {}", player.getLogin());

        return playerMapper.mapFromEntityToResponse(playerRepository.save(player));
    }



    @Override
    public void deletePlayer(Long id) {
        Player player = playerRepository.findById(id).orElseThrow(() -> {
            throw new PlayerIsNotFoundException();
        });

        playerArchivesRepository.save(playerMapper.mapFromEntityToArchive(player));

        log.info("Deleting player by ID: {}", id);
        playerRepository.delete(player);
    }

    @Override
    public List<PlayerArchives> listPlayerArchives() {
        log.info("List of PlayerArchives downloaded");
        return playerArchivesRepository.findAll();
    }


}
