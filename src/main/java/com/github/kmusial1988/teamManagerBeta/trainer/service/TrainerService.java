package com.github.kmusial1988.teamManagerBeta.trainer.service;

import com.github.kmusial1988.teamManagerBeta.trainer.model.TrainerRequest;
import com.github.kmusial1988.teamManagerBeta.trainer.model.TrainerResponse;

import java.util.List;

public interface TrainerService {
    List<TrainerResponse> listTrainers();

    TrainerResponse getTrainerById(Long id);

    TrainerResponse createTrainer(TrainerRequest trainerRequest);

    TrainerResponse updateTrainer(TrainerRequest trainerRequest);

    void deleteTrainer(Long id);
}
