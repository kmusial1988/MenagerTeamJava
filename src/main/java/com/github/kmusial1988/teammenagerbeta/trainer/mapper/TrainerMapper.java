package com.github.kmusial1988.teammenagerbeta.trainer.mapper;
import com.github.kmusial1988.teammenagerbeta.global.globalEnum.RoleEnum;
import com.github.kmusial1988.teammenagerbeta.global.globalEnum.Status;
import com.github.kmusial1988.teammenagerbeta.trainer.model.Trainer;
import com.github.kmusial1988.teammenagerbeta.trainer.model.TrainerRequest;
import com.github.kmusial1988.teammenagerbeta.trainer.model.TrainerResponse;
import org.springframework.stereotype.Component;

@Component
public class TrainerMapper {

    public Trainer mapFromRequestToEntity(final TrainerRequest request){
        final Trainer trainer = new Trainer();
        trainer.setName(request.getName());
        trainer.setSurname(request.getSurname());
        trainer.setLogin(request.getLogin());
        trainer.setPassword(request.getPassword());
        trainer.setImageUrl(request.getImageUrl());
        trainer.setStartWork(request.getStartWork());
        trainer.setStatus(Status.NO);
        trainer.setRole(RoleEnum.TRAINER);

        return trainer;
    }

    public TrainerResponse mapFromEntityToResponse(final Trainer trainer){
        final TrainerResponse response = new TrainerResponse();
        response.setId(trainer.getId());
        response.setName(trainer.getName());
        response.setLogin(trainer.getLogin());
        response.setPassword(trainer.getPassword());
        response.setImageUrl(trainer.getImageUrl());
        response.setStartWork(trainer.getStartWork());
        response.setStatus(trainer.getStatus());
        response.setRole(trainer.getRole());

        return response;
    }

}
