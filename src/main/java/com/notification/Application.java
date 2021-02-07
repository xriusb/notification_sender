package com.notification;

import com.notification.business.BirthdayGreeter;
import com.notification.repository.EmployeeRepository;
import com.notification.repository.FileReader;
import com.notification.sender.EmailSender;
import com.notification.sender.NotificationSender;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Application {

    public static void main(String[] args) {
        EmployeeRepository employeeRepository = new FileReader(args[0]);
        NotificationSender notificationSender = new EmailSender();

        BirthdayGreeter birthdayGreeter = new BirthdayGreeter(employeeRepository, notificationSender);
        birthdayGreeter.sendGreetings(LocalDate.parse(args[1], DateTimeFormatter.ofPattern("yyyy/MM/dd")));
    }
}
