package com.example.activemq.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class Student implements Serializable{

    private static final long serialVersionUID = 1L;
    private String studentId;
    private String name;
    private String rollNumber;
}
