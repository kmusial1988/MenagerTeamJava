package com.github.kmusial1988.teamManagerBeta.player.model;

import com.github.kmusial1988.teamManagerBeta.global.globalEnum.RoleEnum;
import com.github.kmusial1988.teamManagerBeta.global.globalEnum.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerRequest {
    private Long id;
    @NotBlank(message = "Trainer name cannot be blank!")
    @Size(min = 2, max = 20, message = "Organization name has to be between 2 and 20 characters!")
    private String name;
    @NotBlank(message = "Trainer surname cannot be blank!")
    @Size(min = 2, max = 20, message = "Trainer surname has to be between 2 and 20 characters!")
    private String surname;
    @NotBlank(message = "Trainer login cannot be blank!")
    @Size(min = 2, max = 20, message = "Trainer login has to be between 2 and 20 characters!")
    private String login;
    @NotBlank(message = "Trainer password cannot be blank!")
    @Size(min = 2, max = 20, message = "Trainer password has to be between 2 and 20 characters!")
    private String password;
    private String imageUrl;
    private String joined;
    private Status status;
    private RoleEnum role;
}
