package com.github.kmusial1988.teamManagerBeta.trainer.model;

import com.github.kmusial1988.teamManagerBeta.global.globalEnum.RoleEnum;
import com.github.kmusial1988.teamManagerBeta.global.globalEnum.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Trainer {

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





}

