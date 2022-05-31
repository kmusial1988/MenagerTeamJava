package com.github.kmusial1988.teamManagerBeta.trainer.rest;

import com.github.kmusial1988.teamManagerBeta.trainer.model.TrainerRequest;
import com.github.kmusial1988.teamManagerBeta.trainer.model.TrainerResponse;
import com.github.kmusial1988.teamManagerBeta.trainer.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/trainer")
public class TrainerController {

    private final TrainerService trainerService;

    @Autowired
    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping()
    public ResponseEntity<List<TrainerResponse>> getTrainers(){
        return ResponseEntity.status(HttpStatus.OK).body(trainerService.listTrainers());
    }

    @PostMapping()
    public ResponseEntity<TrainerResponse> saveTrainer(@RequestBody @Valid TrainerRequest trainer){
        return ResponseEntity.status(HttpStatus.CREATED).body(trainerService.createTrainer(trainer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainerResponse> getTrainer(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(trainerService.getTrainerById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrainer(@PathVariable("id") Long id){
        trainerService.deleteTrainer(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping()
    public ResponseEntity<TrainerResponse> updateTrainer(@RequestBody @Valid TrainerRequest trainer){
        return ResponseEntity.status(HttpStatus.OK).body(trainerService.updateTrainer(trainer));
    }


}
