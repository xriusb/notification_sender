package com.notification.business;

import com.notification.model.Employee;
import com.notification.repository.EmployeeRepository;
import com.notification.sender.NotificationSender;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class BirthdayGreeter {

    private static final String BIRTHDAY_GREETING_SUBJECT = "Happy birthday!";

    private final EmployeeRepository employeeRepository;
    private final NotificationSender notificationSender;

    public void sendGreetings(LocalDate birthday) {
        List<Employee> employeesToGreet = employeeRepository.getEmployees().stream()
                .filter(employee -> birthday.equals(employee.getBirthDate())).collect(Collectors.toList());

        employeesToGreet.forEach(employee -> notificationSender
                .sendNotifications(employee.getEmail(), BIRTHDAY_GREETING_SUBJECT, createBirthdayMessage(employee)));
    }

    private String createBirthdayMessage(Employee employee) {
        return "Happy birthday, dear "+ employee.getFirstName() + "!";
    }
}
