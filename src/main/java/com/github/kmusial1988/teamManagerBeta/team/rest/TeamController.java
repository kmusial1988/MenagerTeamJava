package com.github.kmusial1988.teamManagerBeta.team.rest;

import com.github.kmusial1988.teamManagerBeta.team.model.TeamArchive;
import com.github.kmusial1988.teamManagerBeta.team.model.TeamRequest;
import com.github.kmusial1988.teamManagerBeta.team.model.TeamResponse;
import com.github.kmusial1988.teamManagerBeta.team.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }


    @GetMapping()
    public ResponseEntity<List<TeamResponse>> getTeam(){
        return ResponseEntity.status(HttpStatus.OK).body(teamService.listTeam());
    }

    @PostMapping()
    public ResponseEntity<TeamResponse> saveTeam(@RequestBody @Valid TeamRequest teamRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(teamService.createTeam(teamRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamResponse> getTeam(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(teamService.getTeamById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable("id") Long id){
        teamService.deleteTeam(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping()
    public ResponseEntity<TeamResponse> updateTeam(@RequestBody @Valid TeamRequest teamRequest){
        return ResponseEntity.status(HttpStatus.OK).body(teamService.updateTeam(teamRequest));
    }

    @GetMapping("/archive")
    public ResponseEntity<List<TeamArchive>> getTeamArchives(){
        return ResponseEntity.status(HttpStatus.OK).body(teamService.listTeamArchives());
    }


}
