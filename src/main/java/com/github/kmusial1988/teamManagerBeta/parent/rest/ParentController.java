package com.github.kmusial1988.teamManagerBeta.parent.rest;

import com.github.kmusial1988.teamManagerBeta.parent.model.ParentArchives;
import com.github.kmusial1988.teamManagerBeta.parent.model.ParentRequest;
import com.github.kmusial1988.teamManagerBeta.parent.model.ParentResponse;
import com.github.kmusial1988.teamManagerBeta.parent.service.ParentService;
import com.github.kmusial1988.teamManagerBeta.player.model.PlayerArchives;
import com.github.kmusial1988.teamManagerBeta.player.model.PlayerRequest;
import com.github.kmusial1988.teamManagerBeta.player.model.PlayerResponse;
import com.github.kmusial1988.teamManagerBeta.player.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/parent")
public class ParentController {

    private final ParentService parentService;

    @Autowired
    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }

    @GetMapping()
    public ResponseEntity<List<ParentResponse>> getParent(){
        return ResponseEntity.status(HttpStatus.OK).body(parentService.listParent());
    }

    @PostMapping()
    public ResponseEntity<ParentResponse> saveParent(@RequestBody @Valid ParentRequest parentRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(parentService.createParent(parentRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParentResponse> getParent(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(parentService.getParentById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParent(@PathVariable("id") Long id){
        parentService.deleteParent(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping()
    public ResponseEntity<ParentResponse> updateParent(@RequestBody @Valid ParentRequest parentRequest){
        return ResponseEntity.status(HttpStatus.OK).body(parentService.updateParent(parentRequest));
    }

    @GetMapping("/archive")
    public ResponseEntity<List<ParentArchives>> getParentArchives(){
        return ResponseEntity.status(HttpStatus.OK).body(parentService.listParentArchives());
    }


}
