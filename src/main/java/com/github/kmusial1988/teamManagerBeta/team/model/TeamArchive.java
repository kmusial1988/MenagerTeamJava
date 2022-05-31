package com.github.kmusial1988.teamManagerBeta.team.model;


import com.github.kmusial1988.teamManagerBeta.global.globalEnum.Status;
import com.github.kmusial1988.teamManagerBeta.parent.model.Parent;
import com.github.kmusial1988.teamManagerBeta.player.model.Player;
import com.github.kmusial1988.teamManagerBeta.trainer.model.Trainer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TeamArchive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    private LocalDateTime teamArchiveData;
    private String imageUrl;
    private String joined;

//    @OneToMany
//    private List<Player> playerList = new ArrayList<>();
//
//    @OneToMany
//    private List<Parent> parentList = new ArrayList<>();
//
//    @OneToMany
//    private List<Trainer> trainerList = new ArrayList<>();
}
