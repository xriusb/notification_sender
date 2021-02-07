package com.notification.business;

import com.notification.model.Employee;
import com.notification.repository.EmployeeRepository;
import com.notification.sender.NotificationSender;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BirthdayGreeterTest {

    private static final String JOHN = "John";
    private static final String JOHN_EMAIL = "john@foo.com";
    private static final String JOHN_BIRTHDAY = "1982-10-08";

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private NotificationSender notificationSender;

    private BirthdayGreeter testee;

    @Before
    public void setup() {
        testee = new BirthdayGreeter(employeeRepository, notificationSender);

        List<Employee> employees = getTestEmployees();
        when(employeeRepository.getEmployees()).thenReturn(employees);
    }

    @Test
    public void whenEmployeesBirthday_sendGreetings() {

        testee.sendGreetings(LocalDate.parse(JOHN_BIRTHDAY));

        verify(notificationSender).sendNotifications(JOHN_EMAIL, "Happy birthday!", "Happy birthday, dear " + JOHN + "!");
    }

    @Test
    public void whenNoEmployeesBirthday_sendNoGreetings() {

        testee.sendGreetings(LocalDate.parse("2000-01-01"));

        verify(notificationSender, times(0)).sendNotifications(anyString(),anyString(), anyString());
    }

    private List<Employee> getTestEmployees() {
        return Arrays.asList(
                Employee.builder().firstName(JOHN).birthDate(LocalDate.parse(JOHN_BIRTHDAY)).email(JOHN_EMAIL).build(),
                Employee.builder().firstName("Mark").birthDate(LocalDate.parse("1983-02-22")).email("mark@foo.com").build(),
                Employee.builder().firstName("Peter").birthDate(LocalDate.parse("1984-10-29")).email("peter@foo.com").build());
    }
}