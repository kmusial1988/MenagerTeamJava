package com.github.kmusial1988.teamManagerBeta.trainer.service.impl;

import com.github.kmusial1988.teamManagerBeta.trainer.exception.TrainerIsAlreadyExistsException;
import com.github.kmusial1988.teamManagerBeta.trainer.exception.TrainerNotFoundException;
import com.github.kmusial1988.teamManagerBeta.trainer.mapper.TrainerMapper;
import com.github.kmusial1988.teamManagerBeta.trainer.model.Trainer;
import com.github.kmusial1988.teamManagerBeta.trainer.model.TrainerArchives;
import com.github.kmusial1988.teamManagerBeta.trainer.model.TrainerRequest;
import com.github.kmusial1988.teamManagerBeta.trainer.model.TrainerResponse;
import com.github.kmusial1988.teamManagerBeta.trainer.repository.TrainerArchivesRepository;
import com.github.kmusial1988.teamManagerBeta.trainer.repository.TrainerRepository;
import com.github.kmusial1988.teamManagerBeta.trainer.service.TrainerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class TrainerServiceImpl implements TrainerService {

    private final TrainerRepository trainerRepository;
    private final TrainerMapper trainerMapper;
    private final TrainerArchivesRepository trainerArchivesRepository;


    public TrainerServiceImpl(TrainerRepository trainerRepository, TrainerMapper trainerMapper, TrainerArchivesRepository trainerArchivesRepository) {
        this.trainerRepository = trainerRepository;
        this.trainerMapper = trainerMapper;
        this.trainerArchivesRepository = trainerArchivesRepository;
    }


    @Override
    public List<TrainerResponse> listTrainers() {
        log.info("List of trainers downloaded");
        return trainerRepository.findAll().stream()
                .map(trainerMapper::mapFromEntityToResponse).collect(Collectors.toList());
    }

    @Override
    public TrainerResponse getTrainerById(Long id) {
        Trainer trainer = trainerRepository.findById(id).orElseThrow(() ->{
            throw new TrainerNotFoundException();
        });
        log.info("Downloading the trainer: {}", id);
        return trainerMapper.mapFromEntityToResponse(trainer);
    }

    @Override
    public TrainerResponse createTrainer(TrainerRequest trainerRequest) {
        Trainer trainer = trainerMapper.mapFromRequestToEntity(trainerRequest);
        trainerRepository.findByLogin(trainer.getLogin()).ifPresent(tr -> {
            throw new TrainerIsAlreadyExistsException(trainer.getLogin());
        });

        log.info("Saving new trainer: {}", trainer.getLogin());
        return trainerMapper.mapFromEntityToResponse(trainerRepository.save(trainer));

    }


    @Override
    public TrainerResponse updateTrainer(TrainerRequest trainerRequest) {


        trainerRepository.findById(trainerRequest.getId()).orElseThrow(()->{
            throw new TrainerNotFoundException();
        });

        trainerRepository.findByIdNotAndLogin(trainerRequest.getId(), trainerRequest.getLogin()).ifPresent(tr -> {
            throw new TrainerIsAlreadyExistsException(trainerRequest.getLogin());
        });

        Trainer trainer = trainerMapper.mapFromRequestToEntity(trainerRequest);

        log.info("Updating trainer: {}", trainer.getLogin());

        return trainerMapper.mapFromEntityToResponse(trainerRepository.save(trainer));
    }



    @Override
    public void deleteTrainer(Long id) {
        Trainer trainer = trainerRepository.findById(id).orElseThrow(() ->{
            throw new TrainerNotFoundException();
        });

        trainerArchivesRepository.save(trainerMapper.mapFromEntityToArchive(trainer));

        log.info("Deleting trainer by ID: {}", id);
        trainerRepository.delete(trainer);

    }
    @Override
    public List<TrainerArchives> listTrainersArchives() {
        log.info("List of TrainerArchives downloaded");
        return trainerArchivesRepository.findAll();
    }



}
