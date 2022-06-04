package com.github.kmusial1988.teamManagerBeta.team.model;

import com.github.kmusial1988.teamManagerBeta.global.globalEnum.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamRequest {
    private Long id;
    private String name;
    private String code;
    private String email;
    private String imageUrl;
    private String joined;
    private Status status;

}
