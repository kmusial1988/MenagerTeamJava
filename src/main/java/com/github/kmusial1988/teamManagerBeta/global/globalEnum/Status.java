package com.github.kmusial1988.teamManagerBeta.global.globalEnum;

public enum Status {


    ALL("ALL"),
    YES("YES"),
    NO("NO");

    Status(String status) {
        this.status = status;
    }

    private final String status;

    public String getStatus() {
        return status;
    }
}

