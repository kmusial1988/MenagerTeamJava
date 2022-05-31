package com.github.kmusial1988.teamManagerBeta.player.mapper;
import com.github.kmusial1988.teamManagerBeta.global.globalEnum.RoleEnum;
import com.github.kmusial1988.teamManagerBeta.global.globalEnum.Status;
import com.github.kmusial1988.teamManagerBeta.player.model.Player;
import com.github.kmusial1988.teamManagerBeta.player.model.PlayerArchives;
import com.github.kmusial1988.teamManagerBeta.player.model.PlayerRequest;
import com.github.kmusial1988.teamManagerBeta.player.model.PlayerResponse;
import com.github.kmusial1988.teamManagerBeta.trainer.model.Trainer;
import com.github.kmusial1988.teamManagerBeta.trainer.model.TrainerResponse;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapper {

    public Player mapFromRequestToEntity(final PlayerRequest request){
        final Player player = new Player();
        player.setName(request.getName());
        player.setSurname(request.getSurname());
        player.setLogin(request.getLogin());
        player.setPassword(request.getPassword());
        player.setImageUrl(request.getImageUrl());
        player.setJoined(request.getJoined());
        player.setStatus(Status.NO);
        player.setRole(RoleEnum.PLAYER);

        return player;
    }

    public PlayerResponse mapFromEntityToResponse(final Player player){
        final PlayerResponse response = new PlayerResponse();
        response.setId(player.getId());
        response.setName(player.getName());
        response.setSurname(player.getSurname());
        response.setLogin(player.getLogin());
        response.setPassword(player.getPassword());
        response.setImageUrl(player.getImageUrl());
        response.setJoined(player.getJoined());
        response.setStatus(player.getStatus());
        response.setRole(player.getRole());

        return response;
    }

    public PlayerArchives mapFromEntityToArchive(final Player player){
        final PlayerArchives archives = new PlayerArchives();
        archives.setId(player.getId());
        archives.setName(player.getName());
        archives.setSurname(player.getSurname());
        archives.setLogin(player.getLogin());
        archives.setPassword(player.getPassword());
        archives.setImageUrl(player.getImageUrl());
        archives.setJoined(player.getJoined());
        archives.setStatus(player.getStatus());
        archives.setRole(player.getRole());

        return archives;
    }

}
