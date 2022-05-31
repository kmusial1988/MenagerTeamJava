package com.github.kmusial1988.teamManagerBeta.trainer.exception;

public class TrainerIsAlreadyExistsException extends IllegalArgumentException {
    public TrainerIsAlreadyExistsException(String trainer) {
        super(String.format("Trainer is already exists.", trainer));
    }
}
