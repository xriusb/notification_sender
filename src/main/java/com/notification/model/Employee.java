package com.notification.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Employee {

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;
}

