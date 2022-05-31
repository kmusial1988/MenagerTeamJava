package com.github.kmusial1988.teamManagerBeta.player.exception;

import java.util.NoSuchElementException;

public class PlayerIsNotFoundException extends NoSuchElementException {
    public PlayerIsNotFoundException(){
        super("Player is not found");
    }
}
