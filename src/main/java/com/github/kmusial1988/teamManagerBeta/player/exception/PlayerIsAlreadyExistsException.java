package com.github.kmusial1988.teamManagerBeta.player.exception;

public class PlayerIsAlreadyExistsException extends IllegalArgumentException {
    public PlayerIsAlreadyExistsException(String player) {
        super(String.format("Player is already exists.", player));
    }
}
