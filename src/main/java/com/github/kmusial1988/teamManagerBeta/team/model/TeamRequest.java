package com.github.kmusial1988.teamManagerBeta.team.model;

import com.github.kmusial1988.teamManagerBeta.global.globalEnum.Status;
import com.github.kmusial1988.teamManagerBeta.parent.model.Parent;
import com.github.kmusial1988.teamManagerBeta.player.model.Player;
import com.github.kmusial1988.teamManagerBeta.trainer.model.Trainer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamRequest {
    private Long id;
    private String name;
    private String code;
    private String imageUrl;
    private String joined;
    private Status status;
//
//    @OneToMany
//    private List<Player> playerList = new ArrayList<>();
//
//    @OneToMany
//    private List<Parent> parentList = new ArrayList<>();
//
//    @OneToMany
//    private List<Trainer> trainerList = new ArrayList<>();
}
