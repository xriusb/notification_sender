package com.notification.repository;

import com.notification.model.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> getEmployees();
}
