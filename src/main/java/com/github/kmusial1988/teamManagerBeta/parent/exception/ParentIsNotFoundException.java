package com.github.kmusial1988.teamManagerBeta.parent.exception;

import java.util.NoSuchElementException;

public class ParentIsNotFoundException extends NoSuchElementException {
    public ParentIsNotFoundException(){
        super("Parent is not found");
    }
}
