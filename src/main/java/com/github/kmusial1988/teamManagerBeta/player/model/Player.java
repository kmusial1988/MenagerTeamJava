package com.github.kmusial1988.teamManagerBeta.player.model;

import com.github.kmusial1988.teamManagerBeta.global.globalEnum.RoleEnum;
import com.github.kmusial1988.teamManagerBeta.global.globalEnum.Status;
import com.github.kmusial1988.teamManagerBeta.parent.model.Parent;
import com.github.kmusial1988.teamManagerBeta.team.model.Team;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "that file cannot be empty of null")
    private String name;
    @NotEmpty(message = "that file cannot be empty of null")
    private String surname;
    @Column(unique = true)
    @NotEmpty(message = "that file cannot be empty of null")
    private String login;
    @NotEmpty(message = "that file cannot be empty of null")
    private String password;
    private String imageUrl;
    private String joined;
    private Status status;
    private RoleEnum role;
    private String teamName;
    @ManyToOne
    private Parent parent;





}
