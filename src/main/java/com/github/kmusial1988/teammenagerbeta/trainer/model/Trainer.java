package com.github.kmusial1988.teammenagerbeta.trainer.model;

import com.github.kmusial1988.teammenagerbeta.global.globalEnum.RoleEnum;
import com.github.kmusial1988.teammenagerbeta.global.globalEnum.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
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
    private String startWork;
    private Status status;
    private RoleEnum role;


}

