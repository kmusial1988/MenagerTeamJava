package com.github.kmusial1988.teamManagerBeta.player.service;

import com.github.kmusial1988.teamManagerBeta.player.model.PlayerArchives;
import com.github.kmusial1988.teamManagerBeta.player.model.PlayerRequest;
import com.github.kmusial1988.teamManagerBeta.player.model.PlayerResponse;

import java.util.List;

public interface PlayerService {

    List<PlayerResponse> listPlayer();

    PlayerResponse getPlayerById(Long id);

    PlayerResponse createPlayer(PlayerRequest playerRequest);

    PlayerResponse updatePlayer(PlayerRequest playerRequest);

    void deletePlayer(Long id);

    List<PlayerArchives> listPlayerArchives();
}
