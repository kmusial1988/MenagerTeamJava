package com.github.kmusial1988.teammenagerbeta.trainer.service;

import com.github.kmusial1988.teammenagerbeta.trainer.model.TrainerRequest;
import com.github.kmusial1988.teammenagerbeta.trainer.model.TrainerResponse;

import java.util.List;


public interface TrainerService {


    List<TrainerResponse> listTrainers();

    TrainerResponse getTrainerById(Long id);

    TrainerResponse createTrainer(TrainerRequest trainer);

    TrainerResponse updateTrainer(TrainerRequest trainer);

    void deleteTrainer(Long id);

}
