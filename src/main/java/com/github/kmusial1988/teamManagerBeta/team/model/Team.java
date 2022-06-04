package com.github.kmusial1988.teamManagerBeta.team.model;

import com.github.kmusial1988.teamManagerBeta.global.globalEnum.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

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
    private String email;
    private String imageUrl;
    private String joined;
    private Status status;

}
