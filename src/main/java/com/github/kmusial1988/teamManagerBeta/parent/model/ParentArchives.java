package com.github.kmusial1988.teamManagerBeta.parent.model;

import com.github.kmusial1988.teamManagerBeta.global.globalEnum.RoleEnum;
import com.github.kmusial1988.teamManagerBeta.global.globalEnum.Status;
import com.github.kmusial1988.teamManagerBeta.player.model.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParentArchives {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateArchiving;
    private String name;
    private String surname;
    private String login;
    private String password;
    private String imageUrl;
    private String joined;
    private Status status;
    private RoleEnum role;

    @OneToMany
    private List<Player> playerList = new ArrayList<>();


}

