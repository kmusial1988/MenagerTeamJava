package com.github.kmusial1988.teamManagerBeta.team.exception;

import java.util.NoSuchElementException;

public class TeamIsNotFoundException extends NoSuchElementException {
    public TeamIsNotFoundException(){
        super("Team is not found");
    }
}
