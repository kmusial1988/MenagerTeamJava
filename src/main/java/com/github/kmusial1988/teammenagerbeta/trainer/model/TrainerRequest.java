package com.github.kmusial1988.teammenagerbeta.trainer.model;

import com.github.kmusial1988.teammenagerbeta.global.globalEnum.RoleEnum;
import com.github.kmusial1988.teammenagerbeta.global.globalEnum.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainerRequest {

    private Long id;
    @NotBlank(message = "Organization name cannot be blank!")
    @Size(min = 2, max = 20, message = "Organization name has to be between 2 and 20 characters!")
    private String name;
    private String surname;
    private String login;
    private String password;
    private String imageUrl;
    private String startWork;
    private Status status;
    private RoleEnum role;


}

