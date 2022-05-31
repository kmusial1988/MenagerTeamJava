package com.github.kmusial1988.teamManagerBeta.trainer.mapper;
import com.github.kmusial1988.teamManagerBeta.global.globalEnum.RoleEnum;
import com.github.kmusial1988.teamManagerBeta.global.globalEnum.Status;
import com.github.kmusial1988.teamManagerBeta.trainer.model.Trainer;
import com.github.kmusial1988.teamManagerBeta.trainer.model.TrainerArchives;
import com.github.kmusial1988.teamManagerBeta.trainer.model.TrainerRequest;
import com.github.kmusial1988.teamManagerBeta.trainer.model.TrainerResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TrainerMapper {

    public Trainer mapFromRequestToEntity(final TrainerRequest request){
        final Trainer trainer = new Trainer();
        trainer.setName(request.getName());
        trainer.setSurname(request.getSurname());
        trainer.setLogin(request.getLogin());
        trainer.setPassword(request.getPassword());
        trainer.setImageUrl(request.getImageUrl());
        trainer.setJoined(request.getJoined());
        trainer.setStatus(Status.NO);
        trainer.setRole(RoleEnum.TRAINER);

        return trainer;
    }

    public TrainerResponse mapFromEntityToResponse(final Trainer trainer){
        final TrainerResponse response = new TrainerResponse();
        response.setId(trainer.getId());
        response.setName(trainer.getName());
        response.setSurname(trainer.getSurname());
        response.setLogin(trainer.getLogin());
        response.setPassword(trainer.getPassword());
        response.setImageUrl(trainer.getImageUrl());
        response.setJoined(trainer.getJoined());
        response.setStatus(trainer.getStatus());
        response.setRole(trainer.getRole());

        return response;
    }

    public TrainerArchives mapFromEntityToArchive(final Trainer trainer){
        final TrainerArchives archives = new TrainerArchives();
        archives.setDateArchiving(LocalDateTime.now());
        archives.setName(trainer.getName());
        archives.setSurname(trainer.getSurname());
        archives.setLogin(trainer.getLogin());
        archives.setPassword(trainer.getPassword());
        archives.setImageUrl(trainer.getImageUrl());
        archives.setJoined(trainer.getJoined());
        archives.setStatus(trainer.getStatus());
        archives.setRole(trainer.getRole());


        return archives;


    }

}
