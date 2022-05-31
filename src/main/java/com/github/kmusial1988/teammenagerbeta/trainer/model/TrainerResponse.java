package com.github.kmusial1988.teammenagerbeta.trainer.model;

import com.github.kmusial1988.teammenagerbeta.global.globalEnum.RoleEnum;
import com.github.kmusial1988.teammenagerbeta.global.globalEnum.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainerResponse {

    private Long id;
    private String name;
    private String surname;
    private String login;
    private String password;
    private String imageUrl;
    private String startWork;
    private Status status;
    private RoleEnum role;


}

