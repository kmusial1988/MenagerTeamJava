package com.github.kmusial1988.teamManagerBeta.parent.mapper;
import com.github.kmusial1988.teamManagerBeta.global.globalEnum.RoleEnum;
import com.github.kmusial1988.teamManagerBeta.global.globalEnum.Status;
import com.github.kmusial1988.teamManagerBeta.parent.model.Parent;
import com.github.kmusial1988.teamManagerBeta.parent.model.ParentArchives;
import com.github.kmusial1988.teamManagerBeta.parent.model.ParentRequest;
import com.github.kmusial1988.teamManagerBeta.parent.model.ParentResponse;
import com.github.kmusial1988.teamManagerBeta.player.model.Player;
import com.github.kmusial1988.teamManagerBeta.player.model.PlayerArchives;
import com.github.kmusial1988.teamManagerBeta.player.model.PlayerRequest;
import com.github.kmusial1988.teamManagerBeta.player.model.PlayerResponse;
import org.springframework.stereotype.Component;

@Component
public class ParentMapper {

    public Parent mapFromRequestToEntity(final ParentRequest request){
        final Parent parent = new Parent();
        parent.setName(request.getName());
        parent.setSurname(request.getSurname());
        parent.setLogin(request.getLogin());
        parent.setPassword(request.getPassword());
        parent.setImageUrl(request.getImageUrl());
        parent.setJoined(request.getJoined());
        parent.setStatus(Status.NO);
        parent.setRole(RoleEnum.PLAYER);

        return parent;
    }

    public ParentResponse mapFromEntityToResponse(final Parent parent){
        final ParentResponse response = new ParentResponse();
        response.setId(parent.getId());
        response.setName(parent.getName());
        response.setSurname(parent.getSurname());
        response.setLogin(parent.getLogin());
        response.setPassword(parent.getPassword());
        response.setImageUrl(parent.getImageUrl());
        response.setJoined(parent.getJoined());
        response.setStatus(parent.getStatus());
        response.setRole(parent.getRole());

        return response;
    }

    public ParentArchives mapFromEntityToArchive(final Parent parent){
        final ParentArchives archives = new ParentArchives();
        archives.setId(parent.getId());
        archives.setName(parent.getName());
        archives.setSurname(parent.getSurname());
        archives.setLogin(parent.getLogin());
        archives.setPassword(parent.getPassword());
        archives.setImageUrl(parent.getImageUrl());
        archives.setJoined(parent.getJoined());
        archives.setStatus(parent.getStatus());
        archives.setRole(parent.getRole());

        return archives;
    }

}
