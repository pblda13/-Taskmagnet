package com.projeto.taskmagnetdemo.model;

import com.projeto.taskmagnetdemo.enums.Status;

import java.util.Date;

public class Task {

    private Long id;
    private String title;
    private String description;
    private Date creationData;
    private Date deadline;
   private Status status;
}
