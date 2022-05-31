package com.github.kmusial1988.teamManagerBeta.parent.exception;

public class ParentIsAlreadyExistsException extends IllegalArgumentException {
    public ParentIsAlreadyExistsException(String parent) {

        super(String.format("Parent is already exists.", parent));
    }
}
