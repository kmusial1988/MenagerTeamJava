package com.github.kmusial1988.teamManagerBeta.global.globalEnum;

public enum RoleEnum {

    ADMIN("ADMIN"),
    ORGANIZATION("ORGANIZATION"),
    TRAINER("TRAINER"),
    GUARDIAN("GUARDIAN"),
    PLAYER("PLAYER");



    private final String role;

    RoleEnum(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }

}
