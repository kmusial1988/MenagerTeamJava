package com.github.kmusial1988.teamManagerBeta.player.rest;

import com.github.kmusial1988.teamManagerBeta.player.model.PlayerArchives;
import com.github.kmusial1988.teamManagerBeta.player.model.PlayerRequest;
import com.github.kmusial1988.teamManagerBeta.player.model.PlayerResponse;
import com.github.kmusial1988.teamManagerBeta.player.service.PlayerService;
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
@RequestMapping("/player")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping()
    public ResponseEntity<List<PlayerResponse>> getPlayer(){
        return ResponseEntity.status(HttpStatus.OK).body(playerService.listPlayer());
    }

    @PostMapping()
    public ResponseEntity<PlayerResponse> savePlayer(@RequestBody @Valid PlayerRequest playerRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(playerService.createPlayer(playerRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerResponse> getPlayer(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(playerService.getPlayerById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable("id") Long id){
        playerService.deletePlayer(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping()
    public ResponseEntity<PlayerResponse> updatePlayer(@RequestBody @Valid PlayerRequest playerRequest){
        return ResponseEntity.status(HttpStatus.OK).body(playerService.updatePlayer(playerRequest));
    }

    @GetMapping("/archive")
    public ResponseEntity<List<PlayerArchives>> getPlayerArchives(){
        return ResponseEntity.status(HttpStatus.OK).body(playerService.listPlayerArchives());
    }


}
