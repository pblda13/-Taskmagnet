package com.projeto.taskmagnetdemo.enums;

public enum Status {

    PENDING("Pending"),
    IN_PROGRESS("In Progress"),
    COMPLETED("Completed");

private String status;

    Status(String status) {
        this.status = status;
    }
}

