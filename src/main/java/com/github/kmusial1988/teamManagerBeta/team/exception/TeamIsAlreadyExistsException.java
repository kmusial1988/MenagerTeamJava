package com.github.kmusial1988.teamManagerBeta.team.exception;

public class TeamIsAlreadyExistsException extends IllegalArgumentException {
    public TeamIsAlreadyExistsException(String team) {
        super(String.format("Team is already exists.", team));
    }
}
