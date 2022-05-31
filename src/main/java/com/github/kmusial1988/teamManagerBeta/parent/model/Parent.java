package com.github.kmusial1988.teamManagerBeta.parent.model;

import com.github.kmusial1988.teamManagerBeta.global.globalEnum.RoleEnum;
import com.github.kmusial1988.teamManagerBeta.global.globalEnum.Status;
import com.github.kmusial1988.teamManagerBeta.player.model.Player;
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
public class Parent {

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

//    @OneToMany(mappedBy = "parent", cascade = CascadeType.REMOVE)
//    private List<Player> playerList = new ArrayList<>();
}
