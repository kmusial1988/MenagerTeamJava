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
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    @NotEmpty(message = "that file cannot be empty of null")
    private String name;
    @Column(unique = true)
    @NotEmpty(message = "that file cannot be empty of null")
    private String code;
    private String imageUrl;
    private String joined;
    private Status status;

//    @OneToMany
//    private List<Player> playerList = new ArrayList<>();
//
//    @OneToMany
//    private List<Parent> parentList = new ArrayList<>();
//
//    @OneToMany
//    private List<Trainer> trainerList = new ArrayList<>();

}
