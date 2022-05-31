package com.github.kmusial1988.teammenagerbeta.trainer.exception;

import java.util.NoSuchElementException;

public class TrainerNotFoundException extends NoSuchElementException {
    public TrainerNotFoundException(){
        super("Trainer is not found");
    }
}
